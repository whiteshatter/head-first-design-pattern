package com.mint.designpattern.decorator.beverage;

import com.mint.designpattern.decorator.Beverage;

public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
