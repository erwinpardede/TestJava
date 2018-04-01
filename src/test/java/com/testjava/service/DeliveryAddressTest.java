package com.testjava.service;

import com.testjava.model.Customer;
import com.testjava.model.DeliveryAddress;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by erwin on 3/30/18.
 */
public class DeliveryAddressTest {

    private ApplicationContext context;

    private IDeliveryAddressService deliveryAddressService;

    public DeliveryAddressTest() {
        context = new ClassPathXmlApplicationContext("services.xml");
        deliveryAddressService = (IDeliveryAddressService) context.getBean("deliveryAddressService");
    }

    @Test
    public void test() {

        DeliveryAddress deliveryAddress = new DeliveryAddress();
        deliveryAddress.setId(1);
        deliveryAddress.setAddress("address");
        deliveryAddress.setCity("city");
        deliveryAddress.setCustomer(new Customer(999, "customer name"));
        deliveryAddress.setPostCode("4324324");
        deliveryAddress.setSelected(true);

        Integer result = this.deliveryAddressService.save(deliveryAddress);
        assertEquals(Integer.valueOf(1), result);

        //test get by customer
        Customer customer = new Customer();
        customer.setId(999);
        List<DeliveryAddress> deliveryAddresses = this.deliveryAddressService.getByCustomer(customer);
        assertEquals(1, deliveryAddresses.size());
        //test get by customer

        deliveryAddress = new DeliveryAddress();
        deliveryAddress.setId(1);
        deliveryAddress.setAddress("addressUpdated");
        deliveryAddress.setCity("cityUpdated");
        deliveryAddress.setCustomer(new Customer(999));

        result = this.deliveryAddressService.update(deliveryAddress);
        assertEquals(Integer.valueOf(1), result);

        deliveryAddress = new DeliveryAddress();
        deliveryAddress.setId(1);

        deliveryAddress = this.deliveryAddressService.get(deliveryAddress);
        assertEquals("addressUpdated", deliveryAddress.getAddress());
        assertEquals("cityUpdated", deliveryAddress.getCity());
        assertNull(deliveryAddress.getPostCode());


        //test update delivery address
        deliveryAddress = new DeliveryAddress();
        deliveryAddress.setId(2);
        deliveryAddress.setAddress("address 2");
        deliveryAddress.setCity("city 2");
        deliveryAddress.setCustomer(new Customer(999, "customer name"));
        deliveryAddress.setPostCode("44443131");
        deliveryAddress.setSelected(false);
        this.deliveryAddressService.save(deliveryAddress);

        deliveryAddress = new DeliveryAddress();
        deliveryAddress.setId(2);
        deliveryAddress.setCustomer(new Customer(999));
        result = this.deliveryAddressService.updateDeliveryAddress(deliveryAddress);
        assertEquals(Integer.valueOf(1), result);

        deliveryAddress = new DeliveryAddress(1);
        deliveryAddress = this.deliveryAddressService.get(deliveryAddress);
        assertEquals(false, deliveryAddress.getSelected());

        deliveryAddress = new DeliveryAddress(2);
        deliveryAddress = this.deliveryAddressService.get(deliveryAddress);
        assertEquals(true, deliveryAddress.getSelected());
        //test update delivery address


        deliveryAddress = new DeliveryAddress();
        deliveryAddress.setId(1);

        result = this.deliveryAddressService.delete(deliveryAddress);
        assertEquals(Integer.valueOf(1), result);
    }
}
