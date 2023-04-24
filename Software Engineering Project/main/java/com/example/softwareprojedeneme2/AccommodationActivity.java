package com.example.softwareprojedeneme2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class AccommodationActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private List<String> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accommodation);

        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        itemList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            itemList.add("Not implemented yet");
        }

        adapter = new RecyclerViewAdapter(itemList);
        recyclerView.setAdapter(adapter);

        BottomNavigationView bottomNavigationBar = findViewById(R.id.bottomNavigationView);
        bottomNavigationBar.setSelectedItemId(R.id.nav_bar_home);
        bottomNavigationBar.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_bar_home:
                    Intent intentHome = new Intent(AccommodationActivity.this, MainScreenActivity.class);
                    startActivity(intentHome);
                    intentHome.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    overridePendingTransition(0,0);
                case R.id.nav_bar_attractions:
                    Intent intentAttractionList = new Intent(AccommodationActivity.this, AttractionListActivity.class);
                    intentAttractionList.putExtra("filtered", false);
                    intentAttractionList.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentAttractionList);
                    overridePendingTransition(0,0);
                    return true;
                case R.id.nav_bar_nearbys:
                    Intent intentNearbys = new Intent(AccommodationActivity.this, NearbyAttractionListActivity.class);
                    intentNearbys.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentNearbys);
                    overridePendingTransition(0,0);
                    return true;
                case R.id.nav_bar_bookmark:
                    Intent intentBookmark = new Intent(AccommodationActivity.this, BookmarkListActivity.class);
                    intentBookmark.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentBookmark);
                    overridePendingTransition(0,0);
                    return true;
                case R.id.nav_bar_settings:
                    Intent intentSettings = new Intent(AccommodationActivity.this, SettingsActivity.class);
                    intentSettings.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentSettings);
                    overridePendingTransition(0,0);
                    return true;
            }
            return false;
        });
    }
}