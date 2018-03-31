package com.testjava.service;

import com.testjava.model.PaymentMethod;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by erwin on 3/30/18.
 */
public class PaymentMethodTest {

    private ApplicationContext context;

    private IPaymentMethodService paymentMethodService;

    public PaymentMethodTest() {
        context = new ClassPathXmlApplicationContext(new String("services.xml"));
        paymentMethodService = (IPaymentMethodService) context.getBean("paymentMethodService");
    }

    @Test
    public void test() {

        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setId(1);
        paymentMethod.setName("payment method");

        Integer result = this.paymentMethodService.save(paymentMethod);
        assertEquals(Integer.valueOf(1), result);

        List<PaymentMethod> paymentMethods = this.paymentMethodService.get();
        assertEquals(1, paymentMethods.size());

        paymentMethod = new PaymentMethod();
        paymentMethod.setId(1);
        paymentMethod.setName("payment method updated");

        result = this.paymentMethodService.update(paymentMethod);
        assertEquals(Integer.valueOf(1), result);

        paymentMethod = new PaymentMethod();
        paymentMethod.setId(1);

        paymentMethod = this.paymentMethodService.get(paymentMethod);
        assertEquals("payment method updated", paymentMethod.getName());

        paymentMethod = new PaymentMethod();
        paymentMethod.setId(1);

        result = this.paymentMethodService.delete(paymentMethod);
        assertEquals(Integer.valueOf(1), result);
    }
}
