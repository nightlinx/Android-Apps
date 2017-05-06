package com.example.anna.app4;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity implements ActionBar.TabListener {

    final String TAB1 = "Tab 1";
    final String TAB2 = "Tab 2";

    Fragment11 f11;
    Fragment13 f12;
    FragmentTransaction transakcja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        f11 = new Fragment11();
        f12 = new Fragment13();
        transakcja = getSupportFragmentManager().beginTransaction();
        transakcja.add(R.id.kontener2, f11);
        transakcja.detach(f11);
        transakcja.add(R.id.kontener2, f12);
        transakcja.detach(f12);
        transakcja.commit();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle("Action bar");

        ActionBar.Tab tab1 = actionBar.newTab();
        tab1.setText(TAB1);
        tab1.setTabListener(this);
        actionBar.addTab(tab1);
        actionBar.selectTab(tab1);

        ActionBar.Tab tab2 = actionBar.newTab();
        tab2.setText(TAB2);
        tab2.setTabListener(this);
        actionBar.addTab(tab2);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        String text = (String) tab.getText();

        if (text.equals(TAB1)) {
            ft.attach(f11);
        } else if (text.equals(TAB2)) {
            ft.attach(f12);
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        String text = (String) tab.getText();

        if (text.equals(TAB1)) {
            ft.detach(f11);
        } else if (text.equals(TAB2)) {
            ft.detach(f12);
        }
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
