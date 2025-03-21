package dtoTest;
import org.junit.jupiter.api.Test;
import dev.team4.vinko.dtos.ReviewDTO;
import static org.junit.jupiter.api.Assertions.*;
class ReviewDTOTest {

    @Test
    void testReviewDTOConstructorAndGetters() {
        // Datos de prueba
        Long id = 1L;
        Integer stars = 5;
        String comment = "Great service!";
        Long elderlyUserId = 2L;
        Long companionId = 3L;

        // Crear una instancia de ReviewDTO
        ReviewDTO reviewDTO = new ReviewDTO(id, stars, comment, elderlyUserId, companionId);

        // Verificar que los valores se asignaron correctamente
        assertEquals(id, reviewDTO.id());
        assertEquals(stars, reviewDTO.stars());
        assertEquals(comment, reviewDTO.comment());
        assertEquals(elderlyUserId, reviewDTO.elderlyUserId());
        assertEquals(companionId, reviewDTO.companionId());
    }

    @Test
    void testReviewDTOEqualsAndHashCode() {
        // Crear dos instancias de ReviewDTO con los mismos valores
        ReviewDTO reviewDTO1 = new ReviewDTO(1L, 5, "Great service!", 2L, 3L);
        ReviewDTO reviewDTO2 = new ReviewDTO(1L, 5, "Great service!", 2L, 3L);

        // Verificar que son iguales
        assertEquals(reviewDTO1, reviewDTO2);
        assertEquals(reviewDTO1.hashCode(), reviewDTO2.hashCode());
    }

    @Test
    void testReviewDTONotEquals() {
        // Crear dos instancias de ReviewDTO con valores diferentes
        ReviewDTO reviewDTO1 = new ReviewDTO(1L, 5, "Great service!", 2L, 3L);
        ReviewDTO reviewDTO2 = new ReviewDTO(2L, 4, "Good service!", 4L, 5L);

        // Verificar que no son iguales
        assertNotEquals(reviewDTO1, reviewDTO2);
        assertNotEquals(reviewDTO1.hashCode(), reviewDTO2.hashCode());
    }

    @Test
    void testReviewDTOToString() {
        // Crear una instancia de ReviewDTO
        ReviewDTO reviewDTO = new ReviewDTO(1L, 5, "Great service!", 2L, 3L);

        // Verificar que el método toString devuelve el formato esperado
        String expectedToString = "ReviewDTO[id=1, stars=5, comment=Great service!, elderlyUserId=2, companionId=3]";
        assertEquals(expectedToString, reviewDTO.toString());
    }
}

