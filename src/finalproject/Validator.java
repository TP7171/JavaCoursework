/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
    
public class Validator {
    //This class is made to validate if the fields of the registry are correctly filled
    //Declaration of the check method with all the variables required
    public static boolean check(TextField NameIn, ComboBox cDIn, ComboBox cMIn,
            ComboBox cYIn, TextField adIn, TextField desIn, CheckBox fire, CheckBox nhs, CheckBox police) {

        boolean nameNotNull = false;
        boolean nameOnlyChar = false;
        boolean dOfb = false;
        boolean mOfb = false;
        boolean yOfb = false;
        boolean address = false;
        boolean description = false;
        boolean comboBoxes = false;

        // CHECK IF THE NAME TEXT FIELD IS ONLY CHAR AND ITS NOT EMPTY
        if (!"".equals(NameIn.getText())) {
            nameNotNull = true;
        }
        if (IsOnlyChar.check(NameIn.getText())) {
            nameOnlyChar = true;
        }

        // CHECK IF THE DOB WAS SELECTED
        if (cDIn.getValue() != null) {
            dOfb = true;
        }
        if (cMIn.getValue() != null) {
            mOfb = true;
        }
        if (cYIn.getValue() != null) {
            yOfb = true;
        }
        //CHECK IF THE ADRESSES AND THE DESCRIPTION ARE NOT EMPTY
        if (!"".equals(adIn.getText())) {
            address = true;
        }
        if (!"".equals(desIn.getText())) {
            description = true;
        }

        //If statment to check if at least one checkbox is selected
        if (fire.isSelected()) {
            comboBoxes = true;

        } else if (nhs.isSelected()) {
            comboBoxes = true;
        } else if (police.isSelected()) {
            comboBoxes = true;
        }

        // Validate all inputs
        if (nameNotNull && nameOnlyChar && dOfb && mOfb && yOfb && address && description && comboBoxes) {
            return true;
        } else {

            //Alert box about errors
            String msg1 = "Please insert the name ";
            String msg2 = "Please insert a name with only characters ";
            String msg3 = "Please insert the date of birth ";
            String msg4 = "Please insert the address ";
            String msg5 = "Please insert the description ";
            String msg6 = "At least one of the emergency services must be selected ";
            String errorMsg = "";

            //if statment for empty name
            if (!nameNotNull) {
                errorMsg = errorMsg + msg1;

            }
            //if for number on the name
            if (nameNotNull && !nameOnlyChar) {
                errorMsg = errorMsg + msg2;
            }

            //if to check if the dob has been inputed
            if (!dOfb || !mOfb || !yOfb) {
                errorMsg = errorMsg + "\n" + msg3;
            }

            // if to check the address field
            if (!address) {
                errorMsg = errorMsg + "\n" + msg4;
            }

            // if to check the description field
            if (!description) {
                errorMsg = errorMsg + "\n" + msg5;
            }

            // if to check the checkboxes
            if (!comboBoxes) {
                errorMsg = errorMsg + "\n" + msg6;
            }

            AlertBox.display("Error", (errorMsg), "OK");

            return false;
        }

    }
}
