package com.example.anna.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Order extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        TextView rezult = (TextView) findViewById(R.id.textView11);
        Bundle data = getIntent().getExtras();
        String text = data.getString("menu");

        System.out.println(text);
        rezult.setText(text);

        TextView result2 = (TextView) findViewById(R.id.textView10);
        Bundle data2 = getIntent().getExtras();
        text = data.getString("contact");
        result2.setText(text);
    }

    public void openContacts(View view) {
        final Intent intent = new Intent(this,Menu.class);
        startActivity(intent);
    }
}
