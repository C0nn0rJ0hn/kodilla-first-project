package com.kodilla.battleship;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


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

        //Enemy board ships
        CreateShips enemyBoat = new CreateShips(Color.TRANSPARENT, Color.BLACK);
        CreateShips enemyPatrolBoat = new CreateShips(Color.TRANSPARENT, Color.BLACK);
        CreateShips enemySubmarine = new CreateShips(Color.TRANSPARENT, Color.BLACK);

        Random r = new Random();
        int randomX = (r.nextInt(10) + 1) * 40;
        int randomY = (r.nextInt(10) + 1) * 40;
        //System.out.println(randomX + " " + randomY);

        /////////////////////////////////////////////////////////

        Ship enemyShip2Cells = new Ship(240, 240, 40, 80, enemyPatrolBoat);
        //enemyShip2Cells.makeVertical();

        Ship enemyShip3Cells = new Ship(80, 80, 40, 120, enemySubmarine);
        enemyShip3Cells.makeVertical();

        Ship enemyShip1Cell = new Ship(80, 320, 40, 40, enemyBoat);

        List<Ship> enemyShips = List.of(enemyShip1Cell, enemyShip2Cells, enemyShip3Cells);


        //Horizontal ship
        /*if (enemyShip2Cells.getShipX() == 400)
        {
            enemyShip2Cells.setShipX(enemyShip2Cells.getShipX() - (enemyShip2Cells.getShipWidth()/2));
        }
        if (enemyShip2Cells.getShipX() == 400)
        {
            enemyShip2Cells.setShipX(enemyShip2Cells.getShipX() - (enemyShip2Cells.getShipWidth()/2));
        }
        enemyShip2Cells.shipDraw();
        enemyBoard.getChildren().add(enemyPatrolBoat);*/


        //Shooting to target - missed
        enemyBoard.setOnMousePressed(event ->
        {
            for(Ship checkShip : enemyShips)
            {
                if (checkShip.getShipX() == enemyBoard.getBoardX() && checkShip.getShipY() == enemyBoard.getBoardY())
                {
                    Rectangle hit = new Rectangle(40,40);
                    hit.setX(enemyBoard.getBoardX());
                    hit.setY(enemyBoard.getBoardY());
                    hit.setFill(Color.RED);
                    hit.setStroke(Color.BLACK);
                    enemyBoard.getChildren().addAll(hit);
                }
                if (checkShip.getLowerBoundsX() <= enemyBoard.getBoardX() && enemyBoard.getBoardX() <= checkShip.getUpperBoundsX()
                && checkShip.getLowerBoundsY() <= enemyBoard.getBoardY() && enemyBoard.getBoardY() <= checkShip.getUpperBoundsY())
                {
                    Rectangle hit2 = new Rectangle(40,40);
                    hit2.setX(enemyBoard.getBoardX());
                    hit2.setY(enemyBoard.getBoardY());
                    hit2.setFill(Color.RED);
                    hit2.setStroke(Color.BLACK);
                    enemyBoard.getChildren().addAll(hit2);
                }
                else
                {
                    int centerX = enemyBoard.getBoardX() + 20;
                    int centerY = enemyBoard.getBoardY() + 20;
                    Circle circle = new Circle(centerX, centerY, 7, Color.BLACK);
                    enemyBoard.getChildren().addAll(circle);
                }
            }
        });


        ////////////////////////////////////////////////////////////
        //Create buttons
        Buttons boat = new Buttons("Boat");
        Buttons patrolBoat = new Buttons("Patrol Boat");
        Buttons submarine = new Buttons("Submarine");
        Buttons destroyer = new Buttons("Destroyer");
        Buttons battleship = new Buttons("Battleship");
        Buttons carrier = new Buttons("Carrier");

        //Get ships on board by pressing specific button
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



        root.setPadding(new Insets(20,20,20,20));
        root.setHgap(20);
        root.setVgap(20);
        root.add(titlePlayer, 0, 0);
        root.add(titleEnemy, 1, 0);
        root.add(playerBoard, 0, 1);
        root.add(enemyBoard, 1,1);
        root.add(buttonsBar, 0, 2);
        root.add(buttonsBar2,0,3);

        //root.setGridLinesVisible(true);

        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }

}
