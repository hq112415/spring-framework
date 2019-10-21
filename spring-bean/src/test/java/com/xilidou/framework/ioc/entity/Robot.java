package com.xilidou.framework.ioc.entity;


public class Robot {

    private Hand hand;

    private Mouth mouth;

    public void show() {

        hand.waveHand();
        mouth.speak();

    }

    public Hand getHand() {
        return hand;
    }

    public Robot setHand(Hand hand) {
        this.hand = hand;
        return this;
    }

    public Mouth getMouth() {
        return mouth;
    }

    public Robot setMouth(Mouth mouth) {
        this.mouth = mouth;
        return this;
    }
}
