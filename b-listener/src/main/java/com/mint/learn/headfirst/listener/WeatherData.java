package com.mint.learn.headfirst.listener;


import lombok.Data;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

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
