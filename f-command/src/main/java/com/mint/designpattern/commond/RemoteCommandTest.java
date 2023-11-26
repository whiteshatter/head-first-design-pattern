package com.mint.designpattern.commond;

public class RemoteCommandTest {
    public static void main(String[] args) {
        Door door = new Door();
        DoorOnCommand doorOnCommand = new DoorOnCommand(door);
        DoorOffCommand doorOffCommand = new DoorOffCommand(door);

        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);


        RemoteControl remoteControl = new RemoteControl(5);
        remoteControl.setCommand(0, doorOnCommand, doorOffCommand);
        remoteControl.setCommand(1, lightOnCommand, lightOffCommand);

        remoteControl.pressOn(0);
        remoteControl.pressOff(0);
        remoteControl.pressOn(1);
        remoteControl.pressOff(1);

    }
}
