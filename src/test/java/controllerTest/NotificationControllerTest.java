package controllerTest;
import dev.team4.vinko.controllers.NotificationController;
import dev.team4.vinko.entities.Notification;
import dev.team4.vinko.repositories.NotificationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class NotificationControllerTest {

    private MockMvc mockMvc;

    @Mock
    private NotificationRepository repository;

    @InjectMocks
    private NotificationController notificationController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(notificationController).build();
    }

    @Test
    void getAllNotifications() throws Exception {
        // Datos de prueba
        Notification notification1 = new Notification(1L, "Notification 1", "Content 1");
        Notification notification2 = new Notification(2L, "Notification 2", "Content 2");
        List<Notification> notifications = Arrays.asList(notification1, notification2);

        // Simulación del repositorio
        when(repository.findAll()).thenReturn(notifications);

        // Ejecutar la solicitud y verificar el resultado
        mockMvc.perform(get("/api/notifications"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].title").value("Notification 1"))
                .andExpect(jsonPath("$[0].content").value("Content 1"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].title").value("Notification 2"))
                .andExpect(jsonPath("$[1].content").value("Content 2"));

        // Verificar que el repositorio se llamó correctamente
        verify(repository, times(1)).findAll();
    }

    @Test
    void createNotification() throws Exception {
        // Datos de prueba
        Notification notification = new Notification(1L, "New Notification", "New Content");

        // Simulación del repositorio
        when(repository.save(any(Notification.class))).thenReturn(notification);

        // Ejecutar la solicitud y verificar el resultado
        mockMvc.perform(post("/api/notifications")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"New Notification\",\"content\":\"New Content\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.title").value("New Notification"))
                .andExpect(jsonPath("$.content").value("New Content"));

        // Verificar que el repositorio se llamó correctamente
        verify(repository, times(1)).save(any(Notification.class));
    }

    @Test
    void getNotificationById() throws Exception {
        // Datos de prueba
        Notification notification = new Notification(1L, "Notification 1", "Content 1");

        // Simulación del repositorio
        when(repository.findById(1L)).thenReturn(Optional.of(notification));

        // Ejecutar la solicitud y verificar el resultado
        mockMvc.perform(get("/api/notifications/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.title").value("Notification 1"))
                .andExpect(jsonPath("$.content").value("Content 1"));

        // Verificar que el repositorio se llamó correctamente
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void getNotificationById_NotFound() throws Exception {
        // Simulación del repositorio para un ID no encontrado
        when(repository.findById(1L)).thenReturn(Optional.empty());

        // Ejecutar la solicitud y verificar el resultado
        mockMvc.perform(get("/api/notifications/1"))
                .andExpect(status().isNotFound());

        // Verificar que el repositorio se llamó correctamente
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void deleteNotification() throws Exception {
        // Simulación del repositorio
        doNothing().when(repository).deleteById(1L);

        // Ejecutar la solicitud y verificar el resultado
        mockMvc.perform(delete("/api/notifications/1"))
                .andExpect(status().isOk());

        // Verificar que el repositorio se llamó correctamente
        verify(repository, times(1)).deleteById(1L);
    }
}


