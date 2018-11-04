package com.gitmad.gtopportuniststheapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private BottomNavigationView navBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        FloatingActionButton fab = findViewById(R.id.fab);

        navBar = findViewById(R.id.navigation);

        navBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                System.out.println(item.toString());
                if (item.toString().equals("Profile")) {
                    startActivity(new Intent(MapActivity.this, ProfileActivity.class));
                } else if (item.toString().equals("Home")) {
                    startActivity(new Intent(MapActivity.this, PhotoGalleryActivity.class));
                }
                // handle desired action here
                // One possibility of action is to replace the contents above the nav bar
                // return true if you want the item to be displayed as the selected item
                return true;
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Map Markers
        LatLng gt = new LatLng(33.777620,-84.396281);
        LatLng gt2 = new LatLng( 33.774103, -84.398823);
        LatLng gt3 = new LatLng( 33.7774, -84.3973);
        LatLng gt4 = new LatLng( 33.7736,-84.3964);
        LatLng gt5 = new LatLng(33.7749,-84.3964);
        mMap.addMarker(new MarkerOptions().position(gt).title("My Current Location"));
        mMap.addMarker(new MarkerOptions().position(gt2).title("Student Center"));
        mMap.addMarker(new MarkerOptions().position(gt3).title("College of Computing"));
        mMap.addMarker(new MarkerOptions().position(gt4).title("Skiles Walkway"));
        mMap.addMarker(new MarkerOptions().position(gt5).title("Clough Undergraduate Learning Commons"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(gt));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(11.0f));
    }
}
