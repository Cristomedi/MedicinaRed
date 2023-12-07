package com.example.medicinared;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {

    Context context;

    private final String [] values;
    private final int [] images;
    View view;
    LayoutInflater layoutInflater;

    public GridAdapter(Context context,String [] values, int [] images){

        this.context=context;

        this.values=values;

        this.images=images;


    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //  return null;

        layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(view==null){

            view= new View(context);
            view= layoutInflater.inflate(R.layout.activity_sigle_item,null);
            ImageView ImageView2=(ImageView) view.findViewById(R.id.imageview);
            TextView textView=(TextView) view.findViewById(R.id.textview);
            ImageView2.setImageResource(images[i]);
            textView.setText(values[i]);


        }

        return view;
    }
}
