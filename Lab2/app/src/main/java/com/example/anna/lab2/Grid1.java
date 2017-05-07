package com.example.anna.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
public class Grid1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid1);

        final GridView gridlist = (GridView) findViewById(R.id.grid_item);

        if (gridlist != null) {
            gridlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    String selectedText = (String) (gridlist.getItemAtPosition(position));
                    Toast.makeText(getApplicationContext(),
                            "Wybrano pozycje : " + selectedText,
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
        gridlist.setAdapter(new MyAdapter(this));
    }

    public void startActivity_3(View view) {
        final Intent intention = new Intent(this, Grid1.class);
        startActivity(intention);
    }
}
