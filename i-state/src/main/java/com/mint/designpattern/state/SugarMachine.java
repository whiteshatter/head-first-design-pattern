package com.mint.designpattern.state;

public class SugarMachine {
    public final static int SOLD_OUT = 0;
    public final static int NO_QUARTER = 1;
    public final static int HAS_QUARTER = 2;
    public final static int SOLD = 3;

    private int state = SOLD_OUT;
    private int count = 0;

    public SugarMachine(int count) {
        this.count = count;
        if (count > 0) {
            state = NO_QUARTER;
        }
    }

    public void insertQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("已投币，不需要再投币");
        } else if (state == SOLD_OUT) {
            System.out.println("糖果卖完了，不能投币");
        } else if (state == SOLD) {
            System.out.println("已经给糖果了");
        } else if (state == NO_QUARTER) {
            state = HAS_QUARTER;
            System.out.println("投币成功");
        }
    }

    public void ejectQuarter() {
        if (state == HAS_QUARTER) {
            state = NO_QUARTER;
            System.out.println("返回金额");
        } else if (state == SOLD_OUT) {
            System.out.println("无法返还金额");
        } else if (state == SOLD) {
            System.out.println("你已经得到糖果");
        } else if (state == NO_QUARTER) {
            System.out.println("你还未投币");
        }
    }

    public void turnCrank() {
        if (state == HAS_QUARTER) {
            state = SOLD;
            System.out.println("得到糖果");
            dispense();
        } else if (state == SOLD_OUT) {
            System.out.println("没有糖果");
        } else if (state == SOLD) {
            System.out.println("你已经得到糖果");
        } else if (state == NO_QUARTER) {
            System.out.println("你还未投币");
        }
    }

    private void dispense() {
        if (state == SOLD) {
            System.out.println("正在售出糖果");
            count--;
            if (count == 0) {
                state = SOLD_OUT;
            } else {
                state = NO_QUARTER;
            }
        } else if (state == SOLD_OUT) {
            System.out.println("没有糖果");
        } else if (state == NO_QUARTER) {
            System.out.println("请先付款");
        } else if (state == HAS_QUARTER) {
            System.out.println("没有该状态");
        }
    }
}
