package comicstore;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Separator;
import javafx.scene.layout.VBox;

import java.time.LocalDateTime;

/**
 * Builds the main inventory GUI, allowing adding and selling comics.
 */
public class InventoryView {
    private final BorderPane root;
    private final TableView<Comic> table;
    private final InventoryManager manager;
    private final ObservableList<Comic> data;

    public InventoryView() {
        manager = new InventoryManager();
        data = FXCollections.observableArrayList(manager.listAllComics());

        root  = new BorderPane();
        table = new TableView<>(data);

        createTable();
        createForm();
    }

    private void createTable() {
        TableColumn<Comic, String> idCol    = new TableColumn<>("ID");
        TableColumn<Comic, String> titleCol = new TableColumn<>("Title");
        TableColumn<Comic, Number> issueCol = new TableColumn<>("Issue");
        TableColumn<Comic, String> pubCol   = new TableColumn<>("Publisher");
        TableColumn<Comic, Number> priceCol = new TableColumn<>("Price");
        TableColumn<Comic, Number> qtyCol   = new TableColumn<>("Quantity");

        idCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getId()));
        titleCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getTitle()));
        issueCol.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getIssueNumber()));
        pubCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getPublisher()));
        priceCol.setCellValueFactory(c -> new SimpleDoubleProperty(c.getValue().getPrice()));
        qtyCol.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getQuantity()));

        table.getColumns().addAll(idCol, titleCol, issueCol, pubCol, priceCol, qtyCol);
        root.setCenter(table);
    }

    private void createForm() {
        VBox form = new VBox(10);
        form.setPadding(new Insets(10));

        TextField idField    = new TextField(); idField.setPromptText("ID");
        TextField titleField = new TextField(); titleField.setPromptText("Title");
        TextField issueField = new TextField(); issueField.setPromptText("Issue #");
        TextField pubField   = new TextField(); pubField.setPromptText("Publisher");
        TextField priceField = new TextField(); priceField.setPromptText("Price");
        TextField qtyField   = new TextField(); qtyField.setPromptText("Quantity");

        Button addBtn  = new Button("Add Comic");
        Button sellBtn = new Button("Sell Comic");

        addBtn.setOnAction(e -> {
            Comic c = new Comic(
                idField.getText(),
                titleField.getText(),
                Integer.parseInt(issueField.getText()),
                pubField.getText(),
                Double.parseDouble(priceField.getText()),
                Integer.parseInt(qtyField.getText())
            );
            manager.addComic(c);
            data.add(c);
            idField.clear(); titleField.clear(); issueField.clear();
            pubField.clear(); priceField.clear(); qtyField.clear();
        });

        sellBtn.setOnAction(e -> {
            Comic selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                new SaleView(selected, manager).show();
                table.refresh();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Please select a comic to sell.");
                alert.showAndWait();
            }
        });

        form.getChildren().addAll(
            new Label("New Comic:"),
            idField, titleField, issueField, pubField, priceField, qtyField,
            addBtn,
            new Separator(),
            sellBtn
        );

        root.setRight(form);
    }

    public Parent getRoot() {
        return root;
    }
}
