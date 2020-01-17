package com.example.final_project;

import android.graphics.drawable.Drawable;
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


    private int image;

    private int authenticity;
    public int price;

    Restaurant(String name, int location, String country, int q, int a, int p, int img) {
        this.name = name;
        this.location = location;
        this.country = country;
        this.price = p;
        this.authenticity = a;
        this.quality = q;
        this.image = img;
    }

    // Comparator for sorting the list by price
    public static Comparator<Restaurant> priceComparator = new Comparator<Restaurant>() {

        public int compare(Restaurant r1, Restaurant r2) {
            int price1 = r1.getPrice();
            int price2 = r2.getPrice();

            //ascending order
            return price2 - price1;
        }
    };

    // Comparator for sorting the list by price
    public static Comparator<Restaurant> authenticityComparator = new Comparator<Restaurant>() {

        public int compare(Restaurant r1, Restaurant r2) {
            int authenticity1 = r1.getAuthenticity();
            int authenticity2 = r2.getAuthenticity();

            //ascending order
            return authenticity2 - authenticity1;
        }
    };

    public static Comparator<Restaurant> qualityComparator = new Comparator<Restaurant>() {

        public int compare(Restaurant r1, Restaurant r2) {
            int quality1 = r1.getQuality();
            int quality2 = r2.getQuality();

            //ascending order
            return quality2 - quality1;
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

    public int getImage() {
        return image;
    }


    public void writeToParcel(Parcel dest, int flags){

        // read and write order must be the same
        // name, location, country, quality, authenticity, price
        dest.writeString(name);
        dest.writeInt(location);
        dest.writeString(country);
        dest.writeInt(quality);
        dest.writeInt(authenticity);
        dest.writeInt(price);

        // write the image id to the blob
        // why: when calling SearchResult from MainActivity, the image id's didn't "convert"
        // so, all the images used to be set to an int value of 0
        // never originally had image written to the stream
        dest.writeInt(image);

    }

    //constructor used for parcel
    public Restaurant(Parcel parcel){

        // read and write order must be the same
        // name, location, country, quality, authenticity, price
        name = parcel.readString();
        location = parcel.readInt();
        country = parcel.readString();
        quality = parcel.readInt();
        authenticity = parcel.readInt();
        price = parcel.readInt();

        // same as from writeToParcel()
        // have to r
        image = parcel.readInt();

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
