package com.mint.designpattern.state;

import lombok.Data;

@Data
public class StateSugarMachine {
    private SoldState soldState;
    private SoldOutState soldOutState;
    private NoQuarterState noQuarterState;
    private HasQuarterState hasQuarterState;
    private State state;
    private int count = 0;

    public StateSugarMachine(int count) {
        soldState = new SoldState(this);
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        if (count > 0) {
            state = noQuarterState;
        } else {
            state = soldOutState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void releaseBall() {
        System.out.println("开始发放糖果");
        if (count != 0) {
            count--;
        }
    }

}
