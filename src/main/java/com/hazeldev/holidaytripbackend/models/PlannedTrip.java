package com.hazeldev.holidaytripbackend.models;

import java.util.List;

public class PlannedTrip {

    private Integer plannedTripId;
    private String plannedTripName;
    private String plannedTripDescription;
    private List<TripCheckpoint> plannedTripCheckpoints;

    public PlannedTrip(Integer plannedTripId, String plannedTripName, String plannedTripDescription, List<TripCheckpoint> plannedTripCheckpoints) {
        this.plannedTripId = plannedTripId;
        this.plannedTripName = plannedTripName;
        this.plannedTripDescription = plannedTripDescription;
        this.plannedTripCheckpoints = plannedTripCheckpoints;
    }

    public Integer getPlannedTripId() {
        return plannedTripId;
    }

    public void setPlannedTripId(Integer plannedTripId) {
        this.plannedTripId = plannedTripId;
    }

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

    public List<TripCheckpoint> getPlannedTripCheckpoints() {
        return plannedTripCheckpoints;
    }

    public void setPlannedTripCheckpoints(List<TripCheckpoint> plannedTripCheckpoints) {
        this.plannedTripCheckpoints = plannedTripCheckpoints;
    }
}
