package com.sqsf.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sqsf.entity.WxApiEntity;
import com.sqsf.mapper.WxApiMapper;
import com.sqsf.service.WxApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author gzx
 * @create 2020-11-06 15:17
 */

//解决跨域问题
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",maxAge = 3600)
//注解的方式进行配置
@RestController
@SpringBootApplication
@RequestMapping("/corocon/postWxApi")
public class WxApiController {

    @Autowired
    private WxApiService wxApiService;

    /**
     * 接口1、1、每天健康数据采集：
     * @return
     */
    @RequestMapping(value = "/yq_mtjkinfo",method = RequestMethod.POST)
    public Object postYqMtjkinfo(
            @RequestBody Map params
    ) {

        return wxApiService.postYqMtjkinfo(params);
    }


    /**
     * 接口2、返校报到数据采集：
     * @return
     */
    @RequestMapping(value = "/yq_fxbdinfo",method = RequestMethod.POST)
    public Object postYqFxbdinfo(
            @RequestBody Map params
    ) {

        return wxApiService.postYqFxbdinfo(params);


    }

    /**
     * 3、学生扫码数据采集
     * @return
     */
    @RequestMapping(value = "/yq_saomainfo",method = RequestMethod.POST)
    public Object postYqSaomainfo(
            @RequestBody Map params
    ) {

       return wxApiService.postYqSaomainfo(params);
    }

    /**
     * 4、学生注册信息
     * @return
     */
    @RequestMapping(value = "/yq_zhuceinfo",method = RequestMethod.POST)
    public Object postYqZhuceinfo(
            @RequestBody Map params
    ) {

        return wxApiService.postYqZhuceinfo(params);
    }

    /**
     * 5学生登陆接口
     * @return
     */
    @RequestMapping(value = "/yq_login",method = RequestMethod.POST)
    public Object postYqLogin(
            @RequestBody Map params
    ) {

        return wxApiService.postYqLogin(params);

    }


    /**
     * 6 获取学校列表：
     * @return
     */
    @RequestMapping(value = "/yq_getcollagelist",method = RequestMethod.POST)
    public Object postGetcollagelist(
//			    		@RequestBody Map params
    ) {

       return wxApiService.postGetcollagelist();
    }


    /**
     * 7、获取扫码历史列表
     * @return
     */
    @RequestMapping(value = "/yq_getsaomalist",method = RequestMethod.POST)
    public Object postGetSaomalist(
            @RequestBody Map params
    ) {

        return wxApiService.postGetSaomalist(params);
    }

    /**
     * 8、提交来访人员信息：
     * @return
     */
    @RequestMapping(value = "/yq_savevisitorinfo",method = RequestMethod.POST)
    public Object postSavevisitorinfo  (
            @RequestBody Map params
    ) {

        return wxApiService.postSavevisitorinfo(params);
    }

    /**
     * 9、获取行政部门信息：
     * @return
     */
    @RequestMapping(value = "/yq_getdepartlist",method = RequestMethod.POST)
    public Object postGetdepartlist    (
            @RequestBody Map params
    ) {

        return wxApiService.postGetdepartlist(params);
    }
}
