package com.testjava.service;

import com.testjava.base.BaseService;
import com.testjava.model.Cart;
import com.testjava.model.Customer;
import com.testjava.model.DeliveryAddress;
import com.testjava.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by erwin on 3/30/18.
 */
public class CartService extends BaseService<Cart> implements ICartService {

    private IProductService productService;
    private IDeliveryAddressService deliveryAddressService;

    public void setDeliveryAddressService(IDeliveryAddressService deliveryAddressService) {
        this.deliveryAddressService = deliveryAddressService;
    }

    public void setProductService(IProductService productService) {
        this.productService = productService;
    }

    @Override
    public List<Cart> getByCustomer(Customer customer) {

        List<Cart> result = new ArrayList<Cart>();
        for (Cart cart : this.objects) {
            if (cart.getCustomer().equals(customer)) {
                result.add(cart);
            }
        }
        return result;
    }

    @Override
    public Integer checkStock(Customer customer) {

        List<Cart> carts = this.getByCustomer(customer);
        boolean updated = false;
        for (Cart cart : carts) {
            Product product = this.productService.get(cart.getProduct());
            if (cart.getQuantity() > product.getStock()) {
                cart.setStatus(3);
            } else {
                cart.setStatus(1);
            }
            this.update(cart);
            updated = true;
        }
        if (updated)
            return 1;
        else
            return 0;
    }

    @Override
    public Integer checkPaymentMethod(Customer customer) {

        List<Cart> carts = this.getByCustomer(customer);
        //randomize check payment method
        boolean updated = false;
        Random random = new Random();
        Integer n = random.nextInt(100);
        for (Cart cart : carts) {
            if (n > 50) {
                cart.setStatus(2);
            }
            this.update(cart);
            updated = true;
        }
        //randomize check payment method
        if (updated)
            return 1;
        else
            return 0;
    }

    @Override
    public Integer checkDeliveryAddress(Customer customer) {

        List<Cart> carts = this.getByCustomer(customer);
        //randomize check delivery address
        List<DeliveryAddress> addresses = this.deliveryAddressService.getByCustomer(carts.get(0).getCustomer());
        DeliveryAddress selectedAddress = null;
        for (DeliveryAddress address : addresses) {
            if (address.getSelected())
                selectedAddress = address;
        }
        if (selectedAddress == null)
            return 0;

        boolean updated = false;
        Random random = new Random();
        Integer n = random.nextInt(100);
        for (Cart cart : carts) {
            if (n > 50) {
                cart.setStatus(4);
            }
            this.update(cart);
            updated = true;
        }
        //randomize check delivery address
        if (updated)
            return 1;
        else
            return 0;
    }

    @Override
    public Integer checkAll(Customer customer) {

        Integer result = this.checkStock(customer);
        if (result == 0) return result;
        result = this.checkPaymentMethod(customer);
        if (result == 0) return result;
        result = this.checkDeliveryAddress(customer);
        return result;
    }
}
