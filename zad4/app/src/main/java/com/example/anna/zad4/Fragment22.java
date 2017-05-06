package com.example.anna.zad4;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.anna.zad4.data.AnotherData;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment22 extends Fragment {

    private OnSaveF22Listener mCallback;

    interface OnSaveF22Listener {
        void onSaveClicked(AnotherData data);
    }

    public Fragment22() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment22, container, false);

        Button saveButton = (Button) view.findViewById(R.id.f22_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText name = (EditText) getView().findViewById(R.id.f22_name);
                EditText price = (EditText) getView().findViewById(R.id.f22_price);
                Switch sport = (Switch) getView().findViewById(R.id.f22_sport);

                mCallback.onSaveClicked(
                        new AnotherData(name.getText().toString(), price.getText().toString(), sport.isChecked())
                );

                Toast.makeText(getActivity(), "Zapisano dane", Toast.LENGTH_SHORT).show();

                name.setText("");
                price.setText("");
                sport.setChecked(false);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallback = (OnSaveF22Listener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnSaveF22Listener");
        }

    }
}
