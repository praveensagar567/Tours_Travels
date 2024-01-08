package com.TourTravel.service;
// PassengerService.java


import com.TourTravel.entity.Passenger;

import java.util.List;

public interface PassengerService {
    Passenger createPassenger(Passenger passenger);
    List<Passenger> getAllPassengers();
    Passenger getPassengerById(Long id);
    void deletePassenger(Long id);

    void signUpPassengerForActivity(Long passengerId, Long activityId);

    // Add other methods as needed
}
