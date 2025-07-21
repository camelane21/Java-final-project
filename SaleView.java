package comicstore;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDateTime;

/**
 * Dialog window for processing a sale of a selected comic.
 */
public class SaleView {
    private final Stage stage;
    private final Comic comic;
    private final InventoryManager manager;

    public SaleView(Comic comic, InventoryManager manager) {
        this.comic  = comic;
        this.manager = manager;

        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Sell Comic: " + comic.getTitle());
        setupScene();
    }

    private void setupScene() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        Label info = new Label(
            "Selling: " + comic.getTitle() +
            " (In stock: " + comic.getQuantity() + ")"
        );

        TextField saleIdField = new TextField(); saleIdField.setPromptText("Sale ID");
        TextField qtyField    = new TextField(); qtyField.setPromptText("Quantity");

        Button confirmBtn = new Button("Confirm Sale");
        Button cancelBtn  = new Button("Cancel");

        confirmBtn.setOnAction(e -> {
            int qty = Integer.parseInt(qtyField.getText());
            new Sale(saleIdField.getText(), comic, qty, LocalDateTime.now());
            manager.updateQuantity(
                comic.getId(), comic.getQuantity() - qty
            );
            stage.close();
        });

        cancelBtn.setOnAction(e -> stage.close());

        HBox buttons = new HBox(10, confirmBtn, cancelBtn);
        layout.getChildren().addAll(info, saleIdField, qtyField, buttons);

        stage.setScene(new Scene(layout, 300, 200));
    }

    public void show() {
        stage.showAndWait();
    }
}
