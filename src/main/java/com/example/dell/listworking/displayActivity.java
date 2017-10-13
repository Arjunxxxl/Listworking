package com.example.dell.listworking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class displayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        BackFroundtask backFroundtask = new BackFroundtask(this);
        backFroundtask.execute("get_info");
    }
}
