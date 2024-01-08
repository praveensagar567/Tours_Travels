package com.TourTravel.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "travel_package_id")
    private TravelPackage travelPackage;

    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL)
    private List<Activity> activities;

    // Additional field to track remaining capacity of activities
    @Transient
    private int remainingCapacity;

    // Constructors
    public Destination() {
    }

    public Destination(String name, TravelPackage travelPackage) {
        this.name = name;
        this.travelPackage = travelPackage;
        this.remainingCapacity = calculateRemainingCapacity();
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

    public TravelPackage getTravelPackage() {
        return travelPackage;
    }

    public void setTravelPackage(TravelPackage travelPackage) {
        this.travelPackage = travelPackage;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
        this.remainingCapacity = calculateRemainingCapacity();
    }

    public int getRemainingCapacity() {
        return remainingCapacity;
    }

    public void setRemainingCapacity(int remainingCapacity) {
        this.remainingCapacity = remainingCapacity;
    }

    // Method to calculate the remaining capacity based on activities
    private int calculateRemainingCapacity() {
        int totalCapacity = 0;
        if (activities != null) {
            for (Activity activity : activities) {
                totalCapacity += activity.getRemainingCapacity();
            }
        }
        return totalCapacity;
    }

    // Other existing methods...

    // toString method for better logging and debugging
    @Override
    public String toString() {
        return "Destination{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", travelPackage=" + travelPackage +
                ", activities=" + activities +
                ", remainingCapacity=" + remainingCapacity +
                '}';
    }
}
