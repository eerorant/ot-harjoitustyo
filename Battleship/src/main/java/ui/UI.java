package ui;

import control.Board;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;

/**
 *
 * @author eero
 */
public class UI {

    Board boardA = new Board('A');
    Board boardB = new Board('B');
    Button[][] buttonsASetUp;
    Button[][] buttonsBSetUp;
    Button[][] buttonsAGame = new Button[10][10];
    Button[][] buttonsBGame = new Button[10][10];
    boolean aSet = false;
    boolean bSet = false;
    Stage window;
    Scene menuScene;
    Scene setUpScene;
    Scene gameScene;
    int turn;
    String playerAName;
    String playerBName;

    public UI(Stage window) {
        this.window = window;
        this.turn = 1;
    }

    public void UIStart() {
        initMainMenu();
        initSetUp();
        initGame();

        window.setScene(menuScene);
        window.show();
    }

    public void paintTilesSet() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (boardA.getTile(i, j) == 1) {
                    buttonsASetUp[i][j].setStyle("-fx-background-color: #fff200; ");
                } else if (boardA.getTile(i, j) == 0) {
                    buttonsASetUp[i][j].setStyle("-fx-background-color: #0062ff; ");
                }
                if (boardB.getTile(i, j) == 1) {
                    buttonsBSetUp[i][j].setStyle("-fx-background-color: #fff200; ");
                } else if (boardB.getTile(i, j) == 0) {
                    buttonsBSetUp[i][j].setStyle("-fx-background-color: #0062ff; ");
                }
                if (boardA.getShipSquares() >= 15) {
                    buttonsASetUp[i][j].setStyle("-fx-background-color: #b5b5b5; ");
                }
                if (boardB.getShipSquares() >= 15) {
                    buttonsBSetUp[i][j].setStyle("-fx-background-color: #b5b5b5; ");
                }
            }
        }
    }

    public void paintTilesGame() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (boardA.getTile(i, j) == 0) {
                    buttonsAGame[i][j].setStyle("-fx-background-color: #0062ff; ");
                }
                if (boardA.getTile(i, j) == 2) {
                    buttonsAGame[i][j].setStyle("-fx-background-color: #ff5e00; ");
                }
                if (boardA.getTile(i, j) == 3) {
                    buttonsAGame[i][j].setStyle("-fx-background-color: #c9deff; ");
                }
                if (boardB.getTile(i, j) == 0) {
                    buttonsBGame[i][j].setStyle("-fx-background-color: #0062ff; ");
                }
                if (boardB.getTile(i, j) == 2) {
                    buttonsBGame[i][j].setStyle("-fx-background-color: #ff5e00; ");
                }
                if (boardB.getTile(i, j) == 3) {
                    buttonsBGame[i][j].setStyle("-fx-background-color: #c9deff; ");
                }
            }
        }
    }

    public void initMainMenu() {
        BorderPane menuPane = new BorderPane();
        Button startButton = new Button("Start");
        menuPane.setCenter(startButton);
        this.menuScene = new Scene(menuPane, 1000, 1000);
        // Main menu start button
        startButton.setOnAction((event) -> {
            window.setScene(setUpScene);
        });
    }

    public void initSetUp() {
        GridPane boardGridSetUp1 = new GridPane();
        GridPane boardGridSetUp2 = new GridPane();

        boardGridSetUp1.setHgap(5);
        boardGridSetUp2.setHgap(5);
        boardGridSetUp1.setVgap(5);
        boardGridSetUp2.setVgap(5);

        buttonsASetUp = new Button[10][10];
        buttonsBSetUp = new Button[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int row = i;
                int column = j;

                buttonsASetUp[row][column] = new Button(" ");
                buttonsBSetUp[row][column] = new Button(" ");
                buttonsASetUp[row][column].setStyle("-fx-background-color: #0062ff; ");
                buttonsBSetUp[row][column].setStyle("-fx-background-color: #0062ff; ");

                buttonsASetUp[row][column].setOnMouseClicked((event) -> {
                    if (event.getButton() == MouseButton.SECONDARY) {
                        boardA.setShip(row, column, false);
                    } else if (event.getButton() == MouseButton.PRIMARY) {
                        boardA.setShip(row, column, true);
                    }
                    if (boardA.getShips() == 5) {
                        aSet = true;
                    }
                    paintTilesSet();
                });

                buttonsBSetUp[row][column].setOnMouseClicked((event) -> {
                    if (aSet) {
                        if (event.getButton() == MouseButton.SECONDARY) {
                            boardB.setShip(row, column, false);
                        } else if (event.getButton() == MouseButton.PRIMARY) {
                            boardB.setShip(row, column, true);
                        }
                        if (boardB.getShips() == 5) {
                            bSet = true;
                        }
                        paintTilesSet();
                    }
                });

                boardGridSetUp1.add(buttonsASetUp[row][column], column, row);
                boardGridSetUp2.add(buttonsBSetUp[row][column], column, row);
            }
        }
        TextField playerA = new TextField();
        TextField playerB = new TextField();

        Button readyButton = new Button("Ready");
        readyButton.setOnAction((event) -> {
            playerAName = playerA.getText();
            playerBName = playerB.getText();
            window.setScene(gameScene);
        });

        VBox setUpBox = new VBox();
        setUpBox.getChildren().addAll(boardGridSetUp1, boardGridSetUp2);
        setUpBox.setSpacing(40);

        HBox hBox = new HBox();
        hBox.setSpacing(200);
        VBox vBox = new VBox();

        vBox.getChildren().addAll(playerA, playerB, readyButton);
        vBox.setSpacing(20);

        hBox.getChildren().addAll(setUpBox, vBox);
        this.setUpScene = new Scene(hBox, 1000, 1000);

    }

    public void initGame() {
        BorderPane gamePane = new BorderPane();
        gamePane.setPrefSize(1000, 1000);
        VBox gameBox = new VBox();
        GridPane boardGridGame1 = new GridPane();
        GridPane boardGridGame2 = new GridPane();

        boardGridGame1.setHgap(5);
        boardGridGame2.setHgap(5);
        boardGridGame1.setVgap(5);
        boardGridGame2.setVgap(5);

        Label gameText = new Label("Turn: " + turn);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int row = i;
                int column = j;

                buttonsAGame[row][column] = new Button(" ");
                buttonsBGame[row][column] = new Button(" ");
                buttonsAGame[row][column].setStyle("-fx-background-color: #0062ff; ");
                buttonsBGame[row][column].setStyle("-fx-background-color: #0062ff; ");

                buttonsAGame[row][column].setOnMouseClicked((event) -> {
                    if (turn == 2) {
                        if (event.getButton() == MouseButton.PRIMARY) {
                            boardA.bomb(row, column);
                            gameText.setText("");
                            turn = 1;
                        }
                        if (boardA.lost()) {
                            gameText.setText("A lost");
                        }
                        paintTilesGame();
                    }
                });

                buttonsBGame[row][column].setOnMouseClicked((event) -> {
                    if (turn == 1) {
                        if (event.getButton() == MouseButton.PRIMARY) {
                            boardB.bomb(row, column);
                            turn = 2;
                        }
                        if (boardB.lost()) {
                            gameText.setText("B lost");
                        }
                        paintTilesGame();
                    }
                });

                boardGridGame1.add(buttonsAGame[row][column], column, row);
                boardGridGame2.add(buttonsBGame[row][column], column, row);
            }
        }
        gameBox.getChildren().addAll(boardGridGame1, boardGridGame2);
        gameBox.setSpacing(40);

        gamePane.setCenter(gameBox);
        gamePane.setRight(gameText);
        this.gameScene = new Scene(gamePane, 1000, 1000);
    }
}
