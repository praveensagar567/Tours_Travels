package com.TourTravel.controller;

import com.TourTravel.entity.Destination;
import com.TourTravel.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/destinations")
public class DestinationController {
    private final DestinationService destinationService;

    @Autowired
    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @PostMapping
    public ResponseEntity<Destination> createDestination(@RequestBody Destination destination) {
        Destination createdDestination = destinationService.createDestination(destination);
        return new ResponseEntity<>(createdDestination, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Destination>> getAllDestinations() {
        List<Destination> destinations = destinationService.getAllDestinations();
        return new ResponseEntity<>(destinations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destination> getDestinationById(@PathVariable Long id) {
        Destination destination = destinationService.getDestinationById(id);
        if (destination != null) {
            return new ResponseEntity<>(destination, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDestination(@PathVariable Long id) {
        destinationService.deleteDestination(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Add other endpoints as needed
}