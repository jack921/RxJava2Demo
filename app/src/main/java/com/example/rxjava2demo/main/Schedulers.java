package com.example.rxjava2demo.main;

public class Schedulers {

    public static final int THREAD=1;
    public static final int MAIN=2;
    public int subscribeStatus=0;
    public int observeStatus=0;

    public static int io(){
        return THREAD;
    }

    public static int MAIN(){
        return MAIN;
    }


}
