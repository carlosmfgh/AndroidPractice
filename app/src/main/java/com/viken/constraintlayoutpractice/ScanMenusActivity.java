package com.viken.constraintlayoutpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class ScanMenusActivity extends AppCompatActivity {

    private Button open_session_menu;
    private LinearLayout session_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_menus);

        open_session_menu = findViewById(R.id.open_menu1);


        open_session_menu.setOnClickListener(view -> {

        });
    }
}