package com.hq.spring.aop.interceptor;


import com.hq.spring.aop.Invocation.MethodInvocation;

public interface AopMethodInterceptor {

    Object invoke(MethodInvocation mi) throws Throwable;

}
