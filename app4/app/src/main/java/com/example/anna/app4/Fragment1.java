package com.example.anna.app4;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment implements RadioGroup.OnCheckedChangeListener {

    RadioGroup radioGroup;

    AppCompatActivity A1;
    OnWyborOpcjiListener sluchaczF1;

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.radioButton:
                sluchaczF1.onWyborOpcji(1);
                break;
            case R.id.radioButton2:
                sluchaczF1.onWyborOpcji(2);
                break;
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((RadioGroup) getActivity().findViewById(R.id.opcje)).setOnCheckedChangeListener(this);



    }

    public interface OnWyborOpcjiListener {
        public void onWyborOpcji (int opcja);
    }

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            A1 = (AppCompatActivity) context;
            sluchaczF1 = (OnWyborOpcjiListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(A1.toString() + " musi implementować OnWyborOpcjiListener");
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment1, container, false);
    }

}
