package com.example.viewpagerinrecyclerviewexam;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new ImageFragment());
        fragmentList.add(new ImageFragment());
        fragmentList.add(new ImageFragment());
        fragmentList.add(new ImageFragment());
        fragmentList.add(new ImageFragment());


        List<Item> items = new ArrayList<>();
        items.add(new Item<>(fragmentList));
        for (int i = 0; i < 30; i++) {
            items.add(new Item<>("item"));
        }

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getSupportFragmentManager(), items);
        recyclerView.setAdapter(adapter);
    }
}
