package com.sqsf.mapper;
import com.sqsf.entity.EpideSituDisplayEntity;
import com.sqsf.service.SchoolPara;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EpideSituDisplayEntiMapper {
    /**
     * 赵晓凤
     *
     * @param school
     * @return
     */
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
    List<EpideSituDisplayEntity> getBaseInfo(@Param("school") String school, @Param("province") String province);

    @Select("select count(1) AS zdgcNum from sq_fxhealth_collection AS tmp1 WHERE school=#{school} && tmp1.heathinfo1!='00001'&& tmp1.id IN "
            + "(select SUBSTRING_INDEX(group_concat(id order by `create_time` desc),',',1) from sq_fxhealth_collection group by user_no)")
    @Results({
    })
    List<EpideSituDisplayEntity> getZdgcrsInfo(String school);

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
    List<EpideSituDisplayEntity> getSyZdgcryinfo(String school);

    //接口4：校园人员分布：校园中心gps（百度地图）
    @Select("SELECT center_longitude AS centerLongitude,center_dimension AS centerDimension" +
            " FROM `sq_school_configure`" +
            " WHERE school=#{school};")
    @Results({
    })
    List<EpideSituDisplayEntity> getSyXyryfbinfo(String school);

    //接口4：校园人员分布：校园中心gps（百度地图）
    @Select("SELECT longitude AS longitude ,dimension AS dimension " +
            "FROM `sq_wxgj_collection` " +
            "WHERE school=#{school} " +
            " AND id IN (" +
            "select SUBSTRING_INDEX(" +
            "group_concat(" +
            "id order by `time` desc),',',1)" +
            " from sq_wxgj_collection group by user_no)")
    @Results({
    })
    List<EpideSituDisplayEntity> getSyXyryfbinfoLD(String school);


    /**
     * 许歌辉
     *
     * @param school
     * @return
     */

    @Select("SELECT * from ((SELECT  0 AS flag, user_name AS userName,user_no AS userNum, addr AS lymc,create_time AS createTime "
            + "FROM sq_wxgj_collection WHERE  school=#{school} AND user_no  NOT IN (select user_no from sq_fxhealth_collection AS tmp1 "
            + "WHERE school = #{school} && tmp1.heathinfo1!='00001'&& tmp1.id IN "
            + "(select SUBSTRING_INDEX(group_concat(id order by `create_time` desc),',',1) "
            + "from sq_fxhealth_collection WHERE school = #{school} group by user_no)) ORDER BY create_time DESC LIMIT 10) "
            + "union all "
            + "(SELECT  1 AS flag,user_name AS userName,user_no AS userNum, addr AS lymc,create_time AS createTime FROM sq_wxgj_collection "
            + "WHERE  school=#{school} AND user_no  IN (select user_no from sq_fxhealth_collection AS tmp1 "
            + "WHERE school = #{school} && tmp1.heathinfo1!='00001'&& tmp1.id IN "
            + "(select SUBSTRING_INDEX(group_concat(id order by `create_time` desc),',',1) from sq_fxhealth_collection "
            + "WHERE school = #{school} group by user_no)) ORDER BY create_time DESC LIMIT 5 )) tmp ORDER BY createTime ASC")
    @Results({})
    List<EpideSituDisplayEntity> getSyYjinfo(String school);


    //接口6 热门来源：
    @Select("SELECT fx_addr_province AS originCity,count(1) AS count "
            + "FROM `sq_fxdata_collection` WHERE school=#{school} GROUP BY fx_addr_province ORDER BY count DESC LIMIT 5;")
    @Results({
    })
    List<EpideSituDisplayEntity> getSyRmlyinfo(String school);

    //接口7返回交通
    @Select("select fx_vehicl as name from sq_fxdata_collection AS tmp1 WHERE school=#{school} "
            + "AND tmp1.id IN (select SUBSTRING_INDEX(group_concat(id order by `create_time` desc),',',1) "
            + "from sq_fxdata_collection WHERE school = #{school} group by user_no)")
    @Results({
//	        @Result(property = "name",  column = "name"),
//	        @Result(property = "industry", column = "industry")
    })
    List<EpideSituDisplayEntity> getSyFxjtinfo(String school);

    //接口8:返校人员来源：学校gps（百度地图）
    @Select("SELECT originCity, count, longitude,dimension FROM (SELECT fx_addr_city AS originCity,count(1) "
            + "AS count FROM `sq_fxdata_collection` WHERE school= #{school} GROUP BY fx_addr_city)tmp "
            + "LEFT JOIN sq_city_gps ON tmp.originCity= sq_city_gps.city;")
    @Results({
    })
    List<EpideSituDisplayEntity> getSyFxrylyinfo(String school);

    //返校交通
    //接口10:各个学院返校信息：
    @Select("SELECT college AS name, count(1) AS count FROM `sq_fxdata_collection`"
            + " LEFT JOIN sq_student_info ON sq_fxdata_collection.user_no =  sq_student_info.user_no"
            + " WHERE sq_fxdata_collection.school = #{school} AND college <>'' AND college IS NOT NULL GROUP BY college;")
    @Results({
//	        @Result(property = "name",  column = "name"),
//	        @Result(property = "industry", column = "industry")
    })
    List<EpideSituDisplayEntity> getSyEjxyfxinfo(String school);

    //--------------------------------------------------
    @Insert("INSERT INTO sq_city_gps(city,longitude,dimension) VALUES(#{city}, #{lng}, #{lat})")
    void insertgps(String city, Double lng, Double lat);


}