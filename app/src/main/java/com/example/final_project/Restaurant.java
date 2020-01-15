package com.example.final_project;

import java.util.ArrayList;

public class Restaurant {
    private String name;
    private int location;
    private String country;
    private Rating rating;

    Restaurant(String name, int location, String country, int q, int a, ArrayList<String> l, int p) {
        this.name = name;
        this.location = location;
        this.country = country;
        this.rating = new Rating(q, a, l, p);
    }

    class Rating {
        private int quality;
        private int authenticity;
        private ArrayList<String> languages;
        private int price;

        Rating(int q, int a, ArrayList<String> l, int p) {
            quality = q;
            authenticity = a;
            languages = l;
            price = p;
        }
    }
    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public String getCountry() {
        return country;
    }

    public Rating getRating() {
        return rating;
    }
}
