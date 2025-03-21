package dev.team4.vinko.services;

import java.util.List;

import org.springframework.stereotype.Service;


import dev.team4.vinko.entities.ElderlyUser;
import dev.team4.vinko.repositories.ElderlyUserRepository;

    @Service
    public class ElderlyUserService {
        private final ElderlyUserRepository repository;

        public ElderlyUserService(ElderlyUserRepository repository) {
            this.repository = repository;
        }

        public List<ElderlyUser> getAllUsers() {
            return repository.findAll();
        }

        public ElderlyUser createUser(ElderlyUser user) {
            return repository.save(user);
        }

        public ElderlyUser getUserById(Long id) {
            return repository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        }

        public ElderlyUser updateUser(Long id, ElderlyUser updatedUser) {
            return repository.findById(id).map(user -> {
                user.setName(updatedUser.getName());
                user.setEmail(updatedUser.getEmail());
                user.setPhone(updatedUser.getPhone());
                return repository.save(user);
            }).orElseThrow(() -> new RuntimeException("User not found"));
        }

        public void deleteUser(Long id) {
            repository.deleteById(id);
        }
    }

