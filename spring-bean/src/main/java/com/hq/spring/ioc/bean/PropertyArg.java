package com.hq.spring.ioc.bean;

public class PropertyArg {

    private String name;

    private String value;

    private String typeName;

    private String ref;

    public String getName() {
        return name;
    }

    public PropertyArg setName(String name) {
        this.name = name;
        return this;
    }

    public String getValue() {
        return value;
    }

    public PropertyArg setValue(String value) {
        this.value = value;
        return this;
    }

    public String getTypeName() {
        return typeName;
    }

    public PropertyArg setTypeName(String typeName) {
        this.typeName = typeName;
        return this;
    }

    public String getRef() {
        return ref;
    }

    public PropertyArg setRef(String ref) {
        this.ref = ref;
        return this;
    }
}
