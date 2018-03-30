package com.xym.springcloud.controller;

import com.xym.springcloud.remote.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xym
 */
@RestController
public class ConsumerController {

    @Autowired
    private HelloRemote helloRemote;

    @RequestMapping(value = "/hello123/{name}", method = RequestMethod.GET)
    public String hello111(@PathVariable("name") String name) {
        return helloRemote.hello123(name);
    }

}
