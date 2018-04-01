package com.xym.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xym
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientApplication {
    public static void main(String[] args) {
//        SpringApplication.run(ConfigClientApplication.class, args);

        new SpringApplicationBuilder(ConfigClientApplication.class).web(true).run(args);
    }
}
