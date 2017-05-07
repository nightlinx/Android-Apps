package com.example.anna.lab2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class MyAdapter2 extends BaseAdapter {

    String[] itemsList1 = new String[] {"A", "B", "C", "D",
            "E", "F", "G", "H", "I", "J"};
    String[] itemsList2 = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    private LayoutInflater inflater = null;
    Context context;

     public MyAdapter2(Context context){
       this.context = context;
     }

    public int getCount(){
        return itemsList1.length;
    }

    public Object getItem(int position){
        return null;
    }

    public long getItemId(int position){
        return 0;
    }

    public View getView(int position, View view, ViewGroup parent){
        View newView;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(view == null) {
            view = inflater.inflate(R.layout.row, null);
        }
        newView = view;
        TextView text1 = (TextView)newView.findViewById(R.id.text1);
        text1.setText(itemsList1[position]);

        TextView text2 = (TextView)newView.findViewById(R.id.text2);
        text2.setText(itemsList2[position]);

        return newView;
    }
}
