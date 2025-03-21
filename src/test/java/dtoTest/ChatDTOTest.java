package dtoTest;
import org.junit.jupiter.api.Test;
import dev.team4.vinko.dtos.ChatDTO;
import static org.junit.jupiter.api.Assertions.*;
class ChatDTOTest {

    @Test
    void testChatDTOGettersAndSetters() {
        // Crear una instancia de ChatDTO
        ChatDTO chatDTO = new ChatDTO();

        // Asignar valores usando setters
        chatDTO.setCompanionId(1L);
        chatDTO.setElderlyUserId(2L);
        chatDTO.setMessage("Hello, how are you?");

        // Verificar que los getters devuelven los valores correctos
        assertEquals(1L, chatDTO.getCompanionId());
        assertEquals(2L, chatDTO.getElderlyUserId());
        assertEquals("Hello, how are you?", chatDTO.getMessage());
    }

    @Test
    void testChatDTOEqualsAndHashCode() {
        // Crear dos instancias de ChatDTO con los mismos valores
        ChatDTO chatDTO1 = new ChatDTO();
        chatDTO1.setCompanionId(1L);
        chatDTO1.setElderlyUserId(2L);
        chatDTO1.setMessage("Hello, how are you?");

        ChatDTO chatDTO2 = new ChatDTO();
        chatDTO2.setCompanionId(1L);
        chatDTO2.setElderlyUserId(2L);
        chatDTO2.setMessage("Hello, how are you?");

        // Verificar que son iguales
        assertEquals(chatDTO1, chatDTO2);
        assertEquals(chatDTO1.hashCode(), chatDTO2.hashCode());
    }

    @Test
    void testChatDTONotEquals() {
        // Crear dos instancias de ChatDTO con valores diferentes
        ChatDTO chatDTO1 = new ChatDTO();
        chatDTO1.setCompanionId(1L);
        chatDTO1.setElderlyUserId(2L);
        chatDTO1.setMessage("Hello, how are you?");

        ChatDTO chatDTO2 = new ChatDTO();
        chatDTO2.setCompanionId(3L);
        chatDTO2.setElderlyUserId(4L);
        chatDTO2.setMessage("Can you assist me?");

        // Verificar que no son iguales
        assertNotEquals(chatDTO1, chatDTO2);
        assertNotEquals(chatDTO1.hashCode(), chatDTO2.hashCode());
    }

    @Test
    void testChatDTOToString() {
        // Crear una instancia de ChatDTO
        ChatDTO chatDTO = new ChatDTO();
        chatDTO.setCompanionId(1L);
        chatDTO.setElderlyUserId(2L);
        chatDTO.setMessage("Hello, how are you?");

        // Verificar que el método toString devuelve el formato esperado
        String expectedToString = "ChatDTO(companionId=1, elderlyUserId=2, message=Hello, how are you?)";
        assertEquals(expectedToString, chatDTO.toString());
    }
}
