package com.example.anna.appwithjava;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int number=0;
    boolean ordered = false;

    public final static String EXTRA_MESSAGE = "com.mycompany.appwithjava.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void aktualizujCene(View view){
        setPrice();
    }

    //dodaje pączka
    public void add(View view){
        if(!ordered) {
            number++;
            display(number);
            setPrice();
        }
    }

    //odejmuje poaczka
    public void sub(View view){
        if(!ordered && number>0) {
            number--;
            display(number);
            setPrice();
        }
    }

    //klikam ZAMOW
    public void order(View view){
        orderNow();
    }

    //zmieniam wyswietlana liczbe pączków
    private void display(int number){
        TextView a = (TextView) findViewById(R.id.quantity);
        a.setText(""+number);
    }

    private void orderNow(){
        ordered = true;
        setPrice();
        TextView a = (TextView) findViewById(R.id.orderBottom);
        a.setText(getString(R.string.zamowiono));
    }

    private String getPrice(){
        double price = number*1.5;
        if(jestPosypka()){
            price += number*0.5;
        }
        if(jestPolewa()){
            price += number*1;
        }
        return (price+"$");
    }

    private String getMessage(){
        String message = getPrice()+"";

        message += "\n"+getString(R.string.liczba_paczkow)+" "+number;
        message += "\n"+getString(R.string.imie_dwukropek)+" "+getName();

        if(jestPosypka()){
            message+= "\n"+ getString(R.string.dodatek) + " " + getString(R.string.posypka);
        }
        if(jestPolewa()) {
            message += "\n" + getString(R.string.dodatek) + " " + getString(R.string.polewa);
        }
        return message;
    }

    private boolean jestPosypka(){
        CheckBox checkBoxPosypka = (CheckBox) findViewById(R.id.checkBoxPosypka);
        return checkBoxPosypka.isChecked();
    }

    private boolean jestPolewa(){
        CheckBox checkBoxPolewa = (CheckBox) findViewById(R.id.checkBoxPolewa);
        return checkBoxPolewa.isChecked();
    }

    private String getName(){
        EditText editText = (EditText) findViewById(R.id.clientName);
        return editText.getText().toString();
    }


    private void setPrice(){
        TextView a = (TextView) findViewById(R.id.price);

        if(ordered) {
            // TODO To nie jest miejsce na start tej aktywno
            String message = getMessage();

            Intent myIntent = new Intent(MainActivity.this, Zamowienie.class);
            myIntent.putExtra(EXTRA_MESSAGE, message); //Optional parameters
            MainActivity.this.startActivity(myIntent);
        }
        else {
            a.setText(getPrice());
        }
    }

    public void email(View view){
        sendEmail(getMessage(), getName());
    }

    public void sms(View view){
        sendSMS(getMessage());
    }


    private void sendEmail(String message, String name) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this

            intent.putExtra(Intent.EXTRA_SUBJECT, "Zamowienie na pączki przez: " + name);
            intent.putExtra(Intent.EXTRA_TEXT, message);

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }

    private void sendSMS(String message) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("smsto:"));  // This ensures only SMS apps respond
            intent.putExtra("sms_body", message);

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }

    public void openBrowser(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://65.media.tumblr.com/8a04458c48ea169e95d493bb6b823753/tumblr_mo07epGedZ1qzymzvo1_500.jpg"));
        startActivity(intent);
    }
}
