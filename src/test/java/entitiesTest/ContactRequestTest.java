package entitiesTest;
import org.junit.jupiter.api.Test;

import dev.team4.vinko.entities.Companion;
import dev.team4.vinko.entities.ContactRequest;
import dev.team4.vinko.entities.ElderlyUser;

import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class ContactRequestTest {

    @Test
    void testContactRequestGettersAndSetters() {
        // Crear una instancia de ContactRequest
        ContactRequest contactRequest = new ContactRequest();

        // Asignar valores usando setters
        contactRequest.setId(1L);
        contactRequest.setMessage("Hello, I need help.");
        contactRequest.setRequestedDate(LocalDateTime.of(2023, 10, 1, 12, 0));

        // Verificar que los getters devuelven los valores correctos
        assertEquals(1L, contactRequest.getId());
        assertEquals("Hello, I need help.", contactRequest.getMessage());
        assertEquals(LocalDateTime.of(2023, 10, 1, 12, 0), contactRequest.getRequestedDate());
    }

    @Test
    void testContactRequestRelationships() {
        // Crear una instancia de ContactRequest
        ContactRequest contactRequest = new ContactRequest();

        // Crear instancias de ElderlyUser y Companion
        ElderlyUser elderlyUser = new ElderlyUser();
        elderlyUser.setId(1L);
        elderlyUser.setName("John Doe");

        Companion companion = new Companion();
        companion.setId(1L);
        companion.setName("Jane Doe");

        // Asignar las relaciones
        contactRequest.setElderlyUser(elderlyUser);
        contactRequest.setCompanion(companion);

        // Verificar que las relaciones se asignaron correctamente
        assertEquals(elderlyUser, contactRequest.getElderlyUser());
        assertEquals(companion, contactRequest.getCompanion());
    }

    @Test
    void testContactRequestEqualsAndHashCode() {
        // Crear dos instancias de ContactRequest con los mismos valores
        LocalDateTime requestedDate = LocalDateTime.of(2023, 10, 1, 12, 0);
        ContactRequest contactRequest1 = new ContactRequest();
        contactRequest1.setId(1L);
        contactRequest1.setMessage("Hello, I need help.");
        contactRequest1.setRequestedDate(requestedDate);

        ContactRequest contactRequest2 = new ContactRequest();
        contactRequest2.setId(1L);
        contactRequest2.setMessage("Hello, I need help.");
        contactRequest2.setRequestedDate(requestedDate);

        // Verificar que son iguales
        assertEquals(contactRequest1, contactRequest2);
        assertEquals(contactRequest1.hashCode(), contactRequest2.hashCode());
    }

    @Test
    void testContactRequestNotEquals() {
        // Crear dos instancias de ContactRequest con valores diferentes
        LocalDateTime requestedDate1 = LocalDateTime.of(2023, 10, 1, 12, 0);
        LocalDateTime requestedDate2 = LocalDateTime.of(2023, 10, 2, 12, 0);
        ContactRequest contactRequest1 = new ContactRequest();
        contactRequest1.setId(1L);
        contactRequest1.setMessage("Hello, I need help.");
        contactRequest1.setRequestedDate(requestedDate1);

        ContactRequest contactRequest2 = new ContactRequest();
        contactRequest2.setId(2L);
        contactRequest2.setMessage("Can you assist me?");
        contactRequest2.setRequestedDate(requestedDate2);

        // Verificar que no son iguales
        assertNotEquals(contactRequest1, contactRequest2);
        assertNotEquals(contactRequest1.hashCode(), contactRequest2.hashCode());
    }

    @Test
    void testContactRequestToString() {
        // Crear una instancia de ContactRequest
        LocalDateTime requestedDate = LocalDateTime.of(2023, 10, 1, 12, 0);
        ContactRequest contactRequest = new ContactRequest();
        contactRequest.setId(1L);
        contactRequest.setMessage("Hello, I need help.");
        contactRequest.setRequestedDate(requestedDate);

        // Verificar que el método toString devuelve el formato esperado
        String expectedToString = "ContactRequest(id=1, message=Hello, I need help., requestedDate=2023-10-01T12:00, elderlyUser=null, companion=null)";
        assertEquals(expectedToString, contactRequest.toString());
    }
}
