package com.yunhui.design.pattern.filterchain;

/**
 *
 * Created on 2022-06-24
 */
public class RoleCheckMiddleware extends Middleware {

    public boolean doCheck(String email, String password) {
        if (email.equals("admin@example.com")) {
            System.out.println("RoleCheckMiddleware check pass");
            System.out.println("Hello, admin!");
            return true;
        }
        System.out.println("Hello, user!");
        System.out.println("RoleCheckMiddleware check pass");
        return true;
    }
}
