package com.hazeldev.holidaytripbackend.controllers;

import com.hazeldev.holidaytripbackend.models.database.PlannedTrip;
import com.hazeldev.holidaytripbackend.repositories.PlannedTripsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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


}
