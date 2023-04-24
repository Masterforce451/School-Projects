package com.example.softwareprojedeneme2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.snackbar.Snackbar;

public class AttractionListActivity extends AppCompatActivity {
    Boolean filterRequest = false;
    CardView cardview_nearbys,cardview_landmarks,cardview_museums,cardview_buildings,cardview_beaches;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_list);
        Intent intent = getIntent();
        filterRequest = intent.getBooleanExtra("filter", false);
        AlertDialog.Builder alert = new AlertDialog.Builder(AttractionListActivity.this).setMessage("This function has not been implemented yet").setPositiveButton("Close", null);
        cardview_nearbys = findViewById(R.id.cardview_nearbys);
        cardview_landmarks = findViewById(R.id.cardview_landmarks);
        cardview_museums = findViewById(R.id.cardview_museums);
        cardview_buildings = findViewById(R.id.cardview_buildings);
        cardview_beaches = findViewById(R.id.cardview_beaches);
        fab = findViewById(R.id.fab);

        fab.setOnClickListener(view -> {
            alert.show();
        });
        cardview_nearbys.setOnClickListener(view -> {
            alert.show();
        });
        cardview_landmarks.setOnClickListener(view -> {
            alert.show();
        });
        cardview_museums.setOnClickListener(view -> {
            alert.show();
        });
        cardview_buildings.setOnClickListener(view -> {
            alert.show();
        });
        cardview_beaches.setOnClickListener(view -> {
            alert.show();
        });

        SearchView searchView = findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        //
        BottomNavigationView bottomNavigationBar = findViewById(R.id.bottomNavigationView);
        bottomNavigationBar.setSelectedItemId(R.id.nav_bar_attractions);
        bottomNavigationBar.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_bar_home:
                    Intent intentHome = new Intent(AttractionListActivity.this, MainScreenActivity.class);
                    intentHome.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentHome);
                    overridePendingTransition(0,0);
                    return true;
                case R.id.nav_bar_attractions:
                    return true;
                case R.id.nav_bar_nearbys:
                    Intent intentNearbys = new Intent(AttractionListActivity.this, NearbyAttractionListActivity.class);
                    intentNearbys.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentNearbys);
                    overridePendingTransition(0,0);
                    return true;
                case R.id.nav_bar_bookmark:
                    Intent intentBookmark = new Intent(AttractionListActivity.this, BookmarkListActivity.class);
                    intentBookmark.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentBookmark);
                    overridePendingTransition(0,0);
                    return true;
                case R.id.nav_bar_settings:
                    Intent intentSettings = new Intent(AttractionListActivity.this, SettingsActivity.class);
                    intentSettings.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentSettings);
                    overridePendingTransition(0,0);
                    return true;
            }
            return false;
        });
    }
}