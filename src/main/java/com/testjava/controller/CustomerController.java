package com.testjava.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by erwin on 3/31/18.
 */
@RestController
@RequestMapping(value = "/api")
public class CustomerController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String get() {
        return "231321432";
    }

}
