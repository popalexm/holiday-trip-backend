package com.hazeldev.holidaytripbackend.models.requestModels;

import javax.validation.constraints.NotNull;

public class AddInPlanningTripRequest {

    @NotNull
    private String tripName;
    private String tripDescription;
    @NotNull
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
