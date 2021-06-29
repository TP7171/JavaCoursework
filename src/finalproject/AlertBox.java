package finalproject;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

    // DISPLAYS AN ALERT BOX NEED TO RECEIVE 3 STRINGS TITLE, THE MSG, AND THE
    //BTN MSG
    public static void display(String title, String message, String btnMessage) {
        Stage primaryStage = new Stage();
        primaryStage.setTitle(title);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setMinWidth(300);
        Label lbl = new Label();
        lbl.setText(message);
        Button closeBtn = new Button();
        closeBtn.setText(btnMessage);
        closeBtn.setOnAction(e -> primaryStage.close());
        VBox layout = new VBox(20);
        layout.getChildren().addAll(lbl, closeBtn);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(25, 25, 25, 25));
        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
    }

}
