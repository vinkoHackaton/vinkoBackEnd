package dtoTest;
import org.junit.jupiter.api.Test;

import dev.team4.vinko.dtos.ActivityDTO;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDTOTest {

    @Test
    void testActivityDTOConstructorAndGetters() {
        // Datos de prueba
        Long id = 1L;
        String name = "Activity 1";
        String description = "Description 1";

        // Crear una instancia de ActivityDTO
        ActivityDTO activityDTO = new ActivityDTO(id, name, description);

        // Verificar que los valores se asignaron correctamente
        assertEquals(id, activityDTO.id());
        assertEquals(name, activityDTO.name());
        assertEquals(description, activityDTO.description());
    }

    @Test
    void testActivityDTOEqualsAndHashCode() {
        // Crear dos instancias de ActivityDTO con los mismos valores
        ActivityDTO activityDTO1 = new ActivityDTO(1L, "Activity 1", "Description 1");
        ActivityDTO activityDTO2 = new ActivityDTO(1L, "Activity 1", "Description 1");

        // Verificar que son iguales
        assertEquals(activityDTO1, activityDTO2);
        assertEquals(activityDTO1.hashCode(), activityDTO2.hashCode());
    }

    @Test
    void testActivityDTONotEquals() {
        // Crear dos instancias de ActivityDTO con valores diferentes
        ActivityDTO activityDTO1 = new ActivityDTO(1L, "Activity 1", "Description 1");
        ActivityDTO activityDTO2 = new ActivityDTO(2L, "Activity 2", "Description 2");

        // Verificar que no son iguales
        assertNotEquals(activityDTO1, activityDTO2);
        assertNotEquals(activityDTO1.hashCode(), activityDTO2.hashCode());
    }

    @Test
    void testActivityDTOToString() {
        // Crear una instancia de ActivityDTO
        ActivityDTO activityDTO = new ActivityDTO(1L, "Activity 1", "Description 1");

        // Verificar que el método toString devuelve el formato esperado
        String expectedToString = "ActivityDTO[id=1, name=Activity 1, description=Description 1]";
        assertEquals(expectedToString, activityDTO.toString());
    }
}
