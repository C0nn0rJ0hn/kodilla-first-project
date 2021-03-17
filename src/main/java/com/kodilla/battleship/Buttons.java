package com.kodilla.battleship;

import javafx.scene.control.Button;
import javafx.scene.text.Font;


import static java.lang.Double.MAX_VALUE;

public class Buttons extends Button
{
    public Buttons(String text)
    {
        setFont(new Font(15));
        setMaxWidth(MAX_VALUE);
        setText(text);
    }
}
