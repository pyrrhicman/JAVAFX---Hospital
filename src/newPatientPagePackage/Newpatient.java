package newPatientPagePackage;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.Controller;
import sample.Patient;

import java.net.URL;
import java.util.ResourceBundle;

public class Newpatient implements Initializable {
    @FXML
    private JFXButton enter;
    @FXML
    private JFXButton cancel;
    @FXML
    private JFXTextField lastname;
    @FXML
    private JFXTextField firstname;
    @FXML
    private JFXTextField socialid;
    @FXML
    private JFXTextField phonenumber;
    @FXML
    private JFXTextField city;
    @FXML
    private JFXTextField address;
    @FXML
    private JFXTextField postalcode;
    @FXML
    private JFXComboBox<String> sex = new JFXComboBox<String>();
    @FXML
    private JFXDatePicker dateofbirth;
    @FXML
    private JFXDatePicker dateofregistration;
    @FXML
    private Text systext;



    public Newpatient() {
        //Controller controller = new Controller();
        //controller.newPatientForm();
    }

    public void initialize(URL location, ResourceBundle resources) {

        sex.getItems().addAll("Male","Female");
        sex.setValue("Male");
        dateofbirth.setEditable(false);
        dateofregistration.setEditable(false);

    }

    public void cancelButtonPressed() {
        Stage stage = (Stage) this.cancel.getScene().getWindow();
        stage.close();
        //newStageRun();

    }

    public void enterButtonPressed() {

        if (fieldsAreNotEmpty()) {
            Patient patient = new Patient
                    (
                            (firstname.getText(0, 1).toUpperCase() + firstname.getText(1, firstname.getText().length() - 1).toLowerCase()),
                            (lastname.getText(0, 1).toUpperCase() + lastname.getText(1, lastname.getText().length() - 1).toLowerCase()),
                            socialid.getText(),
                            sex.getValue(),
                            dateofbirth.getValue().toString(),
                            dateofregistration.getValue().toString(),
                            phonenumber.getText(),
                            (city.getText(0, 1).toUpperCase() + city.getText(1, city.getText().length() - 1).toLowerCase()),
                            (address.getText(0, 1).toUpperCase() + address.getText(1, address.getText().length() - 1).toLowerCase()),
                            postalcode.getText()
                    );

            Controller.getNewPatientAndSaveIt(patient);
            Stage stage = (Stage) this.cancel.getScene().getWindow();
            stage.close();
        } else {
            systext.setText("Please Fill the Form Completely");

        }
    }

    public void firstnameentered() {
        int longname = firstname.getText().length();
        String newname = firstname.getText(0, 1).toUpperCase() + firstname.getText(1, firstname.getText().length() - 1).toLowerCase();
        firstname.setText(newname);

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
