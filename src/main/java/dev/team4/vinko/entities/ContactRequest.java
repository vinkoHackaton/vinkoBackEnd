package dev.team4.vinko.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class ContactRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private LocalDateTime requestedDate;

    @ManyToOne
    @JoinColumn(name = "elderly_user_id")
    private ElderlyUser elderlyUser;

    @ManyToOne
    @JoinColumn(name = "companion_id")
    private Companion companion;

  
}
