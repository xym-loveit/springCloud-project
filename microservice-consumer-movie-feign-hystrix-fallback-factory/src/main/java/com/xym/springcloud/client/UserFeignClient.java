package com.xym.springcloud.client;

import com.xym.springcloud.factory.FeignClientFallbackFactory;
import com.xym.springcloud.pojo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * feign的fallback作回退测试
 * 使用@FeignClient的fallback属性指定回退类
 *
 * @author xym
 */
@FeignClient(name = "abcd",fallbackFactory = FeignClientFallbackFactory.class)
public interface UserFeignClient {


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findByIdNew(@PathVariable("id") Long id);

}
