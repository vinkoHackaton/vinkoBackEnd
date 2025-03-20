package dev.team4.vinko.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.team4.vinko.entities.Notification;
import dev.team4.vinko.repositories.NotificationRepository;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    private final NotificationRepository repository;

    public NotificationController(NotificationRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Notification> getAllNotifications() {
        return repository.findAll();
    }

    @PostMapping
    public Notification createNotification(@RequestBody Notification notification) {
        return repository.save(notification);
    }

    @GetMapping("/{id}")
    public Notification getNotificationById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Notification not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteNotification(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

