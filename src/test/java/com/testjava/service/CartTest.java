package com.testjava.service;

import com.testjava.model.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by erwin on 3/30/18.
 */
public class CartTest {

    private ApplicationContext context;

    private ICartService cartService;
    private IProductService productService;
    private IDeliveryAddressService deliveryAddressService;

    public CartTest() {
        context = new ClassPathXmlApplicationContext("services.xml");
        cartService = (ICartService) context.getBean("cartService");
        productService = (IProductService) context.getBean("productService");
        deliveryAddressService = (IDeliveryAddressService) context.getBean("deliveryAddressService");
    }

    @Test
    public void test() {

        Cart cart = new Cart();
        cart.setId(999);
        cart.setCustomer(new Customer(999, "customer"));
        cart.setProduct(new Product(999,
                "product name",
                "product desc",
                new Category(1, "category name", "category desc"),
                1));
        cart.setQuantity(1);
        cart.setStatus(0);

        Integer result = this.cartService.save(cart);
        assertEquals(Integer.valueOf(1), result);

        //test get by customer
        Customer customer = new Customer();
        customer.setId(999);
        List<Cart> carts = this.cartService.getByCustomer(customer);
        assertEquals(1, carts.size());
        //test get by customer

        Product product = new Product(998,
                "product name 2",
                "product desc 2",
                new Category(1, "category name", "category desc"),
                1);
        this.productService.save(product);

        cart = new Cart();
        cart.setId(999);
        cart.setCustomer(new Customer(999, "customer"));
        cart.setProduct(product);
        cart.setQuantity(1);
        cart.setStatus(0);

        result = this.cartService.update(cart);
        assertEquals(Integer.valueOf(1), result);
        assertEquals(new Product(998), cart.getProduct());

        //test check stock
        result = this.cartService.checkStock(new Customer(999));
        assertEquals(Integer.valueOf(1), result);

        cart = this.cartService.getByCustomer(new Customer(999)).get(0);
        assertEquals(Integer.valueOf(1), cart.getStatus());

        cart.setQuantity(2);
        this.cartService.update(cart);
        this.cartService.checkStock(new Customer(999));
        assertEquals(Integer.valueOf(3), cart.getStatus());
        //test check stock

        //test check payment method
        cart = new Cart();
        cart.setId(999);
        cart.setCustomer(new Customer(999, "customer"));
        cart.setProduct(product);
        cart.setQuantity(1);
        cart.setStatus(0);
        this.cartService.update(cart);

        result = this.cartService.checkPaymentMethod(new Customer(999));
        assertEquals(Integer.valueOf(1), result);
        for (Cart cart1 : carts) {
            assertTrue(cart1.getStatus() == 2 || cart1.getStatus() == 0);
        }
        //test check payment method

        //test check delivery address
        cart = new Cart();
        cart.setId(999);
        cart.setCustomer(new Customer(999, "customer"));
        cart.setProduct(product);
        cart.setQuantity(1);
        cart.setStatus(0);
        this.cartService.update(cart);

        DeliveryAddress deliveryAddress = new DeliveryAddress();
        deliveryAddress.setId(999);
        deliveryAddress.setAddress("Jl. Raya  no. 88");
        deliveryAddress.setCity("Jakarta");
        deliveryAddress.setPostCode("4324232");
        deliveryAddress.setCustomer(new Customer(999));
        deliveryAddress.setSelected(true);
        this.deliveryAddressService.save(deliveryAddress);

        result = this.cartService.checkDeliveryAddress(new Customer(999));
        assertEquals(Integer.valueOf(1), result);
        for (Cart cart1 : carts) {
            assertTrue(cart1.getStatus() == 4 || cart1.getStatus() == 0);
        }
        //test check delivery address

        //test check all
        result = this.cartService.checkAll(new Customer(999));
        assertEquals(Integer.valueOf(1), result);
        for (Cart cart1 : carts) {
            assertTrue(cart1.getStatus() == 1 || cart1.getStatus() == 2 ||
                cart1.getStatus() == 3 || cart1.getStatus() == 4);
        }
        //test check all

        cart = new Cart();
        cart.setId(999);
        cart = this.cartService.get(cart);
        assertNotNull(cart);

        cart = new Cart();
        cart.setId(999);
        result = this.cartService.delete(cart);
        assertEquals(Integer.valueOf(1), result);
    }
}
