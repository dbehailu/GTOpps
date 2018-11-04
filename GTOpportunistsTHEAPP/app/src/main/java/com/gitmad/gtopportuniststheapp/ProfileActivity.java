package com.gitmad.gtopportuniststheapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class ProfileActivity extends AppCompatActivity {

    private ImageView profile_image;
    private TextView name;
    private TextView numPhotos;
    private BottomNavigationView navBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Button btnStart = (Button) findViewById(R.id.btnSignout);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
            }
        });

        navBar = findViewById(R.id.navigation);
        navBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                System.out.println(item.toString());
                if (item.toString().equals("Map")) {
                    startActivity(new Intent(ProfileActivity.this, MapActivity.class));
                } else if (item.toString().equals("Home")) {
                    startActivity(new Intent(ProfileActivity.this, PhotoGalleryActivity.class));
                }
                // handle desired action here
                // One possibility of action is to replace the contents above the nav bar
                // return true if you want the item to be displayed as the selected item
                return true;
            }
        });


    }

}
