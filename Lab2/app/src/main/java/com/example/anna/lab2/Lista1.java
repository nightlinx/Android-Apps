package com.example.anna.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class Lista1 extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String[] napisy = {"arbuz", "banan", "czarna porzeczka", "dynia", "figi", "jajko", "kapusta", "pomarancza", "mango", "papryka", "pomidor", "ogorek"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista1);
        ListView list1 = (ListView) findViewById(R.id.lista_item);

        if (list1 != null) {
            list1.setOnItemClickListener(this);
        }

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, napisy);
        list1.setAdapter(adapter2);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        Toast.makeText(getApplicationContext(),napisy[position],Toast.LENGTH_SHORT).show();
    }
}
