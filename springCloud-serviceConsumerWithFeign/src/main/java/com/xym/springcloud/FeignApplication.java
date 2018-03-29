package com.xym.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 我们通过Feign以接口和注解配置的方式，轻松实现了对computer-service服务的绑定，这样我们就可以在本地应用中像本地服务一样的调用它，并且做到了客户端均衡负载
 *
 * @author xym
 */
@SpringBootApplication
@EnableDiscoveryClient
//@EnableFeignClients注解开启Feign功能
@EnableFeignClients
public class FeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }
}
