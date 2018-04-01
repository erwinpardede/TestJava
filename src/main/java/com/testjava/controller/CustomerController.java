package com.testjava.controller;

import com.testjava.model.Customer;
import com.testjava.model.DeliveryAddress;
import com.testjava.service.ICustomerService;
import com.testjava.service.IDeliveryAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by erwin on 3/31/18.
 */
@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IDeliveryAddressService deliveryAddressService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer get(@PathVariable(value = "id") Integer id) {
        return this.customerService.get(new Customer(id));
    }

    @RequestMapping(value = "/updatePaymentMethod", method = RequestMethod.POST)
    public String updatePaymentMethod(@RequestBody Customer customer) {
        Integer result = this.customerService.updatePaymentMethod(customer);
        if (result == 1) {
            return "Payment method updated successfully";
        } else {
            return "Failed to update payment method";
        }
    }

    @RequestMapping(value = "/updateDeliveryAddress", method = RequestMethod.POST)
    public String updateDeliveryAddress(@RequestBody DeliveryAddress deliveryAddress) {
        Integer result = this.deliveryAddressService.updateDeliveryAddress(deliveryAddress);
        if (result == 1) {
            return "Delivery address updated successfully";
        } else {
            return "Failed to update delivery address";
        }
    }

}
