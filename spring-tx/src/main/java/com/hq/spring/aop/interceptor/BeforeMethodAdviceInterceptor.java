package com.hq.spring.aop.interceptor;


import com.hq.spring.aop.Invocation.MethodInvocation;
import com.hq.spring.aop.advisor.BeforeMethodAdvice;

public class BeforeMethodAdviceInterceptor implements AopMethodInterceptor {

    private BeforeMethodAdvice advice;

    public BeforeMethodAdviceInterceptor(BeforeMethodAdvice advice) {
        this.advice = advice;
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        advice.before(mi.getMethod(), mi.getArguments(), mi);
        return mi.proceed();
    }
}
