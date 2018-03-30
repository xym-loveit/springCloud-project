package com.xym.springcloud.hystrix;

import com.xym.springcloud.remote.HelloRemote;
import org.springframework.stereotype.Component;

/**
 * 发生熔断后执行类回调方法
 *
 * @author xym
 */
@Component
public class HelloRemoteHystrix implements HelloRemote {
    @Override
    public String hello123(String name) {
        return "hello " + name + " , this messge send failed";
    }
}
