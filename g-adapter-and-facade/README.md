# 《适配器和外观模式》

## 适配器简介
> 将一个类通过适配器类转换成另一个类，可以通过另外类的接口调用被转换类方法

## 简单例子
原本类
```java
public interface Duck {
    void quack();
    void fly();
}

public class MallardDuck implements Duck{
    @Override
    public void quack() {
        System.out.println("mall quack");
    }

    @Override
    public void fly() {
        System.out.println("mall fly");
    }
}
```

新类
```java
public interface Turkey {
    void gobble();
    void fly();
}

public class WildTurkey implements Turkey{

    @Override
    public void gobble() {
        System.out.println("gobble gobble");
    }

    @Override
    public void fly() {
        System.out.println("wild fly");
    }
}


```

适配类
```java
public class TurkeyAdapter implements Duck{
    private Turkey turkey;
    
    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }
    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        turkey.fly();
    }
}
```

使用适配器过程：
1. 通过目标接口调用适配器方法对适配器发出请求
2. 适配器使用被适配接口把请求转成被适配者的一个或多个调用接口
3. 客户接收调用结果，不察觉是适配器在其转换作用

## 真实例子
> 早期Java使用Enumeration实现集合遍历，后来使用Iterator接口，构建相关适配器

```java
public class EnumerationIterator implements Iterator {
    private Enumeration enumeration;
    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public Object next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
```

## 外观模式
> 定义一个统一的接口，用来访问多个子系统的接口。如定义一个WatchTV接口，包含Light、TV、Sound等对象，调用watch方法即调用这些对象的相应方法，一键实现看电视操作