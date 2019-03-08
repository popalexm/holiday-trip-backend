package com.hazeldev.holidaytripbackend.models.requestModels;

public class InPlanningTripRequest {

    private String plannedTripName;
    private String plannedTripDescription;

    public String getTripName() {
        return plannedTripName;
    }

    public void setTripName(String plannedTripName) {
        this.plannedTripName = plannedTripName;
    }

    public String getTripDescription() {
        return plannedTripDescription;
    }

    public void setTripDescription(String plannedTripDescription) {
        this.plannedTripDescription = plannedTripDescription;
    }
}
