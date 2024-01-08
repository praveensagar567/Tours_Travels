package com.TourTravel.service.impl;

import com.TourTravel.service.ItineraryPrinter;
import com.TourTravel.service.PassengerPrinter;
import org.springframework.stereotype.Service;

@Service
public class PrinterServiceImpl implements ItineraryPrinter, PassengerPrinter, ActivityPrinter, TravelPackagePrinter {
    @Override
    public void printItinerary() {

    }

    @Override
    public void printPassengerList() {

    }

    @Override
    public void printPassengerDetails(Long passengerId) {

    }
    // Implement methods to print itinerary, passenger list, etc.
}
