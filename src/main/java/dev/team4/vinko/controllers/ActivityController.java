package dev.team4.vinko.controllers;
import dev.team4.vinko.dtos.ActivityDTO;
import dev.team4.vinko.entities.Activity;
import dev.team4.vinko.repositories.ActivityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {
    private final ActivityRepository repository;

    public ActivityController(ActivityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Activity> getAllActivities() {
        return repository.findAll();
    }

    @PostMapping
    public Activity createActivity(@RequestBody Activity activity) {
        return repository.save(activity);
    }

    @GetMapping("/{id}")
    public Activity getActivityById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Activity not found"));
    }

    @PutMapping("/{id}")
    public ActivityDTO updateActivity(@PathVariable Long id, @RequestBody ActivityDTO updatedDTO) {
        return repository.findById(id).map(existingActivity -> {
            existingActivity.setName(updatedDTO.name());
            existingActivity.setDescription(updatedDTO.description());
            
            return convertToDTO(repository.save(existingActivity));
        }).orElseThrow(() -> new RuntimeException("Activity not found"));
    }

    private ActivityDTO convertToDTO(Activity activity) {
        return new ActivityDTO(activity.getId(), activity.getName(), activity.getDescription());
    }

    @DeleteMapping("/{id}")
    public void deleteActivity(@PathVariable Long id) {
        repository.deleteById(id);
    }
    
}