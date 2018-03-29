package com.xym.springcloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 使用@FeignClient("computer-service")注解来绑定该接口对应computer-service服务
 * <p>
 * 通过Spring MVC的注解来配置compute-service服务下的具体实现
 * <p/>
 * name:远程服务名，即spring.application.name配置的名称
 *
 * @author xym
 */
@FeignClient(name = "computer-service")
public interface ComputeClient {

    /**
     * 此类中的方法和远程服务中contoller中的方法名和参数需保持一致。
     *
     * @param a
     * @param b
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    Integer add(@RequestParam("a") Integer a, @RequestParam("b") Integer b);

}
