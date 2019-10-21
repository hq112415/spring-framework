package com.hq.spring.aop.adapter;

import com.hq.spring.aop.interceptor.AopMethodInterceptor;
import com.hq.spring.aop.advisor.Advisor;

public interface AdviceAdapter {

    AopMethodInterceptor getInterceptor(Advisor advisor);
}
