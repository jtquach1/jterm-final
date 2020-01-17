package com.example.final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Collection;

public class SearchResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        // Read/parse the restaurants from the binary blob that was sent to us from the main
        // activity.
        Intent intent = getIntent();
        Collection<Restaurant> res = intent.getParcelableArrayListExtra(MainActivity.EXTRA_MESSAGE);

        ViewGroup restaurantList = findViewById(R.id.restaurant_recycler);

        for (Restaurant restaurant : res) {
            restaurantList.addView(createViewFor(restaurant));
        }
    }

    private View createViewFor(final Restaurant restaurant) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.row_layout, null, false);

        TextView name = view.findViewById(R.id.name);
        name.setText(restaurant.getName());

        ImageView image = view.findViewById(R.id.card_pic);
        image.setImageResource(restaurant.getImage());

        TextView country = view.findViewById(R.id.country);
        country.setText(restaurant.getCountry());

        // fixes dynamic stars loading
        RatingBar priceRating = view.findViewById(R.id.price_rating);
        RatingBar qualityRating = view.findViewById(R.id.quality_rating);
        RatingBar authenticityRating = view.findViewById(R.id.authenticity_rating);

        priceRating.setRating(restaurant.getPrice());
        qualityRating.setRating(restaurant.getQuality());
        authenticityRating.setRating(restaurant.getAuthenticity());


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changeActivity = new Intent(SearchResult.this, RateActivity.class);
                changeActivity.putExtra("restaurant", restaurant);
                startActivity(changeActivity);
            }
        });

        return view;
    }
}
