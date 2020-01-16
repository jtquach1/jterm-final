package com.example.final_project;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ResAdapter extends RecyclerView.Adapter<ResAdapter.ViewHolder> {
    public static final String EXTRA_MESSAGE = "com.example.final_project.RESTAURANT";
    private ArrayList<Restaurant> values;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView name;
        public ImageView img;
        public View layout;
        public TextView country;
        public RatingBar authenticityRating;
        public RatingBar qualityRating;
        public RatingBar priceRating;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            name = v.findViewById(R.id.name);
            authenticityRating = v.findViewById(R.id.authenticity_rating);
            qualityRating = v.findViewById(R.id.quality_rating);
            priceRating = v.findViewById(R.id.price_rating);
            country = v.findViewById(R.id.country);
        }
    }

    public void add(int position, Restaurant item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ResAdapter(ArrayList<Restaurant> myDataset) {
        values = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ResAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        String name = values.get(position).getName();
        String country = values.get(position).getCountry();
        int qualityStars = values.get(position).getQuality();
        int authenticityStars = values.get(position).getAuthenticity();
        int priceStars = values.get(position).getPrice();

        holder.name.setText(name);
        holder.qualityRating.setRating(qualityStars);
        holder.authenticityRating.setRating(authenticityStars);
        holder.priceRating.setRating(priceStars);
        holder.country.setText(country);


        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), RateActivity.class);
                intent.putExtra("name", values.get(position).getName());

                view.getContext().startActivity(intent);

            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}