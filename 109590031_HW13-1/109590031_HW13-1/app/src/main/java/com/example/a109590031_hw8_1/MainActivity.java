package com.example.a109590031_hw8_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public static int level = 0;

    SharedPreferences sharedPreference;
    SharedPreferences.Editor sharedPreferenceEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreference = getSharedPreferences("levelPref", MODE_PRIVATE);
        sharedPreferenceEditor = sharedPreference.edit();

        level = sharedPreference.getInt("level", 0);
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageLevel(level);
    }

    public void increase(View view){
        ImageView imageView = findViewById(R.id.imageView);
        level += 1;
        level = Math.min(7, level);
        sharedPreferenceEditor.putInt("level", level);
        sharedPreferenceEditor.commit();
        imageView.setImageLevel(level);
    }

    public void decrease(View view){
        ImageView imageView = findViewById(R.id.imageView);
        level -= 1;
        level = Math.max(0, level);
        sharedPreferenceEditor.putInt("level", level);
        sharedPreferenceEditor.commit();
        imageView.setImageLevel(level);
    }

    public void clear(View view){
        ImageView imageView = findViewById(R.id.imageView);
        level = 0;
        sharedPreferenceEditor.remove("level");
        sharedPreferenceEditor.commit();
        imageView.setImageLevel(level);
    }
}