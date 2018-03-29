package com.xym.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 使用@EnableCircuitBreaker注解开启断路器功能：
 *
 * @author xym
 */
@SpringBootApplication
@EnableDiscoveryClient
/*启用熔断器*/
@EnableCircuitBreaker
public class ApplicationWithHystrix {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationWithHystrix.class, args);
    }
}
