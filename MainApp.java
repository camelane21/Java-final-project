package comicstore;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Entry point for the Comic Store Management System JavaFX application.
 */
public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        InventoryView view = new InventoryView();
        Scene scene = new Scene(view.getRoot(), 800, 600);

        primaryStage.setTitle("Comic Store Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
