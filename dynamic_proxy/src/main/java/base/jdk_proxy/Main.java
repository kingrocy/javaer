package base.jdk_proxy;

import base.IService;

import java.lang.reflect.Proxy;

/**
 * @Date : 2021/2/4 2:18 下午
 * @Author : dushaoyun
 */
public class Main {

    public static void main(String[] args) {
        IService service = new IService.ServiceImpl();

        ServiceInvocationHandler invocationHandler = new ServiceInvocationHandler(service);

        IService proxyInstance = (IService) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), invocationHandler);

        int add = proxyInstance.add(1, 2);

        System.out.println(add);
    }

}
