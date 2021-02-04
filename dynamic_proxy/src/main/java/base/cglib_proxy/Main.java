package base.cglib_proxy;

import base.IService;
import org.junit.Test;

/**
 * @Date : 2021/2/4 2:39 下午
 * @Author : dushaoyun
 */
public class Main {


    @Test
    public void testInterfaceProxy() {
        IService iService = new IService.ServiceImpl();

        CglibProxyHandler proxyHandler = new CglibProxyHandler(iService);

        IService proxy = proxyHandler.getProxy();

        System.out.println(proxy.add(1, 2));
    }

    @Test
    public void testNotInterface() {
        Math math=new Math();
        CglibProxyHandler proxyHandler = new CglibProxyHandler(math);
        Math proxy = proxyHandler.getProxy();
        System.out.println(proxy.subtract(1,2));
    }
}
