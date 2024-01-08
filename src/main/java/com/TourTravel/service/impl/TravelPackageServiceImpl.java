package com.TourTravel.service.impl;

// TravelPackageServiceImpl.java

import com.TourTravel.entity.TravelPackage;
import com.TourTravel.repository.TravelPackageRepository;
import com.TourTravel.service.TravelPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TravelPackageServiceImpl implements TravelPackageService {
    private final TravelPackageRepository travelPackageRepository;

    @Autowired
    public TravelPackageServiceImpl(TravelPackageRepository travelPackageRepository) {
        this.travelPackageRepository = travelPackageRepository;
    }

    @Override
    public TravelPackage createTravelPackage(TravelPackage travelPackage) {
        // Implement creation logic
        return travelPackageRepository.save(travelPackage);
    }

    @Override
    public List<TravelPackage> getAllTravelPackages() {
        // Implement retrieval logic
        return travelPackageRepository.findAll();
    }

    @Override
    public TravelPackage getTravelPackageById(Long id) {
        Optional<TravelPackage> optionalTravelPackage = travelPackageRepository.findById(id);
        return optionalTravelPackage.orElse(null);
    }

    @Override
    public void deleteTravelPackage(Long id) {
        travelPackageRepository.deleteById(id);
    }

    // Add other method implementations as needed
}
