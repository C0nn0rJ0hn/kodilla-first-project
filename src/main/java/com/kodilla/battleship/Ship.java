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

    private double lowerBoundsX;
    private double lowerBoundsY;
    private double upperBoundsX;
    private double upperBoundsY;

    int actualWidth;
    int actualHeight;

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

    public void makeVertical()
    {
        actualWidth = (int)shipWidth;
        actualHeight = (int)shipHeight;

        setShipWidth(actualHeight);
        setShipHeight(actualWidth);
    }

    public double getLowerBoundsX() {
        lowerBoundsX = shipX;
        return lowerBoundsX;
    }

    public double getUpperBoundsX() {
        if (shipWidth == 40)
        {
            upperBoundsX = shipX;
        }
        else
        {
            upperBoundsX = shipX + shipWidth - 40;

        }
        return upperBoundsX;
    }

    public double getLowerBoundsY() {
        lowerBoundsY = shipY;
        return lowerBoundsY;
    }

    public double getUpperBoundsY() {
        if (shipHeight == 40)
        {
            upperBoundsY = shipY;
        }
        else
        {
            upperBoundsY = shipY + shipHeight - 40;
        }
        return upperBoundsY;
    }
}
