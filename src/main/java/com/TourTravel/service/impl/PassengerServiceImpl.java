package com.TourTravel.service.impl;

// PassengerServiceImpl.java

import com.TourTravel.entity.Activity;
import com.TourTravel.entity.Passenger;
import com.TourTravel.repository.ActivityRepository;
import com.TourTravel.repository.PassengerRepository;
import com.TourTravel.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository;
    private final ActivityRepository activityRepository; // Add this field


    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository, ActivityRepository activityRepository) {
        this.passengerRepository = passengerRepository;
        this.activityRepository = activityRepository;
    }

    @Override
    public Passenger createPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    @Override
    public Passenger getPassengerById(Long id) {
        Optional<Passenger> optionalPassenger = passengerRepository.findById(id);
        return optionalPassenger.orElse(null);
    }

    @Override
    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }

    @Override
    public void signUpPassengerForActivity(Long passengerId, Long activityId) {
        // Fetch passenger and activity from repositories
        Passenger passenger = passengerRepository.findById(passengerId).orElse(null);
        Activity activity = activityRepository.findById(activityId).orElse(null);

        // Check if passenger and activity exist
        if (passenger != null && activity != null) {
            // Sign up the passenger for the activity
            passenger.signUpForActivity(activity);
            passengerRepository.save(passenger);
        }
    }
    // Add other method implementations as needed
}
