package com.xym.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xym
 */
@RefreshScope
@RestController
public class HelloController {

    @Value("${xym.hello}")
    private String xymHello;

    @RequestMapping("/hello")
    public String hello() {
        return this.xymHello;
    }

}
