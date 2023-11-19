# 4.《工厂模式》

## 需求
设计一个披萨相关服务，需要提供不同种类的披萨

## 设计发展
1. 根据传入披萨名用if判断，new 不同的披萨类

缺陷：增加或减少披萨类型，需要对if判断代码做修改

2. 将生成代码转移到新的披萨生成类中

好处：多处可能会调用生成披萨方法，只需要对该类的代码做修改

## 简单工厂
工厂类
```java
public class SimplePizzaFactory {
    public Pizza createPizza(String type) {
        if ("cheese".equals(type)) {
            return new CheesePizza();
        }
        if ("pepperoni".equals(type)) {
            return new PepperoniPizza();
        }
        return null;
    }
}
```

披萨类
```java
public class CheesePizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("cheese prepare");
    }

    @Override
    public void bake() {
        System.out.println("cheese bake");
    }

    @Override
    public void cut() {
        System.out.println("cheese cut");
    }

    @Override
    public void box() {
        System.out.println("cheese box");
    }
}

public class PepperoniPizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("pepperoni prepare");
    }

    @Override
    public void bake() {
        System.out.println("pepperoni bake");
    }

    @Override
    public void cut() {
        System.out.println("pepperoni cut");
    }

    @Override
    public void box() {
        System.out.println("pepperoni box");
    }
}
```

使用
```java
public class SimpleFactoryTest {
    public static void main(String[] args) {
        SimplePizzaFactory factory = new SimplePizzaFactory();
        Pizza cheese = factory.createPizza("cheese");
        if (cheese == null) {
            return;
        }
        cheese.prepare();
        cheese.bake();
        cheese.cut();
        cheese.box();
    }
}
```

## 工厂方法模式
> 需要在不同地点开具有不同风味的披萨店，希望既能生产披萨，又能持有不同地域的披萨风格

## 实现
定义一个抽象的工厂类，不同地域实现不同的工厂

抽象工厂
```java
public abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        if (pizza == null) {
            return null;
        }
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
    
    abstract Pizza createPizza(String type);
}
```

实现
```java
public class NYStylePizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String type) {
        if ("cheese".equals(type)) {
            return new NYStyleCheesePizza();
        }
        if ("pepperoni".equals(type)) {
            return new NYStylePepperoniPizza();
        }
        return null;
    }
}
```

## 抽象工厂
> 定义一个大的接口，创建不同的对象，如披萨加工不同地域需要不同的材料，可以使用抽象工厂得到不同的材料工厂

材料工厂接口
```java
public interface PizzaIngredientFactory {
    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
}
```

工厂实例
```java
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new NYDough();
    }

    @Override
    public Sauce createSauce() {
        return new NYSauce();
    }

    @Override
    public Cheese createCheese() {
        return new NYCheese();
    }
}
```

重写披萨类
```java
@Data
public abstract class Pizza {
    private Cheese cheese;
    private Dough dough;
    private Sauce sauce;
    public abstract void prepare();
    public void bake() {
        System.out.println("pizza bake");
    }
    public void cut() {
        System.out.println("pizza cut");
    }
    public void box() {
        System.out.println("pizza box");
    }
}
```

披萨实现
```java
public class NYStyleCheesePizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;
    public NYStyleCheesePizza() {}

    public NYStyleCheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        cheese = ingredientFactory.createCheese();
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        System.out.println("ny cheese prepare");
    }

}
```

工厂方法
```java
public class NYStylePizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String type) {
        if ("cheese".equals(type)) {
            return new NYStyleCheesePizza(new NYPizzaIngredientFactory());
        }
        if ("pepperoni".equals(type)) {
            return new NYStylePepperoniPizza(new NYPizzaIngredientFactory());
        }
        return null;
    }
}
```

## 工厂方法和抽象工厂区别
工厂方法：
1. 通过继承实现
2. 将实例化具体类从代码中解耦
3. 主要实现一个创建方法

抽象工厂：
1. 通过组合使用
2. 将需要创建的对象和相关产品集合起来
3. 实现一个大接口