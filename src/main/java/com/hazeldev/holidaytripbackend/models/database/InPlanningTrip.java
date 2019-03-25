package com.hazeldev.holidaytripbackend.models.database;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "in_planning_trip")
@EntityListeners(AuditingEntityListener.class)
public class InPlanningTrip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tripId;
    private Integer userId;
    private String tripName;
    private String tripDescription;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "tripId")
    private Set<InPlanningCheckpoint> inPlanningCheckpoints;

    public Integer getTripId() {
        return tripId;
    }

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getTripDescription() {
        return tripDescription;
    }

    public void setTripDescription(String tripDescription) {
        this.tripDescription = tripDescription;
    }

    public Set<InPlanningCheckpoint> getInPlanningCheckpoints() {
        return inPlanningCheckpoints;
    }

    public void setInPlanningCheckpoints(Set<InPlanningCheckpoint> inPlanningCheckpoints) {
        this.inPlanningCheckpoints = inPlanningCheckpoints;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
