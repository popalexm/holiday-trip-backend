package com.hazeldev.holidaytripbackend.controllers;

import com.hazeldev.holidaytripbackend.models.database.InPlanningTrip;
import com.hazeldev.holidaytripbackend.models.requestModels.AddInPlanningCheckpointRequest;
import com.hazeldev.holidaytripbackend.models.requestModels.AddInPlanningTripRequest;
import com.hazeldev.holidaytripbackend.models.requestModels.UpdateCheckpointLocationRequest;
import com.hazeldev.holidaytripbackend.services.InPlanningTripService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class InPlanningTripController {

    @NonNull
    private final InPlanningTripService inPlanningTripService;

    @Autowired
    public InPlanningTripController(InPlanningTripService inPlanningTripService) {
        this.inPlanningTripService = inPlanningTripService;
    }

    @RequestMapping(value = "/post-in-planning-trip", method = RequestMethod.POST)
    @ResponseBody
    public Integer addInPlanningTripForUserId(@Valid @RequestBody AddInPlanningTripRequest request) {
        return inPlanningTripService.saveInPlanningTripToDatabase(request);
    }

    @RequestMapping(value = "/post-in-planning-checkpoint", method = RequestMethod.POST)
    @ResponseBody
    public Integer addCheckpointForTrip(@Valid @RequestBody AddInPlanningCheckpointRequest request) {
        return inPlanningTripService.saveInPlanningCheckpointToDatabase(request);
    }

    @RequestMapping(value = "/delete-in-planning-checkpoint", method = RequestMethod.DELETE)
    public boolean deleteCheckpointForTripId(@RequestParam("userId") Integer userId, @RequestParam("checkpointId") Integer checkpointId) {
        return inPlanningTripService.deleteCheckpoint(checkpointId);
    }

    @RequestMapping(value = "/update-in-planning-checkpoint-location", method = RequestMethod.PATCH)
    @ResponseBody
    public Integer updateCheckpointLocationTripId(@Valid @RequestBody UpdateCheckpointLocationRequest request, @RequestParam("userId") Integer userId) {
        return inPlanningTripService.updateCheckpointLocation(request);
    }

    @RequestMapping(value = "/get-current-in-planning-trip", method = RequestMethod.GET)
    @ResponseBody
    public InPlanningTrip getCurrentInPlanningTrip(@RequestParam("userId") Integer userId) {
        return inPlanningTripService.getCurrentInPlanningTrip(userId);
    }

    @RequestMapping(value = "/set-in-planning-trip-as-done", method = RequestMethod.POST)
    @ResponseBody
    public Integer setInPlanningTripAsDone(@RequestBody Integer userId) {
        return inPlanningTripService.moveInPlanningTripToPlannedRepository(userId);
    }

}
