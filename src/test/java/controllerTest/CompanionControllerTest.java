package controllerTest;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import dev.team4.vinko.controllers.CompanionController;
import dev.team4.vinko.dtos.CompanionDto;
import dev.team4.vinko.entities.Companion;
import dev.team4.vinko.repositories.CompanionRepository;

class CompanionControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CompanionRepository repository;

    @InjectMocks
    private CompanionController companionController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(companionController).build();
    }

    @Test
    void getAllCompanions() throws Exception {
        // Datos de prueba
        Companion companion1 = new Companion(1L, "John Doe", 30, "john@example.com", "Friendly companion", 20.0, 4.5);
        Companion companion2 = new Companion(2L, "Jane Doe", 25, "jane@example.com", "Helpful companion", 25.0, 4.8);
        List<Companion> companions = Arrays.asList(companion1, companion2);

        // Simulación del repositorio
        when(repository.findAll()).thenReturn(companions);

        // Ejecutar la solicitud y verificar el resultado
        mockMvc.perform(get("/api/companions"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("John Doe"))
                .andExpect(jsonPath("$[0].age").value(30))
                .andExpect(jsonPath("$[0].email").value("john@example.com"))
                .andExpect(jsonPath("$[0].description").value("Friendly companion"))
                .andExpect(jsonPath("$[0].hourlyRate").value(20.0))
                .andExpect(jsonPath("$[0].rating").value(4.5))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].name").value("Jane Doe"))
                .andExpect(jsonPath("$[1].age").value(25))
                .andExpect(jsonPath("$[1].email").value("jane@example.com"))
                .andExpect(jsonPath("$[1].description").value("Helpful companion"))
                .andExpect(jsonPath("$[1].hourlyRate").value(25.0))
                .andExpect(jsonPath("$[1].rating").value(4.8));

        // Verificar que el repositorio se llamó correctamente
        verify(repository, times(1)).findAll();
    }

    @Test
    void createCompanion() throws Exception {
        // Datos de prueba
        Companion companion = new Companion(1L, "John Doe", 30, "john@example.com", "Friendly companion", 20.0, 4.5);

        // Simulación del repositorio
        when(repository.save(any(Companion.class))).thenReturn(companion);

        // Ejecutar la solicitud y verificar el resultado
        mockMvc.perform(post("/api/companions")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"John Doe\",\"age\":30,\"email\":\"john@example.com\",\"description\":\"Friendly companion\",\"hourlyRate\":20.0,\"rating\":4.5}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.age").value(30))
                .andExpect(jsonPath("$.email").value("john@example.com"))
                .andExpect(jsonPath("$.description").value("Friendly companion"))
                .andExpect(jsonPath("$.hourlyRate").value(20.0))
                .andExpect(jsonPath("$.rating").value(4.5));

        // Verificar que el repositorio se llamó correctamente
        verify(repository, times(1)).save(any(Companion.class));
    }

    @Test
    void getCompanionById() throws Exception {
        // Datos de prueba
        Companion companion = new Companion(1L, "John Doe", 30, "john@example.com", "Friendly companion", 20.0, 4.5);

        // Simulación del repositorio
        when(repository.findById(1L)).thenReturn(Optional.of(companion));

        // Ejecutar la solicitud y verificar el resultado
        mockMvc.perform(get("/api/companions/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.age").value(30))
                .andExpect(jsonPath("$.email").value("john@example.com"))
                .andExpect(jsonPath("$.description").value("Friendly companion"))
                .andExpect(jsonPath("$.hourlyRate").value(20.0))
                .andExpect(jsonPath("$.rating").value(4.5));

        // Verificar que el repositorio se llamó correctamente
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void getCompanionById_NotFound() throws Exception {
        // Simulación del repositorio para un ID no encontrado
        when(repository.findById(1L)).thenReturn(Optional.empty());

        // Ejecutar la solicitud y verificar el resultado
        mockMvc.perform(get("/api/companions/1"))
                .andExpect(status().isNotFound());

        // Verificar que el repositorio se llamó correctamente
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void updateCompanion() throws Exception {
        // Datos de prueba
        Companion existingCompanion = new Companion(1L, "John Doe", 30, "john@example.com", "Friendly companion", 20.0, 4.5);
        CompanionDto updatedDTO = new CompanionDto(1L, "John Updated", 35, "john.updated@example.com", "Updated description", 25.0, 4.7);

        // Simulación del repositorio
        when(repository.findById(1L)).thenReturn(Optional.of(existingCompanion));
        when(repository.save(any(Companion.class))).thenReturn(existingCompanion);

        // Ejecutar la solicitud y verificar el resultado
        mockMvc.perform(put("/api/companions/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"John Updated\",\"age\":35,\"email\":\"john.updated@example.com\",\"description\":\"Updated description\",\"hourlyRate\":25.0,\"rating\":4.7}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("John Updated"))
                .andExpect(jsonPath("$.age").value(35))
                .andExpect(jsonPath("$.email").value("john.updated@example.com"))
                .andExpect(jsonPath("$.description").value("Updated description"))
                .andExpect(jsonPath("$.hourlyRate").value(25.0))
                .andExpect(jsonPath("$.rating").value(4.7));

        // Verificar que el repositorio se llamó correctamente
        verify(repository, times(1)).findById(1L);
        verify(repository, times(1)).save(any(Companion.class));
    }

    @Test
    void deleteCompanion() throws Exception {
        // Simulación del repositorio
        doNothing().when(repository).deleteById(1L);

        // Ejecutar la solicitud y verificar el resultado
        mockMvc.perform(delete("/api/companions/1"))
                .andExpect(status().isOk());

        // Verificar que el repositorio se llamó correctamente
        verify(repository, times(1)).deleteById(1L);
    }
}
