package com.testjava.controller;

import com.testjava.model.LogisticProvider;
import com.testjava.service.ILogisticProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by erwin on 4/1/18.
 */
@RestController
@RequestMapping(value = "/logisticProvider")
public class LogisticProviderController {

    @Autowired
    private ILogisticProviderService logisticProviderService;

    @RequestMapping(method = RequestMethod.GET)
    public List<LogisticProvider> get() {
        return this.logisticProviderService.get();
    }
}
