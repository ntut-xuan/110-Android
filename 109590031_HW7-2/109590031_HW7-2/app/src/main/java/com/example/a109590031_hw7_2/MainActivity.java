package com.example.a109590031_hw7_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import recyclerview.RecipeAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecipeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinkedList<String> title = new LinkedList<>();
        LinkedList<String> subtitle = new LinkedList<>();

        title.add("竹筍炒肉絲");
        title.add("咖哩炒蟹");

        subtitle.add("竹筍 + 肉絲");
        subtitle.add("咖哩 + 蟹");

        mRecyclerView = findViewById(R.id.recycleview);
        mAdapter = new RecipeAdapter(this, title, subtitle);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}