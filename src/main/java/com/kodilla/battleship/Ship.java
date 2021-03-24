package com.kodilla.battleship;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.stream.Stream;

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

    private int hitCount;
    private boolean shipIsDown;

    public Ship(double shipX, double shipY, double shipHeight, double shipWidth, Rectangle ship) {
        this.shipX = shipX;
        this.shipY = shipY;
        this.shipHeight = shipHeight;
        this.shipWidth = shipWidth;
        this.ship = ship;
        hitCount = 0;
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
            upperBoundsX = shipX + 20;
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
            upperBoundsY = shipY + 20;
        }
        else
        {
            upperBoundsY = shipY + shipHeight - 40;
        }
        return upperBoundsY;
    }

    public boolean isHited(int boardX, int boardY)
    {
        if ((getShipX() == boardX && getShipY() == boardY) || (getLowerBoundsX() <= boardX &&
            boardX <= getUpperBoundsX() && getLowerBoundsY() <= boardY && boardY <= getUpperBoundsY()))
        {
            if (hitCount == actualWidth/40)
            {
                shipIsDown = true;
            }
            else
            {
                shipIsDown = false;
            }

            hitCount++;

            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean isDown()
    {
       return shipIsDown;
    }
}
