package com.example.anna.zad4.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.anna.zad4.R;

import java.util.ArrayList;

public class DataRowAdapter extends ArrayAdapter<DataRow> {
    public DataRowAdapter(Context context, ArrayList<DataRow> data) {
        super(context, 0, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DataRow row = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_datarow, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.row_name);
        name.setText(row.getName());

        return convertView;
    }
}
