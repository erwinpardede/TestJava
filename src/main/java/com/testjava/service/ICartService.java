package com.testjava.service;

import com.testjava.base.IBaseService;
import com.testjava.model.Cart;
import com.testjava.model.Customer;

import java.util.List;

/**
 * Created by erwin on 3/30/18.
 */
public interface ICartService extends IBaseService<Cart> {

    List<Cart> getByCustomer(Customer customer);
    Integer checkStock(Customer customer);
    Integer checkPaymentMethod(Customer customer);
    Integer checkDeliveryAddress(Customer customer);
    Integer checkAll(Customer customer);
}
