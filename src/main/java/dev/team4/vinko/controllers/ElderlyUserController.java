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
import dev.team4.vinko.entities.ElderlyUser;
import dev.team4.vinko.repositories.ElderlyUserRepository;

@RestController
@RequestMapping("/api/elderly-users")
public class ElderlyUserController {
    private final ElderlyUserRepository repository;

    public ElderlyUserController(ElderlyUserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ElderlyUser> getAllUsers() {
        return repository.findAll();
    }

    @PostMapping
    public ElderlyUser createUser(@RequestBody ElderlyUser user) {
        return repository.save(user);
    }

    @GetMapping("/{id}")
    public ElderlyUser getUserById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @PutMapping("/{id}")
    public ElderlyUser updateUser(@PathVariable Long id, @RequestBody ElderlyUser updatedUser) {
        return repository.findById(id).map(user -> {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setPhone(updatedUser.getPhone());
            return repository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}


