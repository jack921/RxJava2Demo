package com.example.rxjava2demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rxjava2demo.main.Observable;
import com.example.rxjava2demo.main.ObservableSubscribe;
import com.example.rxjava2demo.main.Observer;
import com.example.rxjava2demo.main.ObserverAction;
import com.example.rxjava2demo.main.Schedulers;

public class MainActivity extends AppCompatActivity {
    private Button btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTest=findViewById(R.id.btn_test);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                test1();
                DemoUtil.test();
            }
        });

    }

    public void test1(){
        Observable.create(new ObservableSubscribe<String>() {
            @Override
            public void subscribe(ObserverAction observerAction) {
                try {
                    Thread.sleep(5000);
                    observerAction.next("HelloJack");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).subscribeOn(Schedulers.io())
          .observeOn(Schedulers.MAIN())
          .subscribe(new Observer<String>() {
              @Override
              public void subscribe(ObserverAction observerAction) {}
              @Override
              public void next(String data) {
                  btnTest.setText(data);
              }
        });
    }

}
