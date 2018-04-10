package com.xym.springcloud.client;

import com.xym.springcloud.pojo.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author xym
 */
public interface UserFeignClient {


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findByIdNew(@PathVariable("id") Long id);

}
