package com.hq.spring.aop.core;


import com.hq.spring.aop.Invocation.CglibMethodInvocation;
import com.hq.spring.aop.Invocation.MethodInvocation;
import com.hq.spring.aop.advisor.TargetSource;
import com.hq.spring.aop.interceptor.AopMethodInterceptor;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

public class DynamicAdvisedInterceptor implements MethodInterceptor {

    protected final List<AopMethodInterceptor> interceptorList;
    protected final TargetSource targetSource;

    public DynamicAdvisedInterceptor(List<AopMethodInterceptor> interceptorList, TargetSource targetSource) {
        this.interceptorList = interceptorList;
        this.targetSource = targetSource;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        MethodInvocation invocation = new CglibMethodInvocation(obj, targetSource.getTagetObject(), method, args, interceptorList, proxy);
        return invocation.proceed();
    }
}
