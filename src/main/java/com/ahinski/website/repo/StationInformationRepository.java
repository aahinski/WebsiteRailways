package com.ahinski.website.repo;

import com.ahinski.website.models.Route;
import com.ahinski.website.models.StationInformation;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StationInformationRepository extends CrudRepository<StationInformation, Long> {
   // @Query("SELECT s FROM station_information s WHERE s.route_id = ?")
    //Optional<StationInformation> findStationInformationsByRouteId(Long route_id);
}
