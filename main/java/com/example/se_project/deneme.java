/*
package com.example.se_project;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.location.Priority;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class AttractionList extends AppCompatActivity implements UsersAdapter.RecyclerViewInterface {
    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    SettingsFragment settingsFragment = new SettingsFragment();
    NotificationFragment notificationFragment = new NotificationFragment();
    RecyclerView recyclerView;
    List<AttractionLineItem> attractionLineItemList = new ArrayList<>();
    UsersAdapter usersAdapter;
    private LocationRequest locationRequest;
    Cursor cursor;
    private SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_list);
        locationRequest = new LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 1000).build();

        try {
            database = this.openOrCreateDatabase("Attraction Database",MODE_PRIVATE,null);
            database.execSQL("CREATE TABLE IF NOT EXISTS Attractions (id INT,name VARCHAR,latitude FLOAT,longtitude FLOAT,type VARCHAR,district VARCHAR,PRIMARY KEY (id))");
        } catch (Exception e){
            e.printStackTrace();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(AttractionList.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                if (isGPSEnabled()) {
                    LocationServices.getFusedLocationProviderClient(AttractionList.this).requestLocationUpdates(locationRequest, new LocationCallback() {
                        @Override
                        public void onLocationResult(@NonNull LocationResult locationResult) {
                            super.onLocationResult(locationResult);
                            LocationServices.getFusedLocationProviderClient(AttractionList.this).removeLocationUpdates(this);

                            double latitude = 0;
                            double longitude = 0;
                            if (locationResult != null && locationResult.getLocations().size() > 0) {
                                int index = locationResult.getLocations().size() - 1;
                                latitude = locationResult.getLocations().get(index).getLatitude();
                                longitude = locationResult.getLocations().get(index).getLongitude();
                            }
                            //System.out.println(latitude + "  A  " + longitude);
                            double[][] uzakliklar = new double[14][2];
                            String[][] attractionNamesWithIDs = new String[14][2];
                            cursor = database.rawQuery("SELECT id,name,latitude,longtitude FROM Attractions",null);
                            int id = cursor.getColumnIndex("id");
                            int latitude_index = cursor.getColumnIndex("latitude");
                            int longitude_index = cursor.getColumnIndex("longtitude");
                            int name_index = cursor.getColumnIndex("name");

                            Location currentLocation = new Location("Current Location");
                            currentLocation.setLatitude(latitude);
                            currentLocation.setLongitude(longitude);

                            cursor.moveToFirst();
                            int i=0;
                            do {
                                Location attractionLocation = new Location("Attraction Location");
                                float attraction_latitude = cursor.getFloat(latitude_index);
                                float attraction_longitude = cursor.getFloat(longitude_index);
                                String attraction_name = cursor.getString(name_index);
                                int attraction_id = cursor.getInt(id);
                                attractionLocation.setLatitude(attraction_latitude);
                                attractionLocation.setLongitude(attraction_longitude);
                                float distance = currentLocation.distanceTo(attractionLocation);
                                uzakliklar[i][1] = distance;
                                uzakliklar[i][0] = attraction_id;
                                attractionNamesWithIDs[i][0] = String.valueOf(attraction_id);
                                attractionNamesWithIDs[i][1] = attraction_name;
                                i++;
                            } while(cursor.moveToNext());
                            Arrays.sort(uzakliklar, Comparator.comparingDouble(o -> o[1]));
                            for(int j=0;j<uzakliklar.length;j++) {
                                String attraction_to_be_used = null;
                                String attr_id = null;
                                for (int k = 0; k < uzakliklar.length; k++) {
                                    attr_id = String.valueOf(Integer.valueOf((int) uzakliklar[j][0]));
                                    ;
                                    String attr_test = attractionNamesWithIDs[k][0];
                                    if (attr_id.equals(attr_test)) {
                                        attraction_to_be_used = attractionNamesWithIDs[k][1];
                                        break;
                                    }
                                }
                                Resources res = getResources();
                                String photo_id = ("attraction_" + attr_id);
                                int id_going = getResources().getIdentifier(photo_id, "drawable", getPackageName());
                                Drawable drawable = getResources().getDrawable(id_going,getTheme());
                                AttractionLineItem attractionLineItem = new AttractionLineItem(attraction_to_be_used,drawable);
                                attractionLineItemList.add(attractionLineItem);
                            }
                            usersAdapter = new UsersAdapter(attractionLineItemList);
                            recyclerView.setAdapter(usersAdapter);
                        }
                    }, Looper.getMainLooper());
                } else { LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(locationRequest);
                    builder.setAlwaysShow(true);
                    Task<LocationSettingsResponse> result = LocationServices.getSettingsClient(getApplicationContext()).checkLocationSettings(builder.build());
                    result.addOnCompleteListener(task -> {
                        try {LocationSettingsResponse response = task.getResult(ApiException.class);
                            Toast.makeText(AttractionList.this, "GPS is already turned on", Toast.LENGTH_SHORT).show();
                        } catch (ApiException e) {switch (e.getStatusCode()) {
                            case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                                try {ResolvableApiException resolvableApiException = (ResolvableApiException) e;
                                    resolvableApiException.startResolutionForResult(AttractionList.this, 2);
                                } catch (IntentSender.SendIntentException ex) {ex.printStackTrace();}break;
                            case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE: break;
                        }}});}} else {requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);}
        }

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView.setOnClickListener(view -> {

        });

        bottomNavigationView = findViewById(R.id.bottom_navbar);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                    return true;
                case R.id.notification:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, notificationFragment).commit();
                    return true;
                case R.id.settings:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, settingsFragment).commit();
                    return true;
            }
            return false;
        });
    }

    private boolean isGPSEnabled() {
        LocationManager locationManager = null;
        boolean isEnabled = false;
        if (locationManager == null) {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        }
        isEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        return isEnabled;
    }

    @Override
    public void onItemClick(int position) {

    }
}*/