package com.xym.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author xym
 */
@SpringBootApplication
@EnableEurekaServer
public class HAServer2Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(HAServer2Application.class).web(true).run(args);
    }
}