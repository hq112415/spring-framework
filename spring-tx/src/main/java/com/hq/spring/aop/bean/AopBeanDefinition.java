package com.hq.spring.aop.bean;


import com.hq.spring.ioc.bean.BeanDefinition;

import java.util.List;

public class AopBeanDefinition extends BeanDefinition {

    private String target;

    private List<String> interceptorNames;

    public String getTarget() {
        return target;
    }

    public AopBeanDefinition setTarget(String target) {
        this.target = target;
        return this;
    }

    public List<String> getInterceptorNames() {
        return interceptorNames;
    }

    public AopBeanDefinition setInterceptorNames(List<String> interceptorNames) {
        this.interceptorNames = interceptorNames;
        return this;
    }
}
