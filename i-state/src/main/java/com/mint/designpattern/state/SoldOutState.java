package com.mint.designpattern.state;

public class SoldOutState implements State{
    private StateSugarMachine stateSugarMachine;
    public SoldOutState(StateSugarMachine stateSugarMachine) {
        this.stateSugarMachine = stateSugarMachine;
    }
    @Override
    public void insertQuarter() {
        System.out.println("已卖完");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("已卖完");
    }

    @Override
    public void turnCrank() {
        System.out.println("已卖完");
    }

    @Override
    public void dispense() {
        System.out.println("已卖完");
    }
}
