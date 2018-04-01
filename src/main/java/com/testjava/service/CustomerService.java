package com.testjava.service;

import com.testjava.base.BaseService;
import com.testjava.model.Customer;
import com.testjava.model.PaymentMethod;

/**
 * Created by erwin on 3/30/18.
 */
public class CustomerService extends BaseService<Customer> implements ICustomerService {

    private IPaymentMethodService paymentMethodService;

    public void setPaymentMethodService(IPaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @Override
    public Integer updatePaymentMethod(Customer customer) {

        Customer customer1 = this.get(customer);
        customer1.setPaymentMethod(this.paymentMethodService.get(new PaymentMethod(customer.getPaymentMethod().getId())));
        return this.update(customer1);
    }
}
