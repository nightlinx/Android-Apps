package com.example.app3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void openListActivity(View view) {
        startActivity(new Intent(this, ListActivity.class));
    }

    public void openInternalStorageActivity(View view) {
        startActivity(new Intent(this, InternalStorageActivity.class));
    }

    public void openAppProperties(View view) {
        startActivity(new Intent(this, AppPropiertiesActivity.class));
    }

    public void openCustomizedList(View view) {
        startActivity(new Intent(this, CustomizedViewActivity.class));
    }
}
