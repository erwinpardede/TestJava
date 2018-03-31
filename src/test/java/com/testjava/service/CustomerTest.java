package com.testjava.service;

import com.testjava.model.Customer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by erwin on 3/30/18.
 */
public class CustomerTest {

    private ApplicationContext context;

    private ICustomerService customerService;

    public CustomerTest() {
        context = new ClassPathXmlApplicationContext(new String("services.xml"));
        customerService = (ICustomerService) context.getBean("customerService");
    }

    @Test
    public void test() {

        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("customer");

        Integer result = this.customerService.save(customer);
        assertEquals(Integer.valueOf(1), result);

        List<Customer> customers = this.customerService.get();
        assertEquals(1, customers.size());

        customer = new Customer();
        customer.setId(1);
        customer.setName("customerUpdated");

        result = this.customerService.update(customer);
        assertEquals(Integer.valueOf(1), result);

        customer = new Customer();
        customer.setId(1);

        customer = this.customerService.get(customer);
        assertEquals("customerUpdated", customer.getName());

        customer = new Customer();
        customer.setId(1);

        result = this.customerService.delete(customer);
        assertEquals(Integer.valueOf(1), result);
    }
}
