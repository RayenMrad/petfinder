package com.example.petfinder.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View; // Add this import

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.petfinder.R;

public class MainActivity extends AppCompatActivity implements BottomNavigation.NavigationListener { // Add implements

    private BottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        View bottomNavView = findViewById(R.id.bottom_navigation_bar);
        bottomNavigation = new BottomNavigation(this, bottomNavView, this);
        bottomNavigation.setInitialState("home");
    }

    @Override
    public void onHomeClicked() {
        // Custom home click logic
        // You're probably already on home, so just refresh if needed
    }

    @Override
    public void onMapClicked() {
        // Navigate to MapsActivity
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onAddClicked() {
        // Handle add click - navigate to AddActivity or show dialog
        // Intent intent = new Intent(this, AddActivity.class);
        // startActivity(intent);
    }

    @Override
    public void onProfileClicked() {
        // Handle profile click - navigate to ProfileActivity
        // Intent intent = new Intent(this, ProfileActivity.class);
        // startActivity(intent);
    }
}