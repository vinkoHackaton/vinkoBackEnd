package dev.team4.vinko.dtos;
import java.time.LocalDateTime;

public record ContactRequestDTO(Long id, Long elderlyUserId, Long companionId, String message, LocalDateTime requestedDate) {

}
