package comicstore;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

class SaleTest {
    @Test
    void testTotalPriceCalculation() {
        Comic comic = new Comic("C200", "Wonder Woman", 75, "DC", 5.00, 10);
        Sale sale = new Sale("S001", comic, 3, LocalDateTime.now());
        assertEquals(15.00, sale.getTotalPrice(), 0.001);
    }

    @Test
    void testSaleToString() {
        Comic comic = new Comic("C201", "Green Lantern", 1, "DC", 4.50, 8);
        LocalDateTime now = LocalDateTime.of(2025, 7, 11, 14, 0);
        Sale sale = new Sale("S002", comic, 2, now);
        String repr = sale.toString();
        assertTrue(repr.contains("S002"));
        assertTrue(repr.contains("C201"));
        assertTrue(repr.contains("2"));
    }
}
