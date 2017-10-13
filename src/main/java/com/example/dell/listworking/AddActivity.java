package com.example.dell.listworking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText e_id,e_name,e_price,e_qty;
    String id,name,price,qty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        e_id=(EditText)findViewById(R.id.d_id);
        e_name=(EditText)findViewById(R.id.d_name);
        e_qty=(EditText)findViewById(R.id.d_qty);
        e_price=(EditText)findViewById(R.id.d_price);


    }

    public void savedata(View view){
    id = e_id.getText().toString();
        name = e_name.getText().toString();
        qty= e_qty.getText().toString();
        price= e_price.getText().toString();
        BackFroundtask backFroundtask=new BackFroundtask(this);
        backFroundtask.execute("addInfo",id,name,price,qty);
        finish();
    }
}
