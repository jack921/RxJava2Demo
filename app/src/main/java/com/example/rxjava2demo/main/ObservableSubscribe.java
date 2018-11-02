package com.example.rxjava2demo.main;

public interface ObservableSubscribe<T> {
    void subscribe(ObserverAction<T> observerAction);
}
