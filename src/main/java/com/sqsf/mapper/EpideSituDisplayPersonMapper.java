package com.sqsf.mapper;

import com.sqsf.entity.EpideSituDisplayPersonEntity;
import org.apache.ibatis.annotations.Result;
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
     * 李婉婷  7.人员详情信息
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
    })
    List<EpideSituDisplayPersonEntity> getpersonInfoDetail(String school,String userNo);
    /**
     *
     * @param userNo
     * @return
     */
    @Select("SELECT create_time AS timestamp FROM `sq_fxhealth_collection` WHERE school =#{school} AND user_no=#{userNo} and heathinfo1!='00001';")
    @Results({
    })
    List<EpideSituDisplayPersonEntity> getpersonInfoSDetail(String school,String userNo);

}
