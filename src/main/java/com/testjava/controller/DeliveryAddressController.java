package com.testjava.controller;

import com.testjava.model.Customer;
import com.testjava.model.DeliveryAddress;
import com.testjava.service.IDeliveryAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by erwin on 3/31/18.
 */
@RestController
@RequestMapping(value = "/deliveryAddress")
public class DeliveryAddressController {

    @Autowired
    private IDeliveryAddressService deliveryAddressService;

    @RequestMapping(value = "/{customerId}/address", method = RequestMethod.GET)
    public List<DeliveryAddress> getByCustomer(@PathVariable(value = "customerId") Integer customerId) {
        return this.deliveryAddressService.getByCustomer(new Customer(customerId));
    }
}
