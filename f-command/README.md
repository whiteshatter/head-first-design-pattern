# 《命令模式》

## 需求
> 设计一个家电遥控器，有多个可编程插槽，可控制不同电器，可支持不同厂家，具有扩展性

## 单命令简单命令模式

命令
```java
public interface Commond {
    void execute();
}

public class LightOnCommond implements Commond{
    private Light light;

    public LightOnCommond() {}

    public LightOnCommond(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
```

被控制类
```java
public class Light {
    public void on() {
        System.out.println("light on");
    }
}
```

控制类
```java
public class SimpleRemoteControl {
    private Commond slot;

    public SimpleRemoteControl(Commond slot) {
        this.slot = slot;
    }

    public void pressButton() {
        slot.execute();
    }
}
```

测试类
```java
public class CommondTest {
    public static void main(String[] args) {
        Light light = new Light();
        Commond command = new LightOnCommond(light);
        SimpleRemoteControl control = new SimpleRemoteControl(command);
        control.pressButton();
    }
}
```

## 命令模式
多命令控制器
```java
public class RemoteControl {
    private Command[] onCommands;
    private Command[] offCommands;

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
    }

    public void pressOff(int index) {
        offCommands[index].execute();
    }
}
```

相关被控制类
```java
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
}

public class LightOffCommand implements Command{

    private Light light;

    public LightOffCommand() {}

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}
```

控制器测试
```java
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
```

## 撤销功能
通过给不同命令设置撤销指令，实现命令的撤销
添加撤销方法
```java
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
```

添加撤销的控制类
```java
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
```

## 多功能状态开关的撤销
被控类
```java
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
```

命令类
```java
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
```

## 命令模式更多用途
### 队列模式
> 将Command对象放入队列中，使用线程池等进行消费

### 日志记录
> 服务正常工作时在每个检查点用一个command对象记录日志，假如服务崩溃，重启后通过这些对象可以恢复