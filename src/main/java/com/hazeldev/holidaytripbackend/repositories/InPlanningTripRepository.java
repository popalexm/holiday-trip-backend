package com.hazeldev.holidaytripbackend.repositories;

import com.hazeldev.holidaytripbackend.models.database.InPlanningTrip;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

public interface InPlanningTripRepository extends CrudRepository<InPlanningTrip, Integer> {

    InPlanningTrip findFirstByUserId(@NonNull Integer userId);
}
