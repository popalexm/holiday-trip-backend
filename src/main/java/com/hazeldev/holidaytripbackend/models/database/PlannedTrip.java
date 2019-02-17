package com.hazeldev.holidaytripbackend.models.database;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "planned_trips")
@EntityListeners(AuditingEntityListener.class)
public class PlannedTrip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer plannedTripId;
    private Integer userId;
    @NotBlank
    private String plannedTripName;
    private String plannedTripDescription;
    @OneToMany(mappedBy = "checkpointId")
    private List<TripCheckpoint> plannedTripCheckpoints;

    public PlannedTrip() {
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
