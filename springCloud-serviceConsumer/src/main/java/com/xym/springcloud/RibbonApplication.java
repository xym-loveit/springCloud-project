package com.xym.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 打开compute-service的两个服务提供方,观察输出日志
 * <p>
 * 可以看到，之前启动的两个compute-service服务端分别被调用了一次。到这里，我们已经通过Ribbon在客户端已经实现了对服务调用的均衡负载
 *
 * @author xym
 */
@SpringBootApplication
//通过@EnableDiscoveryClient注解来添加发现服务能力
@EnableDiscoveryClient
public class RibbonApplication {

    /**
     * 创建RestTemplate实例，并通过@LoadBalanced注解开启均衡负载能力
     *
     * @return
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class, args);
    }
}
