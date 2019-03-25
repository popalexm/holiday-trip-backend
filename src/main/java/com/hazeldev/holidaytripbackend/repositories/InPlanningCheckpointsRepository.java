package com.hazeldev.holidaytripbackend.repositories;

import com.hazeldev.holidaytripbackend.models.database.InPlanningCheckpoint;

import org.springframework.data.repository.CrudRepository;

public interface InPlanningCheckpointsRepository extends CrudRepository<InPlanningCheckpoint, Integer> {

}
