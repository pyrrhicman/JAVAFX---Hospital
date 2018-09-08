package newPatientPagePackage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.Controller;
import sample.Patient;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class Newpatient implements Initializable {
    @FXML
    private Button enter;
    @FXML
    private Button cancel;
    @FXML
    private TextField lastname;
    @FXML
    private TextField firstname;
    @FXML
    private TextField socialid;
    @FXML
    private TextField phonenumber;
    @FXML
    private TextField city;
    @FXML
    private TextField address;
    @FXML
    private TextField postalcode;
    @FXML
    private ComboBox sex;
    @FXML
    private DatePicker dateofbirth;
    @FXML
    private DatePicker dateofregistration;


    public Newpatient() {
        //Controller controller = new Controller();
        //controller.newPatientForm();
    }

    public void initialize(URL location, ResourceBundle resources) {

    }


    public void cancelButtonPressed() {
        Stage stage =(Stage)this.cancel.getScene().getWindow();
        stage.close();
        //newStageRun();

    }

    public void enterButtonPressed() {

        if (fieldsAreNotEmpty()) {
            Patient patient = new Patient
                    (
                            firstname.getText(),
                            lastname.getText(),
                            socialid.getText(),
                            sex.getTypeSelector(),
                            dateofbirth.getTypeSelector(),
                            dateofregistration.getTypeSelector(),
                            phonenumber.getText(),
                            city.getText(),
                            address.getText(),
                            postalcode.getText()
                    );

            Controller.getNewPatientAndSaveIt(patient);
            Stage stage =(Stage)this.cancel.getScene().getWindow();
            stage.close();
        }
    }

    public boolean fieldsAreNotEmpty() {
        if (!(firstname.getText().isEmpty())) {
            if (!(lastname.getText().isEmpty())) {
                if (!(socialid.getText().isEmpty())) {
                    return true;
                }
            }
        }
        return false;
    }

}
