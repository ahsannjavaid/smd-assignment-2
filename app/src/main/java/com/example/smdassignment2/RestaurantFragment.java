package com.example.smdassignment2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RestaurantFragment extends Fragment {

    private Restaurant restaurant;

    public RestaurantFragment() {
        // Required empty public constructor
    }

    // Method to set the Restaurant object
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_restaurant, container, false);

        // Initialize TextViews to display restaurant information
        TextView ratingTextView = view.findViewById(R.id.tvRating);
        TextView nameTextView = view.findViewById(R.id.tvName);
        TextView locationTextView = view.findViewById(R.id.tvLocation);
        TextView phoneTextView = view.findViewById(R.id.tvPhone);
        TextView descriptionTextView = view.findViewById(R.id.tvDescription);

        // Populate TextViews with restaurant data
        if (restaurant != null) {
            ratingTextView.setText(restaurant.getRating());
            nameTextView.setText(restaurant.getName().toUpperCase());

            // Limiting address text to show
            String location = restaurant.getLocation();
            if (location.length() > 20) {
                location = location.substring(0, 20) + "...";
            }
            locationTextView.setText(location);

            phoneTextView.setText(restaurant.getPhone());

            // Limiting description text to show
            String description = restaurant.getDescription();
            if (description.length() > 40) {
                description = description.substring(0, 40) + "...";
            }
            descriptionTextView.setText(description);
        }

        return view;
    }
}
