package com.hazeldev.holidaytripbackend.models.requestModels;

public class NewCheckpointRequest {

    private String checkpointName;
    private String checkpointDescription;
    private Double checkpointLatitude;
    private Double checkpointLongitude;
    private boolean areArrivalNotificationsEnabled;
    private boolean areDepartureNotificationsEnabled;
    private int checkpointColor;

    public String getCheckpointName() {
        return checkpointName;
    }

    public void setCheckpointName(String checkpointName) {
        this.checkpointName = checkpointName;
    }

    public String getCheckpointDescription() {
        return checkpointDescription;
    }

    public void setCheckpointDescription(String checkpointDescription) {
        this.checkpointDescription = checkpointDescription;
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
