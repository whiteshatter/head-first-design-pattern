package com.mint.designpattern.factory;

import com.mint.designpattern.Pizza;
import com.mint.designpattern.factory.ingredient.NYPizzaIngredientFactory;
import com.mint.designpattern.factory.pizza.NYStyleCheesePizza;
import com.mint.designpattern.factory.pizza.NYStylePepperoniPizza;

public class NYStylePizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String type) {
        if ("cheese".equals(type)) {
            return new NYStyleCheesePizza(new NYPizzaIngredientFactory());
        }
        if ("pepperoni".equals(type)) {
            return new NYStylePepperoniPizza(new NYPizzaIngredientFactory());
        }
        return null;
    }
}
