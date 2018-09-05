package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class Controller implements Initializable {
    @FXML
    private TableView<PatientList> mytable;
    @FXML
    private TableColumn<PatientList, String> c1;
    @FXML
    private TableColumn<PatientList, String> c2;
    @FXML
    private TableColumn<PatientList, String> c3;
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button b3;
    @FXML
    private TextField t1;
    @FXML
    private TextField t2;
    @FXML
    private TextField t3;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        c1.setCellValueFactory(new PropertyValueFactory<PatientList, String>("name"));
        c2.setCellValueFactory(new PropertyValueFactory<PatientList,String>("room"));
        c3.setCellValueFactory(new PropertyValueFactory<PatientList, String>("id"));
        mytable.setItems(getPatients());
        /*mytable.setEditable(true);
        c1.setCellFactory(TextFieldTableCell.forTableColumn());
        c2.setCellFactory(TextFieldTableCell.forTableColumn());
        c3.setCellFactory(TextFieldTableCell.forTableColumn());*/

    }

    public void newPatientButtonPressed() {
        if (!(t1.getText().isEmpty())) {
            if (!(t2.getText().isEmpty())) {
                if (!(t3.getText().isEmpty())) {
                    PatientList newPatient = new PatientList(t1.getText(), t2.getText(), t3.getText());
                    mytable.getItems().add(newPatient);
                }
            }
        }

    }

    public ObservableList<PatientList> getPatients() {
        ObservableList<PatientList> patients = FXCollections.observableArrayList();
        patients.add(new PatientList("Erik", "73", "23436676"));
        patients.add(new PatientList("Mohas", "34", "23454657"));
        patients.add(new PatientList("Mob", "23", "243543534"));
        patients.add(new PatientList("Andrew", "12", "4634523"));
        return patients;
    }
}
