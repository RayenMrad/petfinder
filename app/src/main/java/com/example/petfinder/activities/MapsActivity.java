package com.example.petfinder.activities;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.example.petfinder.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.petfinder.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Configure map settings
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);

        // Set initial camera position (Tunis center)
        LatLng tunis = new LatLng(36.8065, 10.1815);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tunis, 12));

        // Add pet markers with DEFAULT markers (no custom icons)
        addTestPets();
    }

    private void addTestPets() {
        // Pet 1: Lost Dog in Tunis City Center - RED marker
        LatLng pet1Location = new LatLng(36.8065, 10.1815);
        mMap.addMarker(new MarkerOptions()
                .position(pet1Location)
                .title("Max - Lost Dog")
                .snippet("Golden Retriever, Last seen near Habib Bourguiba Avenue")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        // Pet 2: Found Cat in La Marsa - BLUE marker
        LatLng pet2Location = new LatLng(36.8782, 10.3243);
        mMap.addMarker(new MarkerOptions()
                .position(pet2Location)
                .title("Luna - Found Cat")
                .snippet("Siamese, Found near La Marsa Beach")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

        // Pet 3: Lost Rabbit in Carthage - GREEN marker
        LatLng pet3Location = new LatLng(36.8545, 10.3370);
        mMap.addMarker(new MarkerOptions()
                .position(pet3Location)
                .title("Bunny - Lost Rabbit")
                .snippet("White rabbit, Lost near Carthage Museum")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        // Pet 4: Found Bird in Sidi Bou Said - ORANGE marker
        LatLng pet4Location = new LatLng(36.8686, 10.3417);
        mMap.addMarker(new MarkerOptions()
                .position(pet4Location)
                .title("Rio - Found Parrot")
                .snippet("Green parrot, Found in Sidi Bou Said streets")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

        // Pet 5: Lost Dog in Ariana - VIOLET marker
        LatLng pet5Location = new LatLng(36.8625, 10.1956);
        mMap.addMarker(new MarkerOptions()
                .position(pet5Location)
                .title("Rocky - Lost Dog")
                .snippet("German Shepherd, Lost near Ariana Park")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
    }
}