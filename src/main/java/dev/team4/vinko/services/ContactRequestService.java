package dev.team4.vinko.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.team4.vinko.entities.ContactRequest;
import dev.team4.vinko.repositories.ContactRequestRepository;

@Service
public class ContactRequestService {
    private final ContactRequestRepository repository;

    public ContactRequestService(ContactRequestRepository repository) {
        this.repository = repository;
    }

    public List<ContactRequest> getAllRequests() {
        return repository.findAll();
    }

    public Optional<ContactRequest> getRequestById(Long id) {
        return repository.findById(id);
    }

    public ContactRequest createRequest(ContactRequest request) {
        return repository.save(request);
    }

    public ContactRequest updateRequest(Long id, ContactRequest updatedRequest) {
        return repository.findById(id).map(request -> {
            request.setMessage(updatedRequest.getMessage());
            request.setRequestedDate(updatedRequest.getRequestedDate());
            request.setCompanion(updatedRequest.getCompanion());
            request.setElderlyUser(updatedRequest.getElderlyUser());
            return repository.save(request);
        }).orElseThrow(() -> new RuntimeException("Contact request not found"));
    }

    public void deleteRequest(Long id) {
        repository.deleteById(id);
    }
}
