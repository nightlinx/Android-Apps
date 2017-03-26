package com.example.anna.guessgame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ShareActionProvider;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public int numberToGuess;
    public int number;
    public int guessCount = 0;
    private static final String TAG = "MAIN";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private MediaPlayer mp;
 // private ToggleButton toggle;
    private Switch switcher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      toggle = (ToggleButton) findViewById(R.id.music);
        switcher = (Switch) findViewById(R.id.switchMusic);

 //     toggle.setChecked(true);
        mp = MediaPlayer.create(this, R.raw.mariotheme);
        mp.setLooping(true);
//      mp.start();

        sharedPreferences = getSharedPreferences("com.example.anna.guessgame", Context.MODE_PRIVATE );
        editor = sharedPreferences.edit();
        if(sharedPreferences.getInt("BestScore", 100)==100) {
            editor.putInt("BestScore", 100);
            editor.commit();
        }
        else{
            TextView textViewScore = (TextView) findViewById(R.id.score);
            textViewScore.setText(""+sharedPreferences.getInt("BestScore", 100));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.set_new_game:
                setNewGame();

                return true;
            case R.id.reset_score:
                 resetScore();
                return true;
            case R.id.help:
                help();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void help(){
        Intent myIntent = new Intent(MainActivity.this, Help.class);
        MainActivity.this.startActivity(myIntent);
    }

/* @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
        ContextMenu.ContextMenuInfo menuInfo) {
         super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
         inflater.inflate(R.menu.activity_main_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.set_new_game:
                setNewGame();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
*/
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



    private void setGuessCount() {
        TextView textView = (TextView) findViewById(R.id.times);
        textView.setText(Integer.toString(guessCount));
    }

    public void takeAGuess(View view) {
        if(guessCount==0){
            setNewGame();
        }
        EditText editText = (EditText) findViewById(R.id.editText);
        String userGuess = editText.getText().toString();
        String message;

        if (userGuess.isEmpty()) {
            message = "Number, please";
        } else {
            guessCount++;
            number = Integer.parseInt(userGuess);

            if (number > numberToGuess) {
                message = "My number is smaller than "+userGuess;

            } else if (number < numberToGuess) {
                message = "My number is larger than "+userGuess;
            } else {
                message = "yeah! "+userGuess+" is my number\nYour score is "+guessCount;
                if(guessCount<sharedPreferences.getInt("BestScore", 100)){
                    editor.putInt("BestScore",guessCount);
                    editor.commit();
                    TextView textViewScore = (TextView) findViewById(R.id.score);
                    textViewScore.setText(""+guessCount);
                }
            }
        }

        Context context = getApplicationContext();
        //  CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, message, duration);
        toast.show();

        toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
        editText.setText("");
        setGuessCount();
    }

    public void newGame(View view) {
        setNewGame();
    }

    public void setNewGame(){
        guessCount = 0;
        setGuessCount();
        Random random = new Random();
        numberToGuess = random.nextInt(101);
    }


 //   public void displayResetScore(View view){
 //           resetScore();
  //  }


    private void resetScore(){
        editor.putInt("BestScore", 100);
        editor.commit();
        TextView textViewScore = (TextView) findViewById(R.id.score);
        textViewScore.setText("0");
    }
 /*   public void turnMusic(View view){
        if(toggle.isChecked()){
            toggle.getTextOff();
            mp.start();
        }
        else{
            toggle.getTextOn();
            mp.pause();
        }
    }
*/
    public void switchMusic(View view){

        if(switcher.isChecked()){
            switcher.getTextOff();
            mp.start();
        }
        else{
            switcher.getTextOn();
            mp.pause();
        }
    }

}
