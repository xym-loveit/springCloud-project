package com.xym.springcloud.controller;

import com.xym.springcloud.client.UserFeignClient;
import com.xym.springcloud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xym
 */
@RestController
public class MovieController {

    @Autowired
    private UserFeignClient client;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return client.findByIdNew(id);
    }

}
