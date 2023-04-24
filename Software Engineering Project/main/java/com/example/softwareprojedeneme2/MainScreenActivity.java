package com.example.softwareprojedeneme2;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainScreenActivity extends AppCompatActivity {
    Boolean filteredAttractionListRequest = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        Button bAttractions = findViewById(R.id.button_attractions);
        CardView cvNearbys = findViewById(R.id.cardview_nearbys);
        CardView cvMuseums = findViewById(R.id.cardview_museums);
        CardView cvLandmarks = findViewById(R.id.cardview_landmarks);
        CardView cvBuildings = findViewById(R.id.cardview_buildings);
        CardView cvParks = findViewById(R.id.cardview_parks);
        CardView cvBeaches = findViewById(R.id.cardview_beaches);
        AlertDialog.Builder alert = new AlertDialog.Builder(MainScreenActivity.this).setMessage("This function has not been implemented yet").setPositiveButton("Close", null);
        bAttractions.setOnClickListener(v -> {
            filteredAttractionListRequest = false;
            Intent intentAttractionList = new Intent(MainScreenActivity.this, AttractionListActivity.class);
            intentAttractionList.putExtra("filtered", filteredAttractionListRequest);
            intentAttractionList.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intentAttractionList);
        });
        cvNearbys.setOnClickListener(v -> {
            filteredAttractionListRequest = true;
            Intent intentAttractionList = new Intent(MainScreenActivity.this, AttractionListActivity.class);
            intentAttractionList.putExtra("filtered", filteredAttractionListRequest);
            intentAttractionList.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intentAttractionList);
        });
        cvMuseums.setOnClickListener(v -> {
            filteredAttractionListRequest = true;
            Intent intentAttractionList = new Intent(MainScreenActivity.this, AttractionListActivity.class);
            intentAttractionList.putExtra("filtered", filteredAttractionListRequest);
            intentAttractionList.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intentAttractionList);
        });
        cvLandmarks.setOnClickListener(v -> {
            filteredAttractionListRequest = true;
            Intent intentAttractionList = new Intent(MainScreenActivity.this, AttractionListActivity.class);
            intentAttractionList.putExtra("filtered", filteredAttractionListRequest);
            intentAttractionList.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intentAttractionList);
        });
        cvBuildings.setOnClickListener(v -> {
            filteredAttractionListRequest = true;
            Intent intentAttractionList = new Intent(MainScreenActivity.this, AttractionListActivity.class);
            intentAttractionList.putExtra("filtered", filteredAttractionListRequest);
            intentAttractionList.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intentAttractionList);
        });
        cvParks.setOnClickListener(v -> {
            filteredAttractionListRequest = true;
            Intent intentAttractionList = new Intent(MainScreenActivity.this, AttractionListActivity.class);
            intentAttractionList.putExtra("filtered", filteredAttractionListRequest);
            intentAttractionList.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intentAttractionList);
        });
        cvBeaches.setOnClickListener(v -> {
            filteredAttractionListRequest = true;
            Intent intentAttractionList = new Intent(MainScreenActivity.this, AttractionListActivity.class);
            intentAttractionList.putExtra("filtered", filteredAttractionListRequest);
            intentAttractionList.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intentAttractionList);
        });

        Button button_net = findViewById(R.id.button_net);
        button_net.setOnClickListener(view -> {
            alert.show();
        });

        CardView cvNews = findViewById(R.id.cardview_news);
        CardView cvEvents = findViewById(R.id.cardview_events);
        CardView cvTips = findViewById(R.id.cardview_tips);
        cvNews.setOnClickListener(v -> {
            Intent intentNews = new Intent(MainScreenActivity.this, NewsActivity.class);
            intentNews.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intentNews);
        });
        cvEvents.setOnClickListener(v -> {
            Intent intentEvents = new Intent(MainScreenActivity.this, EventsActivity.class);
            intentEvents.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intentEvents);
        });
        cvTips.setOnClickListener(v -> {
            Intent intentTips = new Intent(MainScreenActivity.this, TipsActivity.class);
            intentTips.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intentTips);
        });

        Button bGastronomy = findViewById(R.id.button_gastronomy);
        bGastronomy.setOnClickListener(v -> {
            Intent intentGastronomy = new Intent(MainScreenActivity.this, GastronomyActivity.class);
            intentGastronomy.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intentGastronomy);
        });
        Button bAccommodation = findViewById(R.id.button_accommodation);
        bAccommodation.setOnClickListener(v -> {
            Intent intentAccommodation = new Intent(MainScreenActivity.this, AccommodationActivity.class);
            intentAccommodation.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intentAccommodation);
        });
        Button bTransportCard = findViewById(R.id.button_transport_card);
        bTransportCard.setOnClickListener(v -> {
            Intent intentTransportCard = new Intent(MainScreenActivity.this, TransportCardActivity.class);
            intentTransportCard.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intentTransportCard);
        });
        Button bFAQ = findViewById(R.id.button_faq);
        bFAQ.setOnClickListener(v -> {
            alert.show();
        });

        BottomNavigationView bottomNavigationBar = findViewById(R.id.bottomNavigationView);
        bottomNavigationBar.setSelectedItemId(R.id.nav_bar_home);
        bottomNavigationBar.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_bar_home:
                    return true;
                case R.id.nav_bar_attractions:
                    Intent intentAttractionList = new Intent(MainScreenActivity.this, AttractionListActivity.class);
                    intentAttractionList.putExtra("filtered", false);
                    intentAttractionList.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentAttractionList);
                    overridePendingTransition(0,0);
                    return true;
                case R.id.nav_bar_nearbys:
                    Intent intentNearbys = new Intent(MainScreenActivity.this, NearbyAttractionListActivity.class);
                    intentNearbys.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentNearbys);
                    overridePendingTransition(0,0);
                    return true;
                case R.id.nav_bar_bookmark:
                    Intent intentBookmark = new Intent(MainScreenActivity.this, BookmarkListActivity.class);
                    intentBookmark.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentBookmark);
                    overridePendingTransition(0,0);
                    return true;
                case R.id.nav_bar_settings:
                    Intent intentSettings = new Intent(MainScreenActivity.this, SettingsActivity.class);
                    intentSettings.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentSettings);
                    overridePendingTransition(0,0);
                    return true;
            }
            return false;
        });





    }
}