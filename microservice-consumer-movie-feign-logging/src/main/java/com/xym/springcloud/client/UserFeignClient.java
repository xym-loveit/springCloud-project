package com.xym.springcloud.client;

import com.xym.springcloud.config.FeignLogConfiguration;
import com.xym.springcloud.pojo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author xym
 */
@FeignClient(name = "abcd", configuration = FeignLogConfiguration.class)
public interface UserFeignClient {


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findByIdNew(@PathVariable("id") Long id);

}
