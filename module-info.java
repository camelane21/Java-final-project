module comicstore {
    requires javafx.controls;
    requires javafx.fxml;   
    exports comicstore;
    opens comicstore to javafx.fxml;
}
