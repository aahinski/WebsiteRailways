package com.ahinski.website.repo;

import com.ahinski.website.models.Route;
import com.ahinski.website.models.StationInformation;
import org.springframework.data.repository.CrudRepository;

public interface StationInformationRepository extends CrudRepository<StationInformation, Long> {
}
