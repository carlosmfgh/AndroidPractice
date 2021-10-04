package com.viken.constraintlayoutpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddUserActivity extends AppCompatActivity {
    private static final String TAG = "AddUserActivity";

    private Bundle add_user_bundle;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private TextView userTypeText;
    private Button user_type_arrow_left;
    private Button user_type_arrow_right;
    private Button cancel_add_user;
    private Button enter_add_user;
    private Boolean bFirstUser = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        userTypeText = findViewById(R.id.userTypeText);
        user_type_arrow_left = findViewById(R.id.user_type_arrow_left);
        user_type_arrow_right = findViewById(R.id.user_type_arrow_right);
        cancel_add_user = findViewById(R.id.cancel_add_user);
        enter_add_user = findViewById(R.id.enter_add_user);

        String[] user_types = getResources().getStringArray(R.array.userTypesArray);
        List<String> arrayList = new ArrayList<>();
        for (String user_type : user_types) {
            arrayList.add(user_type);
        }
        arrayList.add(0, getString(R.string.select_user_type));

        // Default to show message 'select user type'


        add_user_bundle = getIntent().getExtras();

        if (add_user_bundle != null) {

            bFirstUser = add_user_bundle.getBoolean("first_login");
        }

        if (bFirstUser) {
            userTypeText.setText(arrayList.get(1).toString());
            user_type_arrow_right.setEnabled(false);
        } else {
            userTypeText.setText(arrayList.get(0).toString());
        }

        user_type_arrow_left.setEnabled(false);

        user_type_arrow_right.setOnClickListener(view -> {
            Log.d(TAG, "user_type_arrow_right: ");
            Integer index = arrayList.indexOf(userTypeText.getText().toString());

            Log.d(TAG, "user_type_arrow_right: " + index);

            if (index == 0) {
                user_type_arrow_left.setEnabled(true);
                userTypeText.setText(arrayList.get(1).toString());
            } else if (index == 1) {
                userTypeText.setText(arrayList.get(2).toString());
                user_type_arrow_left.setEnabled(true);
            } else if (index == 2) {
                userTypeText.setText(arrayList.get(3).toString());
                user_type_arrow_left.setEnabled(true);
                user_type_arrow_right.setEnabled(false);
            }
        });

        user_type_arrow_left.setOnClickListener(view -> {
            Log.d(TAG, "user_type_arrow_left: ");
            Integer index = arrayList.indexOf(userTypeText.getText().toString());

            if (index == 2) {
                userTypeText.setText(arrayList.get(1).toString());
                user_type_arrow_left.setEnabled(false);
            } else if (index == 3) {
                userTypeText.setText(arrayList.get(2).toString());
                user_type_arrow_left.setEnabled(true);
                user_type_arrow_right.setEnabled(true);
            }
        });

        enter_add_user.setOnClickListener(view -> {

        });

        cancel_add_user.setOnClickListener(view -> {

        });
    }


}





//        List<String> user_types_list = new ArrayList<String>();
//        user_types_list.add("Select User Type");
//        user_types_list.add("Admin");
//        user_types_list.add("User");

// THIS WAS THE NEW WAY, WITH THE CUSTOM spinner_dropdown_item layout AND spinner_item layout
//        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.userTypesArray, R.layout.spinner_item);
//        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
//        userTypeSpinner.setClickable(false);
//        userTypeSpinner.setEnabled(false);
//        userTypeSpinner.setAdapter(adapter);
//        userTypeSpinner.setSelection(1);

    // THIS IS HOW IT'S DONE OLD WAY
//        ArrayAdapter<String> user_type_list_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, user_types_list);
//        user_type_list_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        userTypeSpinner.setAdapter(user_type_list_adapter);
