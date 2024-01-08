package com.TourTravel.service;


import com.TourTravel.entity.Activity;

import java.util.List;

public interface ActivityService {
    Activity createActivity(Activity activity);
    List<Activity> getAllActivities();
    Activity getActivityById(Long id);
    void deleteActivity(Long id);
    // Add other methods as needed
}
