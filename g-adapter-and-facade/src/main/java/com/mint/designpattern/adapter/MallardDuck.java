package com.mint.designpattern.adapter;

public class MallardDuck implements Duck{
    @Override
    public void quack() {
        System.out.println("mall quack");
    }

    @Override
    public void fly() {
        System.out.println("mall fly");
    }
}
