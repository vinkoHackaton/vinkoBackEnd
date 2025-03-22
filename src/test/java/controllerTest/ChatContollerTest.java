package controllerTest;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import dev.team4.vinko.controllers.ChatController;
import dev.team4.vinko.entities.Chat;
import dev.team4.vinko.entities.Companion;
import dev.team4.vinko.entities.ElderlyUser;
import dev.team4.vinko.repositories.ChatRepository;
import dev.team4.vinko.repositories.CompanionRepository;
import dev.team4.vinko.repositories.ElderlyUserRepository;

class ChatControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ChatRepository chatRepository;

    @Mock
    private CompanionRepository companionRepository;

    @Mock
    private ElderlyUserRepository elderlyUserRepository;

    @InjectMocks
    private ChatController chatController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(chatController).build();
    }

    @Test
    void sendMessage_Success() throws Exception {
        // Datos de prueba
        Long elderlyUserId = 1L;
        Long companionId = 1L;
        String message = "Hello, how are you?";
        LocalDateTime sentDate = LocalDateTime.now();

        ElderlyUser elderlyUser = new ElderlyUser();
        elderlyUser.setId(elderlyUserId);

        Companion companion = new Companion();
        companion.setId(companionId);

        Chat savedChat = new Chat();
        savedChat.setMessage(message);
        savedChat.setSentDate(sentDate);
        savedChat.setElderlyUser(elderlyUser);
        savedChat.setCompanion(companion);

        // Simulación de repositorios
        when(elderlyUserRepository.findById(elderlyUserId)).thenReturn(Optional.of(elderlyUser));
        when(companionRepository.findById(companionId)).thenReturn(Optional.of(companion));
        when(chatRepository.save(any(Chat.class))).thenReturn(savedChat);

        // Ejecutar la solicitud y verificar el resultado
        mockMvc.perform(post("/api/chats")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"message\":\"Hello, how are you?\",\"elderlyUserId\":1,\"companionId\":1}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.message").value(message))
                .andExpect(jsonPath("$.elderlyUser.id").value(elderlyUserId))
                .andExpect(jsonPath("$.companion.id").value(companionId));

        // Verificar que los métodos del repositorio se llamaron correctamente
        verify(elderlyUserRepository, times(1)).findById(elderlyUserId);
        verify(companionRepository, times(1)).findById(companionId);
        verify(chatRepository, times(1)).save(any(Chat.class));
    }

    @Test
    void sendMessage_EmptyMessage() throws Exception {
        // Ejecutar la solicitud con un mensaje vacío
        mockMvc.perform(post("/api/chats")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"message\":\"\",\"elderlyUserId\":1,\"companionId\":1}"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Message cannot be empty"));

        // Verificar que no se llamó a ningún repositorio
        verify(elderlyUserRepository, never()).findById(any());
        verify(companionRepository, never()).findById(any());
        verify(chatRepository, never()).save(any());
    }

    @Test
    void sendMessage_ElderlyUserNotFound() throws Exception {
        // Datos de prueba
        Long elderlyUserId = 1L;
        // Simulación de repositorio para usuario no encontrado
        when(elderlyUserRepository.findById(elderlyUserId)).thenReturn(Optional.empty());

        // Ejecutar la solicitud y verificar el resultado
        mockMvc.perform(post("/api/chats")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"message\":\"Hello, how are you?\",\"elderlyUserId\":1,\"companionId\":1}"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Elderly User not found"));

        // Verificar que no se llamó a los otros repositorios
        verify(elderlyUserRepository, times(1)).findById(elderlyUserId);
        verify(companionRepository, never()).findById(any());
        verify(chatRepository, never()).save(any());
    }

    @Test
    void sendMessage_CompanionNotFound() throws Exception {
        // Datos de prueba
        Long elderlyUserId = 1L;
        Long companionId = 1L;
        ElderlyUser elderlyUser = new ElderlyUser();
        elderlyUser.setId(elderlyUserId);

        // Simulación de repositorios
        when(elderlyUserRepository.findById(elderlyUserId)).thenReturn(Optional.of(elderlyUser));
        when(companionRepository.findById(companionId)).thenReturn(Optional.empty());

        // Ejecutar la solicitud y verificar el resultado
        mockMvc.perform(post("/api/chats")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"message\":\"Hello, how are you?\",\"elderlyUserId\":1,\"companionId\":1}"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Companion not found"));

        // Verificar que no se llamó al repositorio de chats
        verify(elderlyUserRepository, times(1)).findById(elderlyUserId);
        verify(companionRepository, times(1)).findById(companionId);
        verify(chatRepository, never()).save(any());
    }
}



