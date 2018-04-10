package com.xym.springcloud;

import com.xym.springcloud.config.FeignConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 和ribbon的配置一样，本例中的FeignConfiguration类也不能包含在主应用程序上下文的@ComponentScan中，否则该类中的配置信息就会被所有的
 *
 * @author xym
 * @FeignClient共享 因此，如果只想自定义某个feign客户端的配置，必须防止@Configuration注解的类所在的包与@ComponentScan扫描的包重叠，或应显示指定@ComponentScan不扫描
 * @Configuration类所在的包
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = {FeignConfiguration.class})
@EnableFeignClients
public class ConsumerMovieApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerMovieApplication.class, args);
    }

}
