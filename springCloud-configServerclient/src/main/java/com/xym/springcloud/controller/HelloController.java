package com.xym.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xym
 */
@RestController
public class HelloController {

    @Value("${xym.hello}")
    private String xymHello;

    @RequestMapping("/hello")
    public String hello() {
        return this.xymHello;
    }

}
