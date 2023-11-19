package com.mint.designpattern.decorator;

import lombok.Data;

@Data
public abstract class Beverage {
    protected String description = "unknown beverage";

    public abstract double cost();
}
