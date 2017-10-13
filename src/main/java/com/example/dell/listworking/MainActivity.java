package com.example.dell.listworking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  void add(View view){
        Intent i = new Intent(this,AddActivity.class);
        startActivity(i);
    }

    public  void getInfo(View view){
        Intent a = new Intent(this,displayActivity.class);
        startActivity(a);
    }
}
