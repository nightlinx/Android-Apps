package com.example.anna.lab2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MyAdapter extends BaseAdapter {

    Context context;

    public Integer[] id_pictures = {R.drawable.img1, R.drawable.img2, R.drawable.img3,
            R.drawable.img2, R.drawable.img3, R.drawable.img2,
            R.drawable.img3, R.drawable.img2, R.drawable.img1,};

    public MyAdapter(Context context){
        this.context = context;
    }

    public int getCount(){
        return id_pictures.length;
    }

    public Object getItem(int position){
        return null;
    }

    public long getItemId(int position){
        return 0;
    }

    public View getView(int position, View view, ViewGroup parent){
        ImageView imageView;

        if(view == null){
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(200,200));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8,8,8,8);
        }
        else{
            imageView = (ImageView)view;
        }
        imageView.setImageResource(id_pictures[position]);
        return imageView;
    }
}
