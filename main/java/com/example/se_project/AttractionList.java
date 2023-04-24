package com.example.se_project;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.Manifest;
import android.content.Context;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
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


public class AttractionList extends AppCompatActivity{
    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    SettingsFragment settingsFragment = new SettingsFragment();
    NotificationFragment notificationFragment = new NotificationFragment();
    RecyclerView recyclerView;
    List<AttractionLineItem> attractionLineItemList = new ArrayList<>();
    AttractionAdapter usersAdapter;
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

        /*Veritabanındaki veriler
        database.execSQL("INSERT INTO Attractions VALUES" +
                "(1,'Kordon',38.43834025666333,27.14145202696257,'Landmark','Konak')," +
                "(2,'Kemeralti Bazaar',38.41884376843759,27.13288637311974,'Historic Building','Konak')," +
                "(3,'Izmir Clock Tower',38.419084909647644,27.128818015319702,'Historic Building','Konak')," +
                "(4,'Historical Elevator',38.40881362864622,27.117657036483724,'Historic Building','Konak')," +
                "(5,'Izmir Archeology and Ethnography Museum',38.4137696554268,27.128567486507265,'Museums','Konak')," +
                "(6,'Izmir Kulturpark',38.42863236597575, 27.145398642305416,'Park','Konak')," +
                "(7,'Ephesus Ancient City',37.94111242686145, 27.34152227113099,'Historic building','Selcuk')," +
                "(8,'Maritime Museum',38.57097101886175, 27.022300152454566,'Museum','Inciralti')," +
                "(9,'Bostanlı Sunset Observation Terrace',38.45545700639709, 27.093075269291408,'Landmarks','Karsiyaka')," +
                "(10,'Teos Ancient City',38.179763220722045, 26.783316213464605,'Historic Building','Seferihisar')," +
                "(11,'Perforated Bay',38.231076162087625, 26.342522421980185,'Beach','Cesme')," +
                "(12,'Cesme Cleopatra Bay',38.231892848749375, 26.329422236785312,'Beach','Cesme')," +
                "(13,'Altinkum Beach',38.268430457161216, 26.274091540132478,'Beach','Cesme')," +
                "(14,'Ege Bilmuh',38.45791134777,27.21314013,'Historic Building','Bornova')");*/

        if (ActivityCompat.checkSelfPermission(AttractionList.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
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
                    for (double[] doubles : uzakliklar) {
                        String attraction_to_be_used = null;
                        String attr_id = null;
                        for (int k = 0; k < uzakliklar.length; k++) {
                            attr_id = String.valueOf(Integer.valueOf((int) doubles[0]));
                            ;
                            String attr_test = attractionNamesWithIDs[k][0];
                            if (attr_id.equals(attr_test)) {
                                attraction_to_be_used = attractionNamesWithIDs[k][1];
                                break;
                            }
                        }
                        String photo_file_name = ("attraction_" + attr_id);
                        int id_going = getResources().getIdentifier(photo_file_name, "drawable", getPackageName());
                        Drawable drawable = getResources().getDrawable(id_going, getTheme());
                        AttractionLineItem attractionLineItem = new AttractionLineItem(attraction_to_be_used, drawable, photo_file_name);
                        attractionLineItemList.add(attractionLineItem);
                    }
                    usersAdapter = new AttractionAdapter(attractionLineItemList);
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
                }}});}}}

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

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

}