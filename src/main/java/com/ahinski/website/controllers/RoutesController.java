package com.ahinski.website.controllers;

import com.ahinski.website.models.Route;
import com.ahinski.website.models.Station;
import com.ahinski.website.models.StationInformation;
import com.ahinski.website.repo.RouteRepository;
import com.ahinski.website.repo.StationInformationRepository;
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
public class RoutesController {

    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private StationRepository stationRepository;

    @GetMapping("/routes")
    public String routesMain(Model model) {
        Iterable<Route> routes = routeRepository.findAll();
        model.addAttribute("routes", routes);
        return "routes-main";
    }

    @GetMapping("/routes/{id}")
    public String routesDetails(@PathVariable(value="id") Long id, Model model) {
        Optional<Route> routesOptional = routeRepository.findById(id);
        List<Route> route = new ArrayList<>();
        routesOptional.ifPresent(route :: add);
        model.addAttribute("route", route);
        List<Station> names = new ArrayList<>();
        List<StationInformation> stationInformations = route.get(0).getStationInformationList();
        for(StationInformation s : stationInformations)
            names.add(s.getStation());
        model.addAttribute("station", stationInformations);
        model.addAttribute("names", names);
        return "routes-details";
    }

}