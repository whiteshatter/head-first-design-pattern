package com.mint.learn.headfirst.introduction.strategy.fly.impl;

import com.mint.learn.headfirst.introduction.strategy.fly.FlyBehavior;

public class FlyWithNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("不会飞");
    }
}
