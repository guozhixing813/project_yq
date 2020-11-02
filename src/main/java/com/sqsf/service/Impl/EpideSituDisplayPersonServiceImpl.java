package com.sqsf.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.sqsf.entity.EpideSituDisplayPersonEntity;
import com.sqsf.mapper.EpideSituDisplayPersonMapper;
import com.sqsf.service.EpideSituDisplayPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author gzx
 * @create 2020-11-01 17:59
 */
@Service
public class EpideSituDisplayPersonServiceImpl implements EpideSituDisplayPersonService {

    private static final String DEFAULTSCHOOL ="商丘师范学院";

    @Autowired
    private EpideSituDisplayPersonMapper epideSituDisplayPersonMapper;

    private JSONObject resultJsonObject = new JSONObject();

    @Override
    public List<EpideSituDisplayPersonEntity> getEntiCount(String school) {
        return null;
    }

    @Override
    public List<EpideSituDisplayPersonEntity> getZdsrCount(String school) {
        return null;
    }

    @Override
    public JSONObject getEntiCounts(String school) {

        JSONObject resultJsonObject = new JSONObject();
        if(null==school ||"".equals(school)) school =DEFAULTSCHOOL;

        //校验输入参数合法性
//		if("".equals(isStudent)||"".equals(isStudent)) {
//			resultJsonObject.put("errorCode", "4000");//错误码4000参数为空 4001参数不正确， 4002认证失败
//			return resultJsonObject;
//		}
        try {
            List<EpideSituDisplayPersonEntity> baseInfoList=epideSituDisplayPersonMapper.getEntiCount(school);
            List<EpideSituDisplayPersonEntity> zdsrInfoList=epideSituDisplayPersonMapper.getZdsrCount(school);
            if(baseInfoList.size()<=0 ||zdsrInfoList.size()<=0) {
                resultJsonObject.put("errorCode", "4000");//错误码4000参数为空 4001参数不正确， 4002认证失败
                return (JSONObject) resultJsonObject;
            }
            resultJsonObject.put("errorCode", "");//错误码4000参数为空 4001参数不正确， 4002认证失败
//			resultJsonObject.put("isStudent", isStudent);//输入值
//			resultJsonObject.put("personNo", personNo);//输入值
//
            resultJsonObject.put("teachercount", baseInfoList.get(0).getTeachercount());//教师数量
            resultJsonObject.put("studentcount", baseInfoList.get(0).getStudentcount());//学生数量
            resultJsonObject.put("foreigner", baseInfoList.get(0).getForeigner());//留学生
            resultJsonObject.put("other", baseInfoList.get(0).getOther());//随访人
            resultJsonObject.put("fromOtherCountry", zdsrInfoList.get(0).getFromOtherCountry());//境外输入
            resultJsonObject.put("fromWuHan", zdsrInfoList.get(0).getFromWuHan());//武汉输入
            resultJsonObject.put("focusObservation", zdsrInfoList.get(0).getFocusObservation());//重点观察
        } catch (Exception e) {
            resultJsonObject.put("errorCode", "4003");//错误码4000参数为空 4001参数不正确， 4002认证失败
            // TODO: handle exception
        }

        return resultJsonObject;


    }

}
