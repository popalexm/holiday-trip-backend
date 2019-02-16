package com.hazeldev.holidaytripbackend.models;

public class TripCheckpoint {

    private Integer checkpointId;
    private Double checkpointLatitude;
    private Double checkpointLongitude;
    private String checkpointTitle;
    private String checkpointDescription;
    private boolean areArrivalNotificationsEnabled;
    private boolean areDepartureNotificationsEnabled;
    private int checkpointColor;

    public TripCheckpoint(Integer checkpointId, Double checkpointLatitude, Double checkpointLongitude, String checkpointTitle, String checkpointDescription,
            boolean areArrivalNotificationsEnabled, boolean areDepartureNotificationsEnabled, int checkpointColor) {
        this.checkpointId = checkpointId;
        this.checkpointLatitude = checkpointLatitude;
        this.checkpointLongitude = checkpointLongitude;
        this.checkpointTitle = checkpointTitle;
        this.checkpointDescription = checkpointDescription;
        this.areArrivalNotificationsEnabled = areArrivalNotificationsEnabled;
        this.areDepartureNotificationsEnabled = areDepartureNotificationsEnabled;
        this.checkpointColor = checkpointColor;
    }

    public Integer getCheckpointId() {
        return checkpointId;
    }

    public void setCheckpointId(Integer checkpointId) {
        this.checkpointId = checkpointId;
    }

    public Double getCheckpointLatitude() {
        return checkpointLatitude;
    }

    public void setCheckpointLatitude(Double checkpointLatitude) {
        this.checkpointLatitude = checkpointLatitude;
    }

    public Double getCheckpointLongitude() {
        return checkpointLongitude;
    }

    public void setCheckpointLongitude(Double checkpointLongitude) {
        this.checkpointLongitude = checkpointLongitude;
    }

    public String getCheckpointTitle() {
        return checkpointTitle;
    }

    public void setCheckpointTitle(String checkpointTitle) {
        this.checkpointTitle = checkpointTitle;
    }

    public String getCheckpointDescription() {
        return checkpointDescription;
    }

    public void setCheckpointDescription(String checkpointDescription) {
        this.checkpointDescription = checkpointDescription;
    }

    public boolean isAreArrivalNotificationsEnabled() {
        return areArrivalNotificationsEnabled;
    }

    public void setAreArrivalNotificationsEnabled(boolean areArrivalNotificationsEnabled) {
        this.areArrivalNotificationsEnabled = areArrivalNotificationsEnabled;
    }

    public boolean isAreDepartureNotificationsEnabled() {
        return areDepartureNotificationsEnabled;
    }

    public void setAreDepartureNotificationsEnabled(boolean areDepartureNotificationsEnabled) {
        this.areDepartureNotificationsEnabled = areDepartureNotificationsEnabled;
    }

    public int getCheckpointColor() {
        return checkpointColor;
    }

    public void setCheckpointColor(int checkpointColor) {
        this.checkpointColor = checkpointColor;
    }
}
