package com.mint.designpattern.state;

public class HasQuarterState implements State{
    private StateSugarMachine stateSugarMachine;
    public HasQuarterState(StateSugarMachine stateSugarMachine) {
        this.stateSugarMachine = stateSugarMachine;
    }
    @Override
    public void insertQuarter() {
        System.out.println("已投币");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("返还投币");
        stateSugarMachine.setState(stateSugarMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("开始给糖果");
        stateSugarMachine.setState(stateSugarMachine.getSoldState());
    }

    @Override
    public void dispense() {
        System.out.println("先拉杆");
    }
}
