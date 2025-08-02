module comicstore {
    requires javafx.controls;
    requires javafx.fxml;    // if you use FXML
    exports comicstore;
    opens comicstore to javafx.fxml;
}
