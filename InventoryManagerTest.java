package comicstore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

class InventoryManagerTest {
    private InventoryManager manager;
    private Comic comic;

    @BeforeEach
    void setUp() {
        manager = new InventoryManager();
        comic = new Comic("C100", "X-Men", 1, "Marvel", 2.99, 15);
        manager.addComic(comic);
    }

    @Test
    void testAddAndFind() {
        Optional<Comic> found = manager.findComicById("C100");
        assertTrue(found.isPresent());
        assertEquals("X-Men", found.get().getTitle());
    }

    @Test
    void testRemoveComic() {
        assertTrue(manager.removeComic("C100"));
        assertFalse(manager.findComicById("C100").isPresent());
    }

    @Test
    void testUpdateQuantity() {
        assertTrue(manager.updateQuantity("C100", 30));
        assertEquals(30, manager.findComicById("C100").get().getQuantity());
    }
}
