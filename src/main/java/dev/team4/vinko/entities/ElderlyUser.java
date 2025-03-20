package dev.team4.vinko.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class ElderlyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "elderlyUser", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @OneToMany(mappedBy = "elderlyUser", cascade = CascadeType.ALL)
    private List<ContactRequest> contactRequests;

}
