package entitiesTest;
import org.junit.jupiter.api.Test;
import dev.team4.vinko.entities.Chat;
import dev.team4.vinko.entities.Companion;
import dev.team4.vinko.entities.ElderlyUser;

import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class ChatTest {

    @Test
    void testChatGettersAndSetters() {
        // Crear una instancia de Chat
        Chat chat = new Chat();

        // Asignar valores usando setters
        chat.setId(1L);
        chat.setMessage("Hello, how are you?");
        chat.setSentDate(LocalDateTime.of(2023, 10, 1, 12, 0));

        // Verificar que los getters devuelven los valores correctos
        assertEquals(1L, chat.getId());
        assertEquals("Hello, how are you?", chat.getMessage());
        assertEquals(LocalDateTime.of(2023, 10, 1, 12, 0), chat.getSentDate());
    }

    @Test
    void testChatRelationships() {
        // Crear una instancia de Chat
        Chat chat = new Chat();

        // Crear instancias de ElderlyUser y Companion
        ElderlyUser elderlyUser = new ElderlyUser();
        elderlyUser.setId(1L);
        elderlyUser.setName("John Doe");

        Companion companion = new Companion();
        companion.setId(1L);
        companion.setName("Jane Doe");

        // Asignar las relaciones
        chat.setElderlyUser(elderlyUser);
        chat.setCompanion(companion);

        // Verificar que las relaciones se asignaron correctamente
        assertEquals(elderlyUser, chat.getElderlyUser());
        assertEquals(companion, chat.getCompanion());
    }

    @Test
    void testChatEqualsAndHashCode() {
        // Crear dos instancias de Chat con los mismos valores
        LocalDateTime sentDate = LocalDateTime.of(2023, 10, 1, 12, 0);
        Chat chat1 = new Chat();
        chat1.setId(1L);
        chat1.setMessage("Hello, how are you?");
        chat1.setSentDate(sentDate);

        Chat chat2 = new Chat();
        chat2.setId(1L);
        chat2.setMessage("Hello, how are you?");
        chat2.setSentDate(sentDate);

        // Verificar que son iguales
        assertEquals(chat1, chat2);
        assertEquals(chat1.hashCode(), chat2.hashCode());
    }

    @Test
    void testChatNotEquals() {
        // Crear dos instancias de Chat con valores diferentes
        LocalDateTime sentDate1 = LocalDateTime.of(2023, 10, 1, 12, 0);
        LocalDateTime sentDate2 = LocalDateTime.of(2023, 10, 2, 12, 0);
        Chat chat1 = new Chat();
        chat1.setId(1L);
        chat1.setMessage("Hello, how are you?");
        chat1.setSentDate(sentDate1);

        Chat chat2 = new Chat();
        chat2.setId(2L);
        chat2.setMessage("Can you assist me?");
        chat2.setSentDate(sentDate2);

        // Verificar que no son iguales
        assertNotEquals(chat1, chat2);
        assertNotEquals(chat1.hashCode(), chat2.hashCode());
    }

    @Test
    void testChatToString() {
        // Crear una instancia de Chat
        LocalDateTime sentDate = LocalDateTime.of(2023, 10, 1, 12, 0);
        Chat chat = new Chat();
        chat.setId(1L);
        chat.setMessage("Hello, how are you?");
        chat.setSentDate(sentDate);

        // Verificar que el método toString devuelve el formato esperado
        String expectedToString = "Chat(id=1, message=Hello, how are you?, sentDate=2023-10-01T12:00, elderlyUser=null, companion=null)";
        assertEquals(expectedToString, chat.toString());
    }
}
