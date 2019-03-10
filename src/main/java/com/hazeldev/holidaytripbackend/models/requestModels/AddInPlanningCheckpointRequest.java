package com.hazeldev.holidaytripbackend.models.requestModels;

public class AddInPlanningCheckpointRequest {

    private Integer checkpointId;
    private Integer orderInTrip;
    // Used for one-to-many relationships with the parent trip table
    private Integer tripId;
    private String checkpointTitle;
    private String checkpointDescription;
    private String checkpointAddress;
    private double checkpointLatitude;
    private double checkpointLongitude;
    private boolean areArrivalNotificationsEnabled;
    private boolean areDepartureNotificationsEnabled;
    private int checkpointMarkerColor;

    public Integer getCheckpointId() {
        return checkpointId;
    }

    public String getCheckpointTitle() {
        return checkpointTitle;
    }

    public String getCheckpointDescription() {
        return checkpointDescription;
    }

    public boolean areArrivalNotificationsEnabled() {
        return areArrivalNotificationsEnabled;
    }

    public boolean areDepartureNotificationsEnabled() {
        return areDepartureNotificationsEnabled;
    }

    public String getCheckpointAddress() {
        return checkpointAddress;
    }

    public Integer getOrderInTrip() {
        return orderInTrip;
    }

    public Integer getTripId() {
        return tripId;
    }

    public double getCheckpointLatitude() {
        return checkpointLatitude;
    }

    public double getCheckpointLongitude() {
        return checkpointLongitude;
    }

    public int getCheckpointMarkerColor() {
        return checkpointMarkerColor;
    }

}
