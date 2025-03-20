package dev.team4.vinko.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import dev.team4.vinko.entities.Companion;
import dev.team4.vinko.repositories.CompanionRepository;

@Service
public class CompanionService {
    private final CompanionRepository repository;

    public CompanionService(CompanionRepository repository) {
        this.repository = repository;
    }

    public List<Companion> getAllCompanions() {
        return repository.findAll();
    }

    public Optional<Companion> getCompanionById(Long id) {
        return repository.findById(id);
    }

    public Companion createCompanion(Companion companion) {
        return repository.save(companion);
    }

    public Companion updateCompanion(Long id, Companion updatedCompanion) {
        return repository.findById(id).map(companion -> {
            companion.setName(updatedCompanion.getName());
            companion.setAge(updatedCompanion.getAge());
            companion.setEmail(updatedCompanion.getEmail());
            companion.setDescription(updatedCompanion.getDescription());
            companion.setHourlyRate(updatedCompanion.getHourlyRate());
            return repository.save(companion);
        }).orElseThrow(() -> new RuntimeException("Companion not found"));
    }

    public void deleteCompanion(Long id) {
        repository.deleteById(id);
    }
}
