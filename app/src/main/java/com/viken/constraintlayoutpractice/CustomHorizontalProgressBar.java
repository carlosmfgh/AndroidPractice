package com.viken.constraintlayoutpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

public class CustomHorizontalProgressBar extends AppCompatActivity {
    private ProgressBar progressBar;
    TextView percentage;
    private int progressStatus = 0;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_horizontal_progress_bar);

        handler = new Handler();
        progressBar =  findViewById(R.id.progressBar);
        percentage =  findViewById(R.id.percentage);

        progressBar.setMax(100);

        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 5;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressStatus);
                            percentage.setText(progressStatus+"%");
                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
//                Intent intent = new Intent(CustomHorizontalProgressBar.this, HomeActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
//                finish();
            }
        }).start();

    }
}