package dev.team4.vinko.dtos;
import java.time.LocalDateTime;
public record NotificationDTO(Long id, String message, LocalDateTime timestamp, Long companionId) {

}
