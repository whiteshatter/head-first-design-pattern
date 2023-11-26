package com.mint.designpattern.commond;

public class FanHighSpeedCommand implements Command{
    private Fan fan;

    private int preSpeed;

    public FanHighSpeedCommand(Fan fan) {
        this.fan = fan;
    }
    @Override
    public void execute() {
        preSpeed = fan.getSpeed();
        fan.setHigh();
    }

    @Override
    public void undo() {
        switch (preSpeed) {
            case Fan.LOW:
                fan.setLow();
                break;
            case Fan.MIDDLE:
                fan.setMiddle();
                break;
            case Fan.HIGH:
                fan.setHigh();
                break;
            case Fan.OFF:
                fan.off();
                break;
        }
    }
}
