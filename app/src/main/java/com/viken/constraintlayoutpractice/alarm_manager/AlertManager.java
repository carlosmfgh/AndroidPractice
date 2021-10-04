package com.viken.constraintlayoutpractice.alarm_manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlertManager extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d ("Carlos-AlertManager", "Recieved Alert");
    }
}
