package com.hazeldev.holidaytripbackend.controllers;

import com.hazeldev.holidaytripbackend.models.database.InPlanningCheckpoint;
import com.hazeldev.holidaytripbackend.models.database.InPlanningTrip;
import com.hazeldev.holidaytripbackend.models.requestModels.AddInPlanningCheckpointRequest;
import com.hazeldev.holidaytripbackend.models.requestModels.AddInPlanningTripRequest;
import com.hazeldev.holidaytripbackend.models.requestModels.UpdateCheckpointLocationRequest;
import com.hazeldev.holidaytripbackend.repositories.InPlanningCheckpointsRepository;
import com.hazeldev.holidaytripbackend.repositories.InPlanningTripRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class InPlanningTripController {

    private final InPlanningTripRepository inPlanningTripRepository;
    private final InPlanningCheckpointsRepository inPlanningCheckpointRepository;

    @Autowired
    public InPlanningTripController(InPlanningTripRepository inPlanningTripRepository, InPlanningCheckpointsRepository inPlanningCheckpointRepository) {
        this.inPlanningTripRepository = inPlanningTripRepository;
        this.inPlanningCheckpointRepository = inPlanningCheckpointRepository;
    }

    @RequestMapping(value = "/post-in-planning-trip", method = RequestMethod.POST)
    @ResponseBody
    public Integer addInPlanningTripForUserId(@RequestBody AddInPlanningTripRequest request) {
        InPlanningTrip inPlanningTrip = new InPlanningTrip();

        inPlanningTrip.setUserId(request.getUserId());
        inPlanningTrip.setTripName(request.getTripName());
        inPlanningTrip.setTripDescription(request.getTripDescription());

        InPlanningTrip trip = inPlanningTripRepository.save(inPlanningTrip);
        return trip.getTripId();
    }

    @RequestMapping(value = "/post-in-planning-checkpoint-for-trip", method = RequestMethod.POST)
    public Integer addCheckpointForTripId(@RequestBody AddInPlanningCheckpointRequest request, @RequestParam("tripId") Integer tripId,
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

        InPlanningCheckpoint savedCheckpoint = inPlanningCheckpointRepository.save(checkpoint);
        return savedCheckpoint.getCheckpointId();
    }

    @RequestMapping(value = "/delete-in-planning-checkpoint-for-trip-id", method = RequestMethod.DELETE)
    public Long deleteCheckpointForTripId(@RequestParam("tripId") Integer tripId, @RequestParam("checkpointId") Integer checkpointId) {
        return inPlanningCheckpointRepository.deleteByCheckpointIdAndTripId(checkpointId, tripId);
    }

    @RequestMapping(value = "/update-in-planning-checkpoint-location", method = RequestMethod.PATCH)
    @ResponseBody
    public Integer updateCheckpointLocationTripId(@RequestParam("userId") Integer userId, @RequestBody UpdateCheckpointLocationRequest request) {

        Optional<InPlanningCheckpoint> checkpointResult = inPlanningCheckpointRepository.findById(request.getCheckpointId());
        if (checkpointResult.isPresent()) {
            InPlanningCheckpoint checkpoint = checkpointResult.get();

            checkpoint.setCheckpointLatitude(request.getLatitude());
            checkpoint.setCheckpointLongitude(request.getLongitude());

            InPlanningCheckpoint updatedCheckpoint = inPlanningCheckpointRepository.save(checkpoint);
            return updatedCheckpoint.getCheckpointId();

        } else {
            //TODO See about how to return custom response in case of checkpoint not found by id, instead of returning null
            return null;
        }
    }

    @RequestMapping(value = "/get-current-in-planning-trip", method = RequestMethod.GET)
    @ResponseBody
    public InPlanningTrip getCurrentInPlanningTrip(@RequestParam("userId") Integer userId) {
        return inPlanningTripRepository.findFirstByUserId(userId);
    }

}
