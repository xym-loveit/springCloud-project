package com.xym.springcloud.hystrix;

import com.xym.springcloud.remote.HelloRemote;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 创建HelloRemoteHystrix类继承与HelloRemote实现回调的方法
 * <p>
 * 熔断的时候返回fallback类中的内容
 *
 * @author xym
 */
@Component
public class HelloRemoteHystrix implements HelloRemote {
    @Override
    public String aaa(@RequestParam("name") String name) {
        return "hello " + name + ", this messge send failed ";
    }
}
