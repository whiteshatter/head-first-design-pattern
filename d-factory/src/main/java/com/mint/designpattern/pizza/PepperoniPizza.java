package com.mint.designpattern.pizza;

import com.mint.designpattern.Pizza;

public class PepperoniPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("pepperoni prepare");
    }

    @Override
    public void bake() {
        System.out.println("pepperoni bake");
    }

    @Override
    public void cut() {
        System.out.println("pepperoni cut");
    }

    @Override
    public void box() {
        System.out.println("pepperoni box");
    }
}
