package oom_find;

import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Date : 2020/10/22 7:30 下午
 * @Author : dushaoyun
 */
public class Test {


    public static void main(String[] args) {


        ExecutorService service=Executors.newFixedThreadPool(30);


        for (int i = 0; i < 10; i++) {


            String param="{\"groupId\":53}";
            String api="https://portrait-new.prepub.souche-inc.com/group/users";

            service.execute(()->{

                while (true){

                    try {
                        String s = Request.Post(api).bodyString(param, ContentType.APPLICATION_JSON)
                                .addHeader("_security_token_inc", "91602206242834906")
                                .execute().returnContent().asString();
                        System.out.println(s);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }



            });

        }


        while (true){

        }


    }
}
