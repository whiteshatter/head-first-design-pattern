# 《单例模式》

## 简单单例模式
```java
public class Singleton {
    public static Singleton singleton;
    
    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
```

## 线程安全单例模式
```java
public class Singleton {
    public static volatile Singleton singleton;
    
    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
```