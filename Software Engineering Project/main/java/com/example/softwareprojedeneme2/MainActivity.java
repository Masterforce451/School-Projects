package com.example.softwareprojedeneme2;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler.postDelayed(this::endIntro, 500);
    }
    
    void endIntro() {
        Intent intentMainScreen = new Intent(MainActivity.this, MainScreenActivity.class);
        startActivity(intentMainScreen);
        MainActivity.this.finish();
    }
}