package com.viken.constraintlayoutpractice.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.viken.constraintlayoutpractice.R;

// Google .... "android extends progressbar"

//https://dzone.com/articles/progressbar-in-android

// Take a look to make the assets of what is commented out below.
// https://stackoverflow.com/questions/21333866/how-to-create-a-circular-progressbar-in-android-which-rotates-on-it
public class ProgressBarDialogs extends AppCompatActivity {

    private ProgressBar progressDeterminate;
    //private ProgressBar progressIndeterminateCircular;
    private ProgressBar progressBuffered;
    private ProgressBar progressIndeterminateDeterminate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_dialogs);

        initComponent();
    }

    private void initComponent() {
        progressDeterminate = (ProgressBar) findViewById(R.id.progressDeterminate);
        //progressIndeterminateCircular = (ProgressBar) findViewById(R.id.progressIndeterminateCircular);
        progressBuffered = (ProgressBar) findViewById(R.id.progressBuffered);
        progressIndeterminateDeterminate = (ProgressBar) findViewById(R.id.progressIndeterminateDeterminate);
        startDeterminateProgress();
        startBufferedProgress();
//        startBufferedSecondaryProgress();
        startIndeterminateDeterminateProgress();
//        startDeterminateCircularProgress();
    }
    private void startDeterminateProgress() {
        final Handler mHandler = new Handler();
        Runnable runnable = new Runnable() {
            public void run() {
                int progress = progressDeterminate.getProgress() + 10;
                progressDeterminate.setProgress(progress);
                if (progress > 100) {
                    progressDeterminate.setProgress(0);
                }
                mHandler.postDelayed(this, 1000);
            }
        };
        mHandler.post(runnable);
    }
    private void startBufferedProgress() {
        final Handler mHandler = new Handler();
        Runnable runnable = new Runnable() {
            public void run() {
                int progress = progressBuffered.getProgress() + 5;
                progressBuffered.setProgress(progress);
                if (progress > 100) {
                    progressBuffered.setProgress(0);
                }

                mHandler.postDelayed(this, 500);

            }
        };
        mHandler.postDelayed(runnable, 500);
    }
//    private void startBufferedSecondaryProgress() {
//        final Handler mHandler = new Handler();
//        Runnable runnable = new Runnable() {
//            public void run() {
//                int progress = progressBuffered.getSecondaryProgress() + 5;
//                progressBuffered.setSecondaryProgress(progress);
//                if (progress > 100 && progress_buffered.getProgress() <= 10) {
//                    progressBuffered.setSecondaryProgress(0);
//                }
//                mHandler.postDelayed(this, 250);
//            }
//        };
//        mHandler.post(runnable);
//    }
    private void startIndeterminateDeterminateProgress() {
        final Handler mHandler = new Handler();
        Runnable runnable = new Runnable() {
            public void run() {
                if (progressIndeterminateDeterminate.isIndeterminate()) {
                    progressIndeterminateDeterminate.setIndeterminate(false);
                    mHandler.postDelayed(this, 1000);
                } else {
                    int progress = progressIndeterminateDeterminate.getProgress() + 20;
                    progressIndeterminateDeterminate.setProgress(progress);
                    if (progress > 100 ) {
                        progressIndeterminateDeterminate.setProgress(0);
                        progressIndeterminateDeterminate.setIndeterminate(true);
                        mHandler.postDelayed(this, 4000);
                    }else {
                        mHandler.postDelayed(this, 1000);
                    }
                }
            }
        };
        mHandler.post(runnable);
    }
//    private void startDeterminateCircularProgress() {
//        final Handler mHandler = new Handler();
//        Runnable runnable = new Runnable() {
//            public void run() {
//                int progress = progressIndeterminateCircular.getProgress() + 10;
//                progressIndeterminateCircular.setProgress(progress);
//                if (progress > 100) {
//                    progressIndeterminateCircular.setProgress(0);
//                }
//                mHandler.postDelayed(this, 1000);
//            }
//        };
//        mHandler.post(runnable);
//    }
}