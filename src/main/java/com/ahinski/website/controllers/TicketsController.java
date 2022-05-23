package com.ahinski.website.controllers;

import com.ahinski.website.models.Ticket;
import com.ahinski.website.repo.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/tickets")
    public String ticketsMain(Model model) {
        Iterable<Ticket> tickets = ticketRepository.findAll();
        model.addAttribute("tickets", tickets);
        return "tickets-main";
    }

    @GetMapping("/tickets/{id}")
    public String ticketsDetails(@PathVariable(value="id") Long id, Model model) {
        Optional<Ticket> ticketsOptional = ticketRepository.findById(id);
        List<Ticket> ticket = new ArrayList<>();
        ticketsOptional.ifPresent(ticket :: add);
        model.addAttribute("tickets", ticket);
        return "tickets-details";
    }

}