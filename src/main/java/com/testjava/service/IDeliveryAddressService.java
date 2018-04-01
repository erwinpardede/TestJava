package com.testjava.service;

import com.testjava.base.IBaseService;
import com.testjava.model.Customer;
import com.testjava.model.DeliveryAddress;

import java.util.List;

/**
 * Created by erwin on 3/30/18.
 */
public interface IDeliveryAddressService extends IBaseService<DeliveryAddress> {

    List<DeliveryAddress> getByCustomer(Customer customer);
    Integer updateDeliveryAddress(DeliveryAddress deliveryAddress);
}
