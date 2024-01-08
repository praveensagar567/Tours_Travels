package com.TourTravel.service;



import com.TourTravel.entity.Destination;

import java.util.List;

public interface DestinationService {
    Destination createDestination(Destination destination);
    List<Destination> getAllDestinations();
    Destination getDestinationById(Long id);
    void deleteDestination(Long id);
    // Add other methods as needed
}
