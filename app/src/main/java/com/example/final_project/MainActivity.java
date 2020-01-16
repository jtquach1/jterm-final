package com.example.final_project;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private HashMap<String, ArrayList<Restaurant>> restaurants;
    private Spinner country;
    public static final String EXTRA_MESSAGE = "com.exmaple.final_project.SEARCHRESULT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // change this to display the activity you want to test
//        setContentView(R.layout.activity_main);
//        setContentView(R.layout.activity_rate);
        setContentView(R.layout.activity_results);


        country = findViewById(R.id.country);

        restaurants = new HashMap<>();
        restaurants.put("Indian", new ArrayList<Restaurant>());
        restaurants.put("Filipino", new ArrayList<Restaurant>());
        restaurants.put("Greek", new ArrayList<Restaurant>());
        restaurants.put("Italian", new ArrayList<Restaurant>());

        ArrayList<Restaurant> indianList = new ArrayList<>();
        indianList.add(new Restaurant("Shanti Taste of India", 5, "Indian", 5, 5, 5));
        indianList.add(new Restaurant("Surya Indian Express", 5, "Indian", 5, 5, 5));
        indianList.add(new Restaurant("Royal Punjab", 5, "Indian", 5, 5, 5));
        indianList.add(new Restaurant("Punjabi Dhaba", 5, "Indian", 5, 5, 5));
        indianList.add(new Restaurant("Desi Dhaba", 5, "Indian", 5, 5, 5));
        restaurants.get("Indian").addAll(indianList);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void onSearch(View v) {
        String country = String.valueOf(this.country.getSelectedItem());
        TextView results = findViewById(R.id.result);
        String res = "";
        ArrayList<Restaurant> restaurants = this.restaurants.get(country);
        for (Restaurant r : restaurants) {
            res += (r.getName() + "\n");
        }
        results.setText(res);



        //swtiches the activity
        Intent intent = new Intent(this, SearchResult.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(EXTRA_MESSAGE, restaurants);
        intent.putExtras(bundle);
        startActivity(intent);
    }




}
