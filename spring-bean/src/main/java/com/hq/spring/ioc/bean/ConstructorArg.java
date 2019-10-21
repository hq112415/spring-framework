package com.hq.spring.ioc.bean;


public class ConstructorArg {

    private int index;
    private String ref;
    private String name;


    public int getIndex() {
        return index;
    }

    public ConstructorArg setIndex(int index) {
        this.index = index;
        return this;
    }

    public String getRef() {
        return ref;
    }

    public ConstructorArg setRef(String ref) {
        this.ref = ref;
        return this;
    }

    public String getName() {
        return name;
    }

    public ConstructorArg setName(String name) {
        this.name = name;
        return this;
    }
}
