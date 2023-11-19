# 3.《装饰者模式》

## 需求
> 设计一个咖啡计算服务
> 1. 不同种类咖啡有不同描述
> 2. 不同咖啡有cost方法，计算费用
> 3. 咖啡需要加入不同调料，并计算价格


## 设计发展
1. 对添加不同调料的不同咖啡都定义一个类

    缺陷：导致类爆炸，且维护困难

2. 在基类中添加各种调料的属性，并定义cost方法计算价格，子类继承重写该方法，复用父类代码

    缺陷

   a. 调料价格改变会更改现有代码

   b. 新调料出现会加上新方法，并改变cost方法

   c. 新饮料可能不需要某些调料，但仍会继承

   d. 多材料，如双倍摩卡咖啡咋整

## 装饰者模式

基类
```java
@Data
public abstract class Beverage {
    protected String description = "unknown beverage";

    public abstract double cost();
}
```

装饰基类
```java
public abstract class CondimentDecorator extends Beverage{
    public abstract String getDescription();
}
```


具体饮料类
```java
public class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }
    @Override
    public double cost() {
        return 1.99;
    }
}

public class HouseBlend extends Beverage {
   public HouseBlend() {
      description = "House Blend Coffee";
   }

   @Override
   public double cost() {
      return 0.89;
   }
}
```

相关装饰调料类
```java
public class Whip extends CondimentDecorator {
    Beverage beverage;

    @Override
    public double cost() {
        return 0.36 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",whip";
    }
}

public class Mocha extends CondimentDecorator {
   private Beverage beverage;
   @Override
   public double cost() {
      return 0.2 + beverage.cost();
   }

   @Override
   public String getDescription() {
      return beverage.getDescription() + ",Mocha";
   }
}
```

测试
```java
public class DecoratorTest {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        beverage = new Mocha(beverage);
        beverage = new Mocha(beverage);
        beverage = new Whip(beverage);
        System.out.println(beverage.getDescription());
        System.out.println(beverage.cost());
    }
}
```

结果
```text
Espresso,Mocha,Mocha,whip
2.75
```


## 自定义IO装饰器
```java
public class LowerCaseInputStream extends FilterInputStream {
    protected LowerCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return c == -1 ? c : Character.toLowerCase((char) c);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int result = super.read(b, off, len);
        for (int i = off; i < off + result; i++) {
            b[i] = (byte) Character.toLowerCase((char) b[i]);
        }
        return result;
    }
}
```

IO装饰器测试
```java
public class IODecoratorTest {
    public static void main(String[] args) {
        int c;
        try {
            InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream(IODecoratorTest.class.getClassLoader().getResource("test.txt").getPath())));
            while ((c = in.read()) >= 0) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

原文
```text
Hello World
```
结果
```text
hello world
```