package com.example.softwareprojedeneme2;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TransportCardActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport_card);

        BottomNavigationView bottomNavigationBar = findViewById(R.id.bottomNavigationView);
        bottomNavigationBar.setSelectedItemId(R.id.nav_bar_home);
        bottomNavigationBar.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_bar_home:
                    Intent intentHome = new Intent(TransportCardActivity.this, MainScreenActivity.class);
                    startActivity(intentHome);
                    intentHome.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    overridePendingTransition(0,0);
                case R.id.nav_bar_attractions:
                    Intent intentAttractionList = new Intent(TransportCardActivity.this, AttractionListActivity.class);
                    intentAttractionList.putExtra("filtered", false);
                    intentAttractionList.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentAttractionList);
                    overridePendingTransition(0,0);
                    return true;
                case R.id.nav_bar_nearbys:
                    Intent intentNearbys = new Intent(TransportCardActivity.this, NearbyAttractionListActivity.class);
                    intentNearbys.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentNearbys);
                    overridePendingTransition(0,0);
                    return true;
                case R.id.nav_bar_bookmark:
                    Intent intentBookmark = new Intent(TransportCardActivity.this, BookmarkListActivity.class);
                    intentBookmark.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentBookmark);
                    overridePendingTransition(0,0);
                    return true;
                case R.id.nav_bar_settings:
                    Intent intentSettings = new Intent(TransportCardActivity.this, SettingsActivity.class);
                    intentSettings.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentSettings);
                    overridePendingTransition(0,0);
                    return true;
            }
            return false;
        });
    }
}