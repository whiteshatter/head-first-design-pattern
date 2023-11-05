package com.mint.learn.headfirst.introduction.strategy.fly.impl;

import com.mint.learn.headfirst.introduction.strategy.fly.FlyBehavior;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("fly with wings");
    }
}
