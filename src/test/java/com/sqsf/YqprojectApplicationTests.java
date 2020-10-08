package com.sqsf;

import com.sqsf.mapper.RootEntityMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class YqprojectApplicationTests {

    @Autowired
    private RootEntityMapper rootEntityMapper;

    /**测试：
     *
     * 查询所有
     */
    @Test
    public void findAll() {

//        List<RootEntity> entities = rootEntityMapper.selectList(null);
//        System.out.println(entities);
    }


}
