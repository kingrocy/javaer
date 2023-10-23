package com.yunhui.design.pattern.filterchain;

/**
 *
 * Created on 2022-06-24
 */
public class UserExistsMiddleware extends Middleware {
    private Server server;

    public UserExistsMiddleware(Server server) {
        this.server = server;
    }

    public boolean doCheck(String email, String password) {
        if (!server.hasEmail(email)) {
            System.out.println("This email is not registered!");
            return false;
        }
        if (!server.isValidPassword(email, password)) {
            System.out.println("Wrong password!");
            return false;
        }
        System.out.println("UserExistsMiddleware check pass");
        return true;
    }
}
