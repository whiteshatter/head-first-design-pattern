package com.mint.designpattern.commond;

public class Fan {
    public static final int OFF = 0;
    public static final int LOW = 1;
    public static final int MIDDLE = 2;
    public static final int HIGH = 3;

    private int speed;

    public Fan() {
        speed = OFF;
    }

    public void off() {
        speed = OFF;
    }

    public void setLow() {
        speed = LOW;
    }

    public void setMiddle() {
        speed = MIDDLE;
    }

    public void setHigh() {
        speed = HIGH;
    }

    public int getSpeed() {
        return speed;
    }
}
