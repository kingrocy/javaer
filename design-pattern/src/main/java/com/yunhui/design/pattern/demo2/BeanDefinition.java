package com.yunhui.design.pattern.demo2;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date : 2020/12/21 4:41 下午
 * @Author : dushaoyun
 */
@Getter
@Setter
public class BeanDefinition {

    private String id;
    private String className;
    private List constructorArgs = new ArrayList<>();
    private Scope scope = Scope.SINGLETON;
    private boolean lazyInit = false;

    public boolean isSingleton() {
        return scope.equals(Scope.SINGLETON);
    }

    public static enum Scope {SINGLETON, PROTOTYPE}

    @Getter
    @Setter
    public static class ConstructorArg {
        private boolean isRef;
        private Class type;
        private Object arg;
    }
}



