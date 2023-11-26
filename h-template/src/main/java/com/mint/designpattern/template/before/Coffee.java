package com.mint.designpattern.template.before;

public class Coffee {
    public void prepareRecipe() {
        boilWater();
        brewCoffeeGrinds();
        pourInCup();
        addSugarAndMilk();
    }

    public void boilWater() {
        System.out.println("boiling water");
    }

    public void brewCoffeeGrinds() {
        System.out.println("dripping coffee through filter");
    }

    public void pourInCup() {
        System.out.println("pouring into cup");
    }

    public void addSugarAndMilk() {
        System.out.println("adding sugar and milk");
    }
}
