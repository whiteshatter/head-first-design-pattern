package com.mint.designpattern.decorator.condiment;

import com.mint.designpattern.decorator.Beverage;
import com.mint.designpattern.decorator.CondimentDecorator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Mocha extends CondimentDecorator {
    private Beverage beverage;
    @Override
    public double cost() {
        return 0.2 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Mocha";
    }
}
