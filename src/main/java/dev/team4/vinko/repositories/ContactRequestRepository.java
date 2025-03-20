package dev.team4.vinko.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.team4.vinko.entities.ContactRequest;

@Repository
public interface ContactRequestRepository extends JpaRepository<ContactRequest, Long> {
    List<ContactRequest> findByElderlyUserId(Long elderlyUserId);
    List<ContactRequest> findByCompanionId(Long companionId);
}