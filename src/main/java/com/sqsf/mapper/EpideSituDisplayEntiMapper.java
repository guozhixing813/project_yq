package com.sqsf.mapper;
import com.sqsf.service.EpideSituDisplayService;
import com.sqsf.service.SchoolPara;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EpideSituDisplayEntiMapper {
    //全局接口获取学校参数
    @Select("SELECT province,city FROM `sq_school_configure` WHERE school=#{school}")
    @Results({
            //        @Result(property = "name",  column = "name"),
            //        @Result(property = "industry", column = "industry")
    })
    List<SchoolPara> getSchoolInfo(String school);


    //接口1 查询返校人数
    @Select("select COUNT(1) AS fxNum,SUM(IF(fx_addr_country !='中国',1,0)) AS jwfxNum, SUM(IF(fx_addr_province !=#{province},1,0)) AS wsfxNum"
            + " FROM (SELECT * FROM `sq_fxdata_collection` WHERE school=#{school}) a;")
    @Results({
    })
    List<EpideSituDisplayService> getBaseInfo(String school, String province);

    @Select("select count(1) AS zdgcNum from sq_fxhealth_collection AS tmp1 WHERE school=#{school} && tmp1.heathinfo1!='00001'&& tmp1.id IN "
            + "(select SUBSTRING_INDEX(group_concat(id order by `create_time` desc),',',1) from sq_fxhealth_collection group by user_no)")
    @Results({
    })
    List<EpideSituDisplayService> getZdgcrsInfo(String school);
    //接口3 查询重点观察人员信息   体温大于37.3的温度
    @Select(" SELECT tmp3.user_name AS userName,tmp3.user_no AS userNum,college,fx_addr_province AS originCity FROM "
            + "(SELECT tmp2.user_name,tmp2.user_no,college FROM (select user_name,user_no from sq_fxhealth_collection "
            + "AS tmp1 WHERE school = #{school} && tmp1.heathinfo1!='00001'&& tmp1.id IN "
            + "(select SUBSTRING_INDEX(group_concat(id order by `create_time` desc),',',1) "
            + "from sq_fxhealth_collection WHERE school = #{school} group by user_no)) tmp2 LEFT JOIN sq_student_info ON tmp2.user_no=sq_student_info.user_no)"
            + " tmp3 LEFT JOIN sq_fxdata_collection ON tmp3.user_no=sq_fxdata_collection.user_no ")
    @Results({
//	        @Result(property = "name",  column = "name"),
//	        @Result(property = "industry", column = "industry")
    })

    List<EpideSituDisplayService> getSyZdgcryinfo(String school);
}