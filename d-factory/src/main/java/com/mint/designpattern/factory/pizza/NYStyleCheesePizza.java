package com.mint.designpattern.factory.pizza;

import com.mint.designpattern.Pizza;
import com.mint.designpattern.factory.NYStylePizzaStore;
import com.mint.designpattern.factory.PizzaIngredientFactory;

public class NYStyleCheesePizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;
    public NYStyleCheesePizza() {}

    public NYStyleCheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        cheese = ingredientFactory.createCheese();
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        System.out.println("ny cheese prepare");
    }

}
