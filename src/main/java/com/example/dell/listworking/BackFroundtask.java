package com.example.dell.listworking;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by dell on 9/10/2016.
 */
public class BackFroundtask extends AsyncTask<String ,product,String > {

    Context ctx;
    Activity activity;
    ListView listView;
    productadapter productadapter;

   BackFroundtask(Context ctx) {
       this.ctx=ctx;
       activity=(Activity)ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String ... params) {
        String method = params[0];
        DBoperations dBoperations = new DBoperations(ctx);
        if(method.equals("addInfo")){
            String id = params[1];
            String name = params[2];
            int price = Integer.parseInt(params[3]);
            int qty = Integer.parseInt(params[4]);

            SQLiteDatabase db = dBoperations.getWritableDatabase();
            dBoperations.addINFO(db,id,name,price,qty);
            return "one row inserted...";

        }

        else if(method.equals("get_info")){
            productadapter= new productadapter(ctx,R.layout.displayproductraw);
            SQLiteDatabase db = dBoperations.getReadableDatabase();
            listView=(ListView)activity.findViewById(R.id.listView);
            Cursor cursor = dBoperations.getinfo(db);
            String id,name;
            int price,qty;
            while (cursor.moveToNext()){
            id = cursor.getString(cursor.getColumnIndex(productquantract.productentry.ID));
                name = cursor.getString(cursor.getColumnIndex(productquantract.productentry.name));
                price = cursor.getInt(cursor.getColumnIndex(productquantract.productentry.price));
                qty = cursor.getInt(cursor.getColumnIndex(productquantract.productentry.qty));
                product product = new product(id,name,price,qty);
                publishProgress(product);
            }
            return  "get_info";
        }
    return  null;
    }

    @Override
    protected void onProgressUpdate(product... values) {

        productadapter.add(values[0]);

    }

    @Override
    protected void onPostExecute(String result) {
        if (result.equals("get_info")) {
            listView.setAdapter(productadapter);
        } else {
            Toast.makeText(ctx, "1 row inserted", Toast.LENGTH_SHORT).show();
            super.onPostExecute(result);
        }
    }
}
