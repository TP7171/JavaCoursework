package finalproject;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //Call the Login class to display the login screen
        AlertBox.display("Login Details", "The Default Login is Admin \nThe Default Password id Admin ", "OK!");
        Login.display();

    }

}
