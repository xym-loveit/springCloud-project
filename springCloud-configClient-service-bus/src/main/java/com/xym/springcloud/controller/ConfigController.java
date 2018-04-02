package com.xym.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xym
 */
@RefreshScope
@RestController
public class ConfigController {

    @Value("${xym.hello}")
    public String hello;

    @RequestMapping(value = "hello2", method = RequestMethod.GET)
    public String hello() {
        return this.hello;
    }

}
