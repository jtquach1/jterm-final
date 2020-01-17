package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LoadingScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);

        //delay in ms
        int DELAY = 1000;

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // begin with LoadingScreen
                Intent intent = new Intent(LoadingScreen.this, MainActivity.class);
                // run MainActivity
                startActivity(intent);
                // prevents going back to LoadingScreen when on SearchResult, will quit to home screen
                finish();
            }
        }, DELAY);

    }
}
