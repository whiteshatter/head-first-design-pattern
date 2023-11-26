package com.mint.designpattern.state;

public class NoQuarterState implements State{
    private StateSugarMachine stateSugarMachine;
    public NoQuarterState(StateSugarMachine stateSugarMachine) {
        this.stateSugarMachine = stateSugarMachine;
    }
    @Override
    public void insertQuarter() {
        System.out.println("已投币");
        stateSugarMachine.setState(stateSugarMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("还未投币");
    }

    @Override
    public void turnCrank() {
        System.out.println("还未投币");
    }

    @Override
    public void dispense() {
        System.out.println("还未投币");
    }
}
