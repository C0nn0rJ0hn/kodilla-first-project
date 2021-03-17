package com.kodilla.battleship;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Moves
{
    public void dragged(MouseEvent event, Ship ship) {
        double eventX = event.getX();
        double eventY = event.getY();
        ship.setShipX(ship.getShipX() + eventX);
        ship.setShipY(ship.getShipY() + eventY);
        ship.shipDraw();
    }

    public void released(MouseEvent event, Ship ship) {
        int x =  (int) ship.getShipX() / 40;
        int y =  (int) ship.getShipY() / 40;

        ship.setShipX(40 * x);
        ship.setShipY(40 * y);
        ship.setShipColor(Color.BLUE);
        ship.shipDraw();
    }

    public void pressed(MouseEvent event, Ship ship) {
        MouseButton button = event.getButton();
        double actualHeight = ship.getShipHeight();
        double actualWidth = ship.getShipWidth();

        if (button == MouseButton.SECONDARY)
        {
            ship.setShipHeight(actualWidth);
            ship.setShipWidth(actualHeight);
        }
    }
}
