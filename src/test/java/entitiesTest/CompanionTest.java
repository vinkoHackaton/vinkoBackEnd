package entitiesTest;
import org.junit.jupiter.api.Test;

import dev.team4.vinko.entities.Activity;
import dev.team4.vinko.entities.Companion;
import dev.team4.vinko.entities.ContactRequest;
import dev.team4.vinko.entities.Notification;
import dev.team4.vinko.entities.Review;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CompanionTest {

    @Test
    void testCompanionGettersAndSetters() {
        // Crear una instancia de Companion
        Companion companion = new Companion();

        // Asignar valores usando setters
        companion.setId(1L);
        companion.setName("John Doe");
        companion.setAge(30);
        companion.setEmail("john@example.com");
        companion.setDescription("Friendly companion");
        companion.setPhotoUrl("https://example.com/photo.jpg");
        companion.setHourlyRate(20.0);
        companion.setRating(4.5);

        // Verificar que los getters devuelven los valores correctos
        assertEquals(1L, companion.getId());
        assertEquals("John Doe", companion.getName());
        assertEquals(30, companion.getAge());
        assertEquals("john@example.com", companion.getEmail());
        assertEquals("Friendly companion", companion.getDescription());
        assertEquals("https://example.com/photo.jpg", companion.getPhotoUrl());
        assertEquals(20.0, companion.getHourlyRate());
        assertEquals(4.5, companion.getRating());
    }

    @Test
    void testCompanionRelationships() {
        // Crear una instancia de Companion
        Companion companion = new Companion();

        // Crear listas para las relaciones
        List<Review> reviews = new ArrayList<>();
        Review review = new Review();
        review.setId(1L);
        review.setComment("Great service!");
        reviews.add(review);

        List<Notification> notifications = new ArrayList<>();
        Notification notification = new Notification();
        notification.setId(1L);
        notification.setMessage("New notification");
        notifications.add(notification);

        List<ContactRequest> contactRequests = new ArrayList<>();
        ContactRequest contactRequest = new ContactRequest();
        contactRequest.setId(1L);
        contactRequest.setMessage("Hello, I need help.");
        contactRequests.add(contactRequest);

        List<Activity> activities = new ArrayList<>();
        Activity activity = new Activity();
        activity.setId(1L);
        activity.setName("Yoga Class");
        activities.add(activity);

        // Asignar las relaciones
        companion.setReviews(reviews);
        companion.setNotifications(notifications);
        companion.setContactRequests(contactRequests);
        companion.setActivities(activities);

        // Verificar que las relaciones se asignaron correctamente
        assertEquals(1, companion.getReviews().size());
        assertEquals("Great service!", companion.getReviews().get(0).getComment());

        assertEquals(1, companion.getNotifications().size());
        assertEquals("New notification", companion.getNotifications().get(0).getMessage());

        assertEquals(1, companion.getContactRequests().size());
        assertEquals("Hello, I need help.", companion.getContactRequests().get(0).getMessage());

        assertEquals(1, companion.getActivities().size());
        assertEquals("Yoga Class", companion.getActivities().get(0).getName());
    }

    @Test
    void testCompanionEqualsAndHashCode() {
        // Crear dos instancias de Companion con los mismos valores
        Companion companion1 = new Companion(1L, "John Doe", 30, "john@example.com", "Friendly companion", 20.0, 4.5);
        Companion companion2 = new Companion(1L, "John Doe", 30, "john@example.com", "Friendly companion", 20.0, 4.5);

        // Verificar que son iguales
        assertEquals(companion1, companion2);
        assertEquals(companion1.hashCode(), companion2.hashCode());
    }

    @Test
    void testCompanionNotEquals() {
        // Crear dos instancias de Companion con valores diferentes
        Companion companion1 = new Companion(1L, "John Doe", 30, "john@example.com", "Friendly companion", 20.0, 4.5);
        Companion companion2 = new Companion(2L, "Jane Doe", 25, "jane@example.com", "Helpful companion", 25.0, 4.8);

        // Verificar que no son iguales
        assertNotEquals(companion1, companion2);
        assertNotEquals(companion1.hashCode(), companion2.hashCode());
    }

    @Test
    void testCompanionToString() {
        // Crear una instancia de Companion
        Companion companion = new Companion(1L, "John Doe", 30, "john@example.com", "Friendly companion", 20.0, 4.5);

        // Verificar que el método toString devuelve el formato esperado
        String expectedToString = "Companion(id=1, name=John Doe, age=30, email=john@example.com, description=Friendly companion, photoUrl=null, hourlyRate=20.0, rating=4.5, reviews=[], notifications=[], contactRequests=[], activities=[])";
        assertEquals(expectedToString, companion.toString());
    }
}
