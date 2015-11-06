package com.jezer.crespo.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.jezer.crespo.firstdive.FirstDive;
import com.jezer.crespo.firstdive.OnFirstLaunch;

public class MainActivity extends AppCompatActivity {


public static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirstDive.getInstance(this).doOnFirstLaunch(new OnFirstLaunch() {
            @Override
            public void doOnFirstLaunch() {
                Log.d(TAG, "It's my first time!");
            }
        });





    }
}
