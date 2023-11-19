package com.mint.designpattern;

import com.mint.designpattern.factory.ingredient.Cheese;
import com.mint.designpattern.factory.ingredient.Dough;
import com.mint.designpattern.factory.ingredient.Sauce;
import lombok.Data;

@Data
public abstract class Pizza {
    protected Cheese cheese;
    protected Dough dough;
    protected Sauce sauce;
    public abstract void prepare();
    public void bake() {
        System.out.println("pizza bake");
    }
    public void cut() {
        System.out.println("pizza cut");
    }
    public void box() {
        System.out.println("pizza box");
    }
}
