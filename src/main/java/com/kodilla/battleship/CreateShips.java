package com.kodilla.battleship;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CreateShips extends Rectangle
{
    private Color fill;
    private Color stroke;

    public CreateShips(Color fill, Color stroke)
    {
        this.fill = fill;
        this.stroke = stroke;

        setFill(fill);
        setStroke(stroke);
        opacityProperty().set(0.5);
    }
}
