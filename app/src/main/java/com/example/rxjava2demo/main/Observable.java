package com.example.rxjava2demo.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Observable {
    public ExecutorService cachedThreadPool;
    public ObservableSubscribe observableSubscribe;
    public ObserverAction observerAction;
    public Schedulers schedulers;

    public static Observable create(ObservableSubscribe  observableSubscribes){
        Observable observable=new Observable();
        observable.schedulers=new Schedulers();
        observable.observableSubscribe=observableSubscribes;
        return observable;
    }

    public void subscribe(final Observer observer){
        observerAction=new ObserverAction(observer,schedulers);
        if(schedulers.subscribeStatus==1){
            if(cachedThreadPool==null){
                cachedThreadPool = Executors.newCachedThreadPool();
            }
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    observableSubscribe.subscribe(observerAction);
                }
            });
        }else{
            observableSubscribe.subscribe(observerAction);
        }
        observer.subscribe(observerAction);
    }

    public Observable subscribeOn(int status){
        schedulers.subscribeStatus=status;
        return this;
    }

    public Observable observeOn(int status){
        schedulers.observeStatus=status;
        return this;
    }


}
