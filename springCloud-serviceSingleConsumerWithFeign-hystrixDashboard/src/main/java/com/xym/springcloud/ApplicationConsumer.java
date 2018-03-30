package com.xym.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author xym
 */
@SpringBootApplication
/*启用服务发现*/
@EnableDiscoveryClient
/*启用熔断*/
@EnableCircuitBreaker
/*启用远程调用*/
@EnableFeignClients
/*启用熔断监控*/
@EnableHystrixDashboard
public class ApplicationConsumer {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ApplicationConsumer.class).run(args);
    }
}
