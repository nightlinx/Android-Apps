package com.example.app3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Anna on 17.04.2017.
 */
public class CustomAdapter extends BaseAdapter{
    String[] result;
    String[] info;
    int[] imageId;

    Context context;

    private static LayoutInflater inflater = null;

    public CustomAdapter(Context applicationContext, String[] names, String[] info, int[] imageId) {
        result = names;
        context = applicationContext;
        this.imageId = imageId;
        this.info = info;

        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder {
        TextView tv_name;
        TextView tv_info;
        ImageView img;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder;
        View rowView = convertView;

        if(rowView==null) {
            rowView = inflater.inflate(R.layout.customized_list, null);

            holder = new Holder();
            holder.tv_name = (TextView) rowView.findViewById(R.id.carNameText);
            holder.tv_info = (TextView) rowView.findViewById(R.id.carInfoText);
            holder.img = (ImageView)rowView.findViewById(R.id.carImage);
            rowView.setTag(holder);
        }
        else {
            holder = (Holder) rowView.getTag();
        }

        holder.tv_name.setText(result[position]);
        holder.tv_info.setText( info[position]);
        holder.img.setImageResource(imageId[position]);

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
            }
        });
        return rowView;
    }
}
