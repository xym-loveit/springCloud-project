package com.xym.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xym
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Provider2Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Provider2Application.class).web(true).run(args);
    }
}
