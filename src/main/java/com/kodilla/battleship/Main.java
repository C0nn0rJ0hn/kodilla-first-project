package com.kodilla.battleship;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;


import java.util.*;


public class Main extends Application {

    Stage window;
    int shipsOnEnemyBoard = 6;
    int shipsOnPlayerBoard = 6;
    Random r = new Random();




    //Create boards
    BuildBoard playerBoard = new BuildBoard(11, 11, 40);
    BuildBoard enemyBoard = new BuildBoard(11, 11, 40);

    //Ship lists
    List<Ship> playerShips = new ArrayList<>();
    List<Ship> enemyShips = new ArrayList<>();

    //List storing coordinates of enemy shooting
    List<Point2D> enemyCoordinates = new ArrayList<>();

    //List storing coordinates of player shooting
    List<Point2D> playerCoordinates = new ArrayList<>();



    public void enemyMove()
    {
        int x = (r.nextInt(10) + 1) * 40;
        int y = (r.nextInt(10) + 1) * 40;

        Point2D point = new Point2D(x,y);

        if (!enemyCoordinates.contains(point))
        {
            enemyCoordinates.add(point);

            if (playerShips.get(0).isHit(x,y))
            {
                Rectangle hit = new Rectangle(40,40);
                hit.setStroke(Color.BLACK);
                hit.setFill(Color.YELLOWGREEN);
                hit.setX(x);
                hit.setY(y);
                playerBoard.getChildren().addAll(hit);
                playerShips.get(0).addRect(hit);
                if (playerShips.get(0).isDown())
                {
                    shipsOnPlayerBoard--;
                    playerShips.get(0).getRectangleList().forEach(e -> e.setFill(Color.RED));
                }
            }
            else if (playerShips.get(1).isHit(x,y))
            {
                Rectangle hit = new Rectangle(40,40);
                hit.setStroke(Color.BLACK);
                hit.setFill(Color.YELLOWGREEN);
                hit.setX(x);
                hit.setY(y);
                playerBoard.getChildren().addAll(hit);
                playerShips.get(1).addRect(hit);
                if (playerShips.get(1).isDown())
                {
                    shipsOnPlayerBoard--;
                    playerShips.get(1).getRectangleList().forEach(e -> e.setFill(Color.RED));
                }
            }
            else if (playerShips.get(2).isHit(x,y))
            {
                Rectangle hit = new Rectangle(40,40);
                hit.setStroke(Color.BLACK);
                hit.setFill(Color.YELLOWGREEN);
                hit.setX(x);
                hit.setY(y);
                playerBoard.getChildren().addAll(hit);
                playerShips.get(2).addRect(hit);
                if (playerShips.get(2).isDown())
                {
                    shipsOnPlayerBoard--;
                    playerShips.get(2).getRectangleList().forEach(e -> e.setFill(Color.RED));
                }
            }
            else if (playerShips.get(3).isHit(x,y)) {
                Rectangle hit = new Rectangle(40, 40);
                hit.setStroke(Color.BLACK);
                hit.setFill(Color.YELLOWGREEN);
                hit.setX(x);
                hit.setY(y);
                playerBoard.getChildren().addAll(hit);
                playerShips.get(3).addRect(hit);
                if (playerShips.get(3).isDown()) {
                    shipsOnPlayerBoard--;
                    playerShips.get(3).getRectangleList().forEach(e -> e.setFill(Color.RED));
                }
            }
            else if (playerShips.get(4).isHit(x,y)) {
                Rectangle hit = new Rectangle(40, 40);
                hit.setStroke(Color.BLACK);
                hit.setFill(Color.YELLOWGREEN);
                hit.setX(x);
                hit.setY(y);
                playerBoard.getChildren().addAll(hit);
                playerShips.get(4).addRect(hit);
                if (playerShips.get(4).isDown()) {
                    shipsOnPlayerBoard--;
                    playerShips.get(4).getRectangleList().forEach(e -> e.setFill(Color.RED));
                }
            }
            else if (playerShips.get(5).isHit(x,y)) {
                Rectangle hit = new Rectangle(40, 40);
                hit.setStroke(Color.BLACK);
                hit.setFill(Color.YELLOWGREEN);
                hit.setX(x);
                hit.setY(y);
                playerBoard.getChildren().addAll(hit);
                playerShips.get(5).addRect(hit);
                if (playerShips.get(5).isDown()) {
                    shipsOnPlayerBoard--;
                    playerShips.get(5).getRectangleList().forEach(e -> e.setFill(Color.RED));
                }
            }
            else
            {
                Circle circle = new Circle(x + 20,y + 20, 7, Color.BLACK);
                playerBoard.getChildren().addAll(circle);
            }
            if (shipsOnPlayerBoard == 0 && shipsOnEnemyBoard > 0)
            {
                gameResultLost();
            }
        }
        else
        {
            enemyMove();
        }
    }


    private void closeProgram() {
        Boolean answer = ConfirmBox.display("EXIT GAME", "Are you sure you want to exit?");
        if (answer) {
            window.close();
        }
    }

    private void gameResultWin() {
        ConfirmWin.display("RESULT", "You WON the Battleship game!");

    }

    private void gameResultLost() {
        ConfirmWin.display("RESULT", "You LOST the Battleship game!");

    }

    //Method to check if random x and y do not collide with ship neighbours
    /*public boolean getNeighbors(int x, int y, List<Ship> shipList)
    {
        boolean canPlaceShip = true;
        for (Ship check : shipList)
        {
            if (check.getShipX()-40 <= x && x <= check.getShipX() + check.getShipWidth() && check.getShipY()-40 <= y
                    && y <= check.getShipY() + check.getShipHeight())
            {
                canPlaceShip = false;
            }
            else
            {
                canPlaceShip = true;
            }
        }
        return canPlaceShip;
    }*/

    @Override
    public void start(Stage primaryStage) {

        window = primaryStage;
        window.setOnCloseRequest(e ->
        {
            e.consume();
            closeProgram();
        });

        window.addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {
            if (KeyCode.ESCAPE == event.getCode()) {
                closeProgram();
            }
        });

        GridPane root = new GridPane();

        StackPane titlePlayer = new StackPane();
        Label playerBoardLabel = new Label("Player Board");
        playerBoardLabel.setFont(new Font("Arial", 25));
        titlePlayer.getChildren().add(playerBoardLabel);

        StackPane titleEnemy = new StackPane();
        Label enemyBoardLabel = new Label("Enemy Board");
        enemyBoardLabel.setFont(new Font("Arial", 25));
        titleEnemy.getChildren().add(enemyBoardLabel);

        //Create ships
        CreateShips shipBoat = new CreateShips(Color.BLUE, Color.BLACK);
        CreateShips shipPatrolBoat = new CreateShips(Color.BLUE, Color.BLACK);
        CreateShips shipSubmarine = new CreateShips(Color.BLUE, Color.BLACK);
        CreateShips shipDestroyer = new CreateShips(Color.BLUE, Color.BLACK);
        CreateShips shipBattleship = new CreateShips(Color.BLUE, Color.BLACK);
        CreateShips shipCarrier = new CreateShips(Color.BLUE, Color.BLACK);

        //Locate ships on board
        Ship ship1Cell = new Ship(40, 40, 40, 40, shipBoat);
        Moves moves = new Moves();
        ShipMoves ship1Moves = new ShipMoves(ship1Cell, moves, shipBoat);
        ship1Moves.createMoves();

        Ship ship2Cells = new Ship(40, 120, 40, 80, shipPatrolBoat);
        ShipMoves ship2Moves = new ShipMoves(ship2Cells, moves, shipPatrolBoat);
        ship2Moves.createMoves();

        Ship ship3Cells = new Ship(40, 200, 40, 120, shipSubmarine);
        ShipMoves ship3Moves = new ShipMoves(ship3Cells, moves, shipSubmarine);
        ship3Moves.createMoves();

        Ship ship3Cells2 = new Ship(40, 280, 40, 120, shipDestroyer);
        ShipMoves ship4Moves = new ShipMoves(ship3Cells2, moves, shipDestroyer);
        ship4Moves.createMoves();

        Ship ship4Cells = new Ship(40, 360, 40, 160, shipBattleship);
        ShipMoves ship5Moves = new ShipMoves(ship4Cells, moves, shipBattleship);
        ship5Moves.createMoves();

        Ship ship5Cells = new Ship(240, 200, 40, 200, shipCarrier);
        ShipMoves ship6Moves = new ShipMoves(ship5Cells, moves, shipCarrier);
        ship6Moves.createMoves();

        //Create start game button
        Button startButton = new Button("Start Game");
        EventHandler<MouseEvent> handler = MouseEvent::consume;
        startButton.setOnMousePressed(event -> {
            playerShips.add(ship1Cell);
            playerShips.add(ship2Cells);
            playerShips.add(ship3Cells);
            playerShips.add(ship3Cells2);
            playerShips.add(ship4Cells);
            playerShips.add(ship5Cells);

            playerBoard.addEventFilter(MouseEvent.MOUSE_DRAGGED, handler);
            startButton.setDisable(true);
        });

        //Enemy board ships
        CreateShips enemyBoat = new CreateShips(Color.TRANSPARENT, Color.BLACK);
        CreateShips enemyPatrolBoat = new CreateShips(Color.TRANSPARENT, Color.BLACK);
        CreateShips enemySubmarine = new CreateShips(Color.TRANSPARENT, Color.BLACK);
        CreateShips enemyDestroyer = new CreateShips(Color.TRANSPARENT, Color.BLACK);
        CreateShips enemyBattleship = new CreateShips(Color.TRANSPARENT, Color.BLACK);
        CreateShips enemyCarrier = new CreateShips(Color.TRANSPARENT, Color.BLACK);

        Ship enemyShip1Cell = new Ship(160, 80, 80, 40, enemyBoat);
        Ship enemyShip2Cells = new Ship(320, 200, 40, 80, enemyPatrolBoat);
        enemyShip2Cells.makeVertical();
        Ship enemyShip3Cells = new Ship(280, 320, 40, 120, enemySubmarine);
        Ship enemyShip3Cells2 = new Ship(80, 160, 40, 120, enemyDestroyer);
        enemyShip3Cells2.makeVertical();
        Ship enemyShip4Cells = new Ship(240, 40, 40, 160, enemyBattleship);
        Ship enemyShip5Cells = new Ship(200, 240, 40, 200, enemyCarrier);
        enemyShip5Cells.makeVertical();



        //Generate random enemy ships placement
        /*for (int i = 0; i < 100; i++)
        {
            int x = (r.nextInt(10) + 1) * 40;
            int y = (r.nextInt(10) + 1) * 40;
            boolean isVertical = r.nextBoolean();
            if (isVertical)
            {
                enemyShip5Cells.makeVertical();
            }

            if (enemyShip5Cells.fitShipOnBoard(x, y))
            {
                enemyShip5Cells.setShipX(x);
                enemyShip5Cells.setShipY(y);
                enemyShips.add(enemyShip5Cells);
                break;
            }
            else
            {
                continue;
            }
        }

        for (int i = 0; i < 100; i++)
        {
            int x = (r.nextInt(10) + 1) * 40;
            int y = (r.nextInt(10) + 1) * 40;

            boolean isVertical = r.nextBoolean();
            if (isVertical)
            {
                enemyShip4Cells.makeVertical();
            }
            if (getNeighbors(x,y, enemyShips))
            {
                if (enemyShip4Cells.fitShipOnBoard(x,y))
                {
                    enemyShip4Cells.setShipX(x);
                    enemyShip4Cells.setShipY(y);
                    enemyShips.add(enemyShip4Cells);
                    break;
                }
            }
            else
            {
                continue;
            }
        }

        for (int i = 0; i < 100; i++)
        {
            int x = (r.nextInt(10) + 1) * 40;
            int y = (r.nextInt(10) + 1) * 40;

            boolean isVertical = r.nextBoolean();
            if (isVertical)
            {
                enemyShip3Cells.makeVertical();
            }
            if (getNeighbors(x,y, enemyShips))
            {
                if (enemyShip3Cells2.fitShipOnBoard(x,y))
                {
                    enemyShip3Cells2.setShipX(x);
                    enemyShip3Cells2.setShipY(y);
                    enemyShips.add(enemyShip3Cells2);
                    break;
                }
            }
            else
            {
                continue;
            }
        }

        for (int i = 0; i < 100; i++)
        {
            int x = (r.nextInt(10) + 1) * 40;
            int y = (r.nextInt(10) + 1) * 40;

            boolean isVertical = r.nextBoolean();
            if (isVertical)
            {
                enemyShip3Cells2.makeVertical();
            }
            if (getNeighbors(x,y, enemyShips))
            {
                if (enemyShip3Cells.fitShipOnBoard(x,y))
                {
                    enemyShip3Cells.setShipX(x);
                    enemyShip3Cells.setShipY(y);
                    enemyShips.add(enemyShip3Cells);
                    break;
                }
            }
            else
            {
                continue;
            }
        }

        for (int i = 0; i < 100; i++)
        {
            int x = (r.nextInt(10) + 1) * 40;
            int y = (r.nextInt(10) + 1) * 40;

            boolean isVertical = r.nextBoolean();
            if (isVertical)
            {
                enemyShip2Cells.makeVertical();
            }
            if (getNeighbors(x,y, enemyShips))
            {
                if (enemyShip2Cells.fitShipOnBoard(x,y))
                {
                    enemyShip2Cells.setShipX(x);
                    enemyShip2Cells.setShipY(y);
                    enemyShips.add(enemyShip2Cells);
                    break;
                }
            }
            else
            {
                continue;
            }
        }

        for (int i = 0; i < 100; i++)
        {
            int x = (r.nextInt(10) + 1) * 40;
            int y = (r.nextInt(10) + 1) * 40;

            if (getNeighbors(x,y, enemyShips))
            {
                if (enemyShip1Cell.fitShipOnBoard(x,y))
                {
                    enemyShip1Cell.setShipX(x);
                    enemyShip1Cell.setShipY(y);
                    enemyShips.add(enemyShip1Cell);
                    break;
                }
            }
            else
            {
                continue;
            }
        }*/

        //Shooting to target (missed, hit) - enemy board
        enemyBoard.setOnMousePressed(event ->
                {
                    Point2D point = new Point2D(enemyBoard.getBoardX(), enemyBoard.getBoardY());

                    if (!playerCoordinates.contains(point))
                    {
                        playerCoordinates.add(point);

                        if (enemyShip1Cell.isHit(enemyBoard.getBoardX(), enemyBoard.getBoardY()))
                        {
                            Rectangle hit = new Rectangle(40,40);
                            hit.setStroke(Color.BLACK);
                            hit.setFill(Color.YELLOWGREEN);
                            hit.setX(enemyBoard.getBoardX());
                            hit.setY(enemyBoard.getBoardY());
                            enemyBoard.getChildren().addAll(hit);
                            enemyShip1Cell.addRect(hit);
                            if (enemyShip1Cell.isDown())
                            {
                                shipsOnEnemyBoard--;
                                enemyShip1Cell.getRectangleList().forEach(e -> e.setFill(Color.RED));
                            }
                        }
                        else if (enemyShip2Cells.isHit(enemyBoard.getBoardX(), enemyBoard.getBoardY()))
                        {
                            Rectangle hit = new Rectangle(40,40);
                            hit.setStroke(Color.BLACK);
                            hit.setFill(Color.YELLOWGREEN);
                            hit.setX(enemyBoard.getBoardX());
                            hit.setY(enemyBoard.getBoardY());
                            enemyBoard.getChildren().addAll(hit);
                            enemyShip2Cells.addRect(hit);
                            if (enemyShip2Cells.isDown())
                            {
                                shipsOnEnemyBoard--;
                                enemyShip2Cells.getRectangleList().forEach(e -> e.setFill(Color.RED));
                            }
                        }
                        else if (enemyShip3Cells.isHit(enemyBoard.getBoardX(), enemyBoard.getBoardY()))
                        {
                            Rectangle hit = new Rectangle(40,40);
                            hit.setStroke(Color.BLACK);
                            hit.setFill(Color.YELLOWGREEN);
                            hit.setX(enemyBoard.getBoardX());
                            hit.setY(enemyBoard.getBoardY());
                            enemyBoard.getChildren().addAll(hit);
                            enemyShip3Cells.addRect(hit);
                            if (enemyShip3Cells.isDown())
                            {
                                shipsOnEnemyBoard--;
                                enemyShip3Cells.getRectangleList().forEach(e -> e.setFill(Color.RED));
                            }
                        }
                        else if (enemyShip3Cells2.isHit(enemyBoard.getBoardX(), enemyBoard.getBoardY()))
                        {
                            Rectangle hit = new Rectangle(40,40);
                            hit.setStroke(Color.BLACK);
                            hit.setFill(Color.YELLOWGREEN);
                            hit.setX(enemyBoard.getBoardX());
                            hit.setY(enemyBoard.getBoardY());
                            enemyBoard.getChildren().addAll(hit);
                            enemyShip3Cells2.addRect(hit);
                            if (enemyShip3Cells2.isDown())
                            {
                                shipsOnEnemyBoard--;
                                enemyShip3Cells2.getRectangleList().forEach(e -> e.setFill(Color.RED));
                            }
                        }
                        else if (enemyShip4Cells.isHit(enemyBoard.getBoardX(), enemyBoard.getBoardY()))
                        {
                            Rectangle hit = new Rectangle(40,40);
                            hit.setStroke(Color.BLACK);
                            hit.setFill(Color.YELLOWGREEN);
                            hit.setX(enemyBoard.getBoardX());
                            hit.setY(enemyBoard.getBoardY());
                            enemyBoard.getChildren().addAll(hit);
                            enemyShip4Cells.addRect(hit);
                            if (enemyShip4Cells.isDown())
                            {
                                shipsOnEnemyBoard--;
                                enemyShip4Cells.getRectangleList().forEach(e -> e.setFill(Color.RED));
                            }
                        }
                        else if (enemyShip5Cells.isHit(enemyBoard.getBoardX(), enemyBoard.getBoardY()))
                        {
                            Rectangle hit = new Rectangle(40,40);
                            hit.setStroke(Color.BLACK);
                            hit.setFill(Color.YELLOWGREEN);
                            hit.setX(enemyBoard.getBoardX());
                            hit.setY(enemyBoard.getBoardY());
                            enemyBoard.getChildren().addAll(hit);
                            enemyShip5Cells.addRect(hit);
                            if (enemyShip5Cells.isDown())
                            {
                                shipsOnEnemyBoard--;
                                enemyShip5Cells.getRectangleList().forEach(e -> e.setFill(Color.RED));
                            }
                        }
                        else
                        {
                            Circle circle = new Circle(enemyBoard.getBoardX() + 20, enemyBoard.getBoardY() + 20, 7, Color.BLACK);
                            enemyBoard.getChildren().addAll(circle);
                            enemyMove();
                        }
                        if (shipsOnEnemyBoard == 0 && shipsOnPlayerBoard > 0 )
                        {
                            gameResultWin();
                        }
                    }
                });

        //Create buttons
        Buttons boat = new Buttons("Boat");
        Buttons patrolBoat = new Buttons("Patrol Boat");
        Buttons submarine = new Buttons("Submarine");
        Buttons destroyer = new Buttons("Destroyer");
        Buttons battleship = new Buttons("Battleship");
        Buttons carrier = new Buttons("Carrier");

        //Get ships on player board by pressing specific button
        ButtonAction patrolBoatAction = new ButtonAction(playerBoard, shipPatrolBoat, patrolBoat);
        patrolBoatAction.setAction();

        ButtonAction boatAction = new ButtonAction(playerBoard, shipBoat, boat);
        boatAction.setAction();

        ButtonAction submarineAction = new ButtonAction(playerBoard, shipSubmarine, submarine);
        submarineAction.setAction();

        ButtonAction destroyerAction = new ButtonAction(playerBoard, shipDestroyer, destroyer);
        destroyerAction.setAction();

        ButtonAction battleshipAction = new ButtonAction(playerBoard, shipBattleship, battleship);
        battleshipAction.setAction();

        ButtonAction carrierAction = new ButtonAction(playerBoard, shipCarrier, carrier);
        carrierAction.setAction();

        //Layout for scene
        HBox buttonsBar = new HBox(8);
        HBox.setHgrow(boat, Priority.ALWAYS);
        HBox.setHgrow(patrolBoat, Priority.ALWAYS);
        HBox.setHgrow(submarine, Priority.ALWAYS);

        HBox buttonsBar2 = new HBox(8);
        HBox.setHgrow(destroyer, Priority.ALWAYS);
        HBox.setHgrow(battleship, Priority.ALWAYS);
        HBox.setHgrow(carrier, Priority.ALWAYS);

        buttonsBar.setAlignment(Pos.CENTER);
        buttonsBar.getChildren().addAll(boat, patrolBoat, submarine);
        buttonsBar2.setAlignment(Pos.CENTER);
        buttonsBar2.getChildren().addAll(destroyer, battleship, carrier);

        StackPane gameStartPane = new StackPane();
        gameStartPane.getChildren().addAll(startButton);



        root.setPadding(new Insets(20,20,20,20));
        root.setHgap(20);
        root.setVgap(20);
        root.add(titlePlayer, 0, 0);
        root.add(titleEnemy, 1, 0);
        root.add(playerBoard, 0, 1);
        root.add(enemyBoard, 1,1);
        root.add(buttonsBar, 0, 2);
        root.add(buttonsBar2,0,3);
        root.add(gameStartPane, 1, 2);

        //root.setGridLinesVisible(true);

        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

