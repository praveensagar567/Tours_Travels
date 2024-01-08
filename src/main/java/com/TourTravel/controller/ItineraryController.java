package com.TourTravel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/itinerary")
public class ItineraryController {
    private final PrinterServiceImpl printerService;

    @Autowired
    public ItineraryController(PrinterServiceImpl printerService) {
        this.printerService = printerService;
    }

    @GetMapping("/print")
    public void printItinerary() {
        printerService.printItinerary();
    }
}
