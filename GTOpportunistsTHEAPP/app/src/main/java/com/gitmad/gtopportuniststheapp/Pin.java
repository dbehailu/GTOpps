package com.gitmad.gtopportuniststheapp;

public class Pin {
    private String title;
    private String description;

    private int upVotes;
    private int downVotes;

    private double latitude;
    private double longitude;

    int beginTime;
    int endTime;

    private String user;


    public Pin (String title, String description, double latitude, double longitude, int beginTime,
                int endTime, String user, int upVotes, int downVotes) {
        this.title = title;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.user = user;
        this.upVotes = upVotes;
        this.downVotes = downVotes;
    }

    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() { return longitude; }
    public int getBeginTime() { return beginTime; }
    public int getEndTime() { return endTime; }
    public String getUser() { return user; }
    public int getUpVotes() {
        return upVotes;
    }
    public int getDownVotes() {
        return downVotes;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) { this.description = description; }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public void setLongitude(double longitude) { this.longitude = longitude; }
    public void setBeginTime(int beginTime) { this.beginTime = beginTime; }
    public void setEndTime(int endTime) { this.endTime = endTime; }
    public void setUser(String user) { this.user = user; }
    public void setUpVotes(int upVotes) { this.upVotes = upVotes; }
    public void setDownVotes(int downVotes) {
        this.downVotes = downVotes;
    }

}
