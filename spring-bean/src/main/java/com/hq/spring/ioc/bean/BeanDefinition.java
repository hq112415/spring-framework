package com.hq.spring.ioc.bean;


import java.util.List;

public class BeanDefinition {

    private String name;

    private String className;

    private String[] interfaceName;

    private List<ConstructorArg> constructorArgs;

    private List<PropertyArg> propertyArgs;

    public String getName() {
        return name;
    }

    public BeanDefinition setName(String name) {
        this.name = name;
        return this;
    }

    public String getClassName() {
        return className;
    }

    public BeanDefinition setClassName(String className) {
        this.className = className;
        return this;
    }

    public String[] getInterfaceName() {
        return interfaceName;
    }

    public BeanDefinition setInterfaceName(String[] interfaceName) {
        this.interfaceName = interfaceName;
        return this;
    }

    public List<ConstructorArg> getConstructorArgs() {
        return constructorArgs;
    }

    public BeanDefinition setConstructorArgs(List<ConstructorArg> constructorArgs) {
        this.constructorArgs = constructorArgs;
        return this;
    }

    public List<PropertyArg> getPropertyArgs() {
        return propertyArgs;
    }

    public BeanDefinition setPropertyArgs(List<PropertyArg> propertyArgs) {
        this.propertyArgs = propertyArgs;
        return this;
    }
}
