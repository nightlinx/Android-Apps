package com.example.anna.zad4;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.anna.zad4.data.AnotherData;
import com.example.anna.zad4.data.DataRow;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener, Fragment21.OnSaveF21Listener, Fragment22.OnSaveF22Listener {

    Fragment1 f1;
    Fragment2 f2;
    Fragment3 f3;
    Fragment4 f4;

    final String TAB1 = "Autor";
    final String TAB2 = "Wpisz";
    final String TAB3 = "Warzywa";
    final String TAB4 = "Auta";

    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupFragments();
        setupActionBar();
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        String text = (String) tab.getText();

        switch (text) {
            case TAB1:
                ft.attach(f1);
                break;
            case TAB2:
                ft.attach(f2);
                break;
            case TAB3:
                ft.attach(f3);
                break;
            case TAB4:
                ft.attach(f4);
                break;
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        String text = (String) tab.getText();

        switch (text) {
            case TAB1:
                ft.detach(f1);
                break;
            case TAB2:
                ft.detach(f2);
                break;
            case TAB3:
                ft.detach(f3);
                break;
            case TAB4:
                ft.detach(f4);
                break;
        }
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    private void setupFragments() {
        f1 = new Fragment1();
        f2 = new Fragment2();
        f3 = new Fragment3();
        f4 = new Fragment4();

        ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.kontener, f1);
        ft.add(R.id.kontener, f2);
        ft.add(R.id.kontener, f3);
        ft.add(R.id.kontener, f4);

        ft.detach(f1);
        ft.detach(f2);
        ft.detach(f3);
        ft.detach(f4);
        ft.commit();
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle("Zad 4");

        ActionBar.Tab tab1 = actionBar.newTab();
        tab1.setText(TAB1);
        tab1.setTabListener(this);
        tab1.setIcon(android.R.drawable.ic_dialog_info);
        actionBar.addTab(tab1);
        actionBar.selectTab(tab1);

        ActionBar.Tab tab2 = actionBar.newTab();
        tab2.setText(TAB2);
        tab2.setTabListener(this);
        tab2.setIcon(android.R.drawable.ic_input_add);
        actionBar.addTab(tab2);

        ActionBar.Tab tab3 = actionBar.newTab();
        tab3.setText(TAB3);
        tab3.setTabListener(this);
        tab3.setIcon(android.R.drawable.ic_secure);
        actionBar.addTab(tab3);

        ActionBar.Tab tab4 = actionBar.newTab();
        tab4.setText(TAB4);
        tab4.setTabListener(this);
        tab4.setIcon(android.R.drawable.ic_input_get);
        actionBar.addTab(tab4);
    }

    @Override
    public void onSaveClicked(DataRow data) {
        f3.addData(data);
    }

    @Override
    public void onSaveClicked(AnotherData data) {
        f4.addData(data);
    }
}
