package com.mint.learn.headfirst.introduction.init;

import com.mint.learn.headfirst.introduction.strategy.fly.impl.FlyWithWings;

public class MallardDuck extends Duck {

    public MallardDuck() {
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("绿头鸭外表");
    }

}
