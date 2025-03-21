package controllerTest;
import dev.team4.vinko.controllers.ActivityController;
import dev.team4.vinko.controllers.ActivityController;
import dev.team4.vinko.dtos.ActivityDTO;
import dev.team4.vinko.entities.Activity;
import dev.team4.vinko.repositories.ActivityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.Arrays;
import java.util.Optional;
import java.util.Arrays;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


class "ActivityControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ActivityRepository repository;

    @InjectMocks
    private ActivityController activityController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(activityController).build();
    }

    @Test
    void getAllActivities() throws Exception {
        Activity activity1 = new Activity();
        Activity activity2 = new Activity();

        when(repository.findAll()).thenReturn(Arrays.asList(activity1, activity2));

        mockMvc.perform(get("/api/activities"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("Activity 1"))
                .andExpect(jsonPath("$[0].description").value("Description 1"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].name").value("Activity 2"))
                .andExpect(jsonPath("$[1].description").value("Description 2"));

        verify(repository, times(1)).findAll();
    }

    @Test
    void createActivity() throws Exception {
        Activity activity = new Activity();

        when(repository.save(any(Activity.class))).thenReturn(activity);

        mockMvc.perform(post("/api/activities")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"New Activity\",\"description\":\"New Description\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("New Activity"))
                .andExpect(jsonPath("$.description").value("New Description"));

        verify(repository, times(1)).save(any(Activity.class));
    }

    @Test
    void getActivityById() throws Exception {
        Activity activity = new Activity();

        when(repository.findById(1L)).thenReturn(Optional.of(activity));

        mockMvc.perform(get("/api/activities/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Activity 1"))
                .andExpect(jsonPath("$.description").value("Description 1"));

        verify(repository, times(1)).findById(1L);
    }

    @Test
    void getActivityByIdNotFound() throws Exception {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/activities/1"))
                .andExpect(status().isNotFound());

        verify(repository, times(1)).findById(1L);
    }

    @Test
    void updateActivity() throws Exception {
        Activity existingActivity = new Activity();


        ActivityDTO updatedDTO = new ActivityDTO(1L, "Updated Activity", "Updated Description");

        when(repository.findById(1L)).thenReturn(Optional.of(existingActivity));
        when(repository.save(any(Activity.class))).thenReturn(existingActivity);

        mockMvc.perform(put("/api/activities/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Updated Activity\",\"description\":\"Updated Description\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Updated Activity"))
                .andExpect(jsonPath("$.description").value("Updated Description"));

        verify(repository, times(1)).findById(1L);
        verify(repository, times(1)).save(any(Activity.class));
    }

    @Test
    void updateActivityNotFound() throws Exception {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(put("/api/activities/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Updated Activity\",\"description\":\"Updated Description\"}"))
                .andExpect(status().isNotFound());

        verify(repository, times(1)).findById(1L);
        verify(repository, times(0)).save(any(Activity.class));
    }

    @Test
    void deleteActivity() throws Exception {
        doNothing().when(repository).deleteById(1L);

        mockMvc.perform(delete("/api/activities/1"))
                .andExpect(status().isOk());

        verify(repository, times(1)).deleteById(1L);
    }
}

