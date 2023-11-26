package com.mint.designpattern.commond;

public class DoorOffCommand implements Command{
    private Door door;

    public DoorOffCommand() {}

    public DoorOffCommand(Door door) {
        this.door = door;
    }

    @Override
    public void execute() {
        door.off();
    }

    @Override
    public void undo() {
        door.on();
    }
}
