package com.TourTravel.service;

import com.TourTravel.entity.TravelPackage;

import java.util.List;

public interface TravelPackageService {
    TravelPackage createTravelPackage(TravelPackage travelPackage);
    List<TravelPackage> getAllTravelPackages();
    TravelPackage getTravelPackageById(Long id);
    void deleteTravelPackage(Long id);
    // Add other methods as needed
}

