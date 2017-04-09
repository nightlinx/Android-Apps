package com.example.anna.restaurant;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;
import java.util.ArrayList;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void openContact(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("menu", getMessage());

        final Intent intent = new Intent(this,Contact.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void openMain(View view) {
        final Intent intent = new Intent(this,Main.class);
        startActivity(intent);
    }

    public String getMessage(){
        String msg = "";
        ArrayList<CheckBox> menu = new ArrayList<>();
        ArrayList<CheckBox> myMenu = new ArrayList<>();

        menu.add((CheckBox) findViewById(R.id.checkBox1));
        menu.add((CheckBox) findViewById(R.id.checkBox2));
        menu.add((CheckBox) findViewById(R.id.checkBox3));
        menu.add((CheckBox) findViewById(R.id.checkBox4));
        menu.add((CheckBox) findViewById(R.id.checkBox5));
        menu.add((CheckBox) findViewById(R.id.checkBox6));
        menu.add((CheckBox) findViewById(R.id.checkBox7));
        menu.add((CheckBox) findViewById(R.id.checkBox8));
        menu.add((CheckBox) findViewById(R.id.checkBox9));
        menu.add((CheckBox) findViewById(R.id.checkBox10));

        for(CheckBox meal: menu){
            System.out.println("  "+meal.getText());
            if(meal.isChecked()){
                myMenu.add(meal);
            }
        }

        if(!myMenu.isEmpty()){
            msg+=myMenu.get(0).getText();
            int i = 1;
            for(i=1; i <myMenu.size(); i++){
                msg+="\n" + myMenu.get(i).getText();
            }
        }
        else{
            msg = "nic nie zaznaczono";
        }
        return msg;
    }

    public void sumUp(View view){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context,getMessage(), duration);
        toast.show();
        toast.setGravity(Gravity.CENTER_HORIZONTAL,0,0);
    }
}
