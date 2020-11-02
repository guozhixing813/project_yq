package com.sqsf.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sqsf.entity.EpideSituDisplayPersonEntity;
import com.sqsf.mapper.EpideSituDisplayPersonMapper;
import com.sqsf.service.EpideSituDisplayPersonService;
import com.sqsf.service.SchoolPara;
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

    /**
     * 郭枝杏：3.1 整体概况接口
     * @param school
     * @return
     */
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

        }
        return resultJsonObject;
    }

    /**
     * 郭枝杏：3.2 隔离人数饼状图
     * @param isStudent
     * @param personNo
     * @return
     */
    @Override
    public Object getEntiCount(String isStudent, String personNo) {
        //校验输入参数合法性
        if("".equals(isStudent)||"".equals(isStudent)) {
            resultJsonObject.put("errorCode", "4000");//错误码4000参数为空 4001参数不正确， 4002认证失败
            return resultJsonObject;
        }
        try {
			List<EpideSituDisplayPersonEntity> baseInfoList = epideSituDisplayPersonMapper.getEntiCount("school");
			if(baseInfoList.size()<=0) {
				resultJsonObject.put("errorCode", "4000");//错误码4000参数为空 4001参数不正确， 4002认证失败
				return resultJsonObject;
			}
            resultJsonObject.put("errorCode", "");//错误码4000参数为空 4001参数不正确， 4002认证失败
            resultJsonObject.put("isStudent", isStudent);//输入值
            resultJsonObject.put("personNo", personNo);//输入值
            JSONArray objectArray = new JSONArray();//Json数组

            JSONObject object1 = new JSONObject();
            object1.put("value",0);
            object1.put("name","正在14天隔离人数");
            objectArray.add(object1);
            JSONObject object2 = new JSONObject();
            object2.put("value",0);
            object2.put("name","结束14天隔离人数");
            objectArray.add(object2);
            resultJsonObject.put("data", objectArray);//输入值

			resultJsonObject.put("teachercount", baseInfoList.get(0).getTeachercount());//教师数量
			resultJsonObject.put("studentcount", baseInfoList.get(0).getStudentcount());//学生数量
			resultJsonObject.put("foreigner", baseInfoList.get(0).getForeigner());//留学生
    		resultJsonObject.put("other", baseInfoList.get(0).getOther());//随访人
			resultJsonObject.put("fromOtherCountry", baseInfoList.get(0).getFromOtherCountry());//境外输入
			resultJsonObject.put("fromWuHan", baseInfoList.get(0).getFromWuHan());//武汉输入
			resultJsonObject.put("focusObservation", baseInfoList.get(0).getFocusObservation());//重点观察
        } catch (Exception e) {
            resultJsonObject.put("errorCode", "4003");//错误码4000参数为空 4001参数不正确， 4002认证失败
        }

//        logger.info("getRelationshipMap API  END");
        return resultJsonObject;
    }

    /**
     * 郭枝杏：3.3 校门出入折线图
     * @param school
     * @return
     */
    @Override
    public Object getXmcrCount(String school) {
        JSONObject resultJsonObject = new JSONObject();
        if(null==school ||"".equals(school)) school =DEFAULTSCHOOL;

        try {
            List<EpideSituDisplayPersonEntity> baseInfoList = epideSituDisplayPersonMapper.getXmcrCount(school);
//			if(baseInfoList.size()<=0) {
//				resultJsonObject.put("errorCode", "4000");//错误码4000参数为空 4001参数不正确， 4002认证失败
//				return resultJsonObject;
//			}
            resultJsonObject.put("errorCode", "");//错误码4000参数为空 4001参数不正确， 4002认证失败

            String[] xData = {"01:00","02:00","03:00","04:00","05:00","06:00","07:00","08:00","09:00","10:00","11:00","12:00"
                    ,"13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00","23:00","24:00"};
            Integer[] yDataStudent = new Integer[24];
            Integer[] yDataTeacher = new Integer[24];
            Integer[] yDataOther = new Integer[24];

            for(int i=0; i<24;i++) {
                yDataStudent[i] =0 ;
                yDataTeacher[i] =0 ;
                yDataOther[i] =0 ;
                for(EpideSituDisplayPersonEntity object:baseInfoList) {
                    if(Integer.valueOf(object.getTimestamp())==i+1) {

                        yDataStudent[i]=yDataStudent[i]+object.getStudentcount();
                        yDataTeacher[i]=yDataTeacher[i]+object.getTeachercount();
                        yDataOther[i]=yDataOther[i]+object.getOther();
                    }
                }
            }
            resultJsonObject.put("xData", xData);//教师数量
            resultJsonObject.put("yDataStudent", yDataStudent);//学生数量
            resultJsonObject.put("yDataTeacher", yDataTeacher);//留学生
            resultJsonObject.put("yDataOther", yDataOther);//随访人
        } catch (Exception e) {
            resultJsonObject.put("errorCode", "4003");//错误码4000参数为空 4001参数不正确， 4002认证失败

        }
        return resultJsonObject;
    }


}
