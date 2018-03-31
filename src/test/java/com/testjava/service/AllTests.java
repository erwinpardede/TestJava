package com.testjava.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by erwin on 3/31/18.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        AdminTest.class,
        CartTest.class,
        CategoryTest.class,
        CustomerTest.class,
        DeliveryAddressTest.class,
        LogisticProviderTest.class,
        PaymentMethodTest.class,
        ProductTest.class,
        ShippingTest.class
})
public class AllTests {
}
