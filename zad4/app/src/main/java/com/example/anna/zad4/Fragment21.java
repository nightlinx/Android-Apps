package com.example.anna.zad4;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.anna.zad4.data.DataRow;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment21 extends Fragment {
    private OnSaveF21Listener mCallback;

    interface OnSaveF21Listener {
        void onSaveClicked(DataRow data);
    }

    public Fragment21() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment21, container, false);

        Button saveButton = (Button) view.findViewById(R.id.f21_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText name = (EditText) getView().findViewById(R.id.f21_name);
                EditText weight = (EditText) getView().findViewById(R.id.f21_weight);
                EditText time = (EditText) getView().findViewById(R.id.f21_time);
                RatingBar rating = (RatingBar) getView().findViewById(R.id.f21_rating);

                mCallback.onSaveClicked(
                        new DataRow(name.getText().toString(), weight.getText().toString(), time.getText().toString(), rating.getRating())
                );

                Toast.makeText(getActivity(), "Zapisano dane", Toast.LENGTH_SHORT).show();

                name.setText("");
                weight.setText("");
                time.setText("");
                rating.setRating(0);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallback = (OnSaveF21Listener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnSaveF21Listener");
        }

    }
}
