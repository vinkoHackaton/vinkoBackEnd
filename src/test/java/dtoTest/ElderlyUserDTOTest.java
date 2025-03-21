package dtoTest;
import org.junit.jupiter.api.Test;
import dev.team4.vinko.dtos.ElderlyUserDTO;
import static org.junit.jupiter.api.Assertions.*;
class ElderlyUserDTOTest {

    @Test
    void testElderlyUserDTOConstructorAndGetters() {
        // Datos de prueba
        Long id = 1L;
        String name = "John Doe";
        String email = "john@example.com";
        String phone = "123456789";

        // Crear una instancia de ElderlyUserDTO
        ElderlyUserDTO elderlyUserDTO = new ElderlyUserDTO(id, name, email, phone);

        // Verificar que los valores se asignaron correctamente
        assertEquals(id, elderlyUserDTO.id());
        assertEquals(name, elderlyUserDTO.name());
        assertEquals(email, elderlyUserDTO.email());
        assertEquals(phone, elderlyUserDTO.phone());
    }

    @Test
    void testElderlyUserDTOEqualsAndHashCode() {
        // Crear dos instancias de ElderlyUserDTO con los mismos valores
        ElderlyUserDTO elderlyUserDTO1 = new ElderlyUserDTO(1L, "John Doe", "john@example.com", "123456789");
        ElderlyUserDTO elderlyUserDTO2 = new ElderlyUserDTO(1L, "John Doe", "john@example.com", "123456789");

        // Verificar que son iguales
        assertEquals(elderlyUserDTO1, elderlyUserDTO2);
        assertEquals(elderlyUserDTO1.hashCode(), elderlyUserDTO2.hashCode());
    }

    @Test
    void testElderlyUserDTONotEquals() {
        // Crear dos instancias de ElderlyUserDTO con valores diferentes
        ElderlyUserDTO elderlyUserDTO1 = new ElderlyUserDTO(1L, "John Doe", "john@example.com", "123456789");
        ElderlyUserDTO elderlyUserDTO2 = new ElderlyUserDTO(2L, "Jane Doe", "jane@example.com", "987654321");

        // Verificar que no son iguales
        assertNotEquals(elderlyUserDTO1, elderlyUserDTO2);
        assertNotEquals(elderlyUserDTO1.hashCode(), elderlyUserDTO2.hashCode());
    }

    @Test
    void testElderlyUserDTOToString() {
        // Crear una instancia de ElderlyUserDTO
        ElderlyUserDTO elderlyUserDTO = new ElderlyUserDTO(1L, "John Doe", "john@example.com", "123456789");

        // Verificar que el método toString devuelve el formato esperado
        String expectedToString = "ElderlyUserDTO[id=1, name=John Doe, email=john@example.com, phone=123456789]";
        assertEquals(expectedToString, elderlyUserDTO.toString());
    }
}
