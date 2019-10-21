package com.hq.spring.aop.advisor;


public class Advisor {

    private Advice advice;

    private Pointcut pointcut;


    public Advice getAdvice() {
        return advice;
    }

    public Advisor setAdvice(Advice advice) {
        this.advice = advice;
        return this;
    }

    public Pointcut getPointcut() {
        return pointcut;
    }

    public Advisor setPointcut(Pointcut pointcut) {
        this.pointcut = pointcut;
        return this;
    }
}
