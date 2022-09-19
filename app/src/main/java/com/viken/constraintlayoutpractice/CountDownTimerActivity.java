package com.viken.constraintlayoutpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import java.text.DecimalFormat;

public class CountDownTimerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down_timer);
        //startIndeterminate();
        startDeterminate();
    }

    private void startIndeterminate() {
        final ProgressBarDialog TempDialog;
        CountDownTimer CDT;

        TempDialog = new ProgressBarDialog(this);
        TempDialog.setTitle("Indeterminate Progress");
        TempDialog.setMessage("Please wait...");
        TempDialog.setCancelable(false);
        TempDialog.show();

        CDT = new CountDownTimer(7500, 250) {
            int tick = 0;
            public void onTick(long millisUntilFinished) {
                tick += 1;
                TempDialog.setMessage("Please wait.." + millisUntilFinished + " (" + tick + ")");
                //i--;
            }

            public void onFinish() {
                TempDialog.dismiss();
                //Your Code ...
            }
        }.start();
    }

    private void startDeterminate() {
        final ProgressBarDialog progressBarDialog;
        CountDownTimer CDT;
        DecimalFormat decFormat = new DecimalFormat("#%");
        progressBarDialog = new ProgressBarDialog(this);
        progressBarDialog.setIndeterminate(false);
        progressBarDialog.setTitle("Determinate Progress");
        progressBarDialog.setMessage("B");

        progressBarDialog.setMin(0);
        progressBarDialog.setMax(100);
        progressBarDialog.show();

        CDT = new CountDownTimer(5000, 2500) {
            int tick = 0;
            public void onTick(long millisUntilFinished) {
                tick += 50;
                double perc = tick/100.0;
                //progressBarDialog.setMessage(decFormat.format(perc));
                progressBarDialog.setMessage("Determinate SetMessage");
                progressBarDialog.setProgress(tick);
                //i--;
            }

            public void onFinish() {
                progressBarDialog.dismiss();
                //Your Code ...
            }
        }.start();
    }
}