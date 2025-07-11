/**
 * Represents a comic book in the inventory.
 */
public class Comic {
    private String id;
    private String title;
    private int issueNumber;
    private String publisher;
    private double price;
    private int quantity;

    /**
     * Constructs a new Comic with the given properties.
     */
    public Comic(String id, String title, int issueNumber, String publisher, double price, int quantity) {
        this.id = id;
        this.title = title;
        this.issueNumber = issueNumber;
        this.publisher = publisher;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getIssueNumber() { return issueNumber; }
    public void setIssueNumber(int issueNumber) { this.issueNumber = issueNumber; }

    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return String.format("Comic[id=%s, title=%s, issue=%d, publisher=%s, price=%.2f, qty=%d]",
                id, title, issueNumber, publisher, price, quantity);
    }
}
