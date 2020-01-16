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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.exmaple.final_project.SEARCHRESULT";
    private HashMap<String, ArrayList<Restaurant>> restaurants;
    ArrayList<Restaurant> results;
    private Spinner country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // change this to display the activity you want to test
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_rate);
//        setContentView(R.layout.activity_results);


        country = findViewById(R.id.country);

        restaurants = new HashMap<>();
        restaurants.put("Indian", new ArrayList<Restaurant>());
        restaurants.put("Filipino", new ArrayList<Restaurant>());
        restaurants.put("Greek", new ArrayList<Restaurant>());
        restaurants.put("Italian", new ArrayList<Restaurant>());

        ArrayList<Restaurant> indianList = new ArrayList<>();
        indianList.add(new Restaurant("Shanti Taste of India", 5, "Indian", 5, 5, 5));
        indianList.add(new Restaurant("Surya Indian Express", 5, "Indian", 4, 4, 4));
        indianList.add(new Restaurant("Royal Punjab", 5, "Indian", 5, 5, 2));
        indianList.add(new Restaurant("Punjabi Dhaba", 5, "Indian", 1, 3, 5));
        indianList.add(new Restaurant("Desi Dhaba", 5, "Indian", 2, 1, 1));
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

    private void sortResults() {
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        RadioButton radioButton;
        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);

        TextView test = findViewById(R.id.result);
        test.setText(radioButton.getText());

        if (radioButton.getText().equals("Price"))
            Collections.sort(results, Restaurant.priceComparator);

        if (radioButton.getText().equals("Quality"))
            Collections.sort(results, Restaurant.qualityComparator);

        if (radioButton.getText().equals("Authenticity"))
            Collections.sort(results, Restaurant.authenticityComparator);

    }



    public void onSearch(View v) {
        String country = String.valueOf(this.country.getSelectedItem());
        TextView tv = findViewById(R.id.result);
        String res = "";
        results = this.restaurants.get(country);

        sortResults();

        for (Restaurant r : results) {
            res += (r.getName() + "\n");
        }

        //tv.setText(res);



        //switches the activity
        Intent intent = new Intent(this, SearchResult.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(EXTRA_MESSAGE, results);
        intent.putExtras(bundle);
        startActivity(intent);
    }




}
