package finalproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Reader {

    //Method to save all the inputs in a text file
    public static void reader(List<Patient> PatientListIn) {

        //Declaration of all the required variables
        String tempName;
        String tempDOBString;
        int tempDOB;
        String tempMOB;
        int tempYOB;
        String tempYOBString;
        String tempA;
        String tempD;
        boolean tempFire;
        String tempFireString;
        boolean tempNhs;
        String tempNhsString;
        boolean tempPolice;
        String tempPoliceString;

        //Try-Catch to avoid exception
        try (
                //Declaration of the file reader
                FileReader patientFile = new FileReader("file.txt");
                //Declaration of the stream
                BufferedReader patientStream = new BufferedReader(patientFile);) {
            //Reading the first line to start the stream
            tempName = patientStream.readLine();

            while (tempName != null) {

                //While statement to keep reading the file until empty
                tempDOBString = patientStream.readLine();
                tempMOB = patientStream.readLine();
                tempYOBString = patientStream.readLine();
                tempA = patientStream.readLine();
                tempD = patientStream.readLine();
                tempFireString = patientStream.readLine();
                tempNhsString = patientStream.readLine();
                tempPoliceString = patientStream.readLine();
                tempDOB = Integer.parseInt(tempDOBString);
                tempYOB = Integer.parseInt(tempYOBString);

                //If else statement to check the boolean since the file save as X for True or Void for False
                if ("X".equals(tempFireString)) {
                    tempFire = true;
                } else {
                    tempFire = false;
                }

                if ("X".equals(tempNhsString)) {
                    tempNhs = true;
                } else {
                    tempNhs = false;
                }

                if ("X".equals(tempPoliceString)) {
                    tempPolice = true;
                } else {
                    tempPolice = false;
                }
                //add all the temporaty information to the array
                PatientListIn.add(new Patient(tempName, tempDOB, tempMOB, tempYOB, tempA, tempD, tempFire, tempNhs, tempPolice));
                tempName = patientStream.readLine();

            }
        } // exception in case of file not found
        catch (FileNotFoundException e) {
            AlertBox.display("Error", "No Previous Data Found creating a empty file", "OK!");
        }//exception in case of any error
        catch (IOException e) {
            AlertBox.display("Error", "There was a Problem acessing the saved Data", "OK!");
        }

    }
}
