package com.gitmad.gtopportuniststheapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PinDetailActivity extends AppCompatActivity {

    private String title;
    private String description;
    private String latitude;
    private String longitude;
    private String beginTime;
    private String endTime;
    private String user;
    private String upVote;
    private String downVote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_detail);
        getIncomingIntent();
    }

    private void getIncomingIntent() {

        String title = getIntent().getStringExtra("pin_title");
        String description = getIntent().getStringExtra("pin_description");
        String latitude = getIntent().getStringExtra("pin_latitude");
        String longitude = getIntent().getStringExtra("pin_longitude");
        String beginTime = getIntent().getStringExtra("pin_begin");
        String endTime = getIntent().getStringExtra("pin_end");
        String user = getIntent().getStringExtra("pin_user");
        String upVote = getIntent().getStringExtra("pin_upVote");
        String downVote = getIntent().getStringExtra("pin_downVote");

        this.title = title;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.user = user;
        this.upVote = upVote;
        this.downVote = downVote;

        setWidget(title, description, latitude, longitude, beginTime, endTime, user, upVote, downVote);
    }

    private void setWidget(String title, String description, String latitude, String longitude,
                           String beginTime, String endTime, String user, String upVote, String downVote) {

        TextView loc_title = findViewById(R.id.pin_title);
        loc_title.setText(title);

        TextView loc_description = findViewById(R.id.pin_description);
        loc_description.setText(description);

        TextView loc_latitude = findViewById(R.id.pin_latitude);
        loc_latitude.setText("Latitude: " + latitude);

        TextView loc_longitude = findViewById(R.id.pin_longitude);
        loc_longitude.setText("Longitude: " + longitude);

        TextView loc_beginTime = findViewById(R.id.pin_begin);
        loc_beginTime.setText("Start: " + beginTime + ":00");

        TextView loc_endTime = findViewById(R.id.pin_end);
        loc_endTime.setText("End: " + endTime + ":00");

        TextView loc_user = findViewById(R.id.pin_user);
        loc_user.setText("Contributor: " + user);

        TextView loc_upVote = findViewById(R.id.pin_upVote);
        loc_upVote.setText("Up Votes: "+ upVote);

        TextView loc_downVote = findViewById(R.id.pin_downVote);
        loc_downVote.setText("Down Votes: "+ downVote);
    }
}
