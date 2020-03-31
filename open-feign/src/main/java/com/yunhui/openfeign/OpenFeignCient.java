package com.yunhui.openfeign;

import com.yunhui.openfeign.bean.User;
import com.yunhui.openfeign.interfaces.OpenFeignService;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

/**
 * @Date : 2019-07-10 15:14
 * @Desc :
 */
public class OpenFeignCient {


    private static OpenFeignService service= Feign.builder().encoder(new JacksonEncoder())
            .decoder(new JacksonDecoder())
            .target(OpenFeignService.class, "http://127.0.0.1");

    public static void main(String[] args) {

        User user = service.getUser(1L);

        System.out.println(user);

        User dusy = service.login("dusy", "123456");

        System.out.println(dusy);
    }

}
