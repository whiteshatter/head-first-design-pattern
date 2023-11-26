package com.mint.designpattern.state;

public class SoldState implements State{
    private StateSugarMachine stateSugarMachine;
    public SoldState(StateSugarMachine stateSugarMachine) {
        this.stateSugarMachine = stateSugarMachine;
    }
    @Override
    public void insertQuarter() {
        System.out.println("正在给糖果");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("已给糖果");
    }

    @Override
    public void turnCrank() {
        System.out.println("正在给糖果");
    }

    @Override
    public void dispense() {
        stateSugarMachine.releaseBall();
        if (stateSugarMachine.getCount() > 0) {
            stateSugarMachine.setState(stateSugarMachine.getNoQuarterState());
        } else {
            System.out.println("糖果已卖完");
            stateSugarMachine.setState(stateSugarMachine.getSoldOutState());
        }
    }
}
