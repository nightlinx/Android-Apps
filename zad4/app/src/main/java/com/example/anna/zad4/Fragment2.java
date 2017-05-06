package com.example.anna.zad4;


import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {

    Fragment21 f21;
    Fragment22 f22;

    public Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_fragment2, container, false);

        f21 = new Fragment21();
        f22 = new Fragment22();

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.f2_fragment_container, f21);
        ft.add(R.id.f2_fragment_container, f22);
        ft.detach(f21);
        ft.detach(f22);
        ft.commit();

        RadioGroup group = (RadioGroup)view.findViewById(R.id.f2_settings);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int id) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.detach(f21);
                ft.detach(f22);

                if(id == R.id.f2_vegetable) {
                    ft.attach(f21);
                }
                else if (id == R.id.f2_car) {
                    ft.attach(f22);
                }
                ft.commit();
            }
        });
        group.check(0);

        return view;
    }

}
