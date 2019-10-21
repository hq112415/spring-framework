package com.xilidou.framework.ioc.entity;


public class Mouth {

    private Hand hand;

    private String code;

    public void speak() {
        System.out.println("mouth 编号：" + code + ",依赖于hand 编号" + hand.getCode());
        System.out.println("say hello world");
    }

    public Hand getHand() {
        return hand;
    }

    public Mouth setHand(Hand hand) {
        this.hand = hand;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Mouth setCode(String code) {
        this.code = code;
        return this;
    }
}
