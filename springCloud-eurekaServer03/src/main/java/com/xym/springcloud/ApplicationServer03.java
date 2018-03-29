package com.xym.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 第三个eureka服务注册中心，防止单点问题
 *
 * @author xym
 */
@SpringBootApplication
@EnableEurekaServer
public class ApplicationServer03 {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ApplicationServer03.class).web(true).run(args);
    }
}
