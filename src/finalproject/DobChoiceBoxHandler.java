package finalproject;

import javafx.scene.control.ComboBox;
// JAVA CLASS TO ADD THE DATES FOR THE COMBOBOX

public class DobChoiceBoxHandler {

    public static void DobChoiceBox(ComboBox in) {
        //For loop the add the days
        for (int i = 1; i <= 31; i++) {
            in.getItems().add(i);

        }
        //Set the def value to day

        in.setPromptText("Day");
    }

    public static void MobChoiceBox(ComboBox in) {
        in.getItems().add("January");
        in.getItems().add("February");
        in.getItems().add("March");
        in.getItems().add("April");
        in.getItems().add("May");
        in.getItems().add("June");
        in.getItems().add("July");
        in.getItems().add("August");
        in.getItems().add("September");
        in.getItems().add("October");
        in.getItems().add("November");
        in.getItems().add("December");
        in.getItems().clear();

        in.setPromptText("Month");

    }

    public static void YobChoiceBox(ComboBox in) {

        //For loop the add the years
        for (int i = 2016; i >= 1880; i--) {
            in.getItems().add(i);

        }
        //Set the def value to 2015

        in.setPromptText("Year");

    }
}
