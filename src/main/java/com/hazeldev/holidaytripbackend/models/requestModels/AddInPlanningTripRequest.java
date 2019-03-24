package com.hazeldev.holidaytripbackend.models.requestModels;

public class AddInPlanningTripRequest {

    private String tripName;
    private String tripDescription;
    private Integer userId;

    public String getTripName() {
        return tripName;
    }

    public String getTripDescription() {
        return tripDescription;
    }

    public Integer getUserId() {
        return userId;
    }
}
