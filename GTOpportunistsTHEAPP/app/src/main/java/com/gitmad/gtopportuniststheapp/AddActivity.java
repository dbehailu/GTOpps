package com.gitmad.gtopportuniststheapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        // title
        ImageView titleIcon = findViewById(R.id.ivName);
        TextView titleText = findViewById(R.id.tvName);
        // description
        ImageView descriptionIcon = findViewById(R.id.ivDescription);
        TextView descriptionText = findViewById(R.id.tvDescription);
        // latitude
        ImageView latitudeIcon = findViewById(R.id.ivLatitude);
        TextView Latitude = findViewById(R.id.tvLatitude);
        // longitude
        ImageView longitudeIcon = findViewById(R.id.ivLongitude);
        TextView longitudeText = findViewById(R.id.tvLongitude);
        // start
        ImageView startTimeIcon = findViewById(R.id.ivStartTime);
        TextView startTimeText = findViewById(R.id.tvStartTime);
        // end
        ImageView endTimeIcon = findViewById(R.id.ivEndTime);
        TextView endTimeText = findViewById(R.id.tvEndTime);
        // username
        ImageView userIcon = findViewById(R.id.ivUser);
        TextView userName = findViewById(R.id.tvName);
    }
}
