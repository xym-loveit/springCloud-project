package com.xym.springcloud.factory;

import com.xym.springcloud.client.UserFeignClient;
import com.xym.springcloud.pojo.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author xym
 */
@Component
public class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeignClientFallbackFactory.class);

    @Override
    public UserFeignClient create(final Throwable throwable) {
        return new UserFeignClient() {
            @Override
            public User findByIdNew(Long id) {
                /**
                 * 日志最好放在各个fallback方法中，而不要直接在create方法中。
                 * 否则在引用启动时，就会打印该日志
                 */
                LOGGER.info("fallback;reason was:", throwable);
                User user = new User();
                /**
                 *fallbackFactory属性还有其他的用途，例如让不同的异常返回不同的回退结果，这样可以使得feign的回退更加灵活
                 */
                if (throwable != null && (throwable instanceof IllegalArgumentException)) {
                    user.setId(-1L);
                } else {
                    user.setId(-2L);
                }
                user.setName("默认用户");
                return user;
            }

        };
    }
}
