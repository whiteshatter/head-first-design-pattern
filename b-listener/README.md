# 2.《观察者模式》

## 需求
> 设计一个气象监测系统，包含
> 1. 获取实际气象数据的气象站
> 2. 追踪气象站数据，并更新布告板的WeatherData对象
> 3. 显示目前天气状况给用户的布告板

初始WeatherData类：
```java
public class WeatherData {

    public BigDecimal getTemperature() {
        // 获取气温
        return new BigDecimal("30.5");
    }

    public BigDecimal getHumidity() {
        // 获取湿度
        return new BigDecimal("63");
    }

    public BigDecimal getPressure() {
        // 获取气压
        return new BigDecimal("100000");
    }
    // 气象站被更新，此方法会被调用
    public void measurementsChanged() {

    }
}
```

## 错误示范

```java
public class WeatherData {
    // ...
    public void measurementsChanged() {
        BigDecimal temperature = getTemperature();
        BigDecimal humidity = getHumidity();
        BigDecimal pressure = getPressure();

        currentConditionsDisplay.update(temperature, humidity, pressure);
        statisticsDisplay.update(temperature, humidity, pressure);
    }
}
```

缺陷：

1. 针对具体实现编程，以后修改展示板会修改该方法
2. 一样的调用需要封装

## 观察者模式简介
> 类似报纸的订阅，只要是某家报社订户，就会一直受到新报纸，取消订阅就不会收到，报社还在就会一直有人订阅或取消订阅报纸。
> 
> 出版者 + 订阅者 = 观察者模式
> 
> 出版者为主题（Subject），订阅者为观察者（Observer），主题对象内数据发生变化，就会通知观察者

## 实现气象站

```java
import com.mint.learn.headfirst.listener.display.StatisticsDisplay;

import java.math.BigDecimal;

public interface Subject {
    void registerObserver(Observer observer);

    void removerObserver(Observer observer);

    void notifyObservers();
}

public interface Observer {
    void update(BigDecimal temperature, BigDecimal humidity, BigDecimal pressure);
}

// 主题
@Data
public class WeatherData implements Subject {
    private BigDecimal temperature;
    private BigDecimal humidity;
    private BigDecimal pressure;
    private Set<Observer> observerSet;

    public WeatherData() {
        observerSet = new HashSet<>();
    }
    // private

    @Override
    public void registerObserver(Observer observer) {
        observerSet.add(observer);
    }

    @Override
    public void removerObserver(Observer observer) {
        observerSet.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerSet) {
            observer.update(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(BigDecimal temperature, BigDecimal humidity, BigDecimal pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}

// 观察者
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private BigDecimal temperature;
    private BigDecimal humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("temp:" + temperature + "\n" + "humidity:" + humidity);
    }

    @Override
    public void update(BigDecimal temperature, BigDecimal humidity, BigDecimal pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }
}

// 运行demo
class Demo {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);

        weatherData.setMeasurements(new BigDecimal("20.6"), new BigDecimal("56"), new BigDecimal("100000"));
    }
}
```

