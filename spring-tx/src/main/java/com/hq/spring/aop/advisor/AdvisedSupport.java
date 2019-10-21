package com.hq.spring.aop.advisor;


import com.hq.spring.aop.interceptor.AopMethodInterceptor;

import java.util.LinkedList;
import java.util.List;


public class AdvisedSupport extends Advisor {

    private TargetSource targetSource;

    private List<AopMethodInterceptor> list = new LinkedList<>();

    public void addAopMethodInterceptor(AopMethodInterceptor interceptor) {
        list.add(interceptor);
    }

    public void addAopMethodInterceptors(List<AopMethodInterceptor> interceptors) {
        list.addAll(interceptors);
    }

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public AdvisedSupport setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
        return this;
    }

    public List<AopMethodInterceptor> getList() {
        return list;
    }

    public AdvisedSupport setList(List<AopMethodInterceptor> list) {
        this.list = list;
        return this;
    }
}
