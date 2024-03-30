package com.example.smdassignment2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

        SharedPreferences sharedPreferences = getSharedPreferences("my_preferences", MODE_PRIVATE);

        String json = sharedPreferences.getString("restaurant_list", "");
        if (!json.isEmpty()) {
            try {
                JSONArray jsonArray = new JSONArray(json);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String rating = jsonObject.getString("rating");
                    String name = jsonObject.getString("name");
                    String location = jsonObject.getString("location");
                    String phone = jsonObject.getString("phone");
                    String description = jsonObject.getString("description");
                    restaurantList.add(new Restaurant(rating, name, location, phone, description));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddRestaurantActivity.class);
                startActivityForResult(intent, ADD_ACTIVITY_REQUEST_CODE);
            }
        });

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

                SharedPreferences sharedPreferences = getSharedPreferences("my_preferences", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                JSONArray jsonArray = new JSONArray();
                for (Restaurant restaurant : restaurantList) {
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("rating", restaurant.getRating());
                        jsonObject.put("name", restaurant.getName());
                        jsonObject.put("location", restaurant.getLocation());
                        jsonObject.put("phone", restaurant.getPhone());
                        jsonObject.put("description", restaurant.getDescription());
                        jsonArray.put(jsonObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                editor.putString("restaurant_list", jsonArray.toString());
                editor.apply();

                Toast.makeText(MainActivity.this, "Restaurant added successfully!", Toast.LENGTH_LONG).show();
                // Notify adapter of data change
                adapter.notifyDataSetChanged();
            }
        }
    }
}