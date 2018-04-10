package com.xym.springcloud.client;

import com.xym.springcloud.config.FeignConfiguration;
import com.xym.springcloud.pojo.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * 使用@FeignClient的configuration属性指定配置类，同时将findByIdNew上的Spring MVC注解修改为
 * feign自带的注解( RequestLine/Param )
 *
 * @author xym
 */
@FeignClient(name = "abcd", configuration = FeignConfiguration.class)
public interface UserFeignClient {

    @RequestLine("GET /{id}")
    public User findByIdNew(@Param("id") Long id);

}
