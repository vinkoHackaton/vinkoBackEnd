package dev.team4.vinko.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.team4.vinko.model.Notification;
import dev.team4.vinko.repository.NotificationRepository;

@Service
public class NotificationService {
    private final NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    public List<Notification> getAllNotifications() {
        return repository.findAll();
    }

    public Optional<Notification> getNotificationById(Long id) {
        return repository.findById(id);
    }

    public Notification createNotification(Notification notification) {
        return repository.save(notification);
    }

    public Notification updateNotification(Long id, Notification updatedNotification) {
        return repository.findById(id).map(notification -> {
            notification.setMessage(updatedNotification.getMessage());
            notification.setTimestamp(updatedNotification.getTimestamp());
            notification.setCompanion(updatedNotification.getCompanion());
            return repository.save(notification);
        }).orElseThrow(() -> new RuntimeException("Notification not found"));
    }

    public void deleteNotification(Long id) {
        repository.deleteById(id);
    }
}
