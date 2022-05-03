package com.ahinski.website.repo;

import com.ahinski.website.models.Station;
import org.springframework.data.repository.CrudRepository;

public interface StationRepository extends CrudRepository<Station, Long> {
}
