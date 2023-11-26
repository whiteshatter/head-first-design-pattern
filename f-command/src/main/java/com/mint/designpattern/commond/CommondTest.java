package com.mint.designpattern.commond;

public class CommondTest {
    public static void main(String[] args) {
        Light light = new Light();
        Command command = new LightOnCommand(light);
        SimpleRemoteControl control = new SimpleRemoteControl(command);
        control.pressButton();
    }
}
