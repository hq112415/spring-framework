package com.hq.spring.aop.adapter;

import com.hq.spring.aop.interceptor.AopMethodInterceptor;
import com.hq.spring.aop.interceptor.BeforeMethodAdviceInterceptor;
import com.hq.spring.aop.advisor.Advisor;
import com.hq.spring.aop.advisor.BeforeMethodAdvice;

public class BeforeMethodAdviceAdapter implements AdviceAdapter {

    private BeforeMethodAdviceAdapter() {
    }

    private static final BeforeMethodAdviceAdapter INSTANTS = new BeforeMethodAdviceAdapter();

    public static BeforeMethodAdviceAdapter getInstants() {
        return INSTANTS;
    }

    @Override
    public AopMethodInterceptor getInterceptor(Advisor advisor) {
        BeforeMethodAdvice advice = (BeforeMethodAdvice) advisor.getAdvice();
        return new BeforeMethodAdviceInterceptor(advice);
    }
}
