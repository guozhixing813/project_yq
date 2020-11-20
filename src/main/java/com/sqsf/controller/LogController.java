package com.sqsf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author gzx
 * @create 2020-11-13 17:49
 */
@RequestMapping
@RestController
public class LogController {


    private static final Logger logger  = LoggerFactory.getLogger(LogController.class);

    @GetMapping("/log")
    public String logTest1(String name) {
        // 由低到高：trace < debug < info < warn < error
        //2. Spring Boot默认设定的是 info 级别日志，(日志默认级别也称为root级别)。可修改默认级别日志：logging.level.root=级别名
        //3. 可以进行调整日志级别，设定某个级别后，就只打印设定的这个级别及后面高级别的日志信息。没有指定级别的就用SpringBoot默认规定的级别：root级别
        //4. 可修改指定包的日志级别：指定某个包下面的所有日志级别：logging.level.包名=级别名
        logger.info("------------info--------------{}",name);
        logger.error("------------error--------------{}",name);
        logger.debug("------------debug--------------{}",name);
        logger.trace("------------trace--------------{}",name);
        logger.warn("------------warn--------------{}",name);
        return "log test..."+name;
    }

}
