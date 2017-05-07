package com.example.anna.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Lista2 extends AppCompatActivity{
    private String[] napisy = {"arbuz", "banan", "czarna porzeczka", "dynia", "figi", "jajko", "kapusta", "pomarancza", "mango", "papryka", "pomidor", "ogorek"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista2);
        final ListView multichoiceList = (ListView) findViewById(R.id.lista_multichoice);
        
        if (multichoiceList != null) {
            multichoiceList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    String selectedText = "";
                    SparseBooleanArray selected = multichoiceList.getCheckedItemPositions();
                    for(int i = 0; i < selected.size(); i++){
                        if(selected.valueAt(i)){
                            int index = selected.keyAt(i);
                            selectedText += (" " + String.valueOf(index + 1));
                        }
                    }

                    Toast.makeText(getApplicationContext(),
                            "Wybrano pozycje : " + selectedText,
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, napisy);
        multichoiceList.setAdapter(adapter2);
    }

}
