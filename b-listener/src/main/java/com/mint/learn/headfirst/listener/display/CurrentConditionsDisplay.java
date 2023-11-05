package com.mint.learn.headfirst.listener.display;

import com.mint.learn.headfirst.listener.DisplayElement;
import com.mint.learn.headfirst.listener.Observer;
import com.mint.learn.headfirst.listener.Subject;

import java.math.BigDecimal;


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
