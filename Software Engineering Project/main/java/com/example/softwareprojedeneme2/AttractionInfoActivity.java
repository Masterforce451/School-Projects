package com.example.softwareprojedeneme2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.Locale;
import java.util.Objects;

public class AttractionInfoActivity extends AppCompatActivity {
    SQLiteDatabase database;
    TextToSpeech tts;
    ImageView attractionPhoto, bookmarkButton, attraction_type_icon;
    TextView attractionDistrict, attractionType, attractionInfo, attractionName, transportInfo;
    String temp;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_info);

        BottomNavigationView bottomNavigationBar = findViewById(R.id.bottomNavigationView);
        bottomNavigationBar.setSelectedItemId(R.id.nav_bar_nearbys);
        bottomNavigationBar.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_bar_home:
                    Intent intentHome = new Intent(AttractionInfoActivity.this, MainScreenActivity.class);
                    startActivity(intentHome);
                    intentHome.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    overridePendingTransition(0,0);
                case R.id.nav_bar_attractions:
                    Intent intentAttractionList = new Intent(AttractionInfoActivity.this, AttractionListActivity.class);
                    intentAttractionList.putExtra("filtered", false);
                    intentAttractionList.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentAttractionList);
                    overridePendingTransition(0,0);
                    return true;
                case R.id.nav_bar_nearbys:
                    Intent intentNearbys = new Intent(AttractionInfoActivity.this, NearbyAttractionListActivity.class);
                    intentNearbys.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentNearbys);
                    overridePendingTransition(0,0);
                    return true;
                case R.id.nav_bar_bookmark:
                    Intent intentBookmark = new Intent(AttractionInfoActivity.this, BookmarkListActivity.class);
                    intentBookmark.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentBookmark);
                    overridePendingTransition(0,0);
                    return true;
                case R.id.nav_bar_settings:
                    Intent intentSettings = new Intent(AttractionInfoActivity.this, SettingsActivity.class);
                    intentSettings.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentSettings);
                    overridePendingTransition(0,0);
                    return true;
            }
            return false;
        });

        try {
            database = this.openOrCreateDatabase("Attraction Database",MODE_PRIVATE,null);
            database.execSQL("CREATE TABLE IF NOT EXISTS Attractions (id INT,name VARCHAR,latitude FLOAT,longtitude FLOAT,type VARCHAR,district VARCHAR,PRIMARY KEY (id))");
        } catch (Exception e){
            e.printStackTrace();
        }

        ImageView ttsButton = findViewById(R.id.speech_icon);
        tts = new TextToSpeech(this, status -> {
            if (status == TextToSpeech.SUCCESS) {
                int result = tts.setLanguage(Locale.US);
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                } else {
                    ttsButton.setEnabled(true);
                }
            }
        });

        ttsButton.setOnClickListener(view -> {
            String text = attractionInfo.getText().toString();
            tts.speak(text, TextToSpeech.QUEUE_ADD, null, null);
        });

        ttsButton.setOnLongClickListener(view -> {
            tts.stop();
            tts.shutdown();
            return false;
        });

        attractionPhoto = findViewById(R.id.attraction_photo);
        bookmarkButton = findViewById(R.id.bookmark_icon);
        // checkLocationButton = findViewById(id.checkLocationButton);
        attractionDistrict = findViewById(R.id.attraction_district);
        attractionType = findViewById(R.id.attraction_type);
        attractionInfo = findViewById(R.id.attraction_info);
        attractionName = findViewById(R.id.attraction_name);
        transportInfo = findViewById(R.id.attraction_transport_info);
        attraction_type_icon = findViewById(R.id.attraction_type_icon);

        AlertDialog.Builder alert = new AlertDialog.Builder(AttractionInfoActivity.this).setMessage("This function has not been implemented yet").setPositiveButton("Close", null);
        bookmarkButton.setOnClickListener(view -> {
            alert.setTitle("Favourite Button");
            alert.show();
        });

        attractionPhoto.setImageResource(R.drawable.attraction_1);

        AttractionElement attractionElement = getIntent().getParcelableExtra("attractionObject");
        String attraction_name =  attractionElement.getAttraction_name();

        String name = attractionElement.getPhoto_file_name();
        int resID = getResources().getIdentifier(name,"drawable","com.example.softwareprojedeneme2");
        attractionPhoto.setImageResource(resID);

        if (Objects.equals(attraction_name, "Kordon")){temp = "attraction_1";
        } else if(Objects.equals(attraction_name, "Kemeralti Bazaar")){temp = "attraction_2";
        } else if (Objects.equals(attraction_name, "Izmir Clock Tower")) {temp = "attraction_3";
        }else if (Objects.equals(attraction_name, "Historical Elevator")) {temp = "attraction_4";
        }else if (Objects.equals(attraction_name, "Izmir Archeology and Ethnography Museum")) {temp = "attraction_5";
        }else if (Objects.equals(attraction_name, "Izmir Kulturpark")) {temp = "attraction_6";
        }else if (Objects.equals(attraction_name, "Ephesus Ancient City")) {temp = "attraction_7";
        }else if (Objects.equals(attraction_name, "Maritime Museum")) {temp = "attraction_8";
        }else if (Objects.equals(attraction_name, "Bostanlı Sunset Observation Terrace")) {temp = "attraction_9";
        }else if (Objects.equals(attraction_name, "Teos Ancient City")) {temp = "attraction_10";
        }else if (Objects.equals(attraction_name, "Perforated Bay")) {temp = "attraction_11";
        }else if (Objects.equals(attraction_name, "Cesme Cleopatra Bay")) {temp = "attraction_12";
        }else if (Objects.equals(attraction_name, "Altinkum Beach")) {temp = "attraction_13";
        }else if (Objects.equals(attraction_name, "Ege Bilmuh")) {temp = "attraction_14";}

        int resourceId = getResources().getIdentifier(temp, "array", getPackageName());
        String[] stringArray = getResources().getStringArray(resourceId);

        attractionName.setText(stringArray[0]);
        attractionInfo.setText(stringArray[1]);
        transportInfo.setText(stringArray[2]);

        cursor = database.rawQuery("SELECT name,type,district FROM Attractions",null);
        int name_index = cursor.getColumnIndex("name");
        int type_index = cursor.getColumnIndex("type");
        int district_index = cursor.getColumnIndex("district");

        cursor.moveToFirst();
        do {
            String attr_name = cursor.getString(name_index);
            String attr_type = cursor.getString(type_index);
            String attr_district = cursor.getString(district_index);
            if (Objects.equals(stringArray[0], attr_name)){
                attractionType.setText(attr_type);
                attractionDistrict.setText(attr_district);
                switch (attr_type) {
                    case "Landmark":
                        attraction_type_icon.setImageResource(R.drawable.landmark);
                        break;
                    case "Historic Building":
                        attraction_type_icon.setImageResource(R.drawable.historical_building);
                        break;
                    case "Park":
                        attraction_type_icon.setImageResource(R.drawable.park);
                        break;
                    case "Beach":
                        attraction_type_icon.setImageResource(R.drawable.beach);
                        break;
                    case "Museum":
                        attraction_type_icon.setImageResource(R.drawable.museum);
                        break;
                }
                break;}}while(cursor.moveToNext());


    }


}