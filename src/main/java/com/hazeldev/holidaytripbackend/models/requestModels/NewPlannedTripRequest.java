package com.hazeldev.holidaytripbackend.models.requestModels;

import java.util.List;

public class NewPlannedTripRequest {

    private String plannedTripName;
    private String plannedTripDescription;
    private List<NewCheckpointRequest> plannedCheckpoints;

    public String getPlannedTripName() {
        return plannedTripName;
    }

    public void setPlannedTripName(String plannedTripName) {
        this.plannedTripName = plannedTripName;
    }

    public String getPlannedTripDescription() {
        return plannedTripDescription;
    }

    public void setPlannedTripDescription(String plannedTripDescription) {
        this.plannedTripDescription = plannedTripDescription;
    }

    public List<NewCheckpointRequest> getPlannedCheckpoints() {
        return plannedCheckpoints;
    }

    public void setPlannedCheckpoints(List<NewCheckpointRequest> plannedCheckpoints) {
        this.plannedCheckpoints = plannedCheckpoints;
    }
}
