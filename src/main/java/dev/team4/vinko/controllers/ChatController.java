package dev.team4.vinko.controllers;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Chat sendMessage(@RequestBody ChatDTO chatDTO) {
        ElderlyUser elderlyUser = elderlyUserRepository.findById(chatDTO.getElderlyUserId()).orElse(null);
        Companion companion = companionRepository.findById(chatDTO.getCompanionId()).orElse(null);

        if (elderlyUser == null || companion == null) {
            throw new RuntimeException("Elderly User or Companion not found");
        }

        Chat chat = new Chat();
        chat.setMessage(chatDTO.getMessage());
        chat.setSentDate(LocalDateTime.now());
        chat.setElderlyUser(elderlyUser);
        chat.setCompanion(companion);

        return chatRepository.save(chat);
    }
}
