package com.kodilla.battleship;

import java.util.ArrayList;
import java.util.List;

public class ShipMoves
{
    private Ship ship;
    private Moves move;
    private CreateShips createShip;

    public ShipMoves(Ship ship, Moves move, CreateShips createShip) {
        this.ship = ship;
        this.move = move;
        this.createShip = createShip;
    }

    public void createMoves()
    {
        createShip.setOnMouseDragged(event ->
        {
            move.dragged(event, ship);
        });

        createShip.setOnMouseReleased(event ->
        {
            move.released(ship);
        });

        createShip.setOnMousePressed(event ->
        {
            move.pressed(event, ship);
        });

        ship.shipDraw();
    }
}
