package com.example.app3;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String[] animals = {"cat", "dog", "tigger", "bird", "lion"};
    private String[] info = {"color: black\nage: 3","color: white\nage: 6","color: orange\nage: 13","color: blue\nage: 1", "color: yellow\nage: 10" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListView animalsListView = (ListView) findViewById(R.id.list_view);

        if (animalsListView != null){
            animalsListView.setOnItemClickListener(this);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, animals);
        animalsListView.setAdapter(adapter);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(animals[position]);
        builder.setMessage(info[position])
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
