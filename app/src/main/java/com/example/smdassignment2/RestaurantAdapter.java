package com.example.smdassignment2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {

    private List<Restaurant> restaurantList;

    public RestaurantAdapter(List<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_restaurant, parent, false);
        return new RestaurantViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
        Restaurant restaurant = restaurantList.get(position);
        holder.textRating.setText(restaurant.getRating());
        holder.textName.setText(restaurant.getName());
        holder.textPhone.setText(restaurant.getPhone());

        // Limiting address text to show
        String location = restaurant.getLocation();
        if (location.length() > 25) {
            location = location.substring(0, 25) + "...";
        }
        holder.textLocation.setText(location);

        // Limiting description text to show
        String description = restaurant.getDescription();
        if (description.length() > 25) {
            description = description.substring(0, 25) + "...";
        }
        holder.textDescription.setText(description);
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    public static class RestaurantViewHolder extends RecyclerView.ViewHolder {
        public TextView textRating;
        public TextView textName;
        public TextView textLocation;
        public TextView textPhone;
        public TextView textDescription;
        // Define other views as needed

        public RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);
            textRating = itemView.findViewById(R.id.tvRating);
            textName = itemView.findViewById(R.id.tvName);
            textLocation = itemView.findViewById(R.id.tvLocation);
            textPhone = itemView.findViewById(R.id.tvPhone);
            textDescription = itemView.findViewById(R.id.tvDescription);
        }
    }
}
