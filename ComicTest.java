package comicstore;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComicTest {
    @Test
    void testGettersAndSetters() {
        Comic c = new Comic("C001", "Spider-Man", 1, "Marvel", 3.99, 10);
        assertEquals("C001", c.getId());
        c.setId("C002");
        assertEquals("C002", c.getId());

        c.setQuantity(5);
        assertEquals(5, c.getQuantity());
    }

    @Test
    void testToStringContainsFields() {
        Comic c = new Comic("C001", "Batman", 50, "DC", 4.99, 20);
        String s = c.toString();
        assertTrue(s.contains("Batman"));
        assertTrue(s.contains("DC"));
        assertTrue(s.contains("50"));
    }
}
