package com.example.dell.listworking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

/**
 * Created by dell on 9/10/2016.
 */
public class DBoperations extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME= "productinfo.db";
    private static final String Create_Quert = "create table " + productquantract.productentry.TABLENAME + " ( " +  productquantract.productentry.ID + " text, " +  productquantract.productentry.name + " text, "+ productquantract.productentry.price + " integer, " + productquantract.productentry.qty + " integer); " ;

    public DBoperations(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        Log.d("Databaseoperation", "Databade Created ...");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Create_Quert);
        Log.d("DatabaseOperations","TableCreated");

    }

    public  void  addINFO(SQLiteDatabase db,String id,String name,int price,int qty){
        ContentValues contentValues = new ContentValues();
        contentValues.put(productquantract.productentry.ID,id);
        contentValues.put(productquantract.productentry.name,name);
        contentValues.put(productquantract.productentry.price,price);
        contentValues.put(productquantract.productentry.qty,qty);
        db.insert(productquantract.productentry.TABLENAME,null,contentValues);
        Log.d("DatabaseOperations","1 row inserted");

    }

    public Cursor getinfo(SQLiteDatabase db){
           String []proj = {productquantract.productentry.ID,productquantract.productentry.name,
                   productquantract.productentry.price,productquantract.productentry.qty};
            Cursor cr = db.query(productquantract.productentry.TABLENAME,proj,null,null,null,null,null);
        return cr;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
