package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    ObservableList<Patient> patients = FXCollections.observableArrayList();
    @FXML
    private TableView<Patient> mytable;
    @FXML
    private TableColumn<Patient, String> c1;
    @FXML
    private TableColumn<Patient, String> c2;
    @FXML
    private TableColumn<Patient, String> c3;
    @FXML
    private TableColumn<Patient, String> c4;
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
    @FXML
    private Text text;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        c1.setCellValueFactory(new PropertyValueFactory<Patient, String>("name"));
        c2.setCellValueFactory(new PropertyValueFactory<Patient,String>("room"));
        c3.setCellValueFactory(new PropertyValueFactory<Patient, String>("id"));

        mytable.setItems(getPatients());
        /*mytable.setEditable(true);
        c1.setCellFactory(TextFieldTableCell.forTableColumn());
        c2.setCellFactory(TextFieldTableCell.forTableColumn());
        c3.setCellFactory(TextFieldTableCell.forTableColumn());*/

    }

    public void newPatientButtonPressed() {
        if (fieldsAreNotEmpty()) {

            patients.add(new Patient(t1.getText(), t2.getText(), t3.getText()));
            mytable.getItems();
        }

    }

    public void deleteExistedPatient() {
        if (!(t3.getText().isEmpty())) {
            for (int j = patients.size()-1; j >= 0; j--) {
                if (patients.get(j).getId().equals(t3.getText())) {
                    patients.remove(j);
                    mytable.getItems();
                }
            }
        }

    }

    public ObservableList<Patient> getPatients() {

        patients.add(new Patient("Erik", "73", "23436676"));

        patients.add(new Patient("Mohas", "34", "23454657"));
        patients.add(new Patient("Mob", "23", "243543534"));
        patients.add(new Patient("Andrew", "12", "4634523"));

        return patients;
    }

    public boolean fieldsAreNotEmpty() {
        if (!(t1.getText().isEmpty())) {
            if (!(t2.getText().isEmpty())) {
                if (!(t3.getText().isEmpty())) {
                    return true;
                }
            }
        }

        return false;
    }
}
