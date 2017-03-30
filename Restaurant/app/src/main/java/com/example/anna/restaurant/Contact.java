package com.example.anna.restaurant;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Contact extends AppCompatActivity {

    private String menu_text = "";
    private MediaPlayer mp;
    private Switch switcher;
    private String clientName;
    private String clientSurname;
    private String clientAddress;
    private String clientNumber;
    String msg = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        switcher = (Switch) findViewById(R.id.switchMusic);
        mp = MediaPlayer.create(this, R.raw.listheme);
        mp.setLooping(true);

        Bundle data = getIntent().getExtras();
        menu_text = data.getString("menu");
    }

    public void openOrder(View view) {
        if(isContactFull()){
            Bundle koszyk = new Bundle();
            final Intent intent_order = new Intent(this, Order.class);

            koszyk.putString("contact", getMessage());
            koszyk.putString("menu", menu_text);
            intent_order.putExtras(koszyk);

            startActivity(intent_order);
        }
        else {
            podsumowanie();
        }
    }

    public void openMenu(View view) {
        final Intent intent = new Intent(this,Menu.class);
        startActivity(intent);
    }

    private boolean isContactFull(){
        clientName = ((TextView) findViewById(R.id.clientName)).getText() + "";
        clientSurname = ((TextView) findViewById(R.id.clientSurname)).getText() + "";
        clientAddress =((TextView) findViewById(R.id.clientAddress)).getText() + "";
        clientNumber = ((TextView) findViewById(R.id.clientNumber)).getText() + "";
        return !(clientName.equals("") || clientSurname.equals("") || clientAddress.equals("") || clientNumber.equals(""));
    }

    public String getMessage() {
        if(isContactFull()){
            msg = clientName +"\n"+ clientSurname +"\n"+ clientAddress +"\n"+ clientNumber;
        }
        else{
            msg="podaj wszystkie dane!";
        }
        return msg;
    }

    public void podsumowanie(View view){
        podsumowanie();
    }

    private void podsumowanie(){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context,getMessage(), duration);
        toast.show();
        toast.setGravity(Gravity.CENTER_HORIZONTAL,0,0);
    }



    public void switchMusic(View view) {
        if(switcher.isChecked()){
            switcher.getTextOff();
            mp.start();
        }
        else{
            switcher.getTextOn();
            mp.pause();
        }
    }

    @Override
    protected void onStart() {
        Log.i("ON", "onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i("ON", "onResume");
        super.onResume();
        if(switcher.isChecked()) {
            mp.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ON", "onPause");
        mp.pause();
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.i("ON", "onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ON", "onDestroy");
    }
}
