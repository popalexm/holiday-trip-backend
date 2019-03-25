package com.hazeldev.holidaytripbackend.models.requestModels;

import javax.validation.constraints.NotNull;

public class AddInPlanningCheckpointRequest {

    @NotNull
    private Integer checkpointId;
    @NotNull
    private Integer orderInTrip;
    // Used for one-to-many relationships with the parent trip table
    @NotNull
    private Integer tripId;
    @NotNull
    private String checkpointTitle;
    private String checkpointDescription;
    private String checkpointAddress;
    @NotNull
    private Double checkpointLatitude;
    @NotNull
    private Double checkpointLongitude;
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
