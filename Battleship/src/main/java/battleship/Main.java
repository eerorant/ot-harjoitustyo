package battleship;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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

        // Main menu
        BorderPane menuPane = new BorderPane();
        Button startButton = new Button("Start");
        
        menuPane.setCenter(startButton);
        Scene menuScene = new Scene(menuPane, 1000, 1000);

        // Game view
        BorderPane gamePane = new BorderPane();
        gamePane.setPrefSize(400, 600);
        VBox gameBox = new VBox();
        GridPane board1 = new GridPane();
        GridPane board2 = new GridPane();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board1.add(new Button(i + ", " + j), i, j);
                board2.add(new Button(i + ", " + j), i, j);
            }
        }
        gameBox.getChildren().addAll(board1, board2);
        gameBox.setSpacing(40);
        gamePane.setCenter(gameBox);
        Scene gameScene = new Scene(gamePane, 1000, 1000);

        // Main menu start button
        startButton.setOnAction((event) -> {
            window.setScene(gameScene);
            System.out.println("yeet");
        });

        window.setScene(menuScene);
        window.show();
    }
}
