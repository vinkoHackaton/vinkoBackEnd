package dev.team4.vinko.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.team4.vinko.entities.Activity;
import dev.team4.vinko.repositories.ActivityRepository;

@Service
public class ActivityService {
    private final ActivityRepository repository;

    public ActivityService(ActivityRepository repository) {
        this.repository = repository;
    }

    public List<Activity> getAllActivities() {
        return repository.findAll();
    }

    public Optional<Activity> getActivityById(Long id) {
        return repository.findById(id);
    }

    public Activity createActivity(Activity activity) {
        return repository.save(activity);
    }

    public Activity updateActivity(Long id, Activity updatedActivity) {
        return repository.findById(id).map(activity -> {
            activity.setName(updatedActivity.getName());
            activity.setDescription(updatedActivity.getDescription());
            return repository.save(activity);
        }).orElseThrow(() -> new RuntimeException("Activity not found"));
    }

    public void deleteActivity(Long id) {
        repository.deleteById(id);
    }
}
