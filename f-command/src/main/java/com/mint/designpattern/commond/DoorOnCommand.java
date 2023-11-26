package com.mint.designpattern.commond;

public class DoorOnCommand implements Command{

    private Door door;

    public DoorOnCommand() {}

    public DoorOnCommand(Door door) {
        this.door = door;
    }

    @Override
    public void execute() {
        door.on();
    }

    @Override
    public void undo() {
        door.off();
    }
}
