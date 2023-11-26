package com.mint.designpattern.commond;

public class SimpleRemoteControl {
    private Command slot;

    public SimpleRemoteControl(Command slot) {
        this.slot = slot;
    }

    public void pressButton() {
        slot.execute();
    }
}
