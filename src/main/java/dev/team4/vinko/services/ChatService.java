package dev.team4.vinko.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.team4.vinko.entities.Chat;
import dev.team4.vinko.repositories.ChatRepository;

@Service
public class ChatService {
    private final ChatRepository repository;

    public ChatService(ChatRepository repository) {
        this.repository = repository;
    }

    public List<Chat> getAllChats() {
        return repository.findAll();
    }

    public Optional<Chat> getChatById(Long id) {
        return repository.findById(id);
    }

    public Chat createChat(Chat chat) {
        return repository.save(chat);
    }

    public Chat updateChat(Long id, Chat updatedChat) {
        return repository.findById(id).map(chat -> {
            chat.setMessage(updatedChat.getMessage());
            chat.setSentDate(updatedChat.getSentDate());
            chat.setElderlyUser(updatedChat.getElderlyUser());
            chat.setCompanion(updatedChat.getCompanion());
            return repository.save(chat);
        }).orElseThrow(() -> new RuntimeException("Chat not found"));
    }

    // Delete a chat by ID
    public void deleteChat(Long id) {
        repository.deleteById(id);
    }
}