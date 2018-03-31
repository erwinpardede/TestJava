package com.testjava.service;

import com.testjava.model.LogisticProvider;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by erwin on 3/30/18.
 */
public class LogisticProviderTest {

    private ApplicationContext context;

    private ILogisticProviderService logisticProviderService;

    public LogisticProviderTest() {
        context = new ClassPathXmlApplicationContext(new String("services.xml"));
        logisticProviderService = (ILogisticProviderService) context.getBean("logisticProviderService");
    }

    @Test
    public void test() {

        LogisticProvider logisticProvider = new LogisticProvider();
        logisticProvider.setId(1);
        logisticProvider.setName("logistic provider");

        Integer result = this.logisticProviderService.save(logisticProvider);
        assertEquals(Integer.valueOf(1), result);

        List<LogisticProvider> logisticProviders = this.logisticProviderService.get();
        assertEquals(1, logisticProviders.size());

        logisticProvider = new LogisticProvider();
        logisticProvider.setId(1);
        logisticProvider.setName("logistic provider updated");

        result = this.logisticProviderService.update(logisticProvider);
        assertEquals(Integer.valueOf(1), result);

        logisticProvider = new LogisticProvider();
        logisticProvider.setId(1);

        logisticProvider = this.logisticProviderService.get(logisticProvider);
        assertEquals("logistic provider updated", logisticProvider.getName());

        logisticProvider = new LogisticProvider();
        logisticProvider.setId(1);

        result = this.logisticProviderService.delete(logisticProvider);
        assertEquals(Integer.valueOf(1), result);
    }
}
