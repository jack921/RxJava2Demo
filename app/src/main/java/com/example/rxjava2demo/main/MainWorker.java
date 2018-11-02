package com.example.rxjava2demo.main;

import android.os.Handler;

public class MainWorker {

    private Handler handler;

    public MainWorker(Handler handler){
        this.handler = handler;
    }

    public void schedule(){
        handler.post(new Runnable() {
            @Override
            public void run() {


            }
        });
    }


}
