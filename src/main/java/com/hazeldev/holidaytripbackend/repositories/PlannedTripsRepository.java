package com.hazeldev.holidaytripbackend.repositories;

import com.hazeldev.holidaytripbackend.models.database.PlannedTrip;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.List;

public interface PlannedTripsRepository extends CrudRepository<PlannedTrip, Integer> {

    List<PlannedTrip> findByUserId(@NonNull Integer userId);
}
