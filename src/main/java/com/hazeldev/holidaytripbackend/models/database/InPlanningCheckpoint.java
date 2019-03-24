package com.hazeldev.holidaytripbackend.models.database;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "in_planning_checkpoints")
@EntityListeners(AuditingEntityListener.class)
public class InPlanningCheckpoint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer checkpointId;
    // Used for one-to-many relationships with the parent trip table
    private Integer tripId;
    // Used to define in which order should the checkpoint be passed
    private Integer orderInTrip;
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

    public void setCheckpointId(Integer checkpointId) {
        this.checkpointId = checkpointId;
    }

    public String getCheckpointTitle() {
        return checkpointTitle;
    }

    public void setCheckpointTitle(String checkpointTitle) {
        this.checkpointTitle = checkpointTitle;
    }

    public String getCheckpointDescription() {
        return checkpointDescription;
    }

    public void setCheckpointDescription(String checkpointDescription) {
        this.checkpointDescription = checkpointDescription;
    }

    public boolean areArrivalNotificationsEnabled() {
        return areArrivalNotificationsEnabled;
    }

    public void setAreArrivalNotificationsEnabled(boolean areArrivalNotificationsEnabled) {
        this.areArrivalNotificationsEnabled = areArrivalNotificationsEnabled;
    }

    public boolean areDepartureNotificationsEnabled() {
        return areDepartureNotificationsEnabled;
    }

    public void setAreDepartureNotificationsEnabled(boolean areDepartureNotificationsEnabled) {
        this.areDepartureNotificationsEnabled = areDepartureNotificationsEnabled;
    }

    public int getCheckpointMarkerColor() {
        return checkpointMarkerColor;
    }

    public void setCheckpointMarkerColor(int checkpointMarkerColor) {
        this.checkpointMarkerColor = checkpointMarkerColor;
    }

    public String getCheckpointAddress() {
        return checkpointAddress;
    }

    public void setCheckpointAddress(String checkpointAddress) {
        this.checkpointAddress = checkpointAddress;
    }

    public Integer getOrderInTrip() {
        return orderInTrip;
    }

    public void setOrderInTrip(Integer orderInTrip) {
        this.orderInTrip = orderInTrip;
    }

    public Integer getTripId() {
        return tripId;
    }

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }

    public double getCheckpointLatitude() {
        return checkpointLatitude;
    }

    public void setCheckpointLatitude(double checkpointLatitude) {
        this.checkpointLatitude = checkpointLatitude;
    }

    public double getCheckpointLongitude() {
        return checkpointLongitude;
    }

    public void setCheckpointLongitude(double checkpointLongitude) {
        this.checkpointLongitude = checkpointLongitude;
    }
}
