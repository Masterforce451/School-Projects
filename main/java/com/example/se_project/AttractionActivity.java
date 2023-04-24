package com.example.se_project;
import static com.example.se_project.R.*;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.Locale;
import java.util.Objects;

public class AttractionActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    SettingsFragment settingsFragment = new SettingsFragment();
    NotificationFragment notificationFragment = new NotificationFragment();
    ImageView attractionPhoto;
    Button addFavButton,deleteFavButton,checkLocationButton;
    TextView attractionLocation,attractionType,attractionDescription,attractionName,transportInfo;
    String xxx;
    TextToSpeech tts;
    SQLiteDatabase database;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        try {
            database = this.openOrCreateDatabase("Attraction Database",MODE_PRIVATE,null);
            database.execSQL("CREATE TABLE IF NOT EXISTS Attractions (id INT,name VARCHAR,latitude FLOAT,longtitude FLOAT,type VARCHAR,district VARCHAR,PRIMARY KEY (id))");
        } catch (Exception e){
            e.printStackTrace();
        }

        Button speakButton = findViewById(R.id.speak_button);
        tts = new TextToSpeech(this, status -> {
            if (status == TextToSpeech.SUCCESS) {
                int result = tts.setLanguage(Locale.US);
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                } else {
                    speakButton.setEnabled(true);
                }
            }
        });

        speakButton.setOnClickListener(view -> {
            String text = attractionDescription.getText().toString();
            tts.speak(text, TextToSpeech.QUEUE_ADD, null, null);
        });

        speakButton.setOnLongClickListener(view -> {
            tts.stop();
            tts.shutdown();
            return false;
        });


        attractionPhoto = findViewById(id.attractionPhoto);
        addFavButton = findViewById(id.addFavButton);
        deleteFavButton = findViewById(id.deleteFavButton);
        checkLocationButton = findViewById(id.checkLocationButton);
        attractionLocation = findViewById(id.attractionLocation);
        attractionType = findViewById(id.attractionType);
        attractionDescription = findViewById(id.attractionDescription);
        attractionName = findViewById(id.attractionName);
        transportInfo = findViewById(id.transport_info);

        AlertDialog.Builder alert = new AlertDialog.Builder(AttractionActivity.this).setMessage("This function has not been implemented yet").setPositiveButton("Close", null);

        addFavButton.setOnClickListener(view -> {
            alert.setTitle("Favourite Button");
            alert.show();
        });
        deleteFavButton.setOnClickListener(view -> {
            alert.setTitle("Delete Button");
            alert.show();
        });
        checkLocationButton.setOnClickListener(view -> {
            alert.setTitle("Location Button");
            alert.show();
        });

        bottomNavigationView = findViewById(id.bottom_navbar);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case id.home:
                    getSupportFragmentManager().beginTransaction().replace(id.container, homeFragment).commit();
                    return true;
                case id.notification:
                    getSupportFragmentManager().beginTransaction().replace(id.container, notificationFragment).commit();
                    return true;
                case id.settings:
                    getSupportFragmentManager().beginTransaction().replace(id.container, settingsFragment).commit();
                    return true;
            }
            return false;
        });


        //String[] stringArray = getResources().getStringArray(array.attraction_8);

        //attractionType.setText("Museum");
        //attractionLocation.setText("İnciralti");

        attractionPhoto.setImageResource(drawable.attraction_8);

        AttractionLineItem attractionLineItem = getIntent().getParcelableExtra("attractionObject");
        String attraction_name =  attractionLineItem.getAttraction_name();

        String name = attractionLineItem.getPhoto_file_name();
        int resID = getResources().getIdentifier(name,"drawable","com.example.se_project");
        attractionPhoto.setImageResource(resID);

        if (Objects.equals(attraction_name, "Kordon")){xxx = "attraction_1";
        } else if(Objects.equals(attraction_name, "Kemeralti Bazaar")){xxx = "attraction_2";
        } else if (Objects.equals(attraction_name, "Izmir Clock Tower")) {xxx = "attraction_3";
        }else if (Objects.equals(attraction_name, "Historical Elevator")) {xxx = "attraction_4";
        }else if (Objects.equals(attraction_name, "Izmir Archeology and Ethnography Museum")) {xxx = "attraction_5";
        }else if (Objects.equals(attraction_name, "Izmir Kulturpark")) {xxx = "attraction_6";
        }else if (Objects.equals(attraction_name, "Ephesus Ancient City")) {xxx = "attraction_7";
        }else if (Objects.equals(attraction_name, "Maritime Museum")) {xxx = "attraction_8";
        }else if (Objects.equals(attraction_name, "Bostanlı Sunset Observation Terrace")) {xxx = "attraction_9";
        }else if (Objects.equals(attraction_name, "Teos Ancient City")) {xxx = "attraction_10";
        }else if (Objects.equals(attraction_name, "Perforated Bay")) {xxx = "attraction_11";
        }else if (Objects.equals(attraction_name, "Cesme Cleopatra Bay")) {xxx = "attraction_12";
        }else if (Objects.equals(attraction_name, "Altinkum Beach")) {xxx = "attraction_13";
        }else if (Objects.equals(attraction_name, "Ege Bilmuh")) {xxx = "attraction_14";}

        int resourceId = getResources().getIdentifier(xxx, "array", getPackageName());
        String[] stringArray = getResources().getStringArray(resourceId);

        attractionName.setText(stringArray[0]);
        attractionDescription.setText(stringArray[1]);
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
                attractionLocation.setText(attr_district);
                break;}}while(cursor.moveToNext());
    }
    /*
        messageView = findViewById(id.messageView);
        btnTurkish.setOnClickListener(view -> {
            changeLanguage("tr");
        });
        btnEnglish.setOnClickListener(view -> {
            changeLanguage("eng");
        });
    @SuppressWarnings("deprecation")
    private void changeLanguage(String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.setLocale(locale);
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());
    }
    */
}