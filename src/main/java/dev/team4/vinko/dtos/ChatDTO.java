package dev.team4.vinko.dtos;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ChatDTO {
    private Long companionId;
    private Long elderlyUserId;
    private String message;
}