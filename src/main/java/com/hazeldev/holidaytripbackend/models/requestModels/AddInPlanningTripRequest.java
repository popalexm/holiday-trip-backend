package com.hazeldev.holidaytripbackend.models.requestModels;

public class AddInPlanningTripRequest {

    private String plannedTripName;
    private String plannedTripDescription;
    private Integer userId;

    public String getTripName() {
        return plannedTripName;
    }

    public String getTripDescription() {
        return plannedTripDescription;
    }

    public Integer getUserId() {
        return userId;
    }
}
