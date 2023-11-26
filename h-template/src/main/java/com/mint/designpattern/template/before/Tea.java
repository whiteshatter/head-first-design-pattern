package com.mint.designpattern.template.before;

public class Tea {
    public void prepareRecipe() {
        boilWater();
        steepTeaBag();
        addLemon();
        pourInCup();
    }

    public void boilWater() {
        System.out.println("boiling water");
    }

    public void steepTeaBag() {
        System.out.println("steeping the tea");
    }

    public void addLemon() {
        System.out.println("adding Lemon");
    }

    public void pourInCup() {
        System.out.println("pouring into cup");
    }
}
