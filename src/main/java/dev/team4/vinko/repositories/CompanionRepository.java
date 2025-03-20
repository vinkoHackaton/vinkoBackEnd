package dev.team4.vinko.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.team4.vinko.model.Companion;

public interface CompanionRepository extends JpaRepository<Companion, Long> {
}

