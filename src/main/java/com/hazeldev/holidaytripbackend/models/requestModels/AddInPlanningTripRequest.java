package com.hazeldev.holidaytripbackend.models.requestModels;

public class AddInPlanningTripRequest {

    private String plannedTripName;
    private String plannedTripDescription;

    public String getTripName() {
        return plannedTripName;
    }

    public String getTripDescription() {
        return plannedTripDescription;
    }
}
