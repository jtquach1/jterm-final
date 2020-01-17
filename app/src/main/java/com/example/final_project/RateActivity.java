package com.example.final_project;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

// from example
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class RateActivity extends AppCompatActivity {
    Restaurant restaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();

        restaurant = getIntent().getParcelableExtra("restaurant");

        // change title based on restaurant name
        TextView title = findViewById(R.id.title);
        title.setText("What did you think of " + restaurant.getName() + "?");

        // make restaurant image dynamic
        ImageView image = findViewById(R.id.restaurant_img);
        image.setImageResource(restaurant.getImage());

        // changed id name of the back button
        // onclick should switch between layouts

        // initiate rating bar and a button
        final RatingBar simpleRatingBar1 = (RatingBar) findViewById(R.id.simpleRatingBar1);
        final RatingBar simpleRatingBar2 = (RatingBar) findViewById(R.id.simpleRatingBar2);
        final RatingBar simpleRatingBar3 = (RatingBar) findViewById(R.id.simpleRatingBar3);

        Button submitButton = (Button) findViewById(R.id.submitButton);
        // perform click event on button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Review submitted", Toast.LENGTH_LONG).show();
            }
        });

    }


}
