package com.hq.srping.aop.test;

import com.hq.spring.aop.core.AopApplicationContext;

public class MainTest {

    public static void main(String[] args) throws Exception {

        AopApplicationContext aopApplicationContext = new AopApplicationContext("application.json");
        aopApplicationContext.init();

        TestService testService = (TestService) aopApplicationContext.getBean("testServiceProxy");

        testService.testMethod();


    }
}
