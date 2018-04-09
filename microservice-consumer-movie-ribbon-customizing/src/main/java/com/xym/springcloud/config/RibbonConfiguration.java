package com.xym.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 该类为ribbon的配置类
 * <p>
 * 注意：该类不应该在主应用程序上下文的@ComponentScan中，否则该类中的所有配置信息会被所有的RibbonClient共享，
 * 如果只想自定义某一个ribbon客户端的配置，必须防止@Configuration注解的类所在的包与@ComponentScan扫描的包重叠，
 * 或应显示指定@ComponentScan不扫描@Configuration类所在的包
 *
 * @author xym
 */
@Configuration
public class RibbonConfiguration {

    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }

}
