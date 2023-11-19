package com.mint.designpattern.decorator;

import com.mint.designpattern.decorator.beverage.Espresso;
import com.mint.designpattern.decorator.condiment.Mocha;
import com.mint.designpattern.decorator.condiment.Whip;

public class DecoratorTest {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        beverage = new Mocha(beverage);
        beverage = new Mocha(beverage);
        beverage = new Whip(beverage);
        System.out.println(beverage.getDescription());
        System.out.println(beverage.cost());
    }
}
