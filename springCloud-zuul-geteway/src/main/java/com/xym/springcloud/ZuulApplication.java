package com.xym.springcloud;

import com.xym.springcloud.filter.AccessZuulFilter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @author xym
 */
@SpringCloudApplication
/*启用zuul服务网关代理*/
@EnableZuulProxy
public class ZuulApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
    }

    @Bean
    public AccessZuulFilter accessZuulFilter(){
        return new AccessZuulFilter();
    }
}
