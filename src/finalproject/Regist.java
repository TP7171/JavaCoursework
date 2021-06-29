/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author thiag
 */
public class Regist {

    /**
     * Method to display the registry windows
     *
     * @return
     */
    public static Patient display() {
        //Creating a Default patient to avoid crashs
        Patient dPatient = new Patient("1", 1, "2", 1, "3", "4", false, false, false);
        //Declaring the Stage
        Stage primaryStage = new Stage();

        //Labels
        Label name = new Label("Full Name");
        Label dob = new Label("Date of Birth");
        Label address = new Label("Address");
        Label description = new Label("Description");
        Label servNeeded = new Label("Emergency Services Required");
        Label lblFire = new Label("Fire  ");
        Label lblNhs = new Label("NHS  ");
        Label lblPolice = new Label("Police  ");
        //

        //Txt Fields
        TextField txtName = new TextField();
        //TextField txtDob = new TextField(); NOT USING ANYMORE REPLACED BY COMBOBOX
        TextField txtAddress = new TextField();
        TextField txtDesc = new TextField();
        txtDesc.setMinSize(500, 400);
        txtDesc.setAlignment(Pos.TOP_LEFT);
        //

        //Checkbox
        CheckBox fireChb = new CheckBox();
        CheckBox nhsChb = new CheckBox();
        CheckBox policeChb = new CheckBox();
        //

        //Hbox for the Checkbox + Labels
        HBox chbHBox = new HBox();
        chbHBox.getChildren().addAll(lblFire, fireChb, lblNhs, nhsChb, lblPolice, policeChb);

        //Buttons
        Button confBtn = new Button("Save");
        //

        //Layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(25, 25, 25, 25));
        //

        //ComboBox Declarations and implementation
        ComboBox cBoxDay = new ComboBox();
        DobChoiceBoxHandler.DobChoiceBox(cBoxDay);
        ComboBox cBoxMonth = new ComboBox();
        DobChoiceBoxHandler.MobChoiceBox(cBoxMonth);
        ComboBox cBoxYear = new ComboBox();
        DobChoiceBoxHandler.YobChoiceBox(cBoxYear);
        //

        //Hbox for ChoiceBoxs
        HBox hBoxChoice = new HBox();
        hBoxChoice.getChildren().addAll(cBoxDay, cBoxMonth, cBoxYear);
        hBoxChoice.setPadding(new Insets(10, 10, 10, 10));
        hBoxChoice.setSpacing(10);

        //Closing event handler to avoid empty or half completed registry
        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            AlertBox.display("Error!", "Please Finish the Registry", "Ok!");

        });

        //Button Handler
        confBtn.setOnAction(e -> {

            //SEND ALL DATA TO THE VALIDATOR TO CHECK IF RETURN TRUE SAVE THE DATA
            if (Validator.check(txtName, cBoxDay, cBoxMonth, cBoxYear, txtAddress,
                    txtDesc, fireChb, nhsChb, policeChb)) {
                if (ConfirmationBox.display("Confirmation", "Would you "
                        + "like to save this Occurence?")) {
                    // ADD ALL THE DATA TO THE PATIENT ARRAY
                    //GET ALL THE DATA FROM THE FORM
                    String nm = txtName.getText();
                    int dOfB = (int) cBoxDay.getValue();
                    String testing = (String) cBoxMonth.getValue();
                    int yOfB = (int) cBoxYear.getValue();
                    String ad = txtAddress.getText();
                    String ds = txtDesc.getText();
                    boolean fire = fireChb.isSelected();
                    boolean nhs = nhsChb.isSelected();
                    boolean police = policeChb.isSelected();
                    dPatient.setName(nm);
                    dPatient.setAddress(ad);
                    dPatient.setdOfB(dOfB);
                    dPatient.setmOfB(testing);
                    dPatient.setyOfB(yOfB);
                    dPatient.setDescription(ds);
                    dPatient.setFire(fire);
                    dPatient.setNhs(nhs);
                    dPatient.setPolice(police);

                    //Close the Stage
                    primaryStage.close();
                    //Display Alert Box to confirm that the information was saved
                    AlertBox.display("Saved", "Entry Saved", "Ok!");

                }

            }

        });
        //

        //Grid setup
        //name
        grid.add(name, 0, 0);
        grid.add(txtName, 1, 0);

        //dob
        grid.add(dob, 0, 1);
        //grid.add(txtDob, 1, 1); not using anymore new one will be comboBox 
        grid.add(hBoxChoice, 1, 1);

        //address
        grid.add(address, 0, 2);
        grid.add(txtAddress, 1, 2);

        grid.add(description, 0, 3);
        grid.add(txtDesc, 1, 3);
        grid.add(servNeeded, 0, 4);
        grid.add(confBtn, 1, 5);
        grid.add(chbHBox, 1, 4);
        //

        //Scene
        Scene scene = new Scene(grid, 1000, 800);

        //Stage
        primaryStage.setTitle("Registry");
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setScene(scene);
        primaryStage.showAndWait();

        //
        return dPatient;
    }

}
