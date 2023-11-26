package com.mint.designpattern.template;

public class Coffee extends CaffeineBeverage{
    @Override
    void brew() {
        System.out.println("steeping the tea");
    }

    @Override
    void addCondiments() {
        System.out.println("adding sugar and milk");
    }
}
