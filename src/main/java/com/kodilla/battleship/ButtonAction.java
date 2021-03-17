package com.kodilla.battleship;

public class ButtonAction
{
    BuildBoard board;
    CreateShips createdShip;
    Buttons button;

    public ButtonAction(BuildBoard board, CreateShips createdShip, Buttons button)
    {
        this.board = board;
        this.button = button;
        this.createdShip = createdShip;
    }

    public void setAction()
    {
        button.setOnMousePressed(event ->
        {
            board.getChildren().add(createdShip);
            button.setDisable(true);
        });
    }
}
