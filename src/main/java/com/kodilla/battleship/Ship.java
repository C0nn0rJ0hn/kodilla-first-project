package com.kodilla.battleship;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Ship
{
    private double shipX;
    private double shipY;
    private double shipHeight;
    private double shipWidth;
    private Rectangle ship;

    public Ship(double shipX, double shipY, double shipHeight, double shipWidth, Rectangle ship) {
        this.shipX = shipX;
        this.shipY = shipY;
        this.shipHeight = shipHeight;
        this.shipWidth = shipWidth;
        this.ship = ship;
    }

    public double getShipX() {
        return shipX;
    }

    public void setShipX(double shipX) {
        this.shipX = shipX;
    }

    public double getShipY() {
        return shipY;
    }

    public void setShipY(double shipY) {
        this.shipY = shipY;
    }

    public double getShipHeight() {
        return shipHeight;
    }

    public void setShipHeight(double shipHeight) {
        this.shipHeight = shipHeight;
    }

    public double getShipWidth() {
        return shipWidth;
    }

    public void setShipWidth(double shipWidth) {
        this.shipWidth = shipWidth;
    }

    public void shipDraw()
    {
        ship.setWidth(shipWidth);
        ship.setHeight(shipHeight);
        ship.setTranslateX(shipX);
        ship.setTranslateY(shipY);
        ship.setStroke(Color.BLACK);
    }

    public void setShipColor(Color color)
    {
        ship.setFill(color);
    }
}
