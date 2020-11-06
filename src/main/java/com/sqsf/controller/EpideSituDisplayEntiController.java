package com.sqsf.controller;

import com.sqsf.service.EpideSituDisplayEntiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;


//解决跨域问题
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",maxAge = 3600)
//注解的方式进行配置
@RestController  //返回json字符串的数据，直接可以编写RESTFul的接口
@SpringBootApplication  //@SpringBootApplication声明让spring boot自动给程序进行必要的配置
@RequestMapping("/root/getEpideSituDisplayEnti")  //配置系统拦截url
public class EpideSituDisplayEntiController {
    @Autowired
    private EpideSituDisplayEntiService epideSituDisplayEntiService;


    /**
     *
     * 接口1 赵晓凤：大屏最顶端信息：返校人数 外省返校人数 境外返校人数 重点观察人数
     */
    @RequestMapping(value = "/sy_baseinfo", method = RequestMethod.GET)
    public Object getSyBaseinfo(String school) {

        return epideSituDisplayEntiService.getSyBaseinfo(school);
    }

    /**
     * 接口2、赵晓凤：
     * 疫情监控数据：(全国、全省、全市、全校)累计确诊、境外输入确诊、现有确诊、现有疑似、累计治愈、累计死亡 调用公网用友接口
     *
     */
    @RequestMapping(value = "/sy_yqjkinfo",method = RequestMethod.GET)
    public Object getSyYqjkinfo(String school){
        return epideSituDisplayEntiService.getSyYqjkinfo(school);
    }

    /**
     * 接口3、赵晓凤：、重点观察人员：姓名、学院、来源地、来源地确诊人数
     */
    @RequestMapping(value = "sy_zdgcryinfo", method = RequestMethod.GET)
    public Object getSyZdgcryinfo(String school){
        return epideSituDisplayEntiService.getSyZdgcryinfo(school);

    }
    /**
     * 接口4、赵晓凤：、校园人员分布：校园中心gps（百度地图）
     */
    @RequestMapping(value = "/sy_xyryfbinfo", method = RequestMethod.GET)
    public Object getSyXyryfbinfo(String school){
        return epideSituDisplayEntiService.getSyXyryfbinfo(school);
    }


    /**
     * 许歌辉：接口5 预警信息:学生或老师扫码事件
     *
     * @return
     */
    @RequestMapping(value = "/getSyYjinfo", method = RequestMethod.GET)
    public Object getSyYjinfo(String school) {

        return epideSituDisplayEntiService.getSyYjinfo(school);

    }
    /**
     * 许歌辉：接口6、热门来源
     *
     * @return
     */
    @RequestMapping(value = "/getSyRmlyinfo", method = RequestMethod.GET)
    public Object getSyRmlyinfo(String school){

        return epideSituDisplayEntiService.getSyRmlyin(school);
    }

    /**
     * 许歌辉：接口7、返校交通
     *
     * @return
     */
    @RequestMapping(value = "/getSyFxjtinfo", method = RequestMethod.GET)
    public Object getSyFxjtinfo( String school) {

        return epideSituDisplayEntiService.getSyFxjtinfo(school);
    }






}







