package com.kodilla.battleship;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class BuildBoard extends Pane {

    private int columnNumber;
    private int rowNumber;
    private int cellSize;
    private int boardX;
    private int boardY;

    public BuildBoard(int columnNumber, int rowNumber, int cellSize) {

        this.columnNumber = columnNumber;
        this.rowNumber = rowNumber;
        this.cellSize = cellSize;

        for (int i = 0; i < columnNumber; i++)
        {
            for (int j = 0; j < rowNumber; j++)
            {
                char[] alphabet = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

                Label numeric = new Label("" + j);
                numeric.setFont(new Font(25));
                numeric.setTextFill(Color.YELLOW);

                Rectangle boardCell = new Rectangle(i * cellSize, j * cellSize, cellSize, cellSize);
                boardCell.setOnMouseEntered(event ->
                {
                    boardX = (int)boardCell.getX();
                    boardY = (int)boardCell.getY();
                });
                boardCell.setStroke(Color.BLACK);
                StackPane stackPane = new StackPane();

                Label alphabetic = new Label("" + alphabet[i]);
                alphabetic.setFont(new Font(25));
                alphabetic.setTextFill(Color.YELLOW);

                if (i == 0 || j == 0 )
                {
                    if (i == 0 && j == 0)
                    {
                        boardCell.setFill(Color.BLACK);
                    }
                    else
                    {
                        stackPane.setPrefSize(40, 40);
                        stackPane.setStyle("-fx-background-color: darkcyan; -fx-border-color: black; -fx-border-width: 0.5");
                        stackPane.setTranslateX(i * cellSize);
                        stackPane.setTranslateY(j * cellSize);
                        if (i == 0)
                        {
                            stackPane.getChildren().addAll(numeric);
                        }
                        if (j == 0)
                        {
                            stackPane.getChildren().addAll(alphabetic);
                        }
                    }
                }
                else
                {
                    boardCell.setFill(Color.LIGHTGRAY);
                }
                getChildren().addAll(boardCell, stackPane);
            }
        }
    }

    public int getBoardX()
    {
        return boardX;
    }

    public int getBoardY()
    {
        return boardY;
    }
}
