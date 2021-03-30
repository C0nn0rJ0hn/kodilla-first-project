package com.kodilla.battleship;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
    static boolean answer;

    public static boolean display(String title, String message)
    {
        Stage window = new Stage();

        //Block events to other window
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);
        label.setFont(new Font("Arial", 15));

        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");
        noButton.setPrefWidth(yesButton.getPrefWidth());

        yesButton.setOnAction(e ->
        {
            answer = true;
            window.close();
        });

        yesButton.setOnKeyPressed(event ->
                {
                    if (event.getCode().equals(KeyCode.ENTER)) {
                        yesButton.fire();
                    }
                }
        );

        noButton.setOnAction(e ->
        {
            answer = false;
            window.close();
        });

        noButton.setOnKeyPressed(event ->
                {
                    if (event.getCode().equals(KeyCode.ENTER)) {
                        noButton.fire();
                    }
                }
        );


        VBox layout = new VBox(10);
        layout.setPadding(new Insets(5,0, 5, 0));
        layout.getChildren().addAll(label, yesButton, noButton);
        layout.setAlignment(Pos.CENTER);

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}
