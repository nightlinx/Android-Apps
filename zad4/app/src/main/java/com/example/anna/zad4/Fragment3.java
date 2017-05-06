package com.example.anna.zad4;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.anna.zad4.data.DataRow;
import com.example.anna.zad4.data.DataRowAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment3 extends Fragment {

    ArrayList<DataRow> dataRows = new ArrayList<>();

    public Fragment3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment3, container, false);
        final DataRowAdapter adapter = new DataRowAdapter(getContext(), dataRows);
        ListView listView = (ListView) view.findViewById(R.id.datarow_container);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                DataRow data = adapter.getItem(position);
                Toast.makeText(getActivity(), data.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    void addData(DataRow data) {
        dataRows.add(data);
    }
}
