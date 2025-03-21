package entitiesTest;
import org.junit.jupiter.api.Test;

import dev.team4.vinko.entities.Companion;
import dev.team4.vinko.entities.Notification;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class NotificationTest {

    @Test
    void testNotificationGettersAndSetters() {
        // Crear una instancia de Notification
        Notification notification = new Notification();

        // Asignar valores usando setters
        notification.setId(1L);
        notification.setMessage("New notification");
        notification.setTimestamp(LocalDateTime.of(2023, 10, 1, 12, 0));

        // Verificar que los getters devuelven los valores correctos
        assertEquals(1L, notification.getId());
        assertEquals("New notification", notification.getMessage());
        assertEquals(LocalDateTime.of(2023, 10, 1, 12, 0), notification.getTimestamp());
    }

    @Test
    void testNotificationRelationship() {
        // Crear una instancia de Notification
        Notification notification = new Notification();

        // Crear una instancia de Companion
        Companion companion = new Companion();
        companion.setId(1L);
        companion.setName("John Doe");

        // Asignar la relación
        notification.setCompanion(companion);

        // Verificar que la relación se asignó correctamente
        assertEquals(companion, notification.getCompanion());
    }

    @Test
    void testNotificationEqualsAndHashCode() {
        // Crear dos instancias de Notification con los mismos valores
        LocalDateTime timestamp = LocalDateTime.of(2023, 10, 1, 12, 0);
        Notification notification1 = new Notification();
        notification1.setId(1L);
        notification1.setMessage("New notification");
        notification1.setTimestamp(timestamp);

        Notification notification2 = new Notification();
        notification2.setId(1L);
        notification2.setMessage("New notification");
        notification2.setTimestamp(timestamp);

        // Verificar que son iguales
        assertEquals(notification1, notification2);
        assertEquals(notification1.hashCode(), notification2.hashCode());
    }

    @Test
    void testNotificationNotEquals() {
        // Crear dos instancias de Notification con valores diferentes
        LocalDateTime timestamp1 = LocalDateTime.of(2023, 10, 1, 12, 0);
        LocalDateTime timestamp2 = LocalDateTime.of(2023, 10, 2, 12, 0);
        Notification notification1 = new Notification();
        notification1.setId(1L);
        notification1.setMessage("New notification");
        notification1.setTimestamp(timestamp1);

        Notification notification2 = new Notification();
        notification2.setId(2L);
        notification2.setMessage("Another notification");
        notification2.setTimestamp(timestamp2);

        // Verificar que no son iguales
        assertNotEquals(notification1, notification2);
        assertNotEquals(notification1.hashCode(), notification2.hashCode());
    }

    @Test
    void testNotificationToString() {
        // Crear una instancia de Notification
        LocalDateTime timestamp = LocalDateTime.of(2023, 10, 1, 12, 0);
        Notification notification = new Notification();
        notification.setId(1L);
        notification.setMessage("New notification");
        notification.setTimestamp(timestamp);

        // Verificar que el método toString devuelve el formato esperado
        String expectedToString = "Notification(id=1, message=New notification, timestamp=2023-10-01T12:00, companion=null)";
        assertEquals(expectedToString, notification.toString());
    }
}
