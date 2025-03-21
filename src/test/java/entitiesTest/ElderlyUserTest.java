package entitiesTest;
import org.junit.jupiter.api.Test;

import dev.team4.vinko.entities.ContactRequest;
import dev.team4.vinko.entities.ElderlyUser;
import dev.team4.vinko.entities.Review;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ElderlyUserTest {

    @Test
    void testElderlyUserGettersAndSetters() {
        // Crear una instancia de ElderlyUser
        ElderlyUser elderlyUser = new ElderlyUser();

        // Asignar valores usando setters
        elderlyUser.setId(1L);
        elderlyUser.setName("John Doe");
        elderlyUser.setEmail("john@example.com");
        elderlyUser.setPhone("123456789");

        // Verificar que los getters devuelven los valores correctos
        assertEquals(1L, elderlyUser.getId());
        assertEquals("John Doe", elderlyUser.getName());
        assertEquals("john@example.com", elderlyUser.getEmail());
        assertEquals("123456789", elderlyUser.getPhone());
    }

    @Test
    void testElderlyUserRelationships() {
        // Crear una instancia de ElderlyUser
        ElderlyUser elderlyUser = new ElderlyUser();

        // Crear listas para las relaciones
        List<Review> reviews = new ArrayList<>();
        Review review = new Review();
        review.setId(1L);
        review.setComment("Great service!");
        reviews.add(review);

        List<ContactRequest> contactRequests = new ArrayList<>();
        ContactRequest contactRequest = new ContactRequest();
        contactRequest.setId(1L);
        contactRequest.setMessage("Hello, I need help.");
        contactRequests.add(contactRequest);

        // Asignar las relaciones
        elderlyUser.setReviews(reviews);
        elderlyUser.setContactRequests(contactRequests);

        // Verificar que las relaciones se asignaron correctamente
        assertEquals(1, elderlyUser.getReviews().size());
        assertEquals("Great service!", elderlyUser.getReviews().get(0).getComment());

        assertEquals(1, elderlyUser.getContactRequests().size());
        assertEquals("Hello, I need help.", elderlyUser.getContactRequests().get(0).getMessage());
    }

    @Test
    void testElderlyUserEqualsAndHashCode() {
        // Crear dos instancias de ElderlyUser con los mismos valores
        ElderlyUser elderlyUser1 = new ElderlyUser();
        elderlyUser1.setId(1L);
        elderlyUser1.setName("John Doe");
        elderlyUser1.setEmail("john@example.com");
        elderlyUser1.setPhone("123456789");

        ElderlyUser elderlyUser2 = new ElderlyUser();
        elderlyUser2.setId(1L);
        elderlyUser2.setName("John Doe");
        elderlyUser2.setEmail("john@example.com");
        elderlyUser2.setPhone("123456789");

        // Verificar que son iguales
        assertEquals(elderlyUser1, elderlyUser2);
        assertEquals(elderlyUser1.hashCode(), elderlyUser2.hashCode());
    }

    @Test
    void testElderlyUserNotEquals() {
        // Crear dos instancias de ElderlyUser con valores diferentes
        ElderlyUser elderlyUser1 = new ElderlyUser();
        elderlyUser1.setId(1L);
        elderlyUser1.setName("John Doe");
        elderlyUser1.setEmail("john@example.com");
        elderlyUser1.setPhone("123456789");

        ElderlyUser elderlyUser2 = new ElderlyUser();
        elderlyUser2.setId(2L);
        elderlyUser2.setName("Jane Doe");
        elderlyUser2.setEmail("jane@example.com");
        elderlyUser2.setPhone("987654321");

        // Verificar que no son iguales
        assertNotEquals(elderlyUser1, elderlyUser2);
        assertNotEquals(elderlyUser1.hashCode(), elderlyUser2.hashCode());
    }

    @Test
    void testElderlyUserToString() {
        // Crear una instancia de ElderlyUser
        ElderlyUser elderlyUser = new ElderlyUser();
        elderlyUser.setId(1L);
        elderlyUser.setName("John Doe");
        elderlyUser.setEmail("john@example.com");
        elderlyUser.setPhone("123456789");

        // Verificar que el método toString devuelve el formato esperado
        String expectedToString = "ElderlyUser(id=1, name=John Doe, email=john@example.com, phone=123456789, reviews=[], contactRequests=[])";
        assertEquals(expectedToString, elderlyUser.toString());
    }
}
