package com.xym.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xym
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index(@RequestParam("name") String name) {
        return "hello " + name + " this is first message";
    }

}
