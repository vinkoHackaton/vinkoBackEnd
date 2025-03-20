package dtoTest;
import org.junit.jupiter.api.Test;

import dev.team4.vinko.dtos.ContactRequestDTO;

import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class ContactRequestDTOTest {

    @Test
    void testContactRequestDTOConstructorAndGetters() {
        // Datos de prueba
        Long id = 1L;
        Long elderlyUserId = 2L;
        Long companionId = 3L;
        String message = "Hello, I need help.";
        LocalDateTime requestedDate = LocalDateTime.now();

        // Crear una instancia de ContactRequestDTO
        ContactRequestDTO contactRequestDTO = new ContactRequestDTO(id, elderlyUserId, companionId, message, requestedDate);

        // Verificar que los valores se asignaron correctamente
        assertEquals(id, contactRequestDTO.id());
        assertEquals(elderlyUserId, contactRequestDTO.elderlyUserId());
        assertEquals(companionId, contactRequestDTO.companionId());
        assertEquals(message, contactRequestDTO.message());
        assertEquals(requestedDate, contactRequestDTO.requestedDate());
    }

    @Test
    void testContactRequestDTOEqualsAndHashCode() {
        // Crear dos instancias de ContactRequestDTO con los mismos valores
        LocalDateTime requestedDate = LocalDateTime.now();
        ContactRequestDTO contactRequestDTO1 = new ContactRequestDTO(1L, 2L, 3L, "Hello, I need help.", requestedDate);
        ContactRequestDTO contactRequestDTO2 = new ContactRequestDTO(1L, 2L, 3L, "Hello, I need help.", requestedDate);

        // Verificar que son iguales
        assertEquals(contactRequestDTO1, contactRequestDTO2);
        assertEquals(contactRequestDTO1.hashCode(), contactRequestDTO2.hashCode());
    }

    @Test
    void testContactRequestDTONotEquals() {
        // Crear dos instancias de ContactRequestDTO con valores diferentes
        LocalDateTime requestedDate = LocalDateTime.now();
        ContactRequestDTO contactRequestDTO1 = new ContactRequestDTO(1L, 2L, 3L, "Hello, I need help.", requestedDate);
        ContactRequestDTO contactRequestDTO2 = new ContactRequestDTO(4L, 5L, 6L, "Can you assist me?", requestedDate);

        // Verificar que no son iguales
        assertNotEquals(contactRequestDTO1, contactRequestDTO2);
        assertNotEquals(contactRequestDTO1.hashCode(), contactRequestDTO2.hashCode());
    }

    @Test
    void testContactRequestDTOToString() {
        // Crear una instancia de ContactRequestDTO
        LocalDateTime requestedDate = LocalDateTime.of(2023, 10, 1, 12, 0);
        ContactRequestDTO contactRequestDTO = new ContactRequestDTO(1L, 2L, 3L, "Hello, I need help.", requestedDate);

        // Verificar que el método toString devuelve el formato esperado
        String expectedToString = "ContactRequestDTO[id=1, elderlyUserId=2, companionId=3, message=Hello, I need help., requestedDate=2023-10-01T12:00]";
        assertEquals(expectedToString, contactRequestDTO.toString());
    }
}

