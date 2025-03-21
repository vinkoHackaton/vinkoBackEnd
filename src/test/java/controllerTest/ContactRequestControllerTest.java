package controllerTest;
import dev.team4.vinko.controllers.ContactRequestController;
import dev.team4.vinko.entities.ContactRequest;
import dev.team4.vinko.repositories.ContactRequestRepository;
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

class ContactRequestControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ContactRequestRepository repository;

    @InjectMocks
    private ContactRequestController contactRequestController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(contactRequestController).build();
    }

    @Test
    void getAllRequests() throws Exception {
        
        ContactRequest request1 = new ContactRequest();
        ContactRequest request2 = new ContactRequest();

        ContactRequest request1 = new ContactRequest();
        ContactRequest request2 = new ContactRequest();

        List<ContactRequest> requests = Arrays.asList(request1, request2);

        // Simulación del repositorio
        when(repository.findAll()).thenReturn(requests);

        // Ejecutar la solicitud y verificar el resultado
        mockMvc.perform(get("/api/contact-requests"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("John Doe"))
                .andExpect(jsonPath("$[0].email").value("john@example.com"))
                .andExpect(jsonPath("$[0].message").value("Hello, I need help."))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].name").value("Jane Doe"))
                .andExpect(jsonPath("$[1].email").value("jane@example.com"))
                .andExpect(jsonPath("$[1].message").value("Can you assist me?"));

        // Verificar que el repositorio se llamó correctamente
        verify(repository, times(1)).findAll();
    }

    @Test
    void createRequest() throws Exception {
        // Datos de prueba

        ContactRequest request = new ContactRequest();

        ContactRequest request = new ContactRequest();


        // Simulación del repositorio
        when(repository.save(any(ContactRequest.class))).thenReturn(request);

        // Ejecutar la solicitud y verificar el resultado
        mockMvc.perform(post("/api/contact-requests")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"John Doe\",\"email\":\"john@example.com\",\"message\":\"Hello, I need help.\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.email").value("john@example.com"))
                .andExpect(jsonPath("$.message").value("Hello, I need help."));

        // Verificar que el repositorio se llamó correctamente
        verify(repository, times(1)).save(any(ContactRequest.class));
    }

    @Test
    void getRequestById() throws Exception {
        // Datos de prueba

        ContactRequest request = new ContactRequest();

        ContactRequest request = new ContactRequest();


        // Simulación del repositorio
        when(repository.findById(1L)).thenReturn(Optional.of(request));

        // Ejecutar la solicitud y verificar el resultado
        mockMvc.perform(get("/api/contact-requests/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.email").value("john@example.com"))
                .andExpect(jsonPath("$.message").value("Hello, I need help."));

        // Verificar que el repositorio se llamó correctamente
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void getRequestById_NotFound() throws Exception {
        // Simulación del repositorio para un ID no encontrado
        when(repository.findById(1L)).thenReturn(Optional.empty());

        // Ejecutar la solicitud y verificar el resultado
        mockMvc.perform(get("/api/contact-requests/1"))
                .andExpect(status().isNotFound());

        // Verificar que el repositorio se llamó correctamente
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void deleteRequest() throws Exception {
        // Simulación del repositorio
        doNothing().when(repository).deleteById(1L);

        // Ejecutar la solicitud y verificar el resultado
        mockMvc.perform(delete("/api/contact-requests/1"))
                .andExpect(status().isOk());

        // Verificar que el repositorio se llamó correctamente
        verify(repository, times(1)).deleteById(1L);
    }
}

