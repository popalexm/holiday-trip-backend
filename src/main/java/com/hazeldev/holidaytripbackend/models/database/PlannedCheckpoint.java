package com.hazeldev.holidaytripbackend.models.database;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "planned_checkpoints")
@EntityListeners(AuditingEntityListener.class)
public class PlannedCheckpoint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer checkpointId;
    private Integer plannedTripId;
    private Double checkpointLatitude;
    private Double checkpointLongitude;
    private String checkpointTitle;
    private String checkpointDescription;
    private boolean areArrivalNotificationsEnabled;
    private boolean areDepartureNotificationsEnabled;
    private int checkpointColor;

    public PlannedCheckpoint() {
    }

    public Integer getCheckpointId() {
        return checkpointId;
    }

    public void setCheckpointId(Integer checkpointId) {
        this.checkpointId = checkpointId;
    }

    public Double getCheckpointLatitude() {
        return checkpointLatitude;
    }

    public void setCheckpointLatitude(Double checkpointLatitude) {
        this.checkpointLatitude = checkpointLatitude;
    }

    public Double getCheckpointLongitude() {
        return checkpointLongitude;
    }

    public void setCheckpointLongitude(Double checkpointLongitude) {
        this.checkpointLongitude = checkpointLongitude;
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

    public boolean isAreArrivalNotificationsEnabled() {
        return areArrivalNotificationsEnabled;
    }

    public void setAreArrivalNotificationsEnabled(boolean areArrivalNotificationsEnabled) {
        this.areArrivalNotificationsEnabled = areArrivalNotificationsEnabled;
    }

    public boolean isAreDepartureNotificationsEnabled() {
        return areDepartureNotificationsEnabled;
    }

    public void setAreDepartureNotificationsEnabled(boolean areDepartureNotificationsEnabled) {
        this.areDepartureNotificationsEnabled = areDepartureNotificationsEnabled;
    }

    public int getCheckpointColor() {
        return checkpointColor;
    }

    public void setCheckpointColor(int checkpointColor) {
        this.checkpointColor = checkpointColor;
    }

    public Integer getPlannedTripId() {
        return plannedTripId;
    }

    public void setPlannedTripId(Integer plannedTripId) {
        this.plannedTripId = plannedTripId;
    }
}
