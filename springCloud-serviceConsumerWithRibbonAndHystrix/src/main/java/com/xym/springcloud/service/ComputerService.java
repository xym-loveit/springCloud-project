package com.xym.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 改造原来的服务消费方式，新增ComputeService类，在使用ribbon消费服务的函数上增加@HystrixCommand注解来指定回调方法
 *
 * @author xym
 */
@Service
public class ComputerService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public Integer addService() {
        return restTemplate.getForEntity("http://COMPUTER-SERVICE/add?a=10&b=20", Integer.class).getBody();
    }

    /**
     * 熔断执行方法回调
     *
     * @return
     */
    public Integer addServiceFallback() {
        return -1;
    }

}
