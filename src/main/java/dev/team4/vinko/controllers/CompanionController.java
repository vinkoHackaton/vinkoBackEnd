package dev.team4.vinko.controllers;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.team4.vinko.dtos.CompanionDto;
import dev.team4.vinko.entities.Companion;
import dev.team4.vinko.repositories.CompanionRepository;

@RestController
@RequestMapping("/api/companions")
public class CompanionController {
    private final CompanionRepository repository;

    public CompanionController(CompanionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Companion> getAllCompanions() {
        return repository.findAll();
    }

    @PostMapping
    public Companion createCompanion(@RequestBody Companion companion) {
        return repository.save(companion);
    }

    @GetMapping("/{id}")
    public Companion getCompanionById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Companion not found"));
    }

    @PutMapping("/{id}")
    public CompanionDto updateCompanion(@PathVariable Long id, @RequestBody CompanionDto updatedDTO) {
        return repository.findById(id).map(existingCompanion -> {
            existingCompanion.setName(updatedDTO.name());
            existingCompanion.setAge(updatedDTO.age());
            existingCompanion.setEmail(updatedDTO.email());
            existingCompanion.setDescription(updatedDTO.description());
            existingCompanion.setHourlyRate(updatedDTO.hourlyRate());

            return convertToDTO(repository.save(existingCompanion));
        }).orElseThrow(() -> new RuntimeException("Companion not found"));
    }

    private CompanionDto convertToDTO(Companion companion) {
        return new CompanionDto(
            companion.getId(),
            companion.getName(),
            companion.getAge(),
            companion.getEmail(),
            companion.getDescription(),
            companion.getHourlyRate(),
            companion.getRating()
        );
    }
    

    @DeleteMapping("/{id}")
    public void deleteCompanion(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

