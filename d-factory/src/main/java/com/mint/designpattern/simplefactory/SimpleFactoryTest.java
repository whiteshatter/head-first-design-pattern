package com.mint.designpattern.simplefactory;

import com.mint.designpattern.Pizza;

public class SimpleFactoryTest {
    public static void main(String[] args) {
        SimplePizzaFactory factory = new SimplePizzaFactory();
        Pizza cheese = factory.createPizza("cheese");
        if (cheese == null) {
            return;
        }
        cheese.prepare();
        cheese.bake();
        cheese.cut();
        cheese.box();
    }
}
