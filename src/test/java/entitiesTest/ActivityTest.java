package entitiesTest;
import org.junit.jupiter.api.Test;
import dev.team4.vinko.entities.Activity;
import dev.team4.vinko.entities.Companion;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
class ActivityTest {

    @Test
    void testActivityGettersAndSetters() {
        // Crear una instancia de Activity
        Activity activity = new Activity();

        // Asignar valores usando setters
        activity.setId(1L);
        activity.setName("Yoga Class");
        activity.setDescription("Relaxing yoga session for beginners.");

        // Verificar que los getters devuelven los valores correctos
        assertEquals(1L, activity.getId());
        assertEquals("Yoga Class", activity.getName());
        assertEquals("Relaxing yoga session for beginners.", activity.getDescription());
    }

    @Test
    void testActivityCompanions() {
        // Crear una instancia de Activity
        Activity activity = new Activity();

        // Crear una lista de compañeros (Companion)
        List<Companion> companions = new ArrayList<>();
        Companion companion1 = new Companion();
        companion1.setId(1L);
        companion1.setName("John Doe");

        Companion companion2 = new Companion();
        companion2.setId(2L);
        companion2.setName("Jane Doe");

        companions.add(companion1);
        companions.add(companion2);

        // Asignar la lista de compañeros a la actividad
        activity.setCompanions(companions);

        // Verificar que la lista de compañeros se asignó correctamente
        assertEquals(2, activity.getCompanions().size());
        assertEquals("John Doe", activity.getCompanions().get(0).getName());
        assertEquals("Jane Doe", activity.getCompanions().get(1).getName());
    }

    @Test
    void testActivityEqualsAndHashCode() {
        // Crear dos instancias de Activity con los mismos valores
        Activity activity1 = new Activity();
        activity1.setId(1L);
        activity1.setName("Yoga Class");
        activity1.setDescription("Relaxing yoga session for beginners.");

        Activity activity2 = new Activity();
        activity2.setId(1L);
        activity2.setName("Yoga Class");
        activity2.setDescription("Relaxing yoga session for beginners.");

        // Verificar que son iguales
        assertEquals(activity1, activity2);
        assertEquals(activity1.hashCode(), activity2.hashCode());
    }

    @Test
    void testActivityNotEquals() {
        // Crear dos instancias de Activity con valores diferentes
        Activity activity1 = new Activity();
        activity1.setId(1L);
        activity1.setName("Yoga Class");
        activity1.setDescription("Relaxing yoga session for beginners.");

        Activity activity2 = new Activity();
        activity2.setId(2L);
        activity2.setName("Pilates Class");
        activity2.setDescription("Core strengthening session.");

        // Verificar que no son iguales
        assertNotEquals(activity1, activity2);
        assertNotEquals(activity1.hashCode(), activity2.hashCode());
    }

    @Test
    void testActivityToString() {
        // Crear una instancia de Activity
        Activity activity = new Activity();
        activity.setId(1L);
        activity.setName("Yoga Class");
        activity.setDescription("Relaxing yoga session for beginners.");

        // Verificar que el método toString devuelve el formato esperado
        String expectedToString = "Activity{id=1, name='Yoga Class', description='Relaxing yoga session for beginners.', companions=null}";
        assertEquals(expectedToString, activity.toString());
    }
}


