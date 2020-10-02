package com.sqsf.controller;

import com.sqsf.entity.RootEntity;
import com.sqsf.service.RootService;
import com.sun.tools.hat.internal.model.Root;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author gzx
 * @create 2020-09-27 18:15
 */

//解决跨域问题
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",maxAge = 3600)
//注解的方式进行配置
@RestController  //返回json字符串的数据，直接可以编写RESTFul的接口
@SpringBootApplication  //@SpringBootApplication声明让spring boot自动给程序进行必要的配置
@RequestMapping("/root")  //配置系统拦截url
public class YqloginController {

    @Autowired(required=false)
    private RootService rootService;


    /**
     * 接口1大屏登录接口
     * @return
     */



}
