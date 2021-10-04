package com.viken.constraintlayoutpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.viken.constraintlayoutpractice.alarm_manager.AlarmManagerActivity;

public class MainActivity extends AppCompatActivity {

    private Button login;
    private Button radiation_warning;
    private Button horizontal_progress_bar;
    private Button user_admin;
    private Button list_users;
    private Button add_user;
    private Button edit_user;
    private Button delete_user;
    private Button safety_seekbar;
    private Button drawer_layout;
    private Button scan_menus;
    private Button scan_view_title;
    private Button multi_nav_view;
    private Button alarm_manager_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);
        radiation_warning = findViewById(R.id.radiation_warning);
        horizontal_progress_bar = findViewById(R.id.horizontal_progress_bar);
        user_admin = findViewById(R.id.user_admin);
        list_users = findViewById(R.id.list_users);
        add_user = findViewById(R.id.add_user);
        edit_user = findViewById(R.id.edit_user);
        delete_user = findViewById(R.id.delete_user);
        safety_seekbar = findViewById(R.id.safety_seekbar);
        drawer_layout = findViewById(R.id.drawer_layout);
        scan_menus = findViewById(R.id.scan_menus);
        scan_view_title = findViewById(R.id.scan_view_title);
        multi_nav_view = findViewById(R.id.multi_nav_view);
        alarm_manager_activity = findViewById(R.id.alarm_manager_activity);

        login.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        radiation_warning.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, RadiationWarning.class);
            startActivity(intent);
        });

        horizontal_progress_bar.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CustomHorizontalProgressBar.class);
            startActivity(intent);

        });

        user_admin.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, UserAdministrationActivity.class);
            startActivity(intent);
        });

        list_users.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ListUsersActivity.class);
            startActivity(intent);

        });

        add_user.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
            startActivity(intent);;
        });

        edit_user.setOnClickListener(view -> {
            Intent intent = new Intent( MainActivity.this, EditUserActivity.class);
            startActivity(intent);
        });

        delete_user.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, DeleteUserActivity.class);
            startActivity(intent);
        });

        safety_seekbar.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SafetySeekBarActivity.class);
            startActivity(intent);
        });

        drawer_layout.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, DrawerLayoutActivity.class);
            startActivity(intent);
        });

        scan_menus.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ScanMenusActivity.class);
            startActivity(intent);
        });

        scan_view_title.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ScanViewTitle.class);
            startActivity(intent);
        });

        multi_nav_view.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MultiNavViewActivity.class);
            startActivity(intent);
        });

        alarm_manager_activity.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AlarmManagerActivity.class);
            startActivity(intent);
        });
    }
}