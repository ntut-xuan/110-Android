package com.example.android.hellotoast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another_activity);
        TextView textView = (TextView) findViewById(R.id.showCount2);
        Intent intent = getIntent();
        String currentCount = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        textView.setText(currentCount);
    }
}
