package com.hazeldev.holidaytripbackend.controllers;

import com.hazeldev.holidaytripbackend.models.database.InPlanningCheckpoint;
import com.hazeldev.holidaytripbackend.models.database.InPlanningTrip;
import com.hazeldev.holidaytripbackend.models.requestModels.InPlanningCheckpointRequest;
import com.hazeldev.holidaytripbackend.models.requestModels.InPlanningTripRequest;
import com.hazeldev.holidaytripbackend.repositories.InPlanningTripRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InPlanningTripController {

    private final InPlanningTripRepository inPlanningTripRepository;

    @Autowired
    public InPlanningTripController(InPlanningTripRepository inPlanningTripRepository) {
        this.inPlanningTripRepository = inPlanningTripRepository;
    }

    @RequestMapping(value = "/post-in-planning-trip", method = RequestMethod.POST)
    @ResponseBody
    public Integer addInPlanningTripForUserId(@RequestBody InPlanningTripRequest inPlanningTripRequest, @RequestParam("userId") Integer userId) {
        InPlanningTrip inPlanningTrip = new InPlanningTrip();
        inPlanningTrip.setTripName(inPlanningTripRequest.getTripName());
        inPlanningTrip.setTripDescription(inPlanningTripRequest.getTripDescription());
        InPlanningTrip trip = inPlanningTripRepository.save(inPlanningTrip);
        return trip.getTripId();
    }

    @RequestMapping(value = "/post-in-planning-checkpoint", method = RequestMethod.POST)
    private void addCheckpointForTripId(@RequestBody InPlanningCheckpointRequest request, @RequestParam("tripId") Integer tripId,
            @RequestParam("userId") Integer userId) {
        InPlanningCheckpoint checkpoint = new InPlanningCheckpoint();

        checkpoint.setOrderInTrip(request.getOrderInTrip());
        checkpoint.setTripId(request.getTripId());
        checkpoint.setCheckpointTitle(request.getCheckpointTitle());
        checkpoint.setCheckpointDescription(request.getCheckpointDescription());
        checkpoint.setCheckpointLatitude(request.getCheckpointLatitude());
        checkpoint.setCheckpointLongitude(request.getCheckpointLongitude());
        checkpoint.setCheckpointAddress(request.getCheckpointAddress());
        checkpoint.setAreDepartureNotificationsEnabled(request.areDepartureNotificationsEnabled());
        checkpoint.setAreArrivalNotificationsEnabled(request.areArrivalNotificationsEnabled());
    }

    @RequestMapping(value = "/get-current-in-planning-trip", method = RequestMethod.GET)
    @ResponseBody
    private InPlanningTrip getCurrentInPlanningTrip(@RequestParam("userId") Integer userId) {
        return inPlanningTripRepository.findFirstByUserId(userId);
    }

}
