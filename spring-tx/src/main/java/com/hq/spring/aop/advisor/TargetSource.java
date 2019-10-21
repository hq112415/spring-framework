package com.hq.spring.aop.advisor;


public class TargetSource {

    private Class<?> tagetClass;

    private Object tagetObject;


    public Class<?> getTagetClass() {
        return tagetClass;
    }

    public TargetSource setTagetClass(Class<?> tagetClass) {
        this.tagetClass = tagetClass;
        return this;
    }

    public Object getTagetObject() {
        return tagetObject;
    }

    public TargetSource setTagetObject(Object tagetObject) {
        this.tagetObject = tagetObject;
        return this;
    }
}
