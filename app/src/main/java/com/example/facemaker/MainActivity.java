package com.example.facemaker;

/*@author Maxwell McAtee*/

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    //the array used to populate the hair style spinner
    private String[] hairStyles = {"Clean Cut", "Mohawk", "Long and Wavy"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //population of hairStyle spinner
        ArrayAdapter<String> hairAdapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_spinner_dropdown_item,hairStyles);
        Spinner hairSpinner = findViewById(R.id.hairSpinner);
        hairSpinner.setAdapter(hairAdapter);

        Face face = findViewById(R.id.faceDisplay);

        SeekBar red = findViewById(R.id.redSeek);
        SeekBar green = findViewById(R.id.greenSeek);
        SeekBar blue = findViewById(R.id.blueSeek);
        Button random = findViewById(R.id.randomButton);
        RadioButton hair = findViewById(R.id.hairButton);
        RadioButton skin = findViewById(R.id.skinButton);
        RadioButton eyes = findViewById(R.id.eyeButton);
        FaceListener listen = new FaceListener(face, red, green, blue, hair, skin, eyes );
        random.setOnClickListener(listen);
        red.setOnSeekBarChangeListener(listen);
        green.setOnSeekBarChangeListener(listen);
        blue.setOnSeekBarChangeListener(listen);
        hair.setOnCheckedChangeListener(listen);
        skin.setOnCheckedChangeListener(listen);
        eyes.setOnCheckedChangeListener(listen);

    }
}