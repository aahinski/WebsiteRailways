package com.ahinski.website.controllers;

import com.ahinski.website.models.Ticket;
import com.ahinski.website.models.Train;
import com.ahinski.website.repo.TicketRepository;
import com.ahinski.website.repo.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class TrainsController {

    @Autowired
    private TrainRepository trainRepository;

    @GetMapping("/trains")
    public String trainsMain(Model model) {
        Iterable<Train> trains = trainRepository.findAll();
        model.addAttribute("trains", trains);
        return "trains-main";
    }

    @GetMapping("/trains/{id}")
    public String ticketsDetails(@PathVariable(value="id") Long id, Model model) {
        Optional<Train> trainsOptional = trainRepository.findById(id);
        List<Train> train = new ArrayList<>();
        trainsOptional.ifPresent(train :: add);
        model.addAttribute("trains", train);
        return "trains-details";
    }

}
