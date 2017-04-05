package com.chiquedoll.chiquedoll.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.chiquedoll.chiquedoll.R;
import com.chiquedoll.chiquedoll.view.mvpview.ProductDetailView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(this,LoginActivity.class));
    }
}
