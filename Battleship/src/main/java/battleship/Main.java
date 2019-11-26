package battleship;

import control.Board;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
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

    Board boardA = new Board('A');
    Board boardB = new Board('B');
    Button[][] buttonsA = new Button[10][10];
    Button[][] buttonsB = new Button[10][10];

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
        gamePane.setPrefSize(1000, 1000);
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

        // Set up the boards
        BorderPane setUpPane = new BorderPane();
        setUpPane.setPrefSize(1000, 1000);
        VBox setUpBox = new VBox();
        GridPane setUpGrid1 = new GridPane();
        GridPane setUpGrid2 = new GridPane();
        setUpGrid1.setHgap(5);
        setUpGrid2.setHgap(5);
        setUpGrid1.setVgap(5);
        setUpGrid2.setVgap(5);
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int x = i;
                int y = j;

                buttonsA[i][j] = new Button(" ");
                buttonsB[i][j] = new Button(" ");
                buttonsA[i][j].setStyle("-fx-background-color: #0062ff; ");
                buttonsB[i][j].setStyle("-fx-background-color: #0062ff; ");

                buttonsA[i][j].setOnMouseClicked((event) -> {
                    if (event.getButton() == MouseButton.SECONDARY) {
                        boardA.setShip(x, y, false);
                    } else if (event.getButton() == MouseButton.PRIMARY) {
                        boardA.setShip(x, y, true);
                    }
                    paintTiles();
                });
                

                buttonsB[i][j].setOnMouseClicked((event) -> {
                    if (event.getButton() == MouseButton.SECONDARY) {
                        boardB.setShip(x, y, false);
                    } else if (event.getButton() == MouseButton.PRIMARY) {
                        boardB.setShip(x, y, true);
                    }
                    paintTiles();
                });

                
                setUpGrid1.add(buttonsA[i][j], i, j);
                setUpGrid2.add(buttonsB[i][j], i, j);
            }
        }

        Button readyButton = new Button("Ready");
        readyButton.setOnAction((event) -> {
            window.setScene(gameScene);
        });

        setUpBox.getChildren().addAll(setUpGrid1, setUpGrid2);
        setUpBox.setSpacing(40);
        setUpPane.setCenter(setUpBox);
        setUpPane.setRight(readyButton);
        Scene setUpScene = new Scene(setUpPane, 1000, 1000);

        // Main menu start button
        startButton.setOnAction((event) -> {
            window.setScene(setUpScene);
        });
        
        window.setScene(menuScene);
        window.show();
    }

    public void paintTiles() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (boardA.getTile(i, j) == 1) {
                    buttonsA[i][j].setStyle("-fx-background-color: #fff200; ");
                }
                if (boardB.getTile(i, j) == 1) {
                    buttonsB[i][j].setStyle("-fx-background-color: #fff200; ");
                }
            }
        }
        
    }
}
