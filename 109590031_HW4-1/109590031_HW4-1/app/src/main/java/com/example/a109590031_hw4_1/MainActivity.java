package com.example.a109590031_hw4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView showCount;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        int count = Integer.parseInt(showCount.getText().toString());
        outState.putInt("count", count);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showCount = (TextView) findViewById(R.id.count_textview);
        if(savedInstanceState != null){
            int savedCount = savedInstanceState.getInt("count");
            showCount.setText(String.valueOf(savedCount));
        }
    }

    public void increments(View view){
        int count = Integer.parseInt(showCount.getText().toString());
        count += 1;
        showCount.setText(String.valueOf(count));
    }
}