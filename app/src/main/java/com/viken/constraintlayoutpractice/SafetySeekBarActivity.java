package com.viken.constraintlayoutpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.SeekBar;

import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class SafetySeekBarActivity extends AppCompatActivity {

    private static Thread safetyThread;
    private static long resetStartDiff = 0;
    private static int safetyMaxTime = 0;
    private static boolean bAllowScan = false;

    private final Timer timer = new Timer();
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety_seek_bar);
        context = this;


        // oops not this ...safetySeekBar.setProgressDrawable( getDrawable( R.drawable.safety_seekbar_thumb ));
        //safetySeekBar.setThumb(getDrawable( R.drawable.safety_seekbar_thumb ));


    }

    public static boolean startSafetyTimer(Activity activity) {


        startSafetyThread(activity);
        return bAllowScan;
    }


    private static void startSafetyThread(Activity activity) {


        final long safetyTime = 15_000;
        final long start = System.currentTimeMillis();
        bAllowScan = true;


        //Util.greenLedOn();
        safetyThread = new Thread() {
            public void run() {
                long elapsedSeconds = 0;
                long updatedStart = start;
                while (elapsedSeconds < safetyTime) {

                    updatedStart += resetStartDiff;

                    resetStartDiff = 0;
                    elapsedSeconds = System.currentTimeMillis() - updatedStart;
                    Log.d("startSafetyThread", " >> safetyThread");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // e.printStackTrace();
                        // Only when you break from an interrupt, does this thread stop.
                        // The safetyThread is then set to null, so the memory cleaner will do
                        // its job.
                        break;
                    }

                    // Check progress of initializing.
                    if ((elapsedSeconds > safetyTime) || (safetyThread == null)) {

                        bAllowScan = false;
                        //Util.greenLedOff();
                        safetyThread = null;
                        break;
                    } else {

                        // This check is here for if user had slightly pull to the right during
                        // countdown, it won't jump to previous then jump back to new location
                        // on the seekbar.
                        if (resetStartDiff == 0) {
                            //SeekBar safetySeekBarH =  activity.findViewById(R.id.safetySeekBar);
                            //safetySeekBarH.setProgress((int) elapsedSeconds);
                        }
                    }
                } //  while
            }  //  run()
        };  //  new Thread()

        safetyThread.start();
    }


    void changeThumb () {

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //safetySeekBar.setThumb(context.getDrawable( R.drawable.safety_seekbar_thumb ));
                    }
                });
            }
        }, 3_000);

//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                safetySeekBar.setThumb(context.getDrawable( R.drawable.safety_seekbar_thumb ));
//            }
//        });
    }
}