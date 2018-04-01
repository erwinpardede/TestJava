package com.testjava.service;

import com.testjava.base.BaseService;
import com.testjava.model.Cart;
import com.testjava.model.Shipping;

import java.util.List;
import java.util.Random;

/**
 * Created by erwin on 3/30/18.
 */
public class ShippingService extends BaseService<Shipping> implements IShippingService{

    private ICartService cartService;
    private ILogisticProviderService logisticProviderService;

    public void setLogisticProviderService(ILogisticProviderService logisticProviderService) {
        this.logisticProviderService = logisticProviderService;
    }

    public void setCartService(ICartService cartService) {
        this.cartService = cartService;
    }

    @Override
    public Integer processShipping(Cart cart) {

        Shipping shipping = cart.getShipping();
        shipping.setLogisticProvider(this.logisticProviderService.get(shipping.getLogisticProvider()));
        Random random = new Random();
        Integer n = random.nextInt(999999);
        shipping.setShippingNumber(n.toString());
        Integer result = this.save(shipping);
        if (result == 0)
            return result;

        List<Cart> carts = this.cartService.getByCustomer(cart.getCustomer());
        boolean updated = false;
        for (Cart cart1 : carts) {
            if (cart1.getStatus() == 1) {
                cart1.setShipping(shipping);
                cart1.setStatus(5);
                this.cartService.update(cart1);
                updated = true;
            }
        }
        if (updated)
            return 1;
        else
            return 0;
    }
}
