package com.testjava.service;

import com.testjava.model.Category;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by erwin on 3/30/18.
 */
public class CategoryTest {

    private ApplicationContext context;

    private ICategoryService categoryService;

    public CategoryTest() {
        context = new ClassPathXmlApplicationContext("services.xml");
        categoryService = (ICategoryService) context.getBean("categoryService");
    }

    @Test
    public void test() {

        Category category = new Category();
        category.setId(1);
        category.setName("category name");
        category.setDescription("category desc");

        Integer result = this.categoryService.save(category);
        assertEquals(Integer.valueOf(1), result);

        category = new Category();
        category.setId(1);
        category.setName("category name updated");

        result = this.categoryService.update(category);
        assertEquals(Integer.valueOf(1), result);

        category = new Category();
        category.setId(1);

        category = this.categoryService.get(category);
        assertEquals("category name updated", category.getName());

        category = new Category();
        category.setId(1);

        result = this.categoryService.delete(category);
        assertEquals(Integer.valueOf(1), result);

    }
}
