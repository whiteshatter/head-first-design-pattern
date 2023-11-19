package com.mint.designpattern.simplefactory;

import com.mint.designpattern.Pizza;
import com.mint.designpattern.pizza.CheesePizza;
import com.mint.designpattern.pizza.PepperoniPizza;

public class SimplePizzaFactory {
    public Pizza createPizza(String type) {
        if ("cheese".equals(type)) {
            return new CheesePizza();
        }
        if ("pepperoni".equals(type)) {
            return new PepperoniPizza();
        }
        return null;
    }
}
