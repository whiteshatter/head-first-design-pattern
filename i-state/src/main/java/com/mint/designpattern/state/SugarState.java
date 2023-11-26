package com.mint.designpattern.state;

public class SugarState {
    private int state;
    public void insertQuarter() {
        if (state == StateConstant.HAS_QUARTER) {
            System.out.println("已投币，不需要再投币");
        } else if (state == StateConstant.SOLD_OUT) {
            System.out.println("糖果卖完了，不能投币");
        } else if (state == StateConstant.SOLD) {
            System.out.println("已经给糖果了");
        } else if (state == StateConstant.NO_QUARTER) {
            System.out.println("投币成功");
        }
    }
}
