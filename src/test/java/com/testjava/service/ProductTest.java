package com.testjava.service;

import com.testjava.model.Category;
import com.testjava.model.Product;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by erwin on 3/31/18.
 */
public class ProductTest {

    private ApplicationContext context;

    private IProductService productService;

    public ProductTest() {
        context = new ClassPathXmlApplicationContext(new String("services.xml"));
        productService = (IProductService) context.getBean("productService");
    }

    @Test
    public void test() {

        Product product = new Product();
        product.setId(1);
        product.setName("product name");
        product.setDescription("product description");
        product.setCategory(new Category(1, "category name", "category description"));
        product.setStock(10);

        Integer result = this.productService.save(product);
        assertEquals(Integer.valueOf(1), result);

        List<Product> products = this.productService.get();
        assertEquals(1, products.size());

        product = new Product();
        product.setId(1);
        product.setName("product name updated");
        product.setDescription("product description updated");

        result = this.productService.update(product);
        assertEquals(Integer.valueOf(1), result);

        product = new Product();
        product.setId(1);

        product = this.productService.get(product);
        assertEquals("product name updated", product.getName());
        assertEquals("product description updated", product.getDescription());

        product = new Product();
        product.setId(1);

        result = this.productService.delete(product);
        assertEquals(Integer.valueOf(1), result);
    }
}
