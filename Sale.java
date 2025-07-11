package comicstore;

import java.time.LocalDateTime;

/**
 * Represents a sale transaction of comics.
 */
public class Sale {
    private String saleId;
    private Comic comic;
    private int quantitySold;
    private LocalDateTime saleDate;
    private double totalPrice;

    /**
     * Constructs a new Sale and calculates total price.
     */
    public Sale(String saleId, Comic comic, int quantitySold, LocalDateTime saleDate) {
        this.saleId = saleId;
        this.comic = comic;
        this.quantitySold = quantitySold;
        this.saleDate = saleDate;
        this.totalPrice = comic.getPrice() * quantitySold;
    }

    public String getSaleId() { return saleId; }
    public Comic getComic() { return comic; }
    public int getQuantitySold() { return quantitySold; }
    public LocalDateTime getSaleDate() { return saleDate; }
    public double getTotalPrice() { return totalPrice; }

    @Override
    public String toString() {
        return String.format("Sale[id=%s, comic=%s, qty=%d, date=%s, total=%.2f]",
                saleId, comic.getId(), quantitySold, saleDate, totalPrice);
    }
}