package com.viken.constraintlayoutpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class EnumExampleActivity extends AppCompatActivity {

    private int enumExample;
    private ImageFilterEnum enumExample0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enum_example);

        enumExample = ImageFilterEnum.EVERYDAY.getImageFilterValue();
        Log.d("Carloss", "onCreate1: " + enumExample);
        enumExample = ImageFilterEnum.PENETRATION.getImageFilterValue();
        Log.d("Carloss", "onCreate2: " + enumExample);
        enumExample = ImageFilterEnum.HIRES.getImageFilterValue();
        Log.d("Carloss", "onCreate3: " + enumExample);
        enumExample = ImageFilterEnum.NONE.getImageFilterValue();
        Log.d("Carloss", "onCreate4: " + enumExample);
        enumExample = ImageFilterEnum.STEEL.getImageFilterValue();
        Log.d("Carloss", "onCreate5: " + enumExample);

        enumExample0 = ImageFilterEnum.getImageFilterValue(R.id.everyday);
        Log.d("Carloss", "onCreate1: " + enumExample0);
        enumExample0 = ImageFilterEnum.getImageFilterValue(R.id.penetration);
        Log.d("Carloss", "onCreate2: " + enumExample0);
        enumExample0 = ImageFilterEnum.getImageFilterValue(R.id.hiRes);
        Log.d("Carloss", "onCreate3: " + enumExample0);
        enumExample0 = ImageFilterEnum.getImageFilterValue(R.id.steel);
        Log.d("Carloss", "onCreate4: " + enumExample0);
        enumExample0 = ImageFilterEnum.getImageFilterValue(R.id.noFilter);
        Log.d("Carloss", "onCreate5: " + enumExample0);



    }
}