package com.ahinski.website.controllers;

import com.ahinski.website.models.StationInformation;
import com.ahinski.website.models.Ticket;
import com.ahinski.website.models.Train;
import com.ahinski.website.models.User;
import com.ahinski.website.repo.TicketRepository;
import com.ahinski.website.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class TicketsController {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/tickets")
    public String ticketsMain(Model model, Authentication authentication) {
        User user = userRepository.findByUsername(authentication.getName());
        Optional<Ticket> ticketsOptional = ticketRepository.findById(user.getId());
        List<Ticket> tickets = new ArrayList<>();
        ticketsOptional.ifPresent(tickets :: add);
       /* List<Train> trainList = new ArrayList<>();
        for(Ticket t : tickets)
            trainList.add(t.getTrain());
        List<String> departureNames = new ArrayList<>();
        for(Ticket t : tickets)
            departureNames.add(t.getDepartureStationId().getStation().getName());
        List<String> arrivalNames = new ArrayList<>();
        for(Ticket t : tickets)
            arrivalNames.add(t.getArrivalStationId().getStation().getName());
        model.addAttribute("trains", trainList);
        model.addAttribute("departureStations", departureNames);
        model.addAttribute("ArrivalStations", arrivalNames);
        */
        model.addAttribute("tickets", tickets);
        return "tickets-main";
    }
}