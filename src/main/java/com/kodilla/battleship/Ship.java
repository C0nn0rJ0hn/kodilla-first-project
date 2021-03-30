package com.kodilla.battleship;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;


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

    private List<Rectangle> rectangleList = new ArrayList<>();

    private int hitCount = 0;

    private int declaredWidth;
    private int declaredHeight;

    private boolean isVertical;


    public Ship(double shipX, double shipY, double shipHeight, double shipWidth, Rectangle ship) {
        this.shipX = shipX;
        this.shipY = shipY;
        this.shipHeight = shipHeight;
        this.shipWidth = shipWidth;
        this.ship = ship;
        this.isVertical = false;
        this.declaredWidth = (int)shipWidth;
        this.declaredHeight = (int)shipHeight;
        this.lowerBoundsY = getLowerBoundsY();
        this.lowerBoundsX = getLowerBoundsX();
        this.upperBoundsY = getUpperBoundsY();
        this.upperBoundsX = getUpperBoundsX();

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
        setShipWidth(declaredHeight);
        setShipHeight(declaredWidth);

        isVertical = true;
    }

    public double getLowerBoundsX() {
        lowerBoundsX = shipX;
        return lowerBoundsX;
    }

    public double getUpperBoundsX() {
        upperBoundsX = shipX + shipWidth - 40;
        return upperBoundsX;
    }


    public double getLowerBoundsY() {
        lowerBoundsY = shipY;
        return lowerBoundsY;
    }


    public double getUpperBoundsY() {
        upperBoundsY = shipY + shipHeight - 40;
        return upperBoundsY;
    }


    public boolean isDown()
    {
        if (isVertical)
        {
            if (hitCount == shipHeight/40)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            if (hitCount == shipWidth/40)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

    }

    public boolean isHit(int boardX, int boardY)
    {
        if ((getShipX() == boardX && getShipY() == boardY) || (getLowerBoundsX() <= boardX &&
            boardX <= getUpperBoundsX() && getLowerBoundsY() <= boardY && boardY <= getUpperBoundsY()))
        {
            hitCount++;

            return true;
        }
        else
        {
            return false;
        }
    }

    public void addRect(Rectangle rectangle)
    {
        rectangleList.add(rectangle);
    }

    public List<Rectangle> getRectangleList() {
        return rectangleList;
    }

    //Method to check if ship will fit in grid size
    /*public boolean fitShipOnBoard( int x, int y)
    {
        int rowMinX = 40;
        int columnMinY = 40;
        int rowMaxX = 440;
        int columnMaxY = 440;

        if (rowMinX <= x + shipWidth && x + shipWidth <= rowMaxX && columnMinY <= y + shipHeight && y + shipHeight <= columnMaxY)
        {
            return true;
        }
        else
        {
            return false;
        }
    }*/
}
