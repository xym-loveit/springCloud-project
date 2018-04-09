package com.xym.springcloud.controller;

import com.xym.springcloud.dao.UserRepository;
import com.xym.springcloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xym
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id) {
        User user = this.userRepository.findOne(id);
        return user;
    }
}
