package com.testjava.service;

import com.testjava.model.Admin;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by erwin on 3/30/18.
 */
public class AdminTest {

    private ApplicationContext context;

    @Autowired
    private IAdminService adminService;

    public AdminTest() {
        context = new ClassPathXmlApplicationContext("services.xml");
        adminService = (IAdminService) context.getBean("adminService");
    }

    @Test
    public void test() {
        Admin admin = new Admin();
        admin.setId(1);
        admin.setName("admin");
        Integer result = this.adminService.save(admin);
        assertEquals(Integer.valueOf(1), result);

        admin = new Admin();
        admin.setId(2);
        admin.setName("admin2");
        this.adminService.save(admin);

        admin = new Admin();
        admin.setId(3);
        admin.setName("admin3");
        result = this.adminService.update(admin);
        assertEquals(Integer.valueOf(0), result);

        admin = new Admin();
        admin.setId(1);
        admin.setName("adminUpdated");
        result = this.adminService.update(admin);
        assertEquals(Integer.valueOf(1), result);

        admin = new Admin();
        admin.setId(1);
        admin = this.adminService.get(admin);
        assertEquals("adminUpdated", admin.getName());

        admin = new Admin();
        admin.setId(1);
        result = this.adminService.delete(admin);
        assertEquals(Integer.valueOf(1), result);
    }

}
