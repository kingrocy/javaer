package base.cglib_proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * @Date : 2021/2/4 2:34 下午
 * @Author : dushaoyun
 */
public class CglibProxyHandler implements InvocationHandler {

    private Object ref;

    public CglibProxyHandler(Object ref) {
        this.ref = ref;
    }

    public <T> T getProxy() {
        //增强类
        Enhancer hancer = new Enhancer();
        //对哪一个父类增强
        hancer.setSuperclass(ref.getClass());
        //如何设置增强
        hancer.setCallback(this);
        //返回并创建对象
        return (T) hancer.create();
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke");
        Object result = method.invoke(ref, args);
        System.out.println("after invoke");
        return result;
    }
}
