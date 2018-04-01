package com.testjava.service;

import com.testjava.model.Customer;
import com.testjava.model.PaymentMethod;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * Created by erwin on 3/30/18.
 */
public class CustomerTest {

    private ApplicationContext context;

    private ICustomerService customerService;

    public CustomerTest() {
        context = new ClassPathXmlApplicationContext("services.xml");
        customerService = (ICustomerService) context.getBean("customerService");
    }

    @Test
    public void test() {

        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("customer");
        customer.setPaymentMethod(new PaymentMethod(1));

        Integer result = this.customerService.save(customer);
        assertEquals(Integer.valueOf(1), result);

        customer = new Customer();
        customer.setId(1);
        customer.setName("customerUpdated");

        result = this.customerService.update(customer);
        assertEquals(Integer.valueOf(1), result);

        customer = new Customer();
        customer.setId(1);

        customer = this.customerService.get(customer);
        assertEquals("customerUpdated", customer.getName());

        customer = new Customer(1);
        customer.setPaymentMethod(new PaymentMethod(2));
        result = this.customerService.updatePaymentMethod(customer);
        assertEquals(Integer.valueOf(1), result);

        customer = new Customer(1);
        customer = this.customerService.get(customer);
        assertEquals(new PaymentMethod(2), customer.getPaymentMethod());

        customer = new Customer();
        customer.setId(1);

        result = this.customerService.delete(customer);
        assertEquals(Integer.valueOf(1), result);
    }
}
