package com.testjava.controller;

import com.testjava.model.PaymentMethod;
import com.testjava.service.IPaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by erwin on 3/31/18.
 */
@RestController
@RequestMapping(value = "/paymentMethod")
public class PaymentMethodController {

    @Autowired
    private IPaymentMethodService paymentMethodService;

    @RequestMapping(method = RequestMethod.GET)
    public List<PaymentMethod> get() {
        return this.paymentMethodService.get();
    }
}
