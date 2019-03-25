package com.hazeldev.holidaytripbackend.services;

import com.hazeldev.holidaytripbackend.models.database.InPlanningCheckpoint;
import com.hazeldev.holidaytripbackend.models.database.InPlanningTrip;
import com.hazeldev.holidaytripbackend.models.database.PlannedCheckpoint;
import com.hazeldev.holidaytripbackend.models.database.PlannedTrip;
import com.hazeldev.holidaytripbackend.models.requestModels.AddInPlanningCheckpointRequest;
import com.hazeldev.holidaytripbackend.models.requestModels.AddInPlanningTripRequest;
import com.hazeldev.holidaytripbackend.models.requestModels.UpdateCheckpointLocationRequest;
import com.hazeldev.holidaytripbackend.repositories.InPlanningCheckpointsRepository;
import com.hazeldev.holidaytripbackend.repositories.InPlanningTripRepository;
import com.hazeldev.holidaytripbackend.repositories.PlannedTripsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class InPlanningTripService {

    @NonNull
    private final InPlanningTripRepository inPlanningTripRepository;
    @NonNull
    private final InPlanningCheckpointsRepository inPlanningCheckpointRepository;
    @NonNull
    private final PlannedTripsRepository plannedTripsRepository;

    @Autowired
    public InPlanningTripService(InPlanningTripRepository inPlanningTripRepository, InPlanningCheckpointsRepository inPlanningCheckpointRepository,
            PlannedTripsRepository plannedTripsRepository) {
        this.inPlanningTripRepository = inPlanningTripRepository;
        this.inPlanningCheckpointRepository = inPlanningCheckpointRepository;
        this.plannedTripsRepository = plannedTripsRepository;
    }

    @Nullable
    public Integer saveInPlanningTripToDatabase(@NonNull AddInPlanningTripRequest request) {
        InPlanningTrip inPlanningTrip = new InPlanningTrip();

        inPlanningTrip.setUserId(request.getUserId());
        inPlanningTrip.setTripName(request.getTripName());
        inPlanningTrip.setTripDescription(request.getTripDescription());

        InPlanningTrip savedInPlanningTrip = inPlanningTripRepository.save(inPlanningTrip);
        return savedInPlanningTrip.getTripId();
    }

    @Nullable
    public Integer saveInPlanningCheckpointToDatabase(@NonNull AddInPlanningCheckpointRequest request) {
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

    public boolean deleteCheckpoint(@NonNull Integer checkpointId) {
        try {
            inPlanningCheckpointRepository.deleteById(checkpointId);
            return true;
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Nullable
    public Integer updateCheckpointLocation(@NonNull UpdateCheckpointLocationRequest request) {
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

    @NonNull
    public InPlanningTrip getCurrentInPlanningTrip(@NonNull Integer userId) {
        return inPlanningTripRepository.findFirstByUserId(userId);
    }

    @NonNull
    public Integer moveInPlanningTripToPlannedRepository(@NonNull Integer userId) {

        InPlanningTrip inPlanningTrip = inPlanningTripRepository.findFirstByUserId(userId);

        PlannedTrip plannedTrip = new PlannedTrip();
        plannedTrip.setPlannedTripId(inPlanningTrip.getTripId());
        plannedTrip.setPlannedTripName(inPlanningTrip.getTripName());
        plannedTrip.setPlannedTripDescription(inPlanningTrip.getTripDescription());

        Set<InPlanningCheckpoint> inPlanningCheckpoints = inPlanningTrip.getInPlanningCheckpoints();
        List<PlannedCheckpoint> plannedCheckpoints = new ArrayList<>();
        for (InPlanningCheckpoint inPlanningCheckpoint : inPlanningCheckpoints) {
            PlannedCheckpoint plannedCheckpoint = new PlannedCheckpoint();

            plannedCheckpoint.setCheckpointTitle(inPlanningCheckpoint.getCheckpointTitle());
            plannedCheckpoint.setPlannedTripId(inPlanningCheckpoint.getTripId());
            plannedCheckpoint.setCheckpointDescription(inPlanningCheckpoint.getCheckpointDescription());
            plannedCheckpoint.setCheckpointLatitude(inPlanningCheckpoint.getCheckpointLatitude());
            plannedCheckpoint.setCheckpointLongitude(inPlanningCheckpoint.getCheckpointLongitude());
            plannedCheckpoint.setAreArrivalNotificationsEnabled(inPlanningCheckpoint.areArrivalNotificationsEnabled());
            plannedCheckpoint.setAreDepartureNotificationsEnabled(inPlanningCheckpoint.areDepartureNotificationsEnabled());

            plannedCheckpoints.add(plannedCheckpoint);
        }
        plannedTrip.setPlannedTripCheckpoints(plannedCheckpoints);

        PlannedTrip savedPlannedTrip = plannedTripsRepository.save(plannedTrip);
        inPlanningTripRepository.delete(inPlanningTrip);

        return savedPlannedTrip.getPlannedTripId();
    }
}
