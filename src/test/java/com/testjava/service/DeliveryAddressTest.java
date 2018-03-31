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
        context = new ClassPathXmlApplicationContext(new String("services.xml"));
        deliveryAddressService = (IDeliveryAddressService) context.getBean("deliveryAddressService");
    }

    @Test
    public void test() {

        DeliveryAddress deliveryAddress = new DeliveryAddress();
        deliveryAddress.setId(1);
        deliveryAddress.setAddress("address");
        deliveryAddress.setCity("city");
        deliveryAddress.setCustomer(new Customer(1, "customer name"));
        deliveryAddress.setPostCode("4324324");

        Integer result = this.deliveryAddressService.save(deliveryAddress);
        assertEquals(Integer.valueOf(1), result);

        List<DeliveryAddress> deliveryAddresses = this.deliveryAddressService.get();
        assertEquals(1, deliveryAddresses.size());

        deliveryAddress = new DeliveryAddress();
        deliveryAddress.setId(1);
        deliveryAddress.setAddress("addressUpdated");
        deliveryAddress.setCity("cityUpdated");

        result = this.deliveryAddressService.update(deliveryAddress);
        assertEquals(Integer.valueOf(1), result);

        deliveryAddress = new DeliveryAddress();
        deliveryAddress.setId(1);

        deliveryAddress = this.deliveryAddressService.get(deliveryAddress);
        assertEquals("addressUpdated", deliveryAddress.getAddress());
        assertEquals("cityUpdated", deliveryAddress.getCity());
        assertNull(deliveryAddress.getPostCode());

        deliveryAddress = new DeliveryAddress();
        deliveryAddress.setId(1);

        result = this.deliveryAddressService.delete(deliveryAddress);
        assertEquals(Integer.valueOf(1), result);
    }
}
