package com.xym.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xym
 */
@RestController
public class ConfigClientController {
    @Value("${xym.hello}")
    private String hello;

    @GetMapping("/hello")
    public String hello() {
        return this.hello;
    }
}
