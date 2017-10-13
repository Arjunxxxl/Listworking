package com.example.dell.listworking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 9/10/2016.
 */
public class productadapter extends ArrayAdapter {
    List list = new ArrayList();
    Productholder productholder;
    public productadapter(Context context, int resource) {
        super(context, resource);
    }


    public void add(product object) {
        list.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        if(row==null){
            LayoutInflater layoutInflater =(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.displayproductraw,parent,false);
           productholder = new Productholder();
            productholder.tx_id =(TextView)row.findViewById(R.id.d_id);
            productholder.tx_name=(TextView)row.findViewById(R.id.d_name);
            productholder.tx_price =(TextView)row.findViewById(R.id.d_price);
            productholder.tx_qty =(TextView)row.findViewById(R.id.d_qty);
            row.setTag(productholder);
        }
        else {
            productholder = (Productholder)row.getTag();
        }
        product p = (product)getItem(position);
        productholder.tx_id.setText(p.getId().toString());
        productholder.tx_name.setText(p.getName().toString());
        productholder.tx_price.setText(Integer.toString(p.getPrice()));
        productholder.tx_qty.setText(Integer.toString(p.getQty()));
        return row;
    }
    static  class Productholder{
        TextView tx_id,tx_name,tx_price,tx_qty;
    }
}
