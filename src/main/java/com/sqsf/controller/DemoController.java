package com.sqsf.controller;

import com.alibaba.fastjson.JSONObject;
import com.sqsf.mapper.RootEntityMapper;
import com.sqsf.service.RootService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gzx
 * @create 2020-10-16 15:39
 */

//注解的方式进行配置
@RestController
@RequestMapping("/root")  //配置系统拦截url
public class DemoController {

    @Autowired
    private RootService rootService;

    @RequestMapping("/login")
    public JSONObject login(){


        return rootService.login();
    }
}
