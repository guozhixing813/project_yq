package com.sqsf.service;

import java.util.Map;

/**
 * @author gzx
 * @create 2020-11-06 15:29
 */
public interface WxApiService {


    Object postYqMtjkinfo(Map params);

    Object postYqFxbdinfo(Map params);

    Object postYqSaomainfo(Map params);

    Object postYqZhuceinfo(Map params);

    Object postYqLogin(Map params);

    Object postGetcollagelist();

    Object postGetSaomalist(Map params);

    Object postSavevisitorinfo(Map params);

    Object postGetdepartlist(Map params);
}
