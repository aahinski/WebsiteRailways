package com.ahinski.website.controllers;

import com.ahinski.website.models.*;
import com.ahinski.website.repo.TicketRepository;
import com.ahinski.website.repo.TrainRepository;
import com.ahinski.website.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class BuyTicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/buy-ticket/{train_id}")
    public String ticketInfo(@PathVariable(value="train_id") Long id, Model model) {
        Optional<Train> train = trainRepository.findById(id);
        List<Train> trains = new ArrayList<>();
        train.ifPresent(trains :: add);
        List<StationInformation> list = trains.get(0).getRoute().getStationInformationList();
        List<String> names = new ArrayList<>();
        for(StationInformation stationInformation : list)
            names.add(stationInformation.getStation().getName());
        model.addAttribute("train_id", id.toString());
        model.addAttribute("stations", list);
        model.addAttribute("names", names);
        model.addAttribute("ticket", new Ticket());
        return "buy-ticket";
    }

    @RequestMapping("/buy-ticket/{train_id}")
    public String buyTicket(
            @PathVariable(value="train_id") Long id,
            Model model,
            @RequestParam String firstName,
            @RequestParam String secondName,
            @RequestParam StationInformation arrivalStation,
            @RequestParam StationInformation departureStation,
            Train train,
            Authentication authentication)
    {
        User user = userRepository.findByUsername(authentication.getName());
        Long cost = arrivalStation.getCost() - departureStation.getCost();
        Ticket ticket = new Ticket(
                departureStation,
                arrivalStation, cost,
                firstName, secondName, train, user);
        ticketRepository.save(ticket);
        return "redirect:/tickets";
    }

}
