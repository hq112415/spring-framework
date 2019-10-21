package com.xilidou.framework.ioc.entity;


public class Hand {

    private Mouth mouth;

    private String code;

    public void waveHand() {
        System.out.println("hand 编号：" + code + ",依赖于mouth 编号" + mouth.getCode());
        System.out.println("挥一挥手");
    }

    public Mouth getMouth() {
        return mouth;
    }

    public Hand setMouth(Mouth mouth) {
        this.mouth = mouth;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Hand setCode(String code) {
        this.code = code;
        return this;
    }
}
