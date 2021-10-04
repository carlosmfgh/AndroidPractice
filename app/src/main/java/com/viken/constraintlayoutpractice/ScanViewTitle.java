package com.viken.constraintlayoutpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ScanViewTitle extends AppCompatActivity {

    private Button btnSusp;
    private Button btnPb;
    private ImageView ivSusp;
    private ImageView ivPBLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_view_title);

        btnSusp = findViewById(R.id.btnSusp);
        btnPb = findViewById(R.id.btnPb);
        ivSusp = findViewById(R.id.ivSusp);
        ivPBLogo = findViewById(R.id.ivPBLogo);

        btnSusp.setOnClickListener(view -> {

            if (ivSusp.getVisibility() == View.VISIBLE) {
                ivSusp.setVisibility(View.GONE);
            } else {
                ivSusp.setVisibility(View.VISIBLE);
            }

        });

        btnPb.setOnClickListener(view -> {
            if (ivPBLogo.getVisibility() == View.VISIBLE) {
                ivPBLogo.setVisibility(View.GONE);
            } else {
                ivPBLogo.setVisibility(View.VISIBLE);
            }
        });
    }
}