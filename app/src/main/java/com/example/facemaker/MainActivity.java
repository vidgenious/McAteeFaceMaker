package com.example.facemaker;

/*@author Maxwell McAtee*/

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
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

    }
}