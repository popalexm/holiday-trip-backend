package com.hazeldev.holidaytripbackend.repositories;

import com.hazeldev.holidaytripbackend.models.database.PlannedCheckpoint;
import org.springframework.data.repository.CrudRepository;

public interface PlannedCheckpointRepository extends CrudRepository<PlannedCheckpoint, Integer> {
}
