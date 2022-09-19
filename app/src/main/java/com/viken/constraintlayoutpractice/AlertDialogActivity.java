package com.viken.constraintlayoutpractice;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AlertDialog;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AlertDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);


        new_alert2 ();
//        AlertDialog.Builder alert = new AlertDialog.Builder(this);
//        LinearLayout layout = new LinearLayout(this);
//        TextView tvMessage = new TextView(this);
//        final EditText etInput = new EditText(this);
//        TextView tvValidChars = new TextView(this);
//        String locale = java.util.Locale.getDefault().toString();
//        etInput.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
//
//        tvMessage.setText("");
//        etInput.setSingleLine();
//        layout.setOrientation(LinearLayout.VERTICAL);
//        layout.addView(tvMessage);
//        layout.addView(etInput);
//
//        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which)
//                {
//                    //Do nothing here because we override this button later to change the close behaviour.
//                    //However, we still need this because on older versions of Android unless we
//                    //pass a handler the button doesn't get instantiated
//                    Log.d("AlertDialogActivity", "onClick: ");
//                }
//        });
//
//        alert.show();


    }

    private void new_alert_2 () {


    }

//////////////////////////////////////////////////////////////////////////////////////////////////
    private void new_alert () {

//        final AlertDialog dialog = new AlertDialog.Builder(this)
//                .setTitle("Title")
//                .setMessage("Message")
//                .setPositiveButton(android.R.string.ok, null)
//                .setNegativeButton(android.R.string.cancel, null)
//                .show();
//
//        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
//
//            @Override
//            public void onShow(DialogInterface dialogInterface) {
//
//                Button button = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE);
//                button.setOnClickListener(new View.OnClickListener() {
//
//                    @Override
//                    public void onClick(View view) {
//                        // TODO Do something
//
//                        //Dismiss once everything is OK.
//                        dialog.dismiss();
//                    }
//                });
//            }
//        });
//        dialog.show();
    }

    private void new_alert2 () {

        Context context = this;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LinearLayout layout = new LinearLayout(this);
        //TextView tvMessage = new TextView(this);
        final EditText etInput = new EditText(this);
        TextView tvValidChars = new TextView(this);
        String locale = java.util.Locale.getDefault().toString();
        etInput.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);

        //tvMessage.setText("Oh no !!");
        etInput.setSingleLine();
        layout.setOrientation(LinearLayout.VERTICAL);
        //layout.addView(tvMessage);
        layout.addView(etInput);

        // For now, only display the invalid characters for the US English language.
        if (locale.compareTo("en_US") == 0) {
            layout.addView(tvValidChars);
            tvValidChars.setText("\\ / : * ? “ < > |  are invalid");
            tvValidChars.setTextColor(Color.RED);
        }

        builder.setCancelable(false);
        builder.setTitle("|| Test for preventing dialog close");
        builder.setView(layout);

        // If I hadn't created my own layout above.
        //builder.setMessage("Test for preventing dialog close");
        //builder.setTitle("Test");

        // You need these here, for the 2 buttons to appear.
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub

            }
        });
//        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                // TODO Auto-generated method stub
//
//            }
//        });

        final AlertDialog dialog = builder.create();
        dialog.setCancelable(false);
        dialog.show();
        //Overriding the handler immediately after show is probably a better approach than OnShowListener as described below
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Boolean wantToCloseDialog = false;
                //Do stuff, possibly set wantToCloseDialog to true then...
                if(wantToCloseDialog)
                    dialog.dismiss();
                //else dialog stays open. Make sure you have an obvious way to close the dialog especially if you set cancellable to false.

                AlertDialog.Builder alert = new AlertDialog.Builder(context);
                LinearLayout layout = new LinearLayout(context);
                TextView tvMessage = new TextView(context);
                final EditText etInput = new EditText(context);
                TextView tvValidChars = new TextView(context);
                String locale = java.util.Locale.getDefault().toString();
                etInput.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);

                //tvMessage.setText("Must enter a valid name for a Session, can not be blank!");
                etInput.setSingleLine();
                layout.setOrientation(LinearLayout.VERTICAL);
                layout.addView(tvMessage);
                layout.addView(etInput);
                alert.setCancelable(false);
                alert.setTitle("Error !! ");
                alert.setMessage("Must enter a valid name for a Session, can not be blank!");

                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        //Do nothing here because we override this button later to change the close behaviour.
                        //However, we still need this because on older versions of Android unless we
                        //pass a handler the button doesn't get instantiated
                        Log.d("AlertDialogActivity", "onClick: ");
                    }
                });

                alert.show();
            }
        });

        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Boolean wantToCloseDialog = true;
                //Do stuff, possibly set wantToCloseDialog to true then...
                if(wantToCloseDialog)
                    dialog.dismiss();
                //else dialog stays open. Make sure you have an obvious way to close the dialog especially if you set cancellable to false.
            }
        });

    }


    private void new_alert3 () {

        Context context = this;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Test for preventing dialog close");
        builder.setTitle("Test");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub

            }
        });

        final AlertDialog dialog = builder.create();
        dialog.setCancelable(false);
        dialog.show();
        //Overriding the handler immediately after show is probably a better approach than OnShowListener as described below
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Boolean wantToCloseDialog = false;
                //Do stuff, possibly set wantToCloseDialog to true then...
                if(wantToCloseDialog)
                    dialog.dismiss();
                //else dialog stays open. Make sure you have an obvious way to close the dialog especially if you set cancellable to false.

                AlertDialog.Builder alert = new AlertDialog.Builder(context);
                LinearLayout layout = new LinearLayout(context);
                TextView tvMessage = new TextView(context);
                final EditText etInput = new EditText(context);
                TextView tvValidChars = new TextView(context);
                String locale = java.util.Locale.getDefault().toString();
                etInput.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);

                //tvMessage.setText("Must enter a valid name for a Session, can not be blank!");
                etInput.setSingleLine();
                layout.setOrientation(LinearLayout.VERTICAL);
                layout.addView(tvMessage);
                layout.addView(etInput);
                alert.setCancelable(false);
                alert.setTitle("Error !! ");
                alert.setMessage("Must enter a valid name for a Session, can not be blank!");

                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        //Do nothing here because we override this button later to change the close behaviour.
                        //However, we still need this because on older versions of Android unless we
                        //pass a handler the button doesn't get instantiated
                        Log.d("AlertDialogActivity", "onClick: ");
                    }
                });

                alert.show();
            }
        });

        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Boolean wantToCloseDialog = true;
                //Do stuff, possibly set wantToCloseDialog to true then...
                if(wantToCloseDialog)
                    dialog.dismiss();
                //else dialog stays open. Make sure you have an obvious way to close the dialog especially if you set cancellable to false.
            }
        });

    }


}