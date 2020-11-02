package com.sqsf.mapper;

import com.sqsf.entity.EpideSituDisplayPersonEntity;
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
}
