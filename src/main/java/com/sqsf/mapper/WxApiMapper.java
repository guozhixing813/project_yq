package com.sqsf.mapper;

import com.sqsf.entity.WxApiEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author gzx
 * @create 2020-11-06 15:19
 */
public interface WxApiMapper {

    @Insert("INSERT INTO sq_fxhealth_collection(school,user_name,user_no,heathinfo1,heathinfo2"
            + ",heathinfo3,timestamp,notes,temperature,is_quarantine) VALUES(#{school}, #{userName}, #{userNo},"
            + "#{heathinfo1}, #{heathinfo2}, #{heathinfo3},#{timestamp}, #{notes},#{temperature},#{isQuarantine})")
    void insert(WxApiEntity wxApiData);

    @Insert("INSERT INTO sq_fxdata_collection(school,user_name,user_no,fx_time,fx_addr_country"
            + ",fx_addr_province,fx_addr_city,fx_vehicl,is_thseriousarea,fx_addr_town,fxjt_sm,fxjk) VALUES(#{school}, #{userName}, #{userNo},"
            + "#{fxTime}, #{fxAddrCountry},#{fxAddrProvince},#{fxAddrCity},#{fxVehicl},#{isThseriousarea},#{fxAddrTown},#{fxjtSm},#{fxjk})")
    void postYqFxbdinfo(WxApiEntity wxApiData);

    //返校健康填报同时将数据写入到每日健康中
    @Insert("INSERT INTO sq_fxhealth_collection(school,user_name,user_no,timestamp,heathinfo1) VALUES(#{school}, #{userName}, #{userNo},"
            + "#{fxTime},#{fxjk})")
    void postYqjkinfo(WxApiEntity wxApiData);


    @Insert("INSERT INTO sq_wxgj_collection(school,user_name,user_no,addr,longitude"
            + ",dimension,time) VALUES(#{school}, #{userName}, #{userNo},"
            + "#{addr}, #{longitude},#{dimension},#{timestamp})")
    void postYqSaomainfo(WxApiEntity wxApiData);

    //4、学生注册信息
    @Insert("INSERT INTO sq_student_info(school,college,user_name,user_no,classes"
            + ",phone,md5_password,person_type,department,parents_phone) VALUES(#{school}, #{college},#{userName}, #{userNo},"
            + "#{classes}, #{phone}, #{md5Password}, #{personType},#{department},#{parentPhone})")
    void postYqZhuceinfo(WxApiEntity wxApiData);

    //6、获取学校列表：
    @Select("SELECT school, collage AS college, speciality AS classes FROM `sq_collage_configure` group by school")
    @Results({

    })
    List<WxApiEntity> postGetschoollist();
    //6、获取学校列表：
    @Select("SELECT school, collage AS college, speciality AS classes FROM `sq_collage_configure` where school=#{schools} group by collage")
    @Results({

    })
    List<WxApiEntity> postGetcollagelist(String schools);
    //6、获取学校列表：
    @Select("SELECT school, collage AS college, speciality AS classes FROM `sq_collage_configure` where school=#{schools} and collage = #{collages} group by speciality ")
    @Results({

    })
    List<WxApiEntity> postpersonallitylist(String schools, String collages);

    //接口5登录配置
    @Select("SELECT school,college,user_name AS userName ,classes,phone,user_no AS userNo,person_type as personType,department, parents_phone AS parentPhone"
            + " FROM `sq_student_info` WHERE user_no=#{no} AND md5_password=#{password};")
    @Results({

    })
    List<WxApiEntity> getYqLogin(String no, String password);
    //接口5登录配置
    @Select("SELECT school FROM `sq_fxhealth_collection` WHERE school=#{school} AND user_no=#{no} and heathinfo2 is not null AND timestamp>=CURDATE();")
    @Results({

    })
    List<WxApiEntity> jkSubmit(String school, String no);
    //接口5登录配置
    @Select("SELECT school FROM `sq_fxdata_collection` WHERE school=#{school} AND user_no=#{no};")
    @Results({

    })
    List<WxApiEntity> jtSubmit(String school, String no);



    //4、学生注册信息
    @Select("SELECT school,college,user_name AS userName ,classes,phone,user_no AS userNo, department FROM `sq_student_info` WHERE user_no=#{no} ;")
    @Results({

    })
    List<WxApiEntity> getYqZhuceinfo(String no);


    //7、获取扫码历史列表
    @Select("SELECT addr,time AS timestamp FROM `sq_wxgj_collection` WHERE school=#{school} AND user_no=#{no};")
    @Results({

    })
    List<WxApiEntity> postGetSaomalist(String school,String no);


    @Insert("INSERT INTO sq_visitinfo_info(school,name,phone,toname,tophone"
            + ",visitinfo) VALUES(#{school}, #{userName}, #{phone},"
            + "#{toname}, #{tophone}, #{visitinfo})")
    void postSavevisitorinfo(WxApiEntity wxApiData);


    //9、获取学校列表：
    @Select("SELECT school,department FROM `sq_school_department`  group by school,department")
    @Results({

    })
    List<WxApiEntity> getdepartlist();
}
