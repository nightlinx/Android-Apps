package com.example.app3;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AppPropiertiesActivity extends Activity {

    private static final String PREFERENCES_NAME = "myPreferences";
    private TextView tittle;
    private SeekBar colorSeekBar;
    private Spinner welcomeTextSpinner;
    private RadioGroup textSizeGroup;

    int color = -1310976;
    private String[] welcomeTextes = {"WITAJCIE", "HelloWorld!", "ELO MELO"};
    private int textSize;

    private SharedPreferences data;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_propierties);

        tittle = (TextView) findViewById(R.id.helloText);
        colorSeekBar = (SeekBar) findViewById(R.id.colorChangerSeekBar);
        welcomeTextSpinner = (Spinner) findViewById(R.id.spinner);
        textSizeGroup = (RadioGroup)findViewById(R.id.radioGroup1);

        data = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        color = data.getInt("seekBarColor", -1310976);

        colorSeekBar.setBackgroundColor(color);
        tittle.setTextColor(color);

        colorSeekBar.setOnSeekBarChangeListener(seekBarListener);
        welcomeTextSpinner.setOnItemSelectedListener(spinnerListener);
        textSizeGroup.setOnCheckedChangeListener(groupCheckedListener);

        ArrayAdapter<String> adapter = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_dropdown_item, welcomeTextes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        welcomeTextSpinner.setAdapter(adapter);
    }

    private final RadioGroup.OnCheckedChangeListener groupCheckedListener = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId)
        {
            RadioButton checkedRadioButton = (RadioButton)group.findViewById(checkedId);
            boolean isChecked = checkedRadioButton.isChecked();

            if (isChecked) {
                if(checkedRadioButton.getText().equals("Large")){
                    tittle.setTextSize(30);
                }
                else if (checkedRadioButton.getText().equals("Medium")){
                    tittle.setTextSize(20);
                }
                else{
                    tittle.setTextSize(10);
                }
            }
            Toast.makeText(getApplicationContext(),""+tittle.getTextSize(),Toast.LENGTH_SHORT).show();
        }
    };


    private final Spinner.OnItemSelectedListener spinnerListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            tittle.setText(welcomeTextes[position]);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    };

    private final SeekBar.OnSeekBarChangeListener seekBarListener = new SeekBar.OnSeekBarChangeListener() {
        float[] hsvColor = {0, 1, 1};
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            hsvColor[0] = 360f * progress/ 100;
            color = Color.HSVToColor(hsvColor);
            colorSeekBar.setBackgroundColor(Color.HSVToColor(hsvColor));
            tittle.setTextColor(Color.HSVToColor(hsvColor));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {}

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {        }
    };

    protected void onStop(){
        super.onStop();
        editor = data.edit();
        editor.putInt("seekBarColor", color);
        editor.putInt("textSize", (int) tittle.getTextSize());
        editor.apply();
        Toast.makeText(getApplicationContext(),"Zapisano kolor "+color,Toast.LENGTH_SHORT).show();
    }

}