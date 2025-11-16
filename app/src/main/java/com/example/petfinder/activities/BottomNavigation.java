package com.example.petfinder.activities;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;

import com.example.petfinder.R;

public class BottomNavigation {

    private Context context;
    private View bottomNavView;

    // Navigation item IDs
    private LinearLayout navHome;
    private LinearLayout navMap;
    private LinearLayout navAdd;
    private LinearLayout navProfile;

    // Interface for navigation callbacks
    public interface NavigationListener {
        void onHomeClicked();
        void onMapClicked();
        void onAddClicked();
        void onProfileClicked();
    }

    private NavigationListener navigationListener;

    public BottomNavigation(Context context, View bottomNavView) {
        this.context = context;
        this.bottomNavView = bottomNavView;
        initializeViews();
        setupClickListeners();
    }

    public BottomNavigation(Context context, View bottomNavView, NavigationListener listener) {
        this.context = context;
        this.bottomNavView = bottomNavView;
        this.navigationListener = listener;
        initializeViews();
        setupClickListeners();
    }

    private void initializeViews() {
        // Find all navigation items
        navHome = bottomNavView.findViewById(R.id.nav_home);
        navMap = bottomNavView.findViewById(R.id.nav_map);
        navAdd = bottomNavView.findViewById(R.id.nav_add);
        navProfile = bottomNavView.findViewById(R.id.nav_profile);
    }

    private void setupClickListeners() {
        // Home click listener
        navHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNavigationState("home");
                if (navigationListener != null) {
                    navigationListener.onHomeClicked();
                } else {
                    // Default behavior
                    handleHomeClick();
                }
            }
        });

        // Map click listener
        navMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNavigationState("map");
                if (navigationListener != null) {
                    navigationListener.onMapClicked();
                } else {
                    // Default behavior - navigate to MapsActivity
                    handleMapClick();
                }
            }
        });

        // Add click listener
        navAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNavigationState("add");
                if (navigationListener != null) {
                    navigationListener.onAddClicked();
                } else {
                    // Default behavior
                    handleAddClick();
                }
            }
        });

        // Profile click listener
        navProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNavigationState("profile");
                if (navigationListener != null) {
                    navigationListener.onProfileClicked();
                } else {
                    // Default behavior
                    handleProfileClick();
                }
            }
        });
    }

    // Update navigation state (change colors)
    public void updateNavigationState(String selectedItem) {
        resetNavigationColors();

        switch (selectedItem) {
            case "home":
                setNavigationItemColor(navHome, R.color.cyan_highlight);
                break;
            case "map":
                setNavigationItemColor(navMap, R.color.cyan_highlight);
                break;
            case "add":
                setNavigationItemColor(navAdd, R.color.cyan_highlight);
                break;
            case "profile":
                setNavigationItemColor(navProfile, R.color.cyan_highlight);
                break;
        }
    }

    private void resetNavigationColors() {
        setNavigationItemColor(navHome, R.color.gray);
        setNavigationItemColor(navMap, R.color.gray);
        setNavigationItemColor(navAdd, R.color.gray);
        setNavigationItemColor(navProfile, R.color.gray);
    }

    private void setNavigationItemColor(LinearLayout layout, int colorRes) {
        if (layout != null) {
            ImageView icon = (ImageView) layout.getChildAt(0);
            TextView text = (TextView) layout.getChildAt(1);

            if (icon != null) {
                icon.setColorFilter(ContextCompat.getColor(context, colorRes));
            }
            if (text != null) {
                text.setTextColor(ContextCompat.getColor(context, colorRes));
            }
        }
    }

    // Default click handlers
    private void handleHomeClick() {
        // Already on home, just update UI
        // You can add refresh logic here if needed
    }

    private void handleMapClick() {
        // Navigate to MapsActivity
        Intent intent = new Intent(context, MapsActivity.class);
        context.startActivity(intent);
    }

    private void handleAddClick() {
        // Navigate to AddActivity or show dialog
        // Example: Intent intent = new Intent(context, AddActivity.class);
        // context.startActivity(intent);
    }

    private void handleProfileClick() {
        // Navigate to ProfileActivity
        // Example: Intent intent = new Intent(context, ProfileActivity.class);
        // context.startActivity(intent);
    }

    // Getters for individual items (if needed)
    public LinearLayout getNavHome() { return navHome; }
    public LinearLayout getNavMap() { return navMap; }
    public LinearLayout getNavAdd() { return navAdd; }
    public LinearLayout getNavProfile() { return navProfile; }

    // Setter for navigation listener
    public void setNavigationListener(NavigationListener listener) {
        this.navigationListener = listener;
    }

    // Method to set initial state
    public void setInitialState(String initialState) {
        updateNavigationState(initialState);
    }

    // Method to enable/disable specific navigation items
    public void setNavigationEnabled(String item, boolean enabled) {
        LinearLayout targetItem = null;

        switch (item) {
            case "home":
                targetItem = navHome;
                break;
            case "map":
                targetItem = navMap;
                break;
            case "add":
                targetItem = navAdd;
                break;
            case "profile":
                targetItem = navProfile;
                break;
        }

        if (targetItem != null) {
            targetItem.setEnabled(enabled);
            targetItem.setAlpha(enabled ? 1.0f : 0.5f);
        }
    }
}