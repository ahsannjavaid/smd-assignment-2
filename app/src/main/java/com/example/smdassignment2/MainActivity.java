package com.example.smdassignment2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int ADD_ACTIVITY_REQUEST_CODE = 100;
    List<Restaurant> restaurantList = new ArrayList<>();
    RestaurantAdapter adapter = new RestaurantAdapter(restaurantList);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddRestaurantActivity.class);
                startActivityForResult(intent, ADD_ACTIVITY_REQUEST_CODE);
            }
        });

        restaurantList.add(new Restaurant("4.4", "Al-Fazal", "Gazi Road, Lahore", "+92 333 333 3333", "Our Faluda is a Hot Item."));
        restaurantList.add(new Restaurant("4.5", "KFC", "Akbar Chowk, Lahore", "+92 333 323 1234", "Zinger is very tasty."));
        restaurantList.add(new Restaurant("4.2", "Leans Kitchen", "Model Town, Lahore", "+92 325 323 0934", "Timings are Sahr and Iftar."));
        restaurantList.add(new Restaurant("2.3", "BFC", "Pak Arab, Lahore", "+92 124 323 1634", "We are economical."));
        restaurantList.add(new Restaurant("4.9", "Aslat Shawarma", "Abid Market, Qainchi, Lahore", "+92 213 323 1134", "Sandwich is very famous. Extra charges for extra Mayonnaise."));
        restaurantList.add(new Restaurant("4.7", "Pizza Hut", "Main Boulevard, Gulberg, Lahore", "+92 333 555 1234", "Variety of pizzas available."));
        restaurantList.add(new Restaurant("4.6", "McDonald's", "DHA Phase 5, Lahore", "+92 333 777 5678", "Famous for burgers and fries."));
        restaurantList.add(new Restaurant("4.8", "Nando's", "Mall of Lahore, Lahore Cantt", "+92 321 999 9876", "Specializes in flame-grilled chicken."));
        restaurantList.add(new Restaurant("4.3", "Subway", "Liberty Market, Gulberg, Lahore", "+92 300 888 4321", "Healthy sandwiches made to order."));
        restaurantList.add(new Restaurant("3.9", "Gloria Jean's Coffees", "Emporium Mall, Johar Town, Lahore", "+92 333 111 0000", "Wide range of coffee and snacks."));
        restaurantList.add(new Restaurant("4.1", "Cafe Aylanto", "MM Alam Road, Gulberg, Lahore", "+92 333 222 3456", "Fine dining with a Mediterranean touch."));
        restaurantList.add(new Restaurant("4.0", "Hardees", "Packages Mall, Walton Road, Lahore", "+92 333 666 7890", "Known for its thick burgers."));
        restaurantList.add(new Restaurant("4.4", "OPTP - One Potato Two Potato", "Y Block, DHA Phase 3, Lahore", "+92 321 123 4567", "Famous for fries and burgers."));
        restaurantList.add(new Restaurant("4.2", "Ginyaki", "Mall 1, Cantt, Lahore", "+92 333 444 5555", "Japanese cuisine with sushi and teppanyaki."));
        restaurantList.add(new Restaurant("4.5", "Rowtisserie", "Lalik Chowk, Model Town, Lahore", "+92 333 999 8888", "Rotisserie chicken and sides."));

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                // Retrieve the values from AddActivity
                String name = data.getStringExtra("name");
                String location = data.getStringExtra("location");
                String phone = data.getStringExtra("phone");
                String description = data.getStringExtra("description");
                String rating = data.getStringExtra("rating");

                restaurantList.add(new Restaurant(rating, name, location, phone, description));
                Toast.makeText(MainActivity.this, "Restaurant added successfully!", Toast.LENGTH_LONG).show();
                adapter.notifyDataSetChanged();
            }
        }
    }
}