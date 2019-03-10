package com.hazeldev.holidaytripbackend.repositories;

import com.hazeldev.holidaytripbackend.models.database.InPlanningCheckpoint;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface InPlanningCheckpointsRepository extends CrudRepository<InPlanningCheckpoint, Integer> {

    @Transactional
    Long deleteByCheckpointIdAndTripId(Integer checkpointId, Integer tripId);

}
