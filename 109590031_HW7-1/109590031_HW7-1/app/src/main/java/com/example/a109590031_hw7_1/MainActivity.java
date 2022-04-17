package com.example.a109590031_hw7_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void donutClick(View view){
        Intent intent = new Intent(MainActivity.this, DonutActivity.class);
        startActivity(intent);
    }

    public void froyoClick(View view){
        Intent intent = new Intent(MainActivity.this, FroyoActivity.class);
        startActivity(intent);
    }

    public void iceCreamClick(View view){
        Intent intent = new Intent(MainActivity.this, IceCreamActivity.class);
        startActivity(intent);
    }
}