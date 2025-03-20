package dev.team4.vinko.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Companion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private String description;
    private String photoUrl;
    private Double hourlyRate;
    private Double rating;

    @OneToMany(mappedBy = "companion", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Review> reviews;

    @OneToMany(mappedBy = "companion", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Notification> notifications;

    @OneToMany(mappedBy = "companion", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ContactRequest> contactRequests;

    @ManyToMany
    @JoinTable(
        name = "companion_activity",
        joinColumns = @JoinColumn(name = "companion_id"),
        inverseJoinColumns = @JoinColumn(name = "activity_id")
    )
    private List<Activity> activities;

    public Companion() {
    }

    public Companion(Long id, String name, Integer age, String email, String description, Double hourlyRate, Double rating) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.description = description;
        this.hourlyRate = hourlyRate;
        this.rating = rating;
    }
}