package controllerTest;
import dev.team4.vinko.controllers.ElderlyUserController;
import dev.team4.vinko.entities.ElderlyUser;
import dev.team4.vinko.repositories.ElderlyUserRepository;
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

class ElderlyUserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ElderlyUserRepository repository;

    @InjectMocks
    private ElderlyUserController elderlyUserController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(elderlyUserController).build();
    }

    @Test
    void getAllUsers() throws Exception {
        // Datos de prueba

        ElderlyUser user1 = new ElderlyUser(1L, "John Doe", "john@example.com", "123456789");
        ElderlyUser user2 = new ElderlyUser(2L, "Jane Doe", "jane@example.com", "987654321");

        ElderlyUser user1 = new ElderlyUser();
        ElderlyUser user2 = new ElderlyUser();

        List<ElderlyUser> users = Arrays.asList(user1, user2);

        // Simulación del repositorio
        when(repository.findAll()).thenReturn(users);

        // Ejecutar la solicitud y verificar el resultado
        mockMvc.perform(get("/api/elderly-users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("John Doe"))
                .andExpect(jsonPath("$[0].email").value("john@example.com"))
                .andExpect(jsonPath("$[0].phone").value("123456789"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].name").value("Jane Doe"))
                .andExpect(jsonPath("$[1].email").value("jane@example.com"))
                .andExpect(jsonPath("$[1].phone").value("987654321"));

        // Verificar que el repositorio se llamó correctamente
        verify(repository, times(1)).findAll();
    }

    @Test
    void createUser() throws Exception {
        // Datos de prueba

        ElderlyUser user = new ElderlyUser(1L, "John Doe", "john@example.com", "123456789");

        ElderlyUser user = new ElderlyUser();


        // Simulación del repositorio
        when(repository.save(any(ElderlyUser.class))).thenReturn(user);

        // Ejecutar la solicitud y verificar el resultado
        mockMvc.perform(post("/api/elderly-users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"John Doe\",\"email\":\"john@example.com\",\"phone\":\"123456789\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.email").value("john@example.com"))
                .andExpect(jsonPath("$.phone").value("123456789"));

        // Verificar que el repositorio se llamó correctamente
        verify(repository, times(1)).save(any(ElderlyUser.class));
    }

    @Test
    void getUserById() throws Exception {
        // Datos de prueba

        ElderlyUser user = new ElderlyUser(1L, "John Doe", "john@example.com", "123456789");

        ElderlyUser user = new ElderlyUser();


        // Simulación del repositorio
        when(repository.findById(1L)).thenReturn(Optional.of(user));

        // Ejecutar la solicitud y verificar el resultado
        mockMvc.perform(get("/api/elderly-users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.email").value("john@example.com"))
                .andExpect(jsonPath("$.phone").value("123456789"));

        // Verificar que el repositorio se llamó correctamente
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void getUserById_NotFound() throws Exception {
        // Simulación del repositorio para un ID no encontrado
        when(repository.findById(1L)).thenReturn(Optional.empty());

        // Ejecutar la solicitud y verificar el resultado
        mockMvc.perform(get("/api/elderly-users/1"))
                .andExpect(status().isNotFound());

        // Verificar que el repositorio se llamó correctamente
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void updateUser() throws Exception {
        // Datos de prueba

        ElderlyUser existingUser = new ElderlyUser(1L, "John Doe", "john@example.com", "123456789");
        ElderlyUser updatedUser = new ElderlyUser(1L, "John Updated", "john.updated@example.com", "987654321");

        ElderlyUser existingUser = new ElderlyUser();
        ElderlyUser updatedUser = new ElderlyUser();


        // Simulación del repositorio
        when(repository.findById(1L)).thenReturn(Optional.of(existingUser));
        when(repository.save(any(ElderlyUser.class))).thenReturn(updatedUser);

        // Ejecutar la solicitud y verificar el resultado
        mockMvc.perform(put("/api/elderly-users/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"John Updated\",\"email\":\"john.updated@example.com\",\"phone\":\"987654321\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("John Updated"))
                .andExpect(jsonPath("$.email").value("john.updated@example.com"))
                .andExpect(jsonPath("$.phone").value("987654321"));

        // Verificar que el repositorio se llamó correctamente
        verify(repository, times(1)).findById(1L);
        verify(repository, times(1)).save(any(ElderlyUser.class));
    }

    @Test
    void updateUser_NotFound() throws Exception {
        // Simulación del repositorio para un ID no encontrado
        when(repository.findById(1L)).thenReturn(Optional.empty());

        // Ejecutar la solicitud y verificar el resultado
        mockMvc.perform(put("/api/elderly-users/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"John Updated\",\"email\":\"john.updated@example.com\",\"phone\":\"987654321\"}"))
                .andExpect(status().isNotFound());

        // Verificar que el repositorio no se llamó para guardar
        verify(repository, times(1)).findById(1L);
        verify(repository, never()).save(any(ElderlyUser.class));
    }

    @Test
    void deleteUser() throws Exception {
        // Simulación del repositorio
        doNothing().when(repository).deleteById(1L);

        // Ejecutar la solicitud y verificar el resultado
        mockMvc.perform(delete("/api/elderly-users/1"))
                .andExpect(status().isOk());

        // Verificar que el repositorio se llamó correctamente
        verify(repository, times(1)).deleteById(1L);
    }
}
