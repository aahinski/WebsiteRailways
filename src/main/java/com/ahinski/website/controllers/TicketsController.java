package com.ahinski.website.controllers;

import com.ahinski.website.models.Ticket;
import com.ahinski.website.repo.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}