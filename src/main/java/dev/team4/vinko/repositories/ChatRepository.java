package dev.team4.vinko.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.team4.vinko.entities.Chat;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
