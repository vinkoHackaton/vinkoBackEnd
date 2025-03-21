package dtoTest;
import org.junit.jupiter.api.Test;
import dev.team4.vinko.dtos.CompanionDto;
import static org.junit.jupiter.api.Assertions.*;
class CompanionDtoTest {

    @Test
    void testCompanionDtoConstructorAndGetters() {
        // Datos de prueba
        Long id = 1L;
        String name = "John Doe";
        Integer age = 30;
        String email = "john@example.com";
        String description = "Friendly companion";
        Double hourlyRate = 20.0;
        Double rating = 4.5;

        // Crear una instancia de CompanionDto
        CompanionDto companionDto = new CompanionDto(id, name, age, email, description, hourlyRate, rating);

        // Verificar que los valores se asignaron correctamente
        assertEquals(id, companionDto.id());
        assertEquals(name, companionDto.name());
        assertEquals(age, companionDto.age());
        assertEquals(email, companionDto.email());
        assertEquals(description, companionDto.description());
        assertEquals(hourlyRate, companionDto.hourlyRate());
        assertEquals(rating, companionDto.rating());
    }

    @Test
    void testCompanionDtoEqualsAndHashCode() {
        // Crear dos instancias de CompanionDto con los mismos valores
        CompanionDto companionDto1 = new CompanionDto(1L, "John Doe", 30, "john@example.com", "Friendly companion", 20.0, 4.5);
        CompanionDto companionDto2 = new CompanionDto(1L, "John Doe", 30, "john@example.com", "Friendly companion", 20.0, 4.5);

        // Verificar que son iguales
        assertEquals(companionDto1, companionDto2);
        assertEquals(companionDto1.hashCode(), companionDto2.hashCode());
    }

    @Test
    void testCompanionDtoNotEquals() {
        // Crear dos instancias de CompanionDto con valores diferentes
        CompanionDto companionDto1 = new CompanionDto(1L, "John Doe", 30, "john@example.com", "Friendly companion", 20.0, 4.5);
        CompanionDto companionDto2 = new CompanionDto(2L, "Jane Doe", 25, "jane@example.com", "Helpful companion", 25.0, 4.8);

        // Verificar que no son iguales
        assertNotEquals(companionDto1, companionDto2);
        assertNotEquals(companionDto1.hashCode(), companionDto2.hashCode());
    }

    @Test
    void testCompanionDtoToString() {
        // Crear una instancia de CompanionDto
        CompanionDto companionDto = new CompanionDto(1L, "John Doe", 30, "john@example.com", "Friendly companion", 20.0, 4.5);

        // Verificar que el método toString devuelve el formato esperado
        String expectedToString = "CompanionDto[id=1, name=John Doe, age=30, email=john@example.com, description=Friendly companion, hourlyRate=20.0, rating=4.5]";
        assertEquals(expectedToString, companionDto.toString());
    }
}

