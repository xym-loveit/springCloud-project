package com.xym.springcloud.controller;

import com.xym.springcloud.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 提供rest接口的Controller改为调用ComputeService的addService
 *
 * @author xym
 */
@RestController
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public Integer add() {
        return computerService.addService();
    }

}
