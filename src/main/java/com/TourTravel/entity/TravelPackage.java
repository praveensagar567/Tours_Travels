package com.TourTravel.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TravelPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int passengerCapacity;

    @OneToMany(mappedBy = "travelPackage", cascade = CascadeType.ALL)
    private List<Destination> itinerary;

    @OneToMany(mappedBy = "travelPackage", cascade = CascadeType.ALL)
    private List<Passenger> passengers;

    // Constructors
    public TravelPackage() {
    }

    public TravelPackage(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.itinerary = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public List<Destination> getItinerary() {
        return itinerary;
    }

    public void setItinerary(List<Destination> itinerary) {
        this.itinerary = itinerary;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    // Method to add a destination to the itinerary
    public void addDestinationToItinerary(Destination destination) {
        itinerary.add(destination);
        destination.setTravelPackage(this);
    }

    // Other methods...

    // toString method for better logging and debugging
    @Override
    public String toString() {
        return "TravelPackage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passengerCapacity=" + passengerCapacity +
                ", itinerary=" + itinerary +
                ", passengers=" + passengers +
                '}';
    }
}
