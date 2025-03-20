package dev.team4.vinko.controllers;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.team4.vinko.entities.ContactRequest;
import dev.team4.vinko.repositories.ContactRequestRepository;

@RestController
@RequestMapping("/api/contact-requests")
public class ContactRequestController {
    private final ContactRequestRepository repository;

    public ContactRequestController(ContactRequestRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ContactRequest> getAllRequests() {
        return repository.findAll();
    }

    @PostMapping
    public ContactRequest createRequest(@RequestBody ContactRequest request) {
        return repository.save(request);
    }

    @GetMapping("/{id}")
    public ContactRequest getRequestById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Request not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteRequest(@PathVariable Long id) {
        repository.deleteById(id);
    }
}



