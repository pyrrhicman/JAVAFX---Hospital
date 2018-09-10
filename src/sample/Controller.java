package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import newPatientPagePackage.Newpatient;
import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
public class Controller implements Initializable {
     private static ObservableList<Patient> patients = FXCollections.observableArrayList();
    @FXML
    private TableView<Patient> mytable;
    @FXML
    private TableColumn<Patient, String> lastname;//Full name
    @FXML
    private TableColumn<Patient, String> firstname;//Social Id
    @FXML
    private TableColumn<Patient, String> socialid;//sex
    @FXML
    private TableColumn<Patient, String> sex;//
    @FXML
    private TableColumn<Patient, String> birthday;
    @FXML
    private TableColumn<Patient, String> dateofregistration;
    @FXML
    private TableColumn<Patient, String> phonenumber;
    @FXML
    private TableColumn<Patient, String> city;
    @FXML
    private TableColumn<Patient, String> address;


    @FXML
    private JFXButton b1;
    @FXML
    private JFXButton b2;
    @FXML
    private JFXButton b3;
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
        lastname.setCellValueFactory(new PropertyValueFactory<Patient, String>("lastname"));
        firstname.setCellValueFactory(new PropertyValueFactory<Patient, String>("firstname"));
        socialid.setCellValueFactory(new PropertyValueFactory<Patient, String>("socialid"));
        sex.setCellValueFactory(new PropertyValueFactory<Patient, String>("sex"));
        birthday.setCellValueFactory(new PropertyValueFactory<Patient, String>("birthday"));
        dateofregistration.setCellValueFactory(new PropertyValueFactory<Patient, String>("dateofregistration"));
        phonenumber.setCellValueFactory(new PropertyValueFactory<Patient, String>("phonenumber"));
        city.setCellValueFactory(new PropertyValueFactory<Patient, String>("city"));
        address.setCellValueFactory(new PropertyValueFactory<Patient, String>("address"));
        mytable.setItems(getPatients());
    }

    public void newPatientButtonPressed() {
        newPatientForm();
        //patients.add(new Patient(t1.getText(), t2.getText(), t3.getText()));
        //mytable.getItems();
    }

    public void deleteExistedPatient() {
        if (!(t3.getText().isEmpty())) {
            for (int j = patients.size() - 1; j >= 0; j--) {
                if (patients.get(j).getSocialid().equals(t3.getText())) {
                    patients.remove(j);
                    mytable.getItems();
                }
            }
        }

    }
    public void exitButtonPressed() {
        Stage stage =(Stage)this.b3.getScene().getWindow();
        stage.close();
        System.exit(0);

    }
    public ObservableList<Patient> getPatients() {

        patients.add(new Patient(
                "Mohammad",
                "Askari",
                "210599-7156",
                "Male",
                "1999-21-05",
                "2018-01-10",
                "0465987829",
                "Porvoo",
                "Pormestarinkatu 14 C 89",
                "06100"));

        patients.add(new Patient(
                "Danial",
                "Musavi",
                "130500-7235",
                "Male",
                "2000-09-20",
                "2019-09-12",
                "0465954219",
                "Helsinki",
                "Helsingintie 2 B 22",
                "00100 "));



        return patients;
    }

    public static void getNewPatientAndSaveIt(Patient patient) {
        patients.add(patient);
    }

    /*public boolean fieldsAreNotEmpty() {
        if (!(t1.getText().isEmpty())) {
            if (!(t2.getText().isEmpty())) {
                if (!(t3.getText().isEmpty())) {
                    return true;
                }
            }
        }

        return false;
    }*/


    public void newPatientForm() {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();

            InputStream inputStream = getClass().getResource("/newPatientPagePackage/newpatient.fxml").openStream();
            Pane pane = (Pane) loader.load(inputStream);

            Newpatient newpatient = (Newpatient) loader.getController();

            Scene scene = new Scene(pane);
            stage.setScene(scene);
            scene.getStylesheets().add(Newpatient.class.getResource("/sample.css").toExternalForm());
            stage.setTitle("New Patient");
            stage.setResizable(true);
            stage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}














