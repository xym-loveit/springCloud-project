package com.xym.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author xym
 */
@EnableDiscoveryClient
@SpringBootApplication
/*启用断路器支持*/
//可以通过health endpoint观察hytrix属性，（"hystrix":{"status":"CIRCUIT_OPEN","openCircuitBreakers":["MovieController::findById"]}）
//默认阈值为5秒内20次失败,断路器会打开
@EnableCircuitBreaker
public class ConsumerMovieApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerMovieApplication.class, args);
    }

}
