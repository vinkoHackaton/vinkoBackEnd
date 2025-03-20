package dev.team4.vinko.controllers;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import dev.team4.vinko.dtos.ChatDTO;
import dev.team4.vinko.entities.Chat;
import dev.team4.vinko.entities.Companion;
import dev.team4.vinko.entities.ElderlyUser;
import dev.team4.vinko.repositories.ChatRepository;
import dev.team4.vinko.repositories.CompanionRepository;
import dev.team4.vinko.repositories.ElderlyUserRepository;

@RestController
@RequestMapping("/api/chats")
public class ChatController {

    private final ChatRepository chatRepository;
    private final CompanionRepository companionRepository;
    private final ElderlyUserRepository elderlyUserRepository;

    public ChatController(ChatRepository chatRepository, CompanionRepository companionRepository, ElderlyUserRepository elderlyUserRepository) {
        this.chatRepository = chatRepository;
        this.companionRepository = companionRepository;
        this.elderlyUserRepository = elderlyUserRepository;
    }

    @PostMapping
    public ResponseEntity<Chat> sendMessage(@RequestBody ChatDTO chatDTO) {
        if (chatDTO.getMessage() == null || chatDTO.getMessage().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Message cannot be empty");
        }

        ElderlyUser elderlyUser = elderlyUserRepository.findById(chatDTO.getElderlyUserId())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Elderly User not found"));
        Companion companion = companionRepository.findById(chatDTO.getCompanionId())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Companion not found"));

        Chat chat = new Chat();
        chat.setMessage(chatDTO.getMessage());
        chat.setSentDate(LocalDateTime.now());
        chat.setElderlyUser(elderlyUser);
        chat.setCompanion(companion);

        Chat savedChat = chatRepository.save(chat);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedChat);
    }
}