package com.example.a109590031_hw8_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public static int level = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increase(View view){
        ImageView imageView = findViewById(R.id.imageView);
        level += 1;
        level = Math.min(7, level);
        imageView.setImageLevel(level);
    }

    public void decrease(View view){
        ImageView imageView = findViewById(R.id.imageView);
        level -= 1;
        level = Math.max(0, level);
        imageView.setImageLevel(level);
    }
}