package com.viken.constraintlayoutpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;

public class SwitchActivity extends AppCompatActivity {

    private SwitchCompat txbxswitch;
    private boolean currentSstate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);

        txbxswitch = findViewById(R.id.txbxswitch);

        currentSstate =txbxswitch.isChecked();
        Log.d("SwitchActivity - ", "currentSstate: " + currentSstate);
        txbxswitch.setChecked(true);
        currentSstate =txbxswitch.isChecked();
        Log.d("SwitchActivity - ", "currentSstate: " + currentSstate);

        txbxswitch.setOnCheckedChangeListener((compoundButton, b) -> {

            if (b == true) {
                Log.d("SwitchActivity", "onCheckedChanged: true");
            } else {
                Log.d("SwitchActivity", "onCheckedChanged: false");
            }
        }
        );
    }
}