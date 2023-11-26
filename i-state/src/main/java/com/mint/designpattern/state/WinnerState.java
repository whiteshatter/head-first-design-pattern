package com.mint.designpattern.state;

public class WinnerState implements State{
    private StateSugarMachine stateSugarMachine;
    public WinnerState(StateSugarMachine stateSugarMachine) {
        this.stateSugarMachine = stateSugarMachine;
    }
    @Override
    public void insertQuarter() {
        System.out.println("操作错误");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("操作错误");
    }

    @Override
    public void turnCrank() {
        System.out.println("操作错误");
    }

    @Override
    public void dispense() {
        System.out.println("获得双倍糖果");
        stateSugarMachine.releaseBall();
        if (stateSugarMachine.getCount() == 0) {
            stateSugarMachine.setState(stateSugarMachine.getSoldOutState());
        } else {
            stateSugarMachine.releaseBall();
            if (stateSugarMachine.getCount() > 0) {
                stateSugarMachine.setState(stateSugarMachine.getNoQuarterState());
            } else {
                stateSugarMachine.setState(stateSugarMachine.getSoldOutState());
            }
        }
    }
}
