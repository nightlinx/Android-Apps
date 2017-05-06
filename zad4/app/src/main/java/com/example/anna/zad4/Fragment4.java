package com.example.anna.zad4;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.anna.zad4.data.AnotherData;
import com.example.anna.zad4.data.AnotherDataAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment4 extends Fragment {

    ArrayList<AnotherData> anotherRows = new ArrayList<>();

    public Fragment4() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment4, container, false);
        final AnotherDataAdapter adapter = new AnotherDataAdapter(getContext(), anotherRows);
        ListView listView = (ListView) view.findViewById(R.id.another_container);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                AnotherData data = adapter.getItem(position);
                Toast.makeText(getActivity(), data.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    void addData(AnotherData data) {
        anotherRows.add(data);
    }
}
