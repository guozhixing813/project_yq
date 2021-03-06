package com.sqsf.mapper;

import com.sqsf.entity.EpideSituDisplayPersonEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gzx
 * @create 2020-11-01 18:01
 */
@Repository
public interface EpideSituDisplayPersonMapper {

    /**
     * 郭枝杏：3.1 整体概况接口
     *
     * @param school
     * @return
     */
    @Select("SELECT  SUM(IF(person_type ='1',1,0)) AS teachercount,SUM(IF(person_type ='0',1,0)) "
            + "AS studentcount, SUM(IF(person_type ='2',1,0)) AS foreigner,SUM(IF(person_type ='3',1,0)) "
            + "AS other FROM (SELECT * FROM sq_fxdata_collection  WHERE school =#{school} GROUP BY user_no)tmp1 "
            + "LEFT JOIN  (SELECT * FROM sq_student_info GROUP BY user_no) tmp2 ON tmp1.user_no = tmp2.user_no ")
    @Results({
    })
    public List<EpideSituDisplayPersonEntity> getEntiCount(String school);

    @Select("SELECT  SUM(IF(fx_addr_country !='中国',1,0)) AS fromOtherCountry,"
            + "SUM(IF(fx_addr_city ='武汉市',1,0)) AS fromWuHan, count(1) AS focusObservation  "
            + "FROM (select * from sq_fxhealth_collection AS tmp1 WHERE tmp1.school =#{school} AND tmp1.heathinfo1!='00001'&& "
            + "tmp1.id IN (select SUBSTRING_INDEX(group_concat(id order by `create_time` desc),',',1)"
            + "from sq_fxhealth_collection group by user_no)) tmp2 LEFT JOIN (SELECT * FROM sq_fxdata_collection WHERE school =#{school} group by user_no)tmp3 ON tmp2.user_no"
            + " = tmp3.user_no WHERE tmp2.school =#{school}")
    @Results({
    })
    public List<EpideSituDisplayPersonEntity> getZdsrCount(String school);

    /**
     * 郭枝杏：3.3 校门出入折线图
     *
     * @param school
     * @return
     */
    @Select("SELECT DATE_FORMAT( time, '%H' ) AS timestamp,SUM(IF(person_type ='1',1,0)) AS teachercount ,"
            + "SUM(IF(person_type ='0',1,0)) AS studentcount,SUM(IF(person_type ='3',1,0)) AS other  "
            + "FROM `sq_wxgj_collection` LEFT JOIN sq_student_info ON  sq_wxgj_collection.user_no ="
            + " sq_student_info.user_no WHERE sq_wxgj_collection.time> CURDATE() AND sq_wxgj_collection.school =#{school} AND addr like '%校门%' GROUP BY DATE_FORMAT( time, '%Y-%m-%d %H' )")
    @Results({
    })
    List<EpideSituDisplayPersonEntity> getXmcrCount(String school); // 校门出入

    /**
     * 钱慧玲：4 预警接口
     *
     * @param school
     * @return
     */
    @Select("SELECT heathinfo1,timestamp FROM `sq_fxhealth_collection` WHERE school =#{school} and heathinfo1!='00001';")
    @Results({
    })
    List<EpideSituDisplayPersonEntity> getYjxno(String school);

    @Select("SELECT count(1) AS count FROM `sq_fxhealth_collection` "
            + "WHERE school =#{school} and create_time>  date_sub(NOW(),interval 1 day) and heathinfo1!='00001';")
    @Results({
    })
    List<EpideSituDisplayPersonEntity> getYjxnos(String school);


    /**
     * 接口5事件列表
     *
     * @return
     */
    @Select("SELECT user_name AS userName,user_no AS userNo,`timestamp`AS timestamp"
            + " FROM `sq_fxhealth_collection` WHERE school =#{school} and is_quarantine=1;")
    @Results({
    })
    List<EpideSituDisplayPersonEntity> getSysj(String school);

    /**
     * 钱慧玲：5 响应事件
     *
     * @param school
     * @return
     */
    @Select("SELECT TMP1.user_name AS userName, sex AS sex, age AS age, classes AS classes, phone, parents_phone AS parentPhone, "
            + "fx_time AS fxTime,TMP2.fx_vehicl AS fxVehicl,TMP2.fxjt_sm AS fxjtSm ,TMP2.fx_addr_city AS addr FROM (SELECT * FROM sq_student_info "
            + "WHERE school =#{school} AND user_no = #{userNo}) TMP1 LEFT JOIN (select * from "
            + "sq_fxdata_collection AS tmp1 WHERE school = #{school} AND user_no = #{userNo} AND "
            + "tmp1.id IN (select SUBSTRING_INDEX(group_concat(id order by `create_time` desc),',',1) "
            + "from sq_fxdata_collection WHERE school = #{school} AND user_no = #{userNo} group by user_no))"
            + "TMP2 ON TMP1.user_no = TMP2.user_no;" +
            "")
    @Results({
//	        @Result(property = "name",  column = "name"),
//	        @Result(property = "industry", column = "industry")
    })
    List<EpideSituDisplayPersonEntity> getPersonInfoDetail(@Param("school") String school, @Param("userNo") String personNo);

    /**
     * 钱慧玲：  6、响应事件
     *
     * @param school
     * @param personNo
     * @return
     */
    @Select("SELECT user_name AS userName FROM `sq_student_info` GROUP BY user_no ORDER BY id  DESC LIMIT 10  ;")
    @Results({
//         @Result(property = "name",  column = "name"),
//         @Result(property = "industry", column = "industry")
    })
    List<EpideSituDisplayPersonEntity> getRelationPersonInfo(String school, String personNo);
    /**
     *
     * 李婉婷：  7.人员详情信息
     * @param userNo
     * @return
     */
    @Select("SELECT TMP1.user_name AS userName, sex AS sex, age AS age, classes AS classes, phone, parents_phone AS parentPhone, "
            + "fx_time AS fxTime,TMP2.fx_vehicl AS fxVehicl,TMP2.fxjt_sm AS fxjtSm ,TMP2.fx_addr_city AS addr FROM (SELECT * FROM sq_student_info "
            + "WHERE school =#{school} AND user_no = #{userNo}) TMP1 LEFT JOIN (select * from "
            + "sq_fxdata_collection AS tmp1 WHERE school = #{school} AND user_no = #{userNo} AND "
            + "tmp1.id IN (select SUBSTRING_INDEX(group_concat(id order by `create_time` desc),',',1) "
            + "from sq_fxdata_collection WHERE school = #{school} AND user_no = #{userNo} group by user_no))"
            + "TMP2 ON TMP1.user_no = TMP2.user_no;" +
            "")
    @Results({
//	        @Result(property = "name",  column = "name"),
//	        @Result(property = "industry", column = "industry")
    })
    List<EpideSituDisplayPersonEntity> getpersonInfoDetail(@Param("school") String school,@Param("userNo") String userNo);



    /**
     *
     * @param userNo
     * @return
     */
    @Select("SELECT create_time AS timestamp FROM `sq_fxhealth_collection` WHERE school =#{school} AND user_no=#{userNo} and heathinfo1!='00001';")
    @Results({
//	        @Result(property = "name",  column = "name"),
//	        @Result(property = "industry", column = "industry")
    })
    List<EpideSituDisplayPersonEntity> getpersonInfoSDetail(@Param("school") String school,@Param("userNo")String userNo);


    /**
     * 李婉婷  接口8.个人轨迹图
     *
     * @param school
     * @return
     */
    @Select("SELECT center_longitude AS centerLongitude,center_dimension AS centerDimension"
            + " FROM `sq_school_configure` WHERE school=#{school};")
    @Results({
    })
    List<EpideSituDisplayPersonEntity> getSyGrgjt(@Param("school") String school);

    /**
     * 李婉婷  接口8.个人轨迹图
     * @param personNo
     * @param school
     * @return
     */
    @Select("SELECT addr, longitude AS longitude ,dimension AS dimension,time FROM `sq_wxgj_collection` "
            + "WHERE school=#{school} and user_no=#{personNo} limit 20;")
    @Results({
    })
    List<EpideSituDisplayPersonEntity> getSyGrgjtLD(@Param("school") String school, @Param("personNo") String personNo);

    /**
     * 李婉婷  接口9.个人相应事件
     * @param personNo
     * @param school
     * @return
     */
    @Select("SELECT user_name AS userName ,user_no AS userNo, addr,time FROM `sq_wxgj_collection` WHERE school=#{school} and user_no=#{personNo};")
    @Results({
    })
    List<EpideSituDisplayPersonEntity> getSyGrxysj(@Param("school")String school,@Param("personNo")String personNo,@Param("isStudent")String isStudent);



}
