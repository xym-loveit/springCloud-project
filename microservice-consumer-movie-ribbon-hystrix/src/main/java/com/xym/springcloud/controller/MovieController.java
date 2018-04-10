package com.xym.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xym.springcloud.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author xym
 */
@RestController
public class MovieController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient client;

    @HystrixCommand(fallbackMethod = "findByIdFallback")
    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return restTemplate.getForObject("http://abcd/" + id, User.class);
    }

    /**
     * 回退方法
     *
     * @param id
     * @return
     */
    public User findByIdFallback(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setName("默认用户");
        return user;
    }

    @GetMapping("/log-instance")
    public void logUserInstance() {
        //打印当前选择的哪个节点
        ServiceInstance choose = client.choose("abcd");
        LOGGER.info("{}:{}:{}", choose.getServiceId(), choose.getHost(), choose.getPort());
    }

}
