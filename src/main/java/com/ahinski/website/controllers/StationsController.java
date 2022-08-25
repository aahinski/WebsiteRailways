package com.ahinski.website.controllers;

import com.ahinski.website.models.Station;
import com.ahinski.website.repo.RouteRepository;
import com.ahinski.website.repo.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class StationsController {

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private RouteRepository routeRepository;

    @GetMapping("/stations")
    public String stationsMain(Model model) {
        Iterable<Station> stations = stationRepository.findAll();
        model.addAttribute("stations", stations);
        return "stations-main";
    }

    @GetMapping("/stations/{id}")
    public String stationsDetails(@PathVariable(value="id") Long id, Model model) {
        Optional<Station> stationOptional = stationRepository.findById(id);
        List<Station> station = new ArrayList<>();
        stationOptional.ifPresent(station :: add);
        model.addAttribute("station", station);
        return "stations-details";
    }

}
