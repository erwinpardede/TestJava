package com.testjava.controller;

import com.testjava.model.Cart;
import com.testjava.model.Customer;
import com.testjava.model.Product;
import com.testjava.service.ICartService;
import com.testjava.service.ICustomerService;
import com.testjava.service.IProductService;
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

    @RequestMapping(value = "/{customerId}/getcart", method = RequestMethod.GET)
    public List<Cart> getByCustomer(@PathVariable(value = "customerId") Integer customerId) {
        return this.cartService.getByCustomer(new Customer(customerId));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Cart get(@PathVariable(value = "id") Integer id) {
        return this.cartService.get(new Cart(id));
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestBody Cart cart) {
        cart.setCustomer(this.customerService.get(new Customer(cart.getCustomer().getId())));
        cart.setProduct(this.productService.get(new Product(cart.getProduct().getId())));
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
        cart.setCustomer(this.customerService.get(new Customer(cart.getCustomer().getId())));
        cart.setProduct(this.productService.get(new Product(cart.getProduct().getId())));
        cart.setStatus(0);
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
}
