package com.xym.springcloud.controller;

import com.xym.springcloud.client.UserFeignClient;
import com.xym.springcloud.pojo.User;
import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xym
 */
@Import(FeignClientsConfiguration.class)
@RestController
public class MovieController {

    private UserFeignClient userFeignClient;

    private UserFeignClient adminFeignClient;


    @Autowired
    public MovieController(Decoder decoder, Encoder encoder, Client client, Contract contract) {
        this.userFeignClient = Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract).requestInterceptor(new BasicAuthRequestInterceptor("user", "password1")).target(UserFeignClient.class, "http://abcd/");

        this.adminFeignClient = Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract).requestInterceptor(new BasicAuthRequestInterceptor("admin", "password2")).target(UserFeignClient.class, "http://abcd/");
    }

    @GetMapping("/user-user/{id}")
    public User findByIdUser(@PathVariable Long id) {
        return userFeignClient.findByIdNew(id);
    }

    @GetMapping("/user-admin/{id}")
    public User findByIdAdmin(@PathVariable Long id) {
        return adminFeignClient.findByIdNew(id);
    }

}
