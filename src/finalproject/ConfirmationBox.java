package finalproject;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author thiag Simple Method. The class pops up a confirmation windows
 * @param string to be add to the title and string to the msg
 * @return true or false
 */
public class ConfirmationBox {

    static boolean x;

    public static boolean display(String title, String message) {
        Stage primaryStage = new Stage();
        primaryStage.setTitle(title);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setMinWidth(300);
        Label lbl = new Label();
        lbl.setText(message);
        Button trueBtn = new Button();
        Button falseBtn = new Button();

        trueBtn.setText("Confirm");
        falseBtn.setText("Cancel");

        trueBtn.setOnAction(e -> {
            x = true;
            primaryStage.close();

        });

        falseBtn.setOnAction(e -> {
            x = false;
            primaryStage.close();

        });
        VBox layout = new VBox(20);
        layout.getChildren().addAll(lbl, trueBtn, falseBtn);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(25, 25, 25, 25));
        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
        return x;
    }
}
