package com.mint.learn.headfirst.listener;

public interface Subject {
    void registerObserver(Observer observer);
    void removerObserver(Observer observer);
    void notifyObservers();
}
