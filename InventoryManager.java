package comicstore;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Manages the comic inventory, allowing add/remove/update operations.
 */
public class InventoryManager {
    private List<Comic> comics = new ArrayList<>();

    /**
     * Adds a new comic to the inventory.
     */
    public void addComic(Comic comic) {
        comics.add(comic);
    }

    /**
     * Removes a comic by its ID. Returns true if removed.
     */
    public boolean removeComic(String id) {
        return comics.removeIf(c -> c.getId().equals(id));
    }

    /**
     * Finds a comic by ID.
     */
    public Optional<Comic> findComicById(String id) {
        return comics.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    /**
     * Lists all comics in inventory.
     */
    public List<Comic> listAllComics() {
        return new ArrayList<>(comics);
    }

    /**
     * Updates the quantity of a comic. Returns true if successful.
     */
    public boolean updateQuantity(String id, int newQuantity) {
        Optional<Comic> opt = findComicById(id);
        if (opt.isPresent()) {
            opt.get().setQuantity(newQuantity);
            return true;
        }
        return false;
    }
}