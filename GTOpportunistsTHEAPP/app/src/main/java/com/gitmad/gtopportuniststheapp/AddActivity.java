package com.gitmad.gtopportuniststheapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        // title
        ImageView titleIcon = findViewById(R.id.ivName);
        EditText titleText = findViewById(R.id.tvName);
        // description
        ImageView descriptionIcon = findViewById(R.id.ivDescription);
        EditText descriptionText = findViewById(R.id.tvDescription);
        // latitude
        ImageView latitudeIcon = findViewById(R.id.ivLatitude);
        EditText latitudeText = findViewById(R.id.tvLatitude);
        // longitude
        ImageView longitudeIcon = findViewById(R.id.ivLongitude);
        EditText longitudeText = findViewById(R.id.tvLongitude);
        // start
        ImageView startTimeIcon = findViewById(R.id.ivStartTime);
        EditText startTimeText = findViewById(R.id.tvStartTime);
        // end
        ImageView endTimeIcon = findViewById(R.id.ivEndTime);
        EditText endTimeText = findViewById(R.id.tvEndTime);
        // username
        ImageView userIcon = findViewById(R.id.ivUser);
        EditText userNameText = findViewById(R.id.tvName);

        Button btnSave = (Button) findViewById(R.id.btnDone);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleText.getText().toString().trim();
                String description = descriptionText.getText().toString().trim();
                Double latitude = Double.parseDouble(latitudeText.getText().toString());
                Double longitude = Double.parseDouble(longitudeText.getText().toString());
                Integer startTime = Integer.parseInt(startTimeText.getText().toString());
                Integer endTime = Integer.parseInt(endTimeText.getText().toString());
                String userName = userNameText.getText().toString().trim();

                PhotoGalleryActivity.getDb().add(new Pin(title, description, latitude, longitude,
                        startTime, endTime, userName, 0, 0));

                startActivity(new Intent(AddActivity.this, PhotoGalleryActivity.class));
            }
        });
    }
}
