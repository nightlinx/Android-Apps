package com.example.anna.app4;


import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment1.OnWyborOpcjiListener{

    Fragment11 f11;
    Fragment13 f12;
    FragmentTransaction transakcja;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        f11 = new Fragment11();
        f12 = new Fragment13();
        transakcja = getSupportFragmentManager().beginTransaction();
        transakcja.add(R.id.kontener, f11);
        transakcja.detach(f11);
        transakcja.add(R.id.kontener, f12);
        transakcja.detach(f12);
        transakcja.commit();
    }

    @Override
    public void onWyborOpcji(int opcja) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.detach(f11);
        transaction.detach(f12);

        switch(opcja){
            case 1:
                transaction.attach(f11);
                break;
            case 2:
                transaction.attach(f12);
                break;
        }
        transaction.commit();


    }
}
