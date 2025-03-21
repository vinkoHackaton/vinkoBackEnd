package dtoTest;
import org.junit.jupiter.api.Test;
import dev.team4.vinko.dtos.NotificationDTO;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;
class NotificationDTOTest {

    @Test
    void testNotificationDTOConstructorAndGetters() {
        // Datos de prueba
        Long id = 1L;
        String message = "New notification";
        LocalDateTime timestamp = LocalDateTime.of(2023, 10, 1, 12, 0);
        Long companionId = 2L;

        // Crear una instancia de NotificationDTO
        NotificationDTO notificationDTO = new NotificationDTO(id, message, timestamp, companionId);

        // Verificar que los valores se asignaron correctamente
        assertEquals(id, notificationDTO.id());
        assertEquals(message, notificationDTO.message());
        assertEquals(timestamp, notificationDTO.timestamp());
        assertEquals(companionId, notificationDTO.companionId());
    }

    @Test
    void testNotificationDTOEqualsAndHashCode() {
        // Crear dos instancias de NotificationDTO con los mismos valores
        LocalDateTime timestamp = LocalDateTime.of(2023, 10, 1, 12, 0);
        NotificationDTO notificationDTO1 = new NotificationDTO(1L, "New notification", timestamp, 2L);
        NotificationDTO notificationDTO2 = new NotificationDTO(1L, "New notification", timestamp, 2L);

        // Verificar que son iguales
        assertEquals(notificationDTO1, notificationDTO2);
        assertEquals(notificationDTO1.hashCode(), notificationDTO2.hashCode());
    }

    @Test
    void testNotificationDTONotEquals() {
        // Crear dos instancias de NotificationDTO con valores diferentes
        LocalDateTime timestamp1 = LocalDateTime.of(2023, 10, 1, 12, 0);
        LocalDateTime timestamp2 = LocalDateTime.of(2023, 10, 2, 12, 0);
        NotificationDTO notificationDTO1 = new NotificationDTO(1L, "New notification", timestamp1, 2L);
        NotificationDTO notificationDTO2 = new NotificationDTO(2L, "Another notification", timestamp2, 3L);

        // Verificar que no son iguales
        assertNotEquals(notificationDTO1, notificationDTO2);
        assertNotEquals(notificationDTO1.hashCode(), notificationDTO2.hashCode());
    }

    @Test
    void testNotificationDTOToString() {
        // Crear una instancia de NotificationDTO
        LocalDateTime timestamp = LocalDateTime.of(2023, 10, 1, 12, 0);
        NotificationDTO notificationDTO = new NotificationDTO(1L, "New notification", timestamp, 2L);

        // Verificar que el método toString devuelve el formato esperado
        String expectedToString = "NotificationDTO[id=1, message=New notification, timestamp=2023-10-01T12:00, companionId=2]";
        assertEquals(expectedToString, notificationDTO.toString());
    }
}
