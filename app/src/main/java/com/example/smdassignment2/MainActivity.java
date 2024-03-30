package com.example.smdassignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Restaurant[] restaurants = {
                new Restaurant("4.4", "Al-Fazal", "Gazi Road, Lahore", "+92 333 333 3333", "Our Faluda is a Hot Item."),
                new Restaurant("4.5", "KFC", "Akbar Chowk, Lahore", "+92 333 323 1234", "Zinger is very tasty."),
                new Restaurant("4.2", "Leans Kitchen", "Model Town, Lahore", "+92 325 323 0934", "Timings are Sahr and Iftar."),
                new Restaurant("2.3", "BFC", "Pak Arab, Lahore", "+92 124 323 1634", "We are economical."),
                new Restaurant("4.9", "Aslat Shawarma", "Abid Market, Qainchi, Lahore", "+92 213 323 1134", "Sandwitch is very famous. Extra charges for extra Mayonise."),
                new Restaurant("4.7", "Pizza Hut", "Main Boulevard, Gulberg, Lahore", "+92 333 555 1234", "Variety of pizzas available."),
                new Restaurant("4.6", "McDonald's", "DHA Phase 5, Lahore", "+92 333 777 5678", "Famous for burgers and fries."),
                new Restaurant("4.8", "Nando's", "Mall of Lahore, Lahore Cantt", "+92 321 999 9876", "Specializes in flame-grilled chicken."),
                new Restaurant("4.3", "Subway", "Liberty Market, Gulberg, Lahore", "+92 300 888 4321", "Healthy sandwiches made to order."),
                new Restaurant("3.9", "Gloria Jean's Coffees", "Emporium Mall, Johar Town, Lahore", "+92 333 111 0000", "Wide range of coffee and snacks."),
                new Restaurant("4.1", "Cafe Aylanto", "MM Alam Road, Gulberg, Lahore", "+92 333 222 3456", "Fine dining with a Mediterranean touch."),
                new Restaurant("4.0", "Hardees", "Packages Mall, Walton Road, Lahore", "+92 333 666 7890", "Known for its thick burgers."),
                new Restaurant("4.4", "OPTP - One Potato Two Potato", "Y Block, DHA Phase 3, Lahore", "+92 321 123 4567", "Famous for fries and burgers."),
                new Restaurant("4.2", "Ginyaki", "Mall 1, Cantt, Lahore", "+92 333 444 5555", "Japanese cuisine with sushi and teppanyaki."),
                new Restaurant("4.5", "Rowtisserie", "Lalik Chowk, Model Town, Lahore", "+92 333 999 8888", "Rotisserie chicken and sides."),
        };

        LinearLayout container = findViewById(R.id.container);

        for (Restaurant restaurant : restaurants) {
            RestaurantFragment fragment = new RestaurantFragment();
            fragment.setRestaurant(restaurant);

            getSupportFragmentManager().beginTransaction().add(container.getId(), fragment).commit();

        }
    }
}