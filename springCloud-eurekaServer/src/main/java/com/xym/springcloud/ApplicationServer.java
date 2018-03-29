package com.xym.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka服务注册中心
 *
 * @author xym
 * @EnableEurekaServer注解启动一个服务注册中心提供给其他应用进行对话 <p/>
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class ApplicationServer {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ApplicationServer.class).web(true).run(args);
    }
}
