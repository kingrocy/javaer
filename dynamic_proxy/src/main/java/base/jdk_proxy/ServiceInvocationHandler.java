package base.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Date : 2021/2/4 2:12 下午
 * @Author : dushaoyun
 */
public class ServiceInvocationHandler implements InvocationHandler {

    private Object ref;

    public ServiceInvocationHandler(Object ref) {
        this.ref = ref;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke");
        Object result = method.invoke(ref, args);
        System.out.println("after invoke");
        return result;
    }
}
