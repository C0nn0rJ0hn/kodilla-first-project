package com.kodilla.battleship;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


public class Main extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        window = primaryStage;

        GridPane root = new GridPane();

        StackPane titlePlayer = new StackPane();
        Label playerBoardLabel = new Label("Player Board");
        playerBoardLabel.setFont(new Font("Arial", 25));
        titlePlayer.getChildren().add(playerBoardLabel);

        StackPane titleEnemy = new StackPane();
        Label enemyBoardLabel = new Label("Enemy Board");
        enemyBoardLabel.setFont(new Font("Arial", 25));
        titleEnemy.getChildren().add(enemyBoardLabel);

        //Create boards
        BuildBoard playerBoard = new BuildBoard(11, 11, 40);
        BuildBoard enemyBoard = new BuildBoard(11, 11, 40);

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

        Random r = new Random();

        List<Ship> allShips = List.of(ship1Cell, ship2Cells, ship3Cells, ship3Cells2, ship4Cells, ship5Cells);

        Button startButton = new Button("Start Game");

        EventHandler<MouseEvent> handler = MouseEvent::consume;

        List<Double> playerShips = new ArrayList<>();

        startButton.setOnMousePressed(event -> {

            for (Ship shipCoordinates : allShips)
            {
                if (shipCoordinates.isHited(40,40))
                {
                    Rectangle hit = new Rectangle(40,40);
                    hit.setStroke(Color.BLACK);
                    hit.setFill(Color.RED);
                    hit.setX(40);
                    hit.setY(40);
                    playerBoard.getChildren().addAll(hit);
                }
            }
            playerBoard.addEventFilter(MouseEvent.MOUSE_DRAGGED, handler);
            startButton.setDisable(true);
        });


        //Shooting to target(missed, hit) - player board






        //Enemy board ships
        CreateShips enemyBoat = new CreateShips(Color.TRANSPARENT, Color.BLACK);
        CreateShips enemyPatrolBoat = new CreateShips(Color.TRANSPARENT, Color.BLACK);
        CreateShips enemySubmarine = new CreateShips(Color.TRANSPARENT, Color.BLACK);
        CreateShips enemyDestroyer = new CreateShips(Color.TRANSPARENT, Color.BLACK);
        CreateShips enemyBattleship = new CreateShips(Color.TRANSPARENT, Color.BLACK);
        CreateShips enemyCarrier = new CreateShips(Color.TRANSPARENT, Color.BLACK);


        for (int i = 0; i < 6; i++)
        {
            int randomX= (r.nextInt(10) + 1) * 40;
            int randomY = (r.nextInt(10) + 1) * 40;
            //System.out.println("randomX = " + randomX + " randomY = " + randomY);

        }

        Ship enemyShip1Cell = new Ship(40, 40, 40, 40, enemyBoat);
        Ship enemyShip2Cells = new Ship(360, 80, 40, 80, enemyPatrolBoat);
        Ship enemyShip3Cells = new Ship(80, 320, 40, 120, enemySubmarine);
        Ship enemyShip3Cells2 = new Ship(320, 160, 40, 120, enemyDestroyer);
        Ship enemyShip4Cells = new Ship(160, 200, 40, 160, enemyBattleship);
        Ship enemyShip5Cells = new Ship(120, 80, 40, 200, enemyCarrier);


        List<Ship> enemyShips = List.of(enemyShip1Cell, enemyShip2Cells, enemyShip3Cells, enemyShip3Cells2, enemyShip4Cells, enemyShip5Cells);


        //Random vertical
        /*for (Ship randomShipVertical : enemyShips)
        {
            int randomVertical = r.nextInt(10);
            if (randomVertical % 2 == 0)
            {
                randomShipVertical.makeVertical();
            }
        }*/

        AtomicInteger shipsOnBoard = new AtomicInteger(6);
        //Shooting to target (missed, hit) - enemy board
        enemyBoard.setOnMousePressed(event ->
                {
                    if (enemyShip1Cell.isHited(enemyBoard.getBoardX(), enemyBoard.getBoardY()))
                    {
                        Rectangle hit = new Rectangle(40,40);
                        hit.setStroke(Color.BLACK);
                        hit.setFill(Color.RED);
                        hit.setX(enemyBoard.getBoardX());
                        hit.setY(enemyBoard.getBoardY());
                        enemyBoard.getChildren().addAll(hit);
                        if (enemyShip1Cell.isDown())
                        {
                            shipsOnBoard.decrementAndGet();
                            System.out.println(shipsOnBoard);
                        }
                    }
                    else if (enemyShip2Cells.isHited(enemyBoard.getBoardX(), enemyBoard.getBoardY()))
                    {
                        Rectangle hit = new Rectangle(40,40);
                        hit.setStroke(Color.BLACK);
                        hit.setFill(Color.RED);
                        hit.setX(enemyBoard.getBoardX());
                        hit.setY(enemyBoard.getBoardY());
                        enemyBoard.getChildren().addAll(hit);
                        if (enemyShip2Cells.isDown())
                        {
                            shipsOnBoard.decrementAndGet();
                            System.out.println(shipsOnBoard);
                        }
                    }
                    else if (enemyShip3Cells.isHited(enemyBoard.getBoardX(), enemyBoard.getBoardY()))
                    {
                        Rectangle hit = new Rectangle(40,40);
                        hit.setStroke(Color.BLACK);
                        hit.setFill(Color.RED);
                        hit.setX(enemyBoard.getBoardX());
                        hit.setY(enemyBoard.getBoardY());
                        enemyBoard.getChildren().addAll(hit);
                        if (enemyShip3Cells.isDown())
                        {
                            shipsOnBoard.decrementAndGet();
                            System.out.println(shipsOnBoard);
                        }
                    }
                    else if (enemyShip3Cells2.isHited(enemyBoard.getBoardX(), enemyBoard.getBoardY()))
                    {
                        Rectangle hit = new Rectangle(40,40);
                        hit.setStroke(Color.BLACK);
                        hit.setFill(Color.RED);
                        hit.setX(enemyBoard.getBoardX());
                        hit.setY(enemyBoard.getBoardY());
                        enemyBoard.getChildren().addAll(hit);
                        if (enemyShip3Cells2.isDown())
                        {
                            shipsOnBoard.decrementAndGet();
                            System.out.println(shipsOnBoard);
                        }
                    }
                    else if (enemyShip4Cells.isHited(enemyBoard.getBoardX(), enemyBoard.getBoardY()))
                    {
                        Rectangle hit = new Rectangle(40,40);
                        hit.setStroke(Color.BLACK);
                        hit.setFill(Color.RED);
                        hit.setX(enemyBoard.getBoardX());
                        hit.setY(enemyBoard.getBoardY());
                        enemyBoard.getChildren().addAll(hit);
                        if (enemyShip4Cells.isDown())
                        {
                            shipsOnBoard.decrementAndGet();
                            System.out.println(shipsOnBoard);
                        }
                    }
                    else if (enemyShip5Cells.isHited(enemyBoard.getBoardX(), enemyBoard.getBoardY()))
                    {
                        Rectangle hit = new Rectangle(40,40);
                        hit.setStroke(Color.BLACK);
                        hit.setFill(Color.RED);
                        hit.setX(enemyBoard.getBoardX());
                        hit.setY(enemyBoard.getBoardY());
                        enemyBoard.getChildren().addAll(hit);
                        if (enemyShip5Cells.isDown())
                        {
                            shipsOnBoard.decrementAndGet();
                            System.out.println(shipsOnBoard);
                        }
                    }
                    else
                    {
                        Circle circle = new Circle(enemyBoard.getBoardX() + 20, enemyBoard.getBoardY() + 20, 7, Color.BLACK);
                        enemyBoard.getChildren().addAll(circle);
                    }
                });

        System.out.println(shipsOnBoard.get());









            ////////////////////////////////////////////////////////////
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

    public void winnerPlayer(List<Ship> playerList, List<Ship> enemyList)
    {
        if (playerList.size() == 0 && enemyList.size() > 0)
        {
            System.out.println("You Win");
        }
        else
        {
            System.out.println("You Lost");
        }
    }

}
