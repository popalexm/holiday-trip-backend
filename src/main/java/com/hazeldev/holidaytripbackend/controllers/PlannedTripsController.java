package com.hazeldev.holidaytripbackend.controllers;

import com.hazeldev.holidaytripbackend.models.PlannedTrip;
import com.hazeldev.holidaytripbackend.models.TripCheckpoint;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlannedTripsController {

    @RequestMapping(value = "/get-planned-trips-by-user-id", method = RequestMethod.GET)
    @ResponseBody
    public PlannedTrip getAllPlannedTripByUser(@RequestParam(value = "userId") Integer userId) {
        return new PlannedTrip(userId, "Test", "TestDescription", null);
    }

    @RequestMapping(value = "/save-new-planned-trip-for-user-id", method = RequestMethod.POST)
    @ResponseBody
    public String saveNewPlannedTripForUserId(@RequestBody TripCheckpoint tripCheckpoint, @RequestParam("userId") String userId) {
        return "You have saved a trip for id " + userId + " with contents -" + tripCheckpoint;
    }
}
