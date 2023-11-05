package com.mint.learn.headfirst.listener;

import java.math.BigDecimal;

public interface Observer {
    void update(BigDecimal temperature, BigDecimal humidity, BigDecimal pressure);
}
