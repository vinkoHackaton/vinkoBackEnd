package dev.team4.vinko.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer stars;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "elderly_user_id")
    @JsonBackReference
    private ElderlyUser elderlyUser;

    @ManyToOne
    @JoinColumn(name = "companion_id")
    @JsonBackReference("companion-review")
    private Companion companion;


}