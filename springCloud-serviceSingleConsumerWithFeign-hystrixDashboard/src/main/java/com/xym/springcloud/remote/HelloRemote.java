package com.xym.springcloud.remote;

import com.xym.springcloud.hystrix.HelloRemoteHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 远程接口调用采用feign描述
 *
 * @author xym
 */
@FeignClient(value = "spring-cloud-producer", fallback = HelloRemoteHystrix.class)
public interface HelloRemote {

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    String hello123(@RequestParam("name") String name);
}
