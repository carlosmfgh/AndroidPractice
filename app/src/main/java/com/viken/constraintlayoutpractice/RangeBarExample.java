package com.viken.constraintlayoutpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RangeBarExample extends AppCompatActivity {

    private RangeBar rangeBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_range_bar_example);

        rangeBar = findViewById(R.id.rangebar);
        rangeBar.setMinVal(50);
        rangeBar.setMaxVal(255);
        rangeBar.create();
    }
}