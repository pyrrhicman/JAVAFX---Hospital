package newPatientPagePackage;


import com.jfoenix.controls.*;
import css.CustomStyle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.DatabaseClass;
import sample.Patient;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

import static css.CustomStyle.*;


public class Newpatient implements Initializable {

    @FXML
    private AnchorPane anchorPane;
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
    private TextField daybirth;
    @FXML
    private TextField monthbirth;
    @FXML
    private TextField yearbirth;
    @FXML
    private RadioButton sexmale;
    @FXML
    private RadioButton sexfemale;
    @FXML
    private RadioButton sexother;
    @FXML
    private TextField age;
    @FXML
    private RadioButton enterbirthday;
    @FXML
    private TextField phonenumber;
    @FXML
    private TextField city;
    @FXML
    private TextField address;
    @FXML
    private TextField postalcode;
    @FXML
    private Text systext;

    private double xOffset = 0;
    private double yOffset = 0;
    final ToggleGroup gender = new ToggleGroup();
    private Boolean ageYearBool = false;
    private Boolean ageMonthBool = false;
    private Boolean ageDayBool = false;


    class TextfieldlistenerEditor {

        TextfieldlistenerEditor(TextField textField, String string) {

            textField.focusedProperty().addListener((arg0, oldPropertyValue, newPropertyValue) -> {
                if (!newPropertyValue) {
                    System.out.println(textField.getId() + "  out focus");

                    if (isThisFieldCorrect(textField.getText(), string)) {
                        System.out.println(textField.getId() + "  is formatted");
                        textField.setStyle(CustomStyle.getTextField_Style());

                    } else {
                        System.out.println(textField.getId() + "  is not formatted");
                        textField.setStyle(CustomStyle.getTextField_Style_err());
                    }
                }
            });


        }

    }

    class BirthdayTextFieldWatchDog {
        BirthdayTextFieldWatchDog(TextField textField, int min, int max) {

            textField.focusedProperty().addListener((arg0, oldPropertyValue, newPropertyValue) -> {
                if (!newPropertyValue) {
                    System.out.println(textField.getId() + "  out focus");
                    if (isThisFieldCorrect(textField.getText(), VALID_AGE_FORMAT)) {
                        if (Integer.parseInt(textField.getText()) >= min & Integer.parseInt(textField.getText()) <= max) {
                            if (textField.getText().length()==1) {
                                textField.setText("0" + textField.getText());
                            }
                            System.out.println(textField.getId() + "  is formatted");
                            textField.setStyle(CustomStyle.getTextField_Style());
                            if (textField.getId().equals("daybirth"))ageDayBool = true;
                            else if (textField.getId().equals("monthbirth"))ageMonthBool = true;
                            else if (textField.getId().equals("yearbirth"))ageYearBool = true;

                            ageWriter();

                        } else {
                            if (textField.getId().equals("daybirth"))ageDayBool = false;
                            else if (textField.getId().equals("monthbirth"))ageMonthBool = false;
                            else if (textField.getId().equals("yearbirth"))ageYearBool = false;

                            textField.setStyle(CustomStyle.getTextField_Style_err());

                        }
                    } else {
                        textField.setText("");

                        if (textField.getId().equals("daybirth"))ageDayBool = false;
                        else if (textField.getId().equals("monthbirth"))ageMonthBool = false;
                        else if (textField.getId().equals("yearbirth"))ageYearBool = false;

                        textField.setStyle(CustomStyle.getTextField_Style_err());

                    }
                }

            });
        }
    }


    public void initialize(URL location, ResourceBundle resources) {
        firstname.setStyle(CustomStyle.getTextField_Style());
        lastname.setStyle(CustomStyle.getTextField_Style());
        socialid.setStyle(CustomStyle.getTextField_Style());
        age.setStyle(CustomStyle.getTextField_Style());
        phonenumber.setStyle(CustomStyle.getTextField_Style());
        city.setStyle(CustomStyle.getTextField_Style());
        address.setStyle(CustomStyle.getTextField_Style());
        postalcode.setStyle(CustomStyle.getTextField_Style());
        //COMBO BOX
        daybirth.setStyle(CustomStyle.getTextField_Style());
        monthbirth.setStyle(CustomStyle.getTextField_Style());
        yearbirth.setStyle(CustomStyle.getTextField_Style());
        sexmale.setToggleGroup(gender);
        sexfemale.setToggleGroup(gender);
        sexother.setToggleGroup(gender);

        //DATE PICKER


        age.setDisable(true);
        age.setText("Enter Age or Select Birthday");

        enter.setStyle(CustomStyle.getFormatbutton());
        cancel.setStyle(CustomStyle.getFormatbutton());

        //<editor-fold desc="TEST DATA">
        /*
        firstname.setText("Erik");
        lastname.setText("Aska");
        socialid.setText("211199-7111");
        age.setText("35");
        phonenumber.setText("5589");
        city.setText("Porvoo");
        address.setText("Pormestarinkatu 14C89");
        postalcode.setText("06100");
        */
        //</editor-fold>



        EventHandler<ActionEvent> birthdayAvailable = event -> {
            if (!enterbirthday.isSelected()) {
                age.setDisable(true);
                yearbirth.setDisable(false);
                monthbirth.setDisable(false);
                daybirth.setDisable(false);

            } else {
                age.setDisable(false);
                yearbirth.setDisable(true);
                monthbirth.setDisable(true);
                daybirth.setDisable(true);
            }

        };
        enterbirthday.setOnAction(birthdayAvailable);


        anchorPane.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        anchorPane.setOnMouseDragged(event -> {
            anchorPane.getScene().getWindow().setX(event.getScreenX() - xOffset);
            anchorPane.getScene().getWindow().setY(event.getScreenY() - yOffset);
            anchorPane.getScene().getWindow().setOpacity(0.8);
        });
        anchorPane.setOnMouseReleased(event -> {
            anchorPane.getScene().getWindow().setOpacity(1);
        });

        TextfieldlistenerEditor firstname_Listener = new TextfieldlistenerEditor(firstname, VALID_NAME_FORMAT);
        TextfieldlistenerEditor lastname_Listener = new TextfieldlistenerEditor(lastname, VALID_NAME_FORMAT);
        TextfieldlistenerEditor socialid_Listener = new TextfieldlistenerEditor(socialid, VALID_SOCIAL_ID_FORMAT);
        TextfieldlistenerEditor age_Listener = new TextfieldlistenerEditor(age, VALID_AGE_FORMAT);
        TextfieldlistenerEditor phonenumber_Listener = new TextfieldlistenerEditor(phonenumber, VALID_AGE_FORMAT);
        TextfieldlistenerEditor city_Listener = new TextfieldlistenerEditor(city, VALID_NAME_FORMAT);
        TextfieldlistenerEditor address_Listener = new TextfieldlistenerEditor(address, VALID_ADDRESS_FORMAT);
        TextfieldlistenerEditor postalcode_Listener = new TextfieldlistenerEditor(postalcode, VALID_POSTALCODE_FORMAT);
        BirthdayTextFieldWatchDog BDATEday = new BirthdayTextFieldWatchDog(daybirth, 1, 31);
        BirthdayTextFieldWatchDog BDATEmonth = new BirthdayTextFieldWatchDog(monthbirth, 1, 12);
        BirthdayTextFieldWatchDog BDATEyear = new BirthdayTextFieldWatchDog(yearbirth, 1800, 2200);

    }


    public void cancelButtonPressed() {
        Stage stage = (Stage) this.cancel.getScene().getWindow();
        stage.close();
    }

    public void enterButtonPressed() {
        Date date1 = new Date();
        String birthday = daybirth.getText() + "/" + monthbirth.getText() + "/" + yearbirth.getText();
        String genderString;
        if (sexmale.isSelected()) {
            genderString = "Male";
        } else if (sexfemale.isSelected()) {
            genderString = "Female";
        }else {
            genderString = "Other";
        }
        if (customsPermission()) {


            Patient patient = new Patient
                    (
                            (firstname.getText(0, 1).toUpperCase() + firstname.getText(1, firstname.getText().length()).toLowerCase()),
                            (lastname.getText(0, 1).toUpperCase() + lastname.getText(1, lastname.getText().length()).toLowerCase()),
                            socialid.getText(),
                            genderString,
                            age.getText(),
                            birthday,
                            date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString(),
                            phonenumber.getText(),
                            (city.getText(0, 1).toUpperCase() + city.getText(1, city.getText().length()).toLowerCase()),
                            (address.getText(0, 1).toUpperCase() + address.getText(1, address.getText().length()).toLowerCase()),
                            postalcode.getText()
                    );


            DatabaseClass databaseClass = new DatabaseClass();
            databaseClass.addNewPatient(patient);

            Stage stage = (Stage) this.cancel.getScene().getWindow();
            stage.close();
        }


    }

    private boolean isThisFieldCorrect(String string, String format) {

        if (string.isEmpty()) {
            return false;
        }
        char[] inputName = string.toCharArray();

        for (char c : inputName) {
            if (format.indexOf(c) == -1) {
                return false;
            }
        }

        return true;
    }

    private boolean fieldsAreNotEmpty() {
        if (!(firstname.getText().isEmpty())) {
            if (!(lastname.getText().isEmpty())) {
                if (!(socialid.getText().isEmpty())) {
                    if (!(age.getText().isEmpty())) {
                        if (!(daybirth.getText().isEmpty())) {
                            if (!(monthbirth.getText().isEmpty())) {
                                if (!(yearbirth.getText().isEmpty())) {
                                    if (!(phonenumber.getText().isEmpty())) {
                                        if (!(city.getText().isEmpty())) {
                                            if (!(address.getText().isEmpty())) {
                                                if (!(postalcode.getText().isEmpty())) {
                                                    return true;
                                    } } } } } } } } } } }
        return false;
    }

    private boolean customsPermission() {
        if (fieldsAreNotEmpty()) {
            if (isThisFieldCorrect(firstname.getText(), VALID_NAME_FORMAT)) {
                if (isThisFieldCorrect(lastname.getText(), VALID_NAME_FORMAT)) {
                    if (isThisFieldCorrect(socialid.getText(), VALID_SOCIAL_ID_FORMAT)) {
                        if (isThisFieldCorrect(age.getText(), VALID_AGE_FORMAT)) {
                            if (Integer.parseInt(age.getText()) < 150) {
                                if (isThisFieldCorrect(phonenumber.getText(), VALID_PHONE_NUM_FORMAT)) {
                                    if (isThisFieldCorrect(city.getText(), VALID_NAME_FORMAT)) {
                                        if (isThisFieldCorrect(address.getText(), VALID_ADDRESS_FORMAT)) {
                                            if (isThisFieldCorrect(postalcode.getText(), VALID_POSTALCODE_FORMAT)) {
                                                return true;

                                            } else {
                                                systext.setText("Please Check the Postal Code");
                                            }

                                        } else {
                                            systext.setText("Please Check the Address");
                                        }

                                    } else {
                                        systext.setText("Please Check the City");
                                    }

                                } else {
                                    systext.setText("Please Check the Phone Number");
                                }
                            } else {
                                systext.setText("Please Check the Value of age");
                            }
                        } else {
                            systext.setText("Please Check the Age");
                        }

                    } else {
                        systext.setText("Please Check the Social ID");
                    }

                } else {
                    systext.setText("Please Check the Last Name");
                }

            } else {
                systext.setText("Please Check the First Name");
            }
        } else {
            systext.setText("Please Fill the Form Completely");
        }
        return false;
    }

    private static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }

    private void ageWriter() {
        if (ageDayBool & ageMonthBool & ageYearBool) {
            Date date1 = new Date();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            String date = daybirth.getText() + "/" + monthbirth.getText() + "/" + yearbirth.getText();
            System.out.println("This is Birthday: " + date);
            //convert String to LocalDate
            LocalDate birthday = LocalDate.parse(date, formatter);

            int agebydate = calculateAge(birthday, date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            System.out.println("This is age: " + agebydate);
            age.setText(String.valueOf(agebydate));
        }

    }


}


