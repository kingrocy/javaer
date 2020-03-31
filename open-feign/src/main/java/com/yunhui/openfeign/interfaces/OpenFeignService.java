package com.yunhui.openfeign.interfaces;

import com.yunhui.openfeign.bean.User;
import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * @Date : 2019-07-10 15:14
 * @Desc :
 */
public interface OpenFeignService {


    @RequestLine("GET /user/{id}")
    User getUser(@Param("id") Long id);



    @RequestLine("POST /user/login")
    @Headers("Content-Type: application/json")
    @Body("%7B\"account\": \"{account}\", \"passwd\": \"{passwd}\"%7D")
    User login(@Param("account") String account,@Param("passwd")String passwd);
}
