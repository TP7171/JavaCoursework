package finalproject;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author thiag
 */
public class Login {
    static boolean login;
    //Method to display the Login Screen
    public static boolean display() {
        
        //Declaration of the stage
        Stage primaryStage = new Stage();
        
        //Boolean variable to verify the Password and User
        boolean login = false;

        //Declaration of the Gridpane and parameters
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        //---------------------------------------------//
        
        //Declaration of the Scene + Layout and sending the parameter to the stage
        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        
        //---------------------------------------------//

        
        //Setting the scene title
        Text scenetitle = new Text("Please Log-in");
        //
        
        //Declaring the Components of the Login scene
        Label user = new Label("User");
        TextField userNameTextField = new TextField();
        Label password = new Label("Password");
        PasswordField passwordBox = new PasswordField();
        scenetitle.setFont(Font.font("Arial", FontWeight.NORMAL, 20));

        //-------------------------------------------//
        
        
        //Adding components to the Grid layout
        grid.add(scenetitle, 1, 0, 2, 1);
        grid.add(user, 0, 1);
        grid.add(userNameTextField, 1, 1);
        grid.add(password, 0, 2);
        grid.add(passwordBox, 1, 2);
        grid.setGridLinesVisible(false);

        //--------------------------------------//
        
        //
        Button logInBtn = new Button("Log-in");
        HBox hBtn = new HBox(10);
        hBtn.getChildren().add(logInBtn);
        grid.add(hBtn, 1, 6);
        
        //Text to let the user know that the password or user is wrong
        final Text actiontarget = new Text();
        
        grid.add(actiontarget, 1, 7);
        
        primaryStage.setTitle("Login");
       
        primaryStage.show();
        
        //Shadow effects for the Login Button
        DropShadow shadow = new DropShadow();
        logInBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            logInBtn.setEffect(shadow);
        });

        logInBtn.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            logInBtn.setEffect(null);
        });
        
        //Lambda Expression to Handle the action from the Button
        logInBtn.setOnAction((ActionEvent event) -> {
            if (("admin".equals(userNameTextField.getText()))
                    && "admin".equals(passwordBox.getText())) {
                actiontarget.setFill(Color.BLUE);
                actiontarget.setText("Log-In Successful");
                primaryStage.close();
                UserInterface ui = new UserInterface();
                ui.display();
                

                

            } else {
                actiontarget.setFill(Color.RED);
                actiontarget.setText("Invalid user or password");

            }

        });
        
        //LAmbda expression to handle close request
        //It will consume the close event and call the closemethod to ask
        //for a close confirmation
        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            Closing.close();

        });

        
        //Return
        return login;
        
        
    }

}
