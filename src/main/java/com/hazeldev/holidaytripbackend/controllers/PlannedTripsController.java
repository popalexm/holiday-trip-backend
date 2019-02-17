package com.hazeldev.holidaytripbackend.controllers;

import com.hazeldev.holidaytripbackend.models.database.PlannedTrip;
import com.hazeldev.holidaytripbackend.models.database.TripCheckpoint;
import com.hazeldev.holidaytripbackend.models.requestModels.NewCheckpointRequest;
import com.hazeldev.holidaytripbackend.models.requestModels.NewPlannedTripRequest;
import com.hazeldev.holidaytripbackend.repositories.PlannedTripsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlannedTripsController {

    private final PlannedTripsRepository plannedTripsRepository;

    @Autowired
    public PlannedTripsController(PlannedTripsRepository plannedTripsRepository) {
        this.plannedTripsRepository = plannedTripsRepository;
    }

    @RequestMapping(value = "/get-planned-trips-by-user-id", method = RequestMethod.GET)
    @ResponseBody
    public List<PlannedTrip> getAllPlannedTripByUser(@RequestParam(value = "userId") Integer userId) {
        return plannedTripsRepository.findByUserId(userId);
    }

    @RequestMapping(value = "/save-new-planned-trip-for-user-id", method = RequestMethod.POST)
    @ResponseBody
    public String saveNewPlannedTripForUserId(@RequestBody NewPlannedTripRequest newPlannedTripRequest, @RequestParam("userId") Integer userId) {
        PlannedTrip newPlannedTrip = new PlannedTrip();

        newPlannedTrip.setPlannedTripName(newPlannedTripRequest.getPlannedTripName());
        newPlannedTrip.setPlannedTripDescription(newPlannedTripRequest.getPlannedTripDescription());
        newPlannedTrip.setUserId(userId);

        PlannedTrip savedTrip = plannedTripsRepository.save(newPlannedTrip);

        int savedPlannedTripId = savedTrip.getPlannedTripId();
        List<NewCheckpointRequest> newPlannedTripCheckpoints = newPlannedTripRequest.getPlannedCheckpoints();

        List<TripCheckpoint> checkpoints = new ArrayList<>();
        for (NewCheckpointRequest newCheckpointRequest : newPlannedTripCheckpoints) {
            TripCheckpoint checkpoint = new TripCheckpoint();
            checkpoint.setCheckpointTitle(newCheckpointRequest.getCheckpointName());
            checkpoint.setCheckpointDescription(newCheckpointRequest.getCheckpointDescription());
            checkpoint.setAreArrivalNotificationsEnabled(newCheckpointRequest.isAreArrivalNotificationsEnabled());
            checkpoint.setAreDepartureNotificationsEnabled(newCheckpointRequest.isAreDepartureNotificationsEnabled());
            checkpoint.setPlannedTripId(savedPlannedTripId);
        }
        newPlannedTrip.setPlannedTripCheckpoints(checkpoints);
        // Updates the associated checkpoints for a planned trip
        plannedTripsRepository.save(savedTrip);

        return "Successfully saved trip with id " + savedPlannedTripId;
    }
}
