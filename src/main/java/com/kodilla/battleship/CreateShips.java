package com.kodilla.battleship;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CreateShips extends Rectangle
{
    public CreateShips(Color fill, Color stroke)
    {
        setFill(fill);
        setStroke(stroke);
        opacityProperty().set(0.5);
    }

}
