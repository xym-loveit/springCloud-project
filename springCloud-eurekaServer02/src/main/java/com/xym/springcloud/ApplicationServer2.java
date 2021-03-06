package com.xym.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author xym
 */
@SpringBootApplication
@EnableEurekaServer
public class ApplicationServer2 {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ApplicationServer2.class).web(true).run(args);
    }
}
