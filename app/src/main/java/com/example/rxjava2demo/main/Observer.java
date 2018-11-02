package com.example.rxjava2demo.main;

public abstract class Observer<T> {

    public abstract void subscribe(ObserverAction observerAction);

    public abstract void next(T data);

}
