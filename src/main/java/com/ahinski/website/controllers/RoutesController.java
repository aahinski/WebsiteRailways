package com.ahinski.website.controllers;

import com.ahinski.website.models.Route;
import com.ahinski.website.repo.RouteRepository;
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
        model.addAttribute("routes", route);
        return "routes-details";
    }

}