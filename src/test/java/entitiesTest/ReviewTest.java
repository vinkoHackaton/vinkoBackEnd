package entitiesTest;
import org.junit.jupiter.api.Test;

import dev.team4.vinko.entities.Companion;
import dev.team4.vinko.entities.ElderlyUser;
import dev.team4.vinko.entities.Review;
import static org.junit.jupiter.api.Assertions.*;

class ReviewTest {

    @Test
    void testReviewGettersAndSetters() {
        // Crear una instancia de Review
        Review review = new Review();

        // Asignar valores usando setters
        review.setId(1L);
        review.setStars(5);
        review.setComment("Great service!");

        // Verificar que los getters devuelven los valores correctos
        assertEquals(1L, review.getId());
        assertEquals(5, review.getStars());
        assertEquals("Great service!", review.getComment());
    }

    @Test
    void testReviewRelationships() {
        // Crear una instancia de Review
        Review review = new Review();

        // Crear instancias de ElderlyUser y Companion
        ElderlyUser elderlyUser = new ElderlyUser();
        elderlyUser.setId(1L);
        elderlyUser.setName("John Doe");

        Companion companion = new Companion();
        companion.setId(1L);
        companion.setName("Jane Doe");

        // Asignar las relaciones
        review.setElderlyUser(elderlyUser);
        review.setCompanion(companion);

        // Verificar que las relaciones se asignaron correctamente
        assertEquals(elderlyUser, review.getElderlyUser());
        assertEquals(companion, review.getCompanion());
    }

    @Test
    void testReviewEqualsAndHashCode() {
        // Crear dos instancias de Review con los mismos valores
        Review review1 = new Review();
        review1.setId(1L);
        review1.setStars(5);
        review1.setComment("Great service!");

        Review review2 = new Review();
        review2.setId(1L);
        review2.setStars(5);
        review2.setComment("Great service!");

        // Verificar que son iguales
        assertEquals(review1, review2);
        assertEquals(review1.hashCode(), review2.hashCode());
    }

    @Test
    void testReviewNotEquals() {
        // Crear dos instancias de Review con valores diferentes
        Review review1 = new Review();
        review1.setId(1L);
        review1.setStars(5);
        review1.setComment("Great service!");

        Review review2 = new Review();
        review2.setId(2L);
        review2.setStars(4);
        review2.setComment("Good service!");

        // Verificar que no son iguales
        assertNotEquals(review1, review2);
        assertNotEquals(review1.hashCode(), review2.hashCode());
    }

    @Test
    void testReviewToString() {
        // Crear una instancia de Review
        Review review = new Review();
        review.setId(1L);
        review.setStars(5);
        review.setComment("Great service!");

        // Verificar que el método toString devuelve el formato esperado
        String expectedToString = "Review(id=1, stars=5, comment=Great service!, elderlyUser=null, companion=null)";
        assertEquals(expectedToString, review.toString());
    }
}
