package com.example.anna.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity  extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] list = new String[] {"Pozycja 1", "Pozycja 2", "Pozycja 3"};
    String[] p = new String[] {"1", "2", "3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner option = (Spinner) findViewById(R.id.option);
        if(option != null){
            option.setOnItemSelectedListener(this);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            option.setAdapter(adapter);
        }

    }

    public void openList1(View view) {
        final Intent intent = new Intent(this,Lista1.class);
        startActivity(intent);
    }

    public void openList2(View view) {
        final Intent intent = new Intent(this,Lista2.class);
        startActivity(intent);
    }

    public void openList3(View view) {
        final Intent intent = new Intent(this,Grid1.class);
        startActivity(intent);
    }

    public void openList4(View view) {
        final Intent intent = new Intent(this,Lista3.class);
        startActivity(intent);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),
                "Wybrales : " + p[position],
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
