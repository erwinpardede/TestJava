package com.testjava.service;

import com.testjava.model.LogisticProvider;
import com.testjava.model.Shipping;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by erwin on 3/31/18.
 */
public class ShippingTest {

    private ApplicationContext context;

    private IShippingService shippingService;

    public ShippingTest() {
        context = new ClassPathXmlApplicationContext(new String("services.xml"));
        shippingService = (IShippingService) context.getBean("shippingService");
    }

    @Test
    public void test() {

        Shipping shipping = new Shipping();
        shipping.setId(1);
        shipping.setLogisticProvider(new LogisticProvider(1, "logistic provider"));
        shipping.setShippingNumber("A1210");

        Integer result = this.shippingService.save(shipping);
        assertEquals(Integer.valueOf(1), result);

        List<Shipping> shippings = this.shippingService.get();
        assertEquals(1, shippings.size());

        shipping = new Shipping();
        shipping.setId(1);
        shipping.setShippingNumber("A1211");
        shipping.setLogisticProvider(new LogisticProvider(2, "logistic provider updated"));

        result = this.shippingService.update(shipping);
        assertEquals(Integer.valueOf(1), result);

        shipping = new Shipping();
        shipping.setId(1);

        shipping = this.shippingService.get(shipping);
        assertEquals("A1211", shipping.getShippingNumber());
        assertEquals("logistic provider updated", shipping.getLogisticProvider().getName());

        shipping = new Shipping();
        shipping.setId(1);

        result = this.shippingService.delete(shipping);
        assertEquals(Integer.valueOf(1), result);
    }
}
