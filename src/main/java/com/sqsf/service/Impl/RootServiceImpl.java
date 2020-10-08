package com.sqsf.service.Impl;

import com.sqsf.service.RootService;
import org.springframework.stereotype.Service;

/**
 * @author gzx
 * @create 2020-09-27 18:16
 */

@Service
public class RootServiceImpl implements RootService {

//    @Autowired
//    private RootEntityMapper rootEntityMapper;

    /**
     * 1 大屏登录
     * @param school
     * @param user
     * @param password
     * @return
     */
//    @Override
//    public RootEntity login(String school, String user, String password) throws JSONException {
//
//        // 创建RootEntity对象
//        RootEntity rootEntity= new RootEntity();
//
//
//        // 调用RootEntityMapper方法进行查询
//        List<RootEntity> rootEntityList = rootEntityMapper.selectRootEntity(rootEntity);
//
//        JSONObject resultJsonObject = new JSONObject();
//        resultJsonObject.put("errorCode", 0);//错误码4000参数为空 4001参数不正确， 4002认证失败
//        resultJsonObject.put("MGSS", "登录成功");//
//
//        if(rootEntityList.size()==0) {
//            resultJsonObject.put("errorCode", "4002");//错误码4000参数为空 4001参数不正确， 4002认证失败
//            resultJsonObject.put("MGSS", "登录失败");//
//        }
//
//        resultJsonObject.put("school", rootEntityList.get(0).getSchool()); //获取学校为JSON数据
//        resultJsonObject.put("url", rootEntityList.get(0).getBigscreenUrl()); //获取大屏URL为JSON数据
//
//        return rootEntity;
//    }
}
