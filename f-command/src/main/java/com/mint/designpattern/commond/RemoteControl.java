package com.mint.designpattern.commond;

public class RemoteControl {
    private Command[] onCommands;
    private Command[] offCommands;
    private Command undoCommand;

    public RemoteControl(int slotCount) {
        onCommands = new Command[slotCount];
        offCommands = new Command[slotCount];
        for (int i = 0; i < slotCount; i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    public void setCommand(int index, Command onCommand, Command offCommand) {
        onCommands[index] = onCommand;
        offCommands[index] = offCommand;
    }

    public void pressOn(int index) {
        onCommands[index].execute();
        undoCommand = onCommands[index];
    }

    public void pressOff(int index) {
        offCommands[index].execute();
        undoCommand = offCommands[index];
    }

    public void undoPress() {
        undoCommand.undo();
    }
}
