package com.example.app3;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;

public class InternalStorageActivity extends Activity {

    private static final NumberFormat numberFormat = NumberFormat.getNumberInstance();

    private TextView ageTextView;
    private CheckBox childCheckBox;
    private RadioGroup rGroup;
    private Switch hairSwitch;
    private SeekBar ageSeekBar;

    private String sex = "-";
    private int age = 0;
    private String hair = "-";
    private String child = "-";

    private String switchOn = "wlosy: szatyn";
    private String switchOff = "wlosy: blond";
    private String file_name = "my_app_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);

        ageTextView = (TextView) findViewById(R.id.ageText);
        ageTextView.setText(numberFormat.format(0));

        childCheckBox = (CheckBox) findViewById(R.id.childCheckBox);
        childCheckBox.setOnCheckedChangeListener(checkBoxListener);

        ageSeekBar = (SeekBar) findViewById(R.id.ageSeekBar);
        ageSeekBar.setOnSeekBarChangeListener(seekBarListener);

        rGroup = (RadioGroup)findViewById(R.id.radioGroup1);
        rGroup.setOnCheckedChangeListener(groupCheckedListener);

        hairSwitch = (Switch) findViewById(R.id.hairSwitch);
        hairSwitch.setOnCheckedChangeListener(hairCheckedListener);
    }

    private final CheckBox.OnCheckedChangeListener checkBoxListener = new CheckBox.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked){
                child = "dziecko: tak";
            } else {
                child = "dziecko: nie";
            }
        }
    };

    private final OnSeekBarChangeListener seekBarListener = new OnSeekBarChangeListener(){

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            ageTextView.setText(numberFormat.format(progress));
            age = progress;
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {}

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {}
    };

    private final RadioGroup.OnCheckedChangeListener groupCheckedListener = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId)
        {
            RadioButton checkedRadioButton = (RadioButton)group.findViewById(checkedId);
            boolean isChecked = checkedRadioButton.isChecked();

            if (isChecked) {
                sex = "plec: " + checkedRadioButton.getText();
            }
        }
    };

    private final Switch.OnCheckedChangeListener hairCheckedListener = new Switch.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {
            if (bChecked) {
                hair = switchOn;
            } else {
                hair = switchOff;
            }
        }
    };


    public void getInfo(View view) {
        StringBuffer datax = new StringBuffer("");
        try {
            FileInputStream fIn = openFileInput(file_name) ;
            InputStreamReader isr = new InputStreamReader ( fIn ) ;
            BufferedReader buffreader = new BufferedReader ( isr ) ;

            String readString = buffreader.readLine ( ) ;
            while ( readString != null ) {
                datax.append(readString+"\n");
                readString = buffreader.readLine ( ) ;
            }
            isr.close ( ) ;
        } catch ( IOException ioe ) {
            ioe.printStackTrace ( ) ;
            Toast.makeText(getApplicationContext(),"Nie udalo otworzyc pliku",Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(getApplicationContext(),"--dane z pliku--\n"+datax.toString(),Toast.LENGTH_SHORT).show();
    }

    public void safeInfo(View view) {
        FileOutputStream os;
        try {
            os = openFileOutput(file_name, Context.MODE_PRIVATE);
            os.write((sex + "\n").getBytes());
            os.write((hair + "\n").getBytes());
            os.write(("wiek: "+ age + "\n").getBytes());
            os.write((child + "\n").getBytes());
            os.close();

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Nie udalo sie zapisac do pliku", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(getApplicationContext(), "Informacje zapisane w pliku!", Toast.LENGTH_SHORT).show();
    }
}
