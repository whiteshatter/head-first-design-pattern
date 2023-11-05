package com.mint.learn.headfirst.listener.display;


import lombok.Data;

import java.math.BigDecimal;

@Data
public abstract class WeatherDisplay {
    private BigDecimal temperature;
    private BigDecimal humidity;
    private BigDecimal pressure;

    public void update(BigDecimal temperature, BigDecimal humidity, BigDecimal pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    abstract void display();
}
