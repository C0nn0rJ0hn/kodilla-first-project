package com.kodilla.battleship;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Moves
{
    private double actualShipX;
    private double actualShipY;

    public void dragged(MouseEvent event, Ship ship) {
        double eventX = event.getX();
        double eventY = event.getY();
        ship.setShipX(ship.getShipX() + eventX);
        ship.setShipY(ship.getShipY() + eventY);
        ship.shipDraw();
    }

    public void released(Ship ship) {
        int x =  (int) ship.getShipX() / 40;
        int y =  (int) ship.getShipY() / 40;

        ship.setShipX(x * 40);
        ship.setShipY(y * 40);
        ship.setShipColor(Color.BLUE);
        ship.shipDraw();

        actualShipX = ship.getShipX();
        actualShipY = ship.getShipY();
    }

    public void pressed(MouseEvent event, Ship ship) {
        MouseButton button = event.getButton();

        if (button == MouseButton.SECONDARY)
        {
            ship.makeVertical();
        }
    }
}

