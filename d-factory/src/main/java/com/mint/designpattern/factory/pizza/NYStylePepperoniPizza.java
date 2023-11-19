package com.mint.designpattern.factory.pizza;

import com.mint.designpattern.Pizza;
import com.mint.designpattern.factory.PizzaIngredientFactory;

public class NYStylePepperoniPizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;
    public NYStylePepperoniPizza() {}

    public NYStylePepperoniPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        cheese = ingredientFactory.createCheese();
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        System.out.println("ny pepperoni prepare");
    }

}
