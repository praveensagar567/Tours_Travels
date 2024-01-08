package com.TourTravel.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String passengerNumber;
    private double balance;

    @Enumerated(EnumType.STRING)
    private PassengerType passengerType;

    @ManyToMany
    @JoinTable(
            name = "passenger_activity",
            joinColumns = @JoinColumn(name = "passenger_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id"))
    private List<Activity> activities;

    // Additional field for activities signed up
    @OneToMany(mappedBy = "passenger")
    private List<Activity> signedUpActivities;

    // Constructors
    public Passenger() {
        this.activities = new ArrayList<>();
        this.signedUpActivities = new ArrayList<>();
    }

    public Passenger(String name, String passengerNumber, double balance, PassengerType passengerType) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.balance = balance;
        this.passengerType = passengerType;
        this.activities = new ArrayList<>();
        this.signedUpActivities = new ArrayList<>();
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

    public String getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(String passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(PassengerType passengerType) {
        this.passengerType = passengerType;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public List<Activity> getSignedUpActivities() {
        return signedUpActivities;
    }

    public void setSignedUpActivities(List<Activity> signedUpActivities) {
        this.signedUpActivities = signedUpActivities;
    }

    // Method to sign up for an activity
    public void signUpForActivity(Activity activity) {
        if (activity.hasAvailableSpaces()) {
            signedUpActivities.add(activity);
            activity.getPassengers().add(this);
            activity.setRemainingCapacity(activity.getRemainingCapacity() - 1);

            // Deduct the appropriate amount from the balance based on passenger type
            if (passengerType == PassengerType.STANDARD) {
                balance -= activity.getCost();
            } else if (passengerType == PassengerType.GOLD) {
                double discountedCost = 0.9 * activity.getCost();
                balance -= discountedCost;
            }
            // Premium passengers sign up for free, so no deduction needed for them
        }
    }

    // Other methods...

    // toString method for better logging and debugging
    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passengerNumber='" + passengerNumber + '\'' +
                ", balance=" + balance +
                ", passengerType=" + passengerType +
                ", activities=" + activities +
                ", signedUpActivities=" + signedUpActivities +
                '}';
    }
}
