package com.example.final_project;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

// from example
import android.widget.RatingBar;
import android.widget.Button;
import android.widget.Toast;


public class RateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // changed id name of the back button
        // onclick should switch between layouts
        FloatingActionButton fab = findViewById(R.id.go_back);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // initiate rating bar and a button
        final RatingBar simpleRatingBar1 = (RatingBar) findViewById(R.id.simpleRatingBar1);
        final RatingBar simpleRatingBar2 = (RatingBar) findViewById(R.id.simpleRatingBar2);
        final RatingBar simpleRatingBar3 = (RatingBar) findViewById(R.id.simpleRatingBar3);


        Button submitButton = (Button) findViewById(R.id.submitButton);
        // perform click event on button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get values and then displayed in a toast
                String totalStars1 = "Total Stars:: " + simpleRatingBar1.getNumStars();
                String rating1 = "Rating :: " + simpleRatingBar1.getRating();
                Toast.makeText(getApplicationContext(), totalStars1 + "\n" + rating1, Toast.LENGTH_LONG).show();
                // get values and then displayed in a toast
                String totalStars2 = "Total Stars:: " + simpleRatingBar2.getNumStars();
                String rating2 = "Rating :: " + simpleRatingBar2.getRating();
                Toast.makeText(getApplicationContext(), totalStars2 + "\n" + rating2, Toast.LENGTH_LONG).show();
                // get values and then displayed in a toast
                String totalStars3 = "Total Stars:: " + simpleRatingBar3.getNumStars();
                String rating3 = "Rating :: " + simpleRatingBar3.getRating();
                Toast.makeText(getApplicationContext(), totalStars3 + "\n" + rating3, Toast.LENGTH_LONG).show();
            }
        });

    }
    public void changeLayout(View view) {
        // switches the activity, but crashes
        Intent intent = new Intent(this, ResultsActivity.class);
        startActivity(intent);
//        setContentView(R.layout.activity_rate);
    }

}
