package com.TourTravel.controller;
// TravelPackageController.java

import com.TourTravel.entity.TravelPackage;
import com.TourTravel.service.TravelPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/travel-packages")
public class TravelPackageController {
    private final TravelPackageService travelPackageService;

    @Autowired
    public TravelPackageController(TravelPackageService travelPackageService) {
        this.travelPackageService = travelPackageService;
    }

    @PostMapping
    public ResponseEntity<TravelPackage> createTravelPackage(@RequestBody TravelPackage travelPackage) {
        TravelPackage createdTravelPackage = travelPackageService.createTravelPackage(travelPackage);
        return new ResponseEntity<>(createdTravelPackage, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TravelPackage>> getAllTravelPackages() {
        List<TravelPackage> travelPackages = travelPackageService.getAllTravelPackages();
        return new ResponseEntity<>(travelPackages, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TravelPackage> getTravelPackageById(@PathVariable Long id) {
        TravelPackage travelPackage = travelPackageService.getTravelPackageById(id);
        if (travelPackage != null) {
            return new ResponseEntity<>(travelPackage, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTravelPackage(@PathVariable Long id) {
        travelPackageService.deleteTravelPackage(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Add other endpoints as needed
}
