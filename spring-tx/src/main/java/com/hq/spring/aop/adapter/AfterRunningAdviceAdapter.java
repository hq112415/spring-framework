package com.hq.spring.aop.adapter;


import com.hq.spring.aop.interceptor.AfterRunningAdviceInterceptor;
import com.hq.spring.aop.interceptor.AopMethodInterceptor;
import com.hq.spring.aop.advisor.Advisor;
import com.hq.spring.aop.advisor.AfterRunningAdvice;

public class AfterRunningAdviceAdapter implements AdviceAdapter {

    private AfterRunningAdviceAdapter() {

    }

    private static final AfterRunningAdviceAdapter INSTANTS = new AfterRunningAdviceAdapter();

    public static AfterRunningAdviceAdapter getInstants() {
        return INSTANTS;
    }

    @Override
    public AopMethodInterceptor getInterceptor(Advisor advisor) {
        AfterRunningAdvice advice = (AfterRunningAdvice) advisor.getAdvice();
        return new AfterRunningAdviceInterceptor(advice);
    }
}
