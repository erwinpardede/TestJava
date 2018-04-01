package com.testjava.controller;

import com.testjava.model.Cart;
import com.testjava.model.Customer;
import com.testjava.model.Product;
import com.testjava.service.ICartService;
import com.testjava.service.ICustomerService;
import com.testjava.service.IProductService;
import com.testjava.service.IShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by erwin on 3/31/18.
 */
@RestController
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private ICartService cartService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IProductService productService;
    @Autowired
    private IShippingService shippingService;

    @RequestMapping(value = "/{customerId}/getcart", method = RequestMethod.GET)
    public List<Cart> getByCustomer(@PathVariable(value = "customerId") Integer customerId) {
        return this.cartService.getByCustomer(new Customer(customerId));
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Cart> get() {
        return this.cartService.get();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Cart get(@PathVariable(value = "id") Integer id) {
        return this.cartService.get(new Cart(id));
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestBody Cart cart) {
        cart.setCustomer(this.customerService.get(cart.getCustomer()));
        cart.setProduct(this.productService.get(cart.getProduct()));
        cart.setStatus(0);
        Integer result = this.cartService.save(cart);
        if (result == 1) {
            return "Cart saved successfully";
        } else {
            return "Failed to save cart";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody Cart cart) {
        Cart cart1 = this.cartService.get(cart); //get values from previous data
        cart.setCustomer(cart1.getCustomer());

        cart.setProduct(this.productService.get(cart.getProduct()));
        cart.setStatus(0);
        Integer result = this.cartService.update(cart);
        if (result == 1) {
            return "Cart updated successfully";
        } else {
            return "Failed to update cart";
        }
    }

    @RequestMapping(value = "/updateByAdmin", method = RequestMethod.POST)
    public String updateByAdmin(@RequestBody Cart cart) {
        Cart cart1 = this.cartService.get(cart); //get values from previous data
        cart.setCustomer(cart1.getCustomer());
        cart.setProduct(cart1.getProduct());
        cart.setQuantity(cart1.getQuantity());

        Integer result = this.cartService.update(cart);
        if (result == 1) {
            return "Cart updated successfully";
        } else {
            return "Failed to update cart";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String delete(@RequestBody Cart cart) {
        Integer result = this.cartService.delete(cart);
        if (result == 1) {
            return "Cart deleted successfully";
        } else {
            return "Failed to delete cart";
        }
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String submitOrder(@RequestBody Customer customer) {
        Integer result = this.cartService.checkAll(customer);
        if (result == 1) {
            return "Order submitted successfully";
        } else {
            return "Failed to submit order";
        }
    }

    @RequestMapping(value = "/processShipping", method = RequestMethod.POST)
    public String processShipping(@RequestBody Cart cart) {
        Integer result = this.shippingService.processShipping(cart);
        if (result == 1) {
            return "Shipping processed successfully";
        } else {
            return "Failed to process shipping";
        }
    }
}
