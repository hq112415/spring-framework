package com.hq.spring.aop.core;


import com.hq.spring.aop.advisor.AdvisedSupport;
import com.hq.spring.ioc.utils.ClassUtils;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;

public class CglibAopProxy implements AopProxy {

    private AdvisedSupport advised;

    private Object[] constructorArgs;

    private Class<?>[] constructorArgTypes;

    public CglibAopProxy(AdvisedSupport config) {
        this.advised = config;
    }


    @Override
    public Object getProxy() {
        return getProxy(null);
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {

        Class<?> rootClass = advised.getTargetSource().getTagetClass();

        if (classLoader == null) {
            classLoader = ClassUtils.getDefultClassLoader();
        }
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(rootClass.getSuperclass());
        //增加拦截器的核心方法
        Callback callbacks = getCallBack(advised);
        enhancer.setCallback(callbacks);
        enhancer.setClassLoader(classLoader);
        if (constructorArgs != null && constructorArgs.length > 0) {
            return enhancer.create(constructorArgTypes, constructorArgs);
        }

        return enhancer.create();
    }

    private Callback getCallBack(AdvisedSupport advised) {
        return new DynamicAdvisedInterceptor(advised.getList(), advised.getTargetSource());
    }

    public AdvisedSupport getAdvised() {
        return advised;
    }

    public CglibAopProxy setAdvised(AdvisedSupport advised) {
        this.advised = advised;
        return this;
    }

    public Object[] getConstructorArgs() {
        return constructorArgs;
    }

    public CglibAopProxy setConstructorArgs(Object[] constructorArgs) {
        this.constructorArgs = constructorArgs;
        return this;
    }

    public Class<?>[] getConstructorArgTypes() {
        return constructorArgTypes;
    }

    public CglibAopProxy setConstructorArgTypes(Class<?>[] constructorArgTypes) {
        this.constructorArgTypes = constructorArgTypes;
        return this;
    }
}
