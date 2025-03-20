package dev.team4.vinko.controllers;

import dev.team4.vinko.entities.Chat;
import dev.team4.vinko.entities.Companion;
import dev.team4.vinko.entities.ElderlyUser;
import dev.team4.vinko.dto.ChatDTO;
import dev.team4.vinko.repository.ChatRepository;
import dev.team4.vinko.repository.CompanionRepository;
import dev.team4.vinko.repository.ElderlyUserRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

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
