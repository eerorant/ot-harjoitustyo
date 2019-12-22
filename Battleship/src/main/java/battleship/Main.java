package battleship;


import javafx.application.Application;
import javafx.stage.Stage;
import ui.UI;

/**
 *
 * @author eero
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(Main.class);
    }

    @Override
    public void start(Stage window) {
        UI ui = new UI(window);
        ui.UIStart();

    }
}