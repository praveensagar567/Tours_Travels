package com.TourTravel.service.impl;
// ActivityServiceImpl.java

import com.TourTravel.entity.Activity;
import com.TourTravel.repository.ActivityRepository;
import com.TourTravel.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityServiceImpl implements ActivityService {
    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public Activity createActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    @Override
    public Activity getActivityById(Long id) {
        Optional<Activity> optionalActivity = activityRepository.findById(id);
        return optionalActivity.orElse(null);
    }

    @Override
    public void deleteActivity(Long id) {
        activityRepository.deleteById(id);
    }

    // Add other method implementations as needed
}
