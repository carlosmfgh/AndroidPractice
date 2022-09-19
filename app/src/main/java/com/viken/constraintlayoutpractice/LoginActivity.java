package com.viken.constraintlayoutpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private AutoCompleteTextView usernameAutoCompleteTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameAutoCompleteTextView = findViewById(R.id.usernameAutoCompleteTextView);

        // Setting this means your theme needs to have NoActionBar ... see AndroidManifest.xml
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // You can set whatever title you want. Either on your toolbar that you define in the
        // layout when you have the theme of NoActionBar.  Or if you have the theme that gives
        // you the action bar, you can set this too.
        getSupportActionBar().setTitle("Login - me setting");


        TextView versionTextView = findViewById(R.id.versionTextView);
        versionTextView.setText("4.0.2-RC1");

        //
        // THIS IN ESSENCE IS A CLICK MESSAGE FOR CLICKING ON THE LEFT DRAWABLE WITHIN THE
        // username textview.
        //
        usernameAutoCompleteTextView.setOnTouchListener((v, event) -> {

            if(event.getAction() == MotionEvent.ACTION_UP) {
                if(event.getRawX() <= usernameAutoCompleteTextView.getTotalPaddingLeft()) {
                    // your action here

                    return true;
                }
            }
            return false;
        });
    }
}