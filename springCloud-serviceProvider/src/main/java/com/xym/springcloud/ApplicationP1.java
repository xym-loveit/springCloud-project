package com.xym.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xym
 */
@SpringBootApplication
//该注解能激活Eureka中的DiscoveryClient实现
@EnableDiscoveryClient
public class ApplicationP1 {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ApplicationP1.class).web(true).run(args);
    }
}
