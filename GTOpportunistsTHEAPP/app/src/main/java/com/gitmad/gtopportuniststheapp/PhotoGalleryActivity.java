package com.gitmad.gtopportuniststheapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;


public class PhotoGalleryActivity extends AppCompatActivity {

    private BottomNavigationView navBar;

    private static ArrayList<Pin> pinDatabase = new ArrayList<>();
    public static ArrayList<Pin> getDb() {
        return pinDatabase;
    }

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerViewAdapter adapter;

    private static boolean init = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_gallery);

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PhotoGalleryActivity.this, AddActivity.class));
            }
        });

        //Nav Bar Stuff
        navBar = findViewById(R.id.navigation);
        navBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                System.out.println(item.toString());
                if (item.toString().equals("Map")) {
                    startActivity(new Intent(PhotoGalleryActivity.this, MapActivity.class));
                } else if (item.toString().equals("Profile")) {
                    startActivity(new Intent(PhotoGalleryActivity.this, ProfileActivity.class));
                }
                // handle desired action here
                // One possibility of action is to replace the contents above the nav bar
                // return true if you want the item to be displayed as the selected item
                return true;
            }
        });

        if (!init) {
            initPinDatabase();
            init = true;
        }

        initRecyclerView();

    }

    private void initPinDatabase() {

        //Pin Database Stuff
        pinDatabase.add(new Pin("Free Pizza!", "There's free pizza in the CULC",
                33.7749, 84.3964, 14, 15, "AndyBoi",
                9, 0));

        pinDatabase.add(new Pin("Google Swag", " ~ Free swag in CoC lobby ~",
                33.7774, 84.3973, 15, 17, "Peter Parker",
                6, 2));

        pinDatabase.add(new Pin("Free Coffee", "Come by Skiles Walkway!!!",
                33.7740, 84.3973, 11, 12, "Avril Lavigne",
                4, 1));

        pinDatabase.add(new Pin("Free Chick-fil-A", "8-Count Nugget Meal",
                33.7740, 84.3988, 12, 13, "Adam Shoji",
                1, 8));

    }

    private void initRecyclerView(){

        //Recycler Stuff
        recyclerView = findViewById(R.id.recycler_view);
        adapter = new RecyclerViewAdapter(getDb());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }
}
