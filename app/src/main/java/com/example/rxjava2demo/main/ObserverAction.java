package com.example.rxjava2demo.main;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class ObserverAction<T> {
    public Handler mainThread = new Handler(Looper.getMainLooper());
    private Schedulers schedulers;
    private Observer observer;

    public ObserverAction(Observer observer,Schedulers schedulers){
        this.observer=observer;
        this.schedulers=schedulers;
    }

    public void next(final T data){
        if(schedulers.observeStatus==2){
            Message message = Message.obtain(mainThread, new Runnable() {
                @Override
                public void run() {
                  observer.next(data);
                }
            });
            message.obj = this;
            mainThread.sendMessageDelayed(message,100);
        }else{
            observer.next(data);
        }
    }

}
