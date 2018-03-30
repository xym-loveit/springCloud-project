package com.xym.springcloud.remote;

import com.xym.springcloud.hystrix.HelloRemoteHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign是一个声明式Web Service客户端。使用Feign能让编写Web Service客户端更加简单, 它的使用方法是定义一个接口，然后在上面添加注解，同时也支持JAX-RS标准的注解。Feign也支持可拔插式的编码器和解码器。Spring Cloud对Feign进行了封装，使其支持了Spring MVC标准注解和HttpMessageConverters。Feign可以与Eureka和Ribbon组合使用以支持负载均衡。
 * <p>
 * name:远程服务名，及spring.application.name配置的名称
 * 此类中的方法和远程服务中contoller中的方法名(由RequestMapping指定)和参数(RequestParam)需保持一致
 * <p>
 * 在HelloRemote类添加指定fallback类，在服务熔断的时候返回fallback类中的内容。
 *
 * @author xym
 */
@FeignClient(name = "spring-cloud-producer", fallback = HelloRemoteHystrix.class)
public interface HelloRemote {

    /**
     * RequestMapping里的hello参数要求和远程服务中controller中的方法名及其参数保持一致
     *
     * @param name
     * @return
     */
    @RequestMapping("hello")
    public String aaa(@RequestParam("name") String name);

}
