package com.example.a109590031_hw6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ordered(View view){
        CheckBox[] checkboxes = {findViewById(R.id.checkBox9), findViewById(R.id.checkBox10), findViewById(R.id.checkBox11), findViewById(R.id.checkBox12), findViewById(R.id.checkBox13)};
        StringBuilder toastMessage = new StringBuilder("你點了 ");
        for (CheckBox checkbox : checkboxes) {
            if (checkbox.isChecked()) {
                toastMessage.append(checkbox.getText()).append(" ");
            }
        }
        Toast toast = Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT);
        toast.show();
    }
}