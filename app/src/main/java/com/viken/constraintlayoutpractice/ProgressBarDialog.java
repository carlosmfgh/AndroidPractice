package com.viken.constraintlayoutpractice;

import android.app.Dialog;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.widget.LinearLayoutCompat;

import java.text.DecimalFormat;

public class ProgressBarDialog extends Dialog {

    private LinearLayoutCompat llIndeterminateContainer;
    private LinearLayoutCompat llDeterminateContainer;
    private TextView tvTitle;
    private TextView tvIndeterminateMessage;
    private TextView tvDeterminateMessage;
    private ProgressBar determinateProgressBar;
    private TextView progressPercentage;
    private TextView progressCount;
    private boolean bIndeterminate = true;
    private int max = 0;

    public ProgressBarDialog(Context context) {
        super(context);
        setContentView(R.layout.progress_bar_dialog);
        llIndeterminateContainer = findViewById(R.id.llIndeterminateContainer);
        llDeterminateContainer = findViewById(R.id.llDeterminateContainer);
        tvTitle = findViewById(R.id.tvTitle);
        tvIndeterminateMessage = findViewById(R.id.tvIndeterminateMessage);
        tvDeterminateMessage = findViewById(R.id.tvDeterminateMessage);
        determinateProgressBar = findViewById(R.id.determinateProgressBar);
        progressPercentage = findViewById(R.id.progressPercentage);
        progressCount =  findViewById(R.id.progressCount);

        setIndeterminate(true);
        setCancelable(false);
    }

    public void setTitle(String title) {
        tvTitle.setText(title);
    }

    public void setMessage(String message) {
        tvIndeterminateMessage.setText(message);
        tvDeterminateMessage.setText(message);
    }

    public void setIndeterminate (boolean determinate) {
        bIndeterminate = determinate;

        if (bIndeterminate) {
            llIndeterminateContainer.setVisibility(View.VISIBLE);
            llDeterminateContainer.setVisibility(View.GONE);
        } else {
            llIndeterminateContainer.setVisibility(View.GONE);
            llDeterminateContainer.setVisibility(View.VISIBLE);
        }
    }

    public void setMax (int max) {
        this.max = max;
        determinateProgressBar.setMax(max);
    }

    public void setMin (int min) {
        determinateProgressBar.setMin(min);
    }

    public void setProgress (int progress) {
        determinateProgressBar.setProgress(progress);

        // Show percentage
        DecimalFormat decFormat = new DecimalFormat("#%");
        progressPercentage.setText(decFormat.format(progress/(double)max));

        // Show count
        progressCount.setText(progress + "/" + max);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        boolean ret = false;
        switch (keyCode) {
            case android.view.KeyEvent.KEYCODE_VOLUME_DOWN:
            case android.view.KeyEvent.KEYCODE_VOLUME_UP:
                ret = true;
                break;
            default:
                super.onKeyDown(keyCode, event);
                break;
        }

        return ret;
    }
}