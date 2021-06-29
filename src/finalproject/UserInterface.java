package finalproject;

import datastructurecw.Saver;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author thiag
 */
public class UserInterface {

    Stage primStage;
    TableView<Patient> table;
    ArrayList<Patient> arrayPatient = new ArrayList<>();
    
    //Method Display to show the User Interface
    public void display() {
        Stage primaryStage = new Stage();
        Button newBtn;
        Button closeBtn;
        
        
        
        
        //Load the data from the saved file.
        Reader.reader(arrayPatient);
        
        
        //Pane------------------------------------------------------------//
        BorderPane layout = new BorderPane();

        //----------------------------------------------------------------//
        //Scene----------------------------------------------------------//
        Scene sceneMain = new Scene(layout, 900, 400);

        //---------------------------------------------------------------//
        //PrimaryStage Settings------------------------------------------//
        primaryStage.setTitle("Emergency Program");
        primaryStage.setScene(sceneMain);
        primaryStage.setMaximized(true);
        primaryStage.show();
        //---------------------------------------------------------------//

        //Button----------------------------------------------------------//
        newBtn = new Button();
        newBtn.setText("New Occurrence");
        
        closeBtn = new Button();
        closeBtn.setText("Close Occurrence");

        //New button handler with shadow effect
        DropShadow shadow = new DropShadow();
        newBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            newBtn.setEffect(shadow);
        });

        newBtn.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            newBtn.setEffect(null);
        });

       
        newBtn.setOnAction(e -> {

            newBtnClicked();

        });
        //Close button event hnalder with shadow effect
        
        closeBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            closeBtn.setEffect(shadow);
        });

        closeBtn.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            closeBtn.setEffect(null);
        });
        closeBtn.setOnAction(e -> {

            closeBtnClicked();

        });
    
        //Declaration of the itens in the List
        
        //Name Column
        TableColumn<Patient, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //DOB column
        TableColumn<Patient, String> dobColumn = new TableColumn<>("Date of Birth");
        dobColumn.setMinWidth(120);
        dobColumn.setCellValueFactory(new PropertyValueFactory<>("dob"));
        dobColumn.setStyle("-fx-alignment: CENTER;");

        //Address Column
        TableColumn<Patient, String> addressColumn = new TableColumn<>("Address");
        addressColumn.setMinWidth(200);
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));

        //description column
        TableColumn<Patient, String> descriptionColumn = new TableColumn<>("Description");
        descriptionColumn.setMinWidth(400);
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        //firecolumn
        TableColumn<Patient, String> fireColumn = new TableColumn<>("Fire");
        fireColumn.setMinWidth(40);
        fireColumn.setMaxWidth(40);
        fireColumn.setResizable(false);
        fireColumn.setCellValueFactory(new PropertyValueFactory<>("fire"));
        fireColumn.setStyle("-fx-alignment: CENTER;");

        //nhscolumn
        TableColumn<Patient, String> nhsColumn = new TableColumn<>("NHS");
        nhsColumn.setMinWidth(40);
        nhsColumn.setMaxWidth(40);
        fireColumn.setResizable(false);
        nhsColumn.setCellValueFactory(new PropertyValueFactory<>("nhs"));
        nhsColumn.setStyle("-fx-alignment: CENTER;");
        //policecolumn
        TableColumn<Patient, String> policeColumn = new TableColumn<>("Police");
        policeColumn.setMinWidth(40);
        policeColumn.setMaxWidth(40);
        policeColumn.setCellValueFactory(new PropertyValueFactory<>("police"));
        policeColumn.setResizable(false);
        policeColumn.setStyle("-fx-alignment: CENTER;");

        
        //Creating of the Tableview
        table = new TableView<>();
        //Method to add of items from the array to the list calling the 
        //get Patient Method
        table.setItems(getPatient());
        table.getColumns().addAll(nameColumn, dobColumn, addressColumn,
                descriptionColumn, fireColumn, nhsColumn, policeColumn);
        //

        
       
        
        //Hbox to accomodate the New and close Btn
        HBox topHBox = new HBox();
        //Setting the Hbox onthe top of the layout
        layout.setTop(topHBox);
        //Parameters for the Hbox such as Spacing , Alignment and Padding
        topHBox.setSpacing(10);
        topHBox.setAlignment(Pos.TOP_LEFT);
        topHBox.setPadding(new Insets(20, 20, 20, 20));
        //Setting the Table previosly declared to the center of the layout
        layout.setCenter(table);
        //Adding the New and close Button to the Hbox
        topHBox.getChildren().addAll(newBtn,closeBtn);
        
        //Lambda Expression to get any closing request consume it and call the Closing Method
        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            Closing.close();

        });

    }

        
    //Method to Add the items saved in the array of Patient to the List
    public ObservableList<Patient> getPatient() {
        ObservableList<Patient> patients = FXCollections.observableArrayList();
        int controler;
        controler = arrayPatient.size();
        for (int i = 0; i < arrayPatient.size() ; i++) {
            
            patients.add(arrayPatient.get(i));  
            
        }
 
          
        
        return patients;
    }
    
    //Method to Handle the Actions of the close Btn
    private void closeBtnClicked() {
        ObservableList<Patient> patientSelected,allPatients;
        allPatients = table.getItems();
        patientSelected = table.getSelectionModel().getSelectedItems();
        patientSelected.forEach(allPatients::remove);
        arrayPatient.clear();
        arrayPatient.addAll(allPatients);
        Saver.saver(arrayPatient);
        
    }

    //Method to Handle the Action of the New Btn
    private void newBtnClicked() {
        arrayPatient.add(Regist.display());
        Saver.saver(arrayPatient);
        table.setItems(getPatient());
    }
}
