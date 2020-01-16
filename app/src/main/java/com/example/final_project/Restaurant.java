package com.example.final_project;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Restaurant implements Parcelable {
    private String name;
    private int location;
    private String country;
    private int quality;

    private int authenticity;
    public int price;

    Restaurant(String name, int location, String country, int q, int a, int p) {
        this.name = name;
        this.location = location;
        this.country = country;
        this.price = p;
        this.authenticity = a;
        this.quality = q;
    }

    // Comparator for sorting the list by price
    public static Comparator<Restaurant> priceComparator = new Comparator<Restaurant>() {

        public int compare(Restaurant r1, Restaurant r2) {
            int price1 = r1.getPrice();
            int price2 = r2.getPrice();

            //ascending order
            return price1 - price2;
        }
    };

    // Comparator for sorting the list by price
    public static Comparator<Restaurant> authenticityComparator = new Comparator<Restaurant>() {

        public int compare(Restaurant r1, Restaurant r2) {
            int authenticity1 = r1.getAuthenticity();
            int authenticity2 = r2.getAuthenticity();

            //ascending order
            return authenticity1 - authenticity2;
        }
    };

    public static Comparator<Restaurant> qualityComparator = new Comparator<Restaurant>() {

        public int compare(Restaurant r1, Restaurant r2) {
            int quality1 = r1.getQuality();
            int quality2 = r2.getQuality();

            //ascending order
            return quality1 - quality2;
        }
    };


    public int getQuality() {
        return quality;
    }

    public int getAuthenticity() {
        return authenticity;
    }

    public int getPrice() {
        return price;
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


    public void writeToParcel(Parcel dest, int flags){

        dest.writeString(name);
        dest.writeInt(location);
        dest.writeString(country);
        dest.writeInt(quality);
        dest.writeInt(authenticity);
        dest.writeInt(price);


    }

    //constructor used for parcel
    public Restaurant(Parcel parcel){

        name = parcel.readString();
        location = parcel.readInt();
        country = parcel.readString();
        quality = parcel.readInt();
        authenticity = parcel.readInt();
        price = parcel.readInt();

    }

    //creator - used when un-parceling our parcel (creating the object)
    public static final Parcelable.Creator<Restaurant> CREATOR = new Parcelable.Creator<Restaurant>(){

        @Override
        public Restaurant createFromParcel(Parcel parcel) {
            return new Restaurant(parcel);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[0];
        }
    };

    //return hashcode of object
    public int describeContents() {
        return hashCode();
    }

}
