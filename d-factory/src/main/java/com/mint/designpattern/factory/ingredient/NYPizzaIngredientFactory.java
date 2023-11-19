package com.mint.designpattern.factory.ingredient;

import com.mint.designpattern.factory.PizzaIngredientFactory;
import com.mint.designpattern.factory.ingredient.impl.NYCheese;
import com.mint.designpattern.factory.ingredient.impl.NYDough;
import com.mint.designpattern.factory.ingredient.impl.NYSauce;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new NYDough();
    }

    @Override
    public Sauce createSauce() {
        return new NYSauce();
    }

    @Override
    public Cheese createCheese() {
        return new NYCheese();
    }
}
