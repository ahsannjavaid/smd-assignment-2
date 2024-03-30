package com.example.smdassignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddRestaurantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurant);

        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDataAndReturn();
            }
        });
    }
    private void saveDataAndReturn() {
        // Retrieve values from EditText fields
        String name = ((EditText) findViewById(R.id.etName)).getText().toString();
        String location = ((EditText) findViewById(R.id.etLocation)).getText().toString();
        String phone = ((EditText) findViewById(R.id.etPhone)).getText().toString();
        String description = ((EditText) findViewById(R.id.etDescription)).getText().toString();
        String rating = ((EditText) findViewById(R.id.etRating)).getText().toString();

        // Create an Intent to return the values to MainActivity
        Intent returnIntent = new Intent();
        returnIntent.putExtra("name", name);
        returnIntent.putExtra("location", location);
        returnIntent.putExtra("phone", phone);
        returnIntent.putExtra("description", description);
        returnIntent.putExtra("rating", rating);

        // Set result and finish AddActivity
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}