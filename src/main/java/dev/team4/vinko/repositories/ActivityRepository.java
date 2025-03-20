package dev.team4.vinko.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.team4.vinko.entities.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}