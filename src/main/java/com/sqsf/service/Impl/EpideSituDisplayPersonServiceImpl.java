package com.sqsf.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sqsf.entity.EpideSituDisplayPersonEntity;
import com.sqsf.mapper.EpideSituDisplayPersonMapper;
import com.sqsf.service.EpideSituDisplayPersonService;
import com.sqsf.service.SchoolPara;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author gzx
 * @create 2020-11-01 17:59
 */
@Service
public class EpideSituDisplayPersonServiceImpl implements EpideSituDisplayPersonService {

    private static final String DEFAULTSCHOOL = "商丘师范学院";

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
     *
     * @param school
     * @return
     */
    @Override
    public JSONObject getEntiCounts(String school) {

        JSONObject resultJsonObject = new JSONObject();
        if (null == school || "".equals(school)) school = DEFAULTSCHOOL;

        //校验输入参数合法性
//		if("".equals(isStudent)||"".equals(isStudent)) {
//			resultJsonObject.put("errorCode", "4000");//错误码4000参数为空 4001参数不正确， 4002认证失败
//			return resultJsonObject;
//		}
        try {
            List<EpideSituDisplayPersonEntity> baseInfoList = epideSituDisplayPersonMapper.getEntiCount(school);
            List<EpideSituDisplayPersonEntity> zdsrInfoList = epideSituDisplayPersonMapper.getZdsrCount(school);
            if (baseInfoList.size() <= 0 || zdsrInfoList.size() <= 0) {
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
     *
     * @param isStudent
     * @param personNo
     * @return
     */
    @Override
    public Object getEntiCount(String isStudent, String personNo) {
        //校验输入参数合法性
        if ("".equals(isStudent) || "".equals(isStudent)) {
            resultJsonObject.put("errorCode", "4000");//错误码4000参数为空 4001参数不正确， 4002认证失败
            return resultJsonObject;
        }
        try {
            List<EpideSituDisplayPersonEntity> baseInfoList = epideSituDisplayPersonMapper.getEntiCount("school");
            if (baseInfoList.size() <= 0) {
                resultJsonObject.put("errorCode", "4000");//错误码4000参数为空 4001参数不正确， 4002认证失败
                return resultJsonObject;
            }
            resultJsonObject.put("errorCode", "");//错误码4000参数为空 4001参数不正确， 4002认证失败
            resultJsonObject.put("isStudent", isStudent);//输入值
            resultJsonObject.put("personNo", personNo);//输入值
            JSONArray objectArray = new JSONArray();//Json数组

            JSONObject object1 = new JSONObject();
            object1.put("value", 0);
            object1.put("name", "正在14天隔离人数");
            objectArray.add(object1);
            JSONObject object2 = new JSONObject();
            object2.put("value", 0);
            object2.put("name", "结束14天隔离人数");
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
     *
     * @param school
     * @return
     */
    @Override
    public Object getXmcrCount(String school) {
        JSONObject resultJsonObject = new JSONObject();
        if (null == school || "".equals(school)) school = DEFAULTSCHOOL;

        try {
            List<EpideSituDisplayPersonEntity> baseInfoList = epideSituDisplayPersonMapper.getXmcrCount(school);
//			if(baseInfoList.size()<=0) {
//				resultJsonObject.put("errorCode", "4000");//错误码4000参数为空 4001参数不正确， 4002认证失败
//				return resultJsonObject;
//			}
            resultJsonObject.put("errorCode", "");//错误码4000参数为空 4001参数不正确， 4002认证失败

            String[] xData = {"01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00"
                    , "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00", "24:00"};
            Integer[] yDataStudent = new Integer[24];
            Integer[] yDataTeacher = new Integer[24];
            Integer[] yDataOther = new Integer[24];

            for (int i = 0; i < 24; i++) {
                yDataStudent[i] = 0;
                yDataTeacher[i] = 0;
                yDataOther[i] = 0;
                for (EpideSituDisplayPersonEntity object : baseInfoList) {
                    if (Integer.valueOf(object.getTimestamp()) == i + 1) {

                        yDataStudent[i] = yDataStudent[i] + object.getStudentcount();
                        yDataTeacher[i] = yDataTeacher[i] + object.getTeachercount();
                        yDataOther[i] = yDataOther[i] + object.getOther();
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

    /**
     * 钱慧玲：4 预警接口
     *
     * @param school
     * @return
     */
    @Override
    public JSONObject getYjxno(String school) {
        JSONObject resultJsonObject = new JSONObject();
        resultJsonObject.put("errorCode", "");//错误码4000参数为空 4001参数不正确， 4002认证失败
        if (null == school || "".equals(school)) school = DEFAULTSCHOOL;

        List<String> result = new ArrayList<>();
        List<EpideSituDisplayPersonEntity> epideSituInfoList = epideSituDisplayPersonMapper.getYjxno(school);
        List<EpideSituDisplayPersonEntity> epidesSituInfoList = epideSituDisplayPersonMapper.getYjxnos(school);

        Integer[] count = new Integer[]{0, 0, 0, 0, 0};
        for (EpideSituDisplayPersonEntity epideSituInfo : epideSituInfoList) {
            String heathinfo1 = epideSituInfo.getHeathinfo1();
            String timestamp = epideSituInfo.getTimestamp();
            if (heathinfo1.length() != 5) break;
            for (int i = 0; i < 4; i++) {
                if ("1".equals(heathinfo1.substring(i, i + 1))) {
                    count[i]++;
                }
            }

        }
        result.add("至目前累计前出现发热" + count[0] + "位");
        result.add("至目前累计前出现咳嗽" + count[1] + "位");
        result.add("至目前累计前出现气喘" + count[2] + "位");
        result.add("至目前累计前出现腹泻" + count[3] + "位");
        //result.add("至目前累计确诊0例");
        result.add("今日新增发热、咳嗽、气喘、腹泻" + epidesSituInfoList.get(0).getCount() + "位");
        resultJsonObject.put("result", result);

//        logger.info("sy_ejxyfxinfo API  END");
        return resultJsonObject;
    }

    /**
     * 钱慧玲：5、响应事件
     *
     * @return
     */
    @Override
    public JSONObject getSysj(String school) {
        JSONObject resultJsonObject = new JSONObject();
        resultJsonObject.put("errorCode", "");//错误码4000参数为空 4001参数不正确， 4002认证失败
        if (null == school || "".equals(school)) school = DEFAULTSCHOOL;

        JSONArray result = new JSONArray();
        List<EpideSituDisplayPersonEntity> epideSituInfoList = epideSituDisplayPersonMapper.getSysj(school);
        for (EpideSituDisplayPersonEntity epideSituInfo : epideSituInfoList) {
            JSONObject jsonObj1 = new JSONObject();
            jsonObj1.put("name", epideSituInfo.getUserName());
            jsonObj1.put("content", epideSituInfo.getTimestamp() + "隔离");
            jsonObj1.put("level", "一级");
            result.add(jsonObj1);
        }


        resultJsonObject.put("result", result);

        return resultJsonObject;
    }

    /**
     * 钱慧玲：6、响应事件
     *
     * @return
     */
    @Override
    public JSONObject getSySelationship(String school, String personNo) {

        JSONObject resultJsonObject = new JSONObject();
        resultJsonObject.put("errorCode", "");//错误码4000参数为空 4001参数不正确， 4002认证失败
        if (null == school || "".equals(school)) school = DEFAULTSCHOOL;
        JSONArray categoryArray = new JSONArray();
        JSONArray linksArray = new JSONArray();
        JSONArray nodesList = new JSONArray();

        List<EpideSituDisplayPersonEntity> baseInfoList = epideSituDisplayPersonMapper.getPersonInfoDetail(school, personNo);
        List<EpideSituDisplayPersonEntity> relationList = epideSituDisplayPersonMapper.getRelationPersonInfo(school, personNo);
        if (baseInfoList.size() == 0 || relationList.size() == 0) {
            resultJsonObject.put("errorCode", "4001");//错误码4000参数为空 4001参数不正确， 4002认证失败
            resultJsonObject.put("msg", "查询不到人");//错误码4000参数为空 4001参数不正确， 4002认证失败
            resultJsonObject.put("categories", categoryArray);
            resultJsonObject.put("nodes", nodesList);
            resultJsonObject.put("links", linksArray);
            return resultJsonObject;
        }


        JSONObject jsonObj1 = new JSONObject();
        jsonObj1.put("name", "核心人物");
        categoryArray.add(jsonObj1);
        JSONObject jsonObj2 = new JSONObject();
        jsonObj2.put("name", "舍友");
        categoryArray.add(jsonObj2);
//		JSONObject jsonObj3= new JSONObject();
//		jsonObj3.put("name", "密切同学");
//		categoryArray.add(jsonObj3);
        JSONObject jsonObj4 = new JSONObject();
        jsonObj4.put("name", "轨迹接触");
        categoryArray.add(jsonObj4);


        JSONObject nodesObj1 = new JSONObject();
        nodesObj1.put("category", 0);
        nodesObj1.put("name", baseInfoList.get(0).getUserName());
        nodesObj1.put("value", 25);
        nodesObj1.put("label", baseInfoList.get(0).getUserName());
        nodesList.add(nodesObj1);
        JSONObject nodesObj2 = new JSONObject();
        nodesObj2.put("category", 1);
        nodesObj2.put("name", "彭岚承");
        nodesObj2.put("value", 25);
        nodesObj2.put("label", "彭岚承");
        nodesList.add(nodesObj2);
        JSONObject nodesObj3 = new JSONObject();
        nodesObj3.put("category", 1);
        nodesObj3.put("name", "董会风");
        nodesObj3.put("value", 15);
        nodesObj3.put("label", "董会风");
        nodesList.add(nodesObj3);

        for (EpideSituDisplayPersonEntity relationObject : relationList) {
            JSONObject nodesObj4 = new JSONObject();
            nodesObj4.put("category", 2);
            nodesObj4.put("name", relationObject.getUserName());
            nodesObj4.put("value", 23);
            nodesObj4.put("label", relationObject.getUserName());
            nodesList.add(nodesObj4);
        }


        for (int i = 1; i < nodesList.size(); i++) {
            JSONObject linkObj1 = new JSONObject();
            linkObj1.put("source", nodesList.getJSONObject(0).getString("name"));
            linkObj1.put("target", nodesList.getJSONObject(i).getString("name"));
            linkObj1.put("weight ", 1);
            linksArray.add(linkObj1);
        }
        for (int i = 2; i < nodesList.size(); i++) {
            JSONObject linkObj1 = new JSONObject();
            linkObj1.put("source", nodesList.getJSONObject(1).getString("name"));
            linkObj1.put("target", nodesList.getJSONObject(i).getString("name"));
            linkObj1.put("weight ", 1);
            linksArray.add(linkObj1);
        }


        resultJsonObject.put("categories", categoryArray);
        resultJsonObject.put("nodes", nodesList);
        resultJsonObject.put("links", linksArray);

//        logger.info("sy_ejxyfxinfo API  END");
        return resultJsonObject;
    }


}