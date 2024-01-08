package com.TourTravel.service.impl;

// DestinationServiceImpl.java

import com.TourTravel.entity.Destination;
import com.TourTravel.repository.DestinationRepository;
import com.TourTravel.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinationServiceImpl implements DestinationService {
    private final DestinationRepository destinationRepository;

    @Autowired
    public DestinationServiceImpl(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    @Override
    public Destination createDestination(Destination destination) {
        return destinationRepository.save(destination);
    }

    @Override
    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }

    @Override
    public Destination getDestinationById(Long id) {
        Optional<Destination> optionalDestination = destinationRepository.findById(id);
        return optionalDestination.orElse(null);
    }

    @Override
    public void deleteDestination(Long id) {
        destinationRepository.deleteById(id);
    }

    // Add other method implementations as needed
}
