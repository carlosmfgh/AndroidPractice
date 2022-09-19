package com.viken.constraintlayoutpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.Chronometer;

public class ChronometerActivity extends AppCompatActivity {

    private Chronometer simpleChronometer;
    private Button start;
    private Button stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chronometer);

        simpleChronometer = findViewById(R.id.simpleChronometer);
        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//        }


        start.setOnClickListener(view -> {
            simpleChronometer.setBase(SystemClock.elapsedRealtime());
            simpleChronometer.stop();
            simpleChronometer.start();

        });

        stop.setOnClickListener(view -> {
            simpleChronometer.stop();

        });
    }
}