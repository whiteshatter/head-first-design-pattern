# 《模版模式》

## 需求
> 某咖啡店对咖啡和茶的冲泡方法有规定
> 1. 咖啡冲泡
> 
>    a. 把水煮沸
>    b. 用沸水冲泡咖啡
>    c. 把咖啡倒进杯子
>    d. 加糖和牛奶
>
> 2. 茶冲泡
>
>    a. 把水煮沸
>    b. 用沸水浸泡茶叶
>    c. 把咖啡倒进杯子
>    d. 加柠檬

## 最初设计
```java
public class Coffee {
    public void prepareRecipe() {
        boilWater();
        brewCoffeeGrinds();
        pourInCup();
        addSugarAndMilk();
    }

    public void boilWater() {
        System.out.println("boiling water");
    }

    public void brewCoffeeGrinds() {
        System.out.println("dripping coffee through filter");
    }

    public void pourInCup() {
        System.out.println("pouring into cup");
    }

    public void addSugarAndMilk() {
        System.out.println("adding sugar and milk");
    }
}

public class Tea {
    public void prepareRecipe() {
        boilWater();
        steepTeaBag();
        addLemon();
        pourInCup();
    }

    public void boilWater() {
        System.out.println("boiling water");
    }

    public void steepTeaBag() {
        System.out.println("steeping the tea");
    }

    public void addLemon() {
        System.out.println("adding Lemon");
    }

    public void pourInCup() {
        System.out.println("pouring into cup");
    }
}
```

缺陷：很多代码冗余

## 使用模版方法
```java
public abstract class CaffeineBeverage {
    void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    abstract void brew();
    abstract void addCondiments();
    void boilWater() {
        System.out.println("boiling water");
    }
    void pourInCup() {
        System.out.println("pouring into cup");
    }
}

public class Coffee extends CaffeineBeverage{
    @Override
    void brew() {
        System.out.println("steeping the tea");
    }

    @Override
    void addCondiments() {
        System.out.println("adding sugar and milk");
    }
}

public class Tea extends CaffeineBeverage{
    @Override
    void brew() {
        System.out.println("steeping the tea");
    }

    @Override
    void addCondiments() {
        System.out.println("adding Lemon");
    }
}
```

好处：
1. 模板类主导一切，拥有算法、且主导算法
2. 子类可以将代码复用最大化
3. 算法只存在于一个地方，容易修改
4. 提供框架，可以让其他饮料插入，只需实现自己方法
5. 专注算法本身，由子类提供完整实现

## 模版方法hook
```java
public abstract class CaffeineBeverage {
    void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }
    
    // ...
    
    boolean customerWantsCondiments() {
        return true;
    }
}
```
子类可通过覆盖customerWantsCondiments方法决定是否放辅料