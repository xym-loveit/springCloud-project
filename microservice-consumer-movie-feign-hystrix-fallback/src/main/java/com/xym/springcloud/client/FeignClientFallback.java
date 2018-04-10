package com.xym.springcloud.client;

import com.xym.springcloud.pojo.User;
import org.springframework.stereotype.Component;

/**
 * 回退类FeignClientFallback需实现feign client接口
 *
 * @author xym
 */
@Component
public class FeignClientFallback implements UserFeignClient {

    @Override
    public User findByIdNew(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setName("默认用户");
        return user;
    }
}
