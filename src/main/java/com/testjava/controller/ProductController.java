package com.testjava.controller;

import com.testjava.model.Product;
import com.testjava.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by erwin on 3/31/18.
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> get() {
        return this.productService.get();
    }
}
