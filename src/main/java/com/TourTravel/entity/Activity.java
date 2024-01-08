package com.TourTravel.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double cost;
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;

    @ManyToMany(mappedBy = "activities")
    private List<Passenger> passengers;

    // Additional field to track remaining capacity
    private int remainingCapacity;

    // Constructors
    public Activity() {
    }

    public Activity(String name, String description, double cost, int capacity, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
        this.remainingCapacity = capacity;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public int getRemainingCapacity() {
        return remainingCapacity;
    }

    public void setRemainingCapacity(int remainingCapacity) {
        this.remainingCapacity = remainingCapacity;
    }

    // Method to check if there are available spaces
    public boolean hasAvailableSpaces() {
        return remainingCapacity > 0;
    }

    // Other existing methods...

    // toString method for better logging and debugging
    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", capacity=" + capacity +
                ", destination=" + destination +
                ", passengers=" + passengers +
                ", remainingCapacity=" + remainingCapacity +
                '}';
    }
}
