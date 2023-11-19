package com.mint.designpattern.factory;

import com.mint.designpattern.factory.ingredient.Cheese;
import com.mint.designpattern.factory.ingredient.Dough;
import com.mint.designpattern.factory.ingredient.Sauce;

public interface PizzaIngredientFactory {
    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
}
