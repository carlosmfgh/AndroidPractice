package com.viken.constraintlayoutpractice.alarm_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.viken.constraintlayoutpractice.R;

import java.util.Calendar;

public class AlarmManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_manager);
        Calendar c = Calendar.getInstance();
        //c.add(Calendar.MINUTE, 2);
        long time;
        PendingIntent pendingChopperWheelAlaramIntent;

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(this, AnotherAlertManager.class);

        int requestCode = 1; //  <-- We would create many of these.  We have only one to test, so
                             // we'll just go along with useing 1
        pendingChopperWheelAlaramIntent = PendingIntent.getBroadcast(this, requestCode, intent, 0);

        Log.d ("Carlos-AlertManager", "Set Alert");
        time = c.getTimeInMillis() + 3_000;
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, time, pendingChopperWheelAlaramIntent);

        //alarmManager.cancel(pendingIntent);

    }

    public void logMessage () {
        Log.d("Carlos-AlertManager", "logMessage: ");
    }

    static public class AnotherAlertManager extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d ("Carlos-AnotherAlertManager", "Recieved Alert");


        }
    }
}

