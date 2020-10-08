package com.sqsf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EnableAutoConfiguration
@SpringBootApplication
@MapperScan("com.sqsf.mapper")
public class YqprojectApplication {


    public static void main(String[] args) {

        SpringApplication.run(YqprojectApplication.class, args);

    }

}
