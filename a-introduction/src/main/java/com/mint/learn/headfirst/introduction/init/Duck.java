package com.mint.learn.headfirst.introduction.init;

import com.mint.learn.headfirst.introduction.strategy.fly.FlyBehavior;

public class Duck {
    protected FlyBehavior flyBehavior;

    public void swim() {
        System.out.println("鸭子游泳");
    }

    public void display() {
        System.out.println("鸭子外表");
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

}
