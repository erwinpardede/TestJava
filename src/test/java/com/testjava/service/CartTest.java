package com.testjava.service;

import com.testjava.model.Cart;
import com.testjava.model.Category;
import com.testjava.model.Customer;
import com.testjava.model.Product;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by erwin on 3/30/18.
 */
public class CartTest {

    private ApplicationContext context;

    private ICartService cartService;

    public CartTest() {
        context = new ClassPathXmlApplicationContext(new String("services.xml"));
        cartService = (ICartService) context.getBean("cartService");
    }

    @Test
    public void test() {

        Cart cart = new Cart();
        cart.setId(1);
        cart.setCustomer(new Customer(1, "customer"));
        cart.setProduct(new Product(1,
                "product name",
                "product desc",
                new Category(1, "category name", "category desc"),
                1));
        cart.setQuantity(1);
        cart.setStatus(0);

        Integer result = this.cartService.save(cart);
        assertEquals(Integer.valueOf(1), result);

        List<Cart> carts = this.cartService.get();
        assertEquals(1, carts.size());

        cart = new Cart();
        cart.setId(1);
        cart.setStatus(1);

        result = this.cartService.update(cart);
        assertEquals(Integer.valueOf(1), result);
        assertEquals(Integer.valueOf(1), cart.getStatus());

        cart = new Cart();
        cart.setId(1);
        cart = this.cartService.get(cart);
        assertNotNull(cart);

        cart = new Cart();
        cart.setId(1);
        result = this.cartService.delete(cart);
        assertEquals(Integer.valueOf(1), result);
    }
}
