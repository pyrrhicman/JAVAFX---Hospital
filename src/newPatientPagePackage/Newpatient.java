package newPatientPagePackage;

    //<editor-fold desc="IMPORTS">
import com.jfoenix.controls.*;
import css.CustomStyle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
import java.util.Date;
import java.util.ResourceBundle;

import static css.CustomStyle.*;
//</editor-fold>

public class Newpatient implements Initializable {

    //<editor-fold desc="FXML Elements">
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private JFXButton enter;
    @FXML
    private JFXButton cancel;
    /*@FXML
    private JFXButton settheme;*/
    @FXML
    private JFXTextField lastname;
    @FXML
    private JFXTextField firstname;
    @FXML
    private JFXTextField socialid;
    @FXML
    private JFXComboBox<String> gender = new JFXComboBox<String>();
    @FXML
    private JFXTextField age;
    @FXML
    private JFXDatePicker birthday;
    @FXML
    private JFXRadioButton enterbirthday;
    @FXML
    private JFXDatePicker registerationday;
    @FXML
    private JFXTextField phonenumber;
    @FXML
    private JFXTextField city;
    @FXML
    private JFXTextField address;
    @FXML
    private JFXTextField postalcode;
    @FXML
    private Text systext;
    /*@FXML
    private JFXColorPicker cp1;
    @FXML
    private JFXColorPicker cp2;
    @FXML
    private JFXColorPicker cp3;
    @FXML
    private JFXColorPicker cp4;
    @FXML
    private JFXColorPicker cp5;
    @FXML
    private JFXColorPicker cp6;
    @FXML
    private JFXColorPicker cp7;
    @FXML
    private JFXColorPicker cp8;

    @FXML
    private JFXColorPicker cp9;*/
    //</editor-fold>


    private double xOffset = 0;
    private double yOffset = 0;



    class TextfieldlistenerEditor {

        TextfieldlistenerEditor(JFXTextField jfxTextField, String string) {
            CustomStyle.updateCustomStyle();
            jfxTextField.focusedProperty().addListener((arg0, oldPropertyValue, newPropertyValue) -> {
                if (newPropertyValue)
                {
                    //System.out.println(jfxTextField.getId()+ "  on focus");
                }
                else
                {

                    System.out.println(jfxTextField.getId()+"  out focus");

                    if (isThisFieldCorrect(jfxTextField.getText(),string)) {
                        System.out.println(jfxTextField.getId()+"  is formatted");
                        jfxTextField.setStyle(textField_Style);

                    } else {
                        System.out.println(jfxTextField.getId()+"  is not formatted");
                        jfxTextField.setStyle(textField_Style_err);
                    }


                }
            });


        }
    }



    public void initialize(URL location, ResourceBundle resources) {
        birthday.setDisable(true);
        birthday.setEditable(false);
        gender.getItems().addAll("Male","Female");
        gender.setValue("Male");
        age.setEditable(true);
        age.setText("Enter Age or Select Birthday");
        registerationday.setEditable(false);
        LocalDate birthDate = LocalDate.of(2018,1,2);
        birthday.setValue(birthDate);

        customstylesetter();

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

        Date date1 = new Date();
        registerationday.setValue(date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

        EventHandler<ActionEvent> birthdaytonull = event ->{
            birthday.setOnAction(null);
            birthday.setValue(birthDate);
        };
        age.setOnAction(birthdaytonull);

        EventHandler<ActionEvent> agecalculator = event -> {
            int agebydate = calculateAge(birthday.getValue(), date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            age.setOnAction(null);
            age.setText(String.valueOf(agebydate));
            age.setOnAction(birthdaytonull);
        };
        birthday.setOnAction(agecalculator);

        EventHandler<ActionEvent> birthdayAvailable = event -> {
            if (enterbirthday.isSelected()) {
                age.setDisable(true);
                birthday.setDisable(false);
            } else {
                age.setDisable(false);
                birthday.setDisable(true);
            }

        };
        enterbirthday.setOnAction(birthdayAvailable);

        EventHandler<MouseEvent> mouseEvent = event -> {

            System.out.println(event.toString());//36-42
            String string = event.toString().substring(36, 42);
            switch (string) {
                case "id=cp1":
                    systext.setText("fxFocusColor");
                    break;
                case "id=cp2":
                    systext.setText("jfxUnfocusColor1");
                    break;
                case "id=cp3":
                    systext.setText("jfxUnfocusColor2");
                    break;
                case "id=cp4":
                    systext.setText("fxBase");
                    break;
                case "id=cp5":
                    systext.setText("fxTextFill");
                    break;
                case "id=cp6":
                    systext.setText("fxButtonColor");
                    break;
                case "id=cp7":
                    systext.setText("fxButtonSideColor");
                    break;
                case "id=cp8":
                    systext.setText("fxPromptTextColor");
                    break;
                case "id=cp9":
                    systext.setText("fxAnchorBackgroundColor");
                    break;
            }
        };


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

        TextfieldlistenerEditor firstname_Listener  = new TextfieldlistenerEditor(firstname,VALID_NAME_FORMAT);
        TextfieldlistenerEditor lastname_Listener  = new TextfieldlistenerEditor(lastname,VALID_NAME_FORMAT);
        TextfieldlistenerEditor socialid_Listener  = new TextfieldlistenerEditor(socialid,VALID_SOCIAL_ID_FORMAT);
        TextfieldlistenerEditor age_Listener  = new TextfieldlistenerEditor(age,VALID_AGE_FORMAT);
        TextfieldlistenerEditor phonenumber_Listener  = new TextfieldlistenerEditor(phonenumber,VALID_AGE_FORMAT);
        TextfieldlistenerEditor city_Listener  = new TextfieldlistenerEditor(city,VALID_NAME_FORMAT);
        TextfieldlistenerEditor address_Listener  = new TextfieldlistenerEditor(address,VALID_ADDRESS_FORMAT);
        TextfieldlistenerEditor postalcode_Listener  = new TextfieldlistenerEditor(postalcode,VALID_POSTALCODE_FORMAT);
    }

    public void customstylesetter() {

        //<editor-fold desc="setSTYLE">
        CustomStyle.updateCustomStyle();

        //ANCHOR PANE
        anchorPane.setStyle(anchorPane_Style);

        //TEXT FIELDS
        firstname.setStyle(textField_Style_Font + textField_Style);
        lastname.setStyle(textField_Style_Font + textField_Style);
        socialid.setStyle(textField_Style_Font + textField_Style);
        age.setStyle(textField_Style_Font + textField_Style);
        phonenumber.setStyle(textField_Style_Font + textField_Style);
        city.setStyle(textField_Style_Font + textField_Style);
        address.setStyle(textField_Style_Font + textField_Style);
        postalcode.setStyle(textField_Style_Font + textField_Style);

        //COMBO BOX
        gender.setStyle(comboBox_Style_Font+comboBox_Style);

        //DATE PICKER
        registerationday.setStyle(datePicker_Style_Font+datePicker_Style);
        birthday.setStyle(datePicker_Style_Font+datePicker_Style);

        //BUTTONS
        enter.setStyle(button_Style_Font + button_Style +"-fx-background-color: "+ fxButtonColor +";");
        cancel.setStyle(button_Style_Font + button_Style +"-fx-background-color: "+ fxButtonColor +";");
        //settheme.setStyle(button_Style_Font + button_Style +"-fx-background-color: "+ fxButtonColor +";");

        //TEXT
        systext.setText(textField_Style);



        //</editor-fold>
        //enter.setStyle("-fx-background-color: "+ fxButtonColor+";" + "-fx-border-color:transparent transparent transparent "+fxButtonSideColor +";");
        //cancel.setStyle("-fx-background-color: "+ fxButtonColor+";");
        //settheme.setStyle("-fx-background-color: "+ fxButtonColor+";");

    }

    public void cancelButtonPressed() {
        Stage stage = (Stage) this.cancel.getScene().getWindow();
        stage.close();
    }

    public void enterButtonPressed() {
        if (customsPermission()) {


            Patient patient = new Patient
                    (
                            (firstname.getText(0, 1).toUpperCase() + firstname.getText(1, firstname.getText().length()).toLowerCase()),
                            (lastname.getText(0, 1).toUpperCase() + lastname.getText(1, lastname.getText().length()).toLowerCase()),
                            socialid.getText(),
                            gender.getValue(),
                            age.getText(),
                            birthday.getValue().toString(),
                            registerationday.getValue().toString(),
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
                        //if (!(registerationday.getText().isEmpty())) {
                            if (!(phonenumber.getText().isEmpty())) {
                                if (!(city.getText().isEmpty())) {
                                    if (!(address.getText().isEmpty())) {
                                        if (!(postalcode.getText().isEmpty())) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        //}
                    }
                }
            }
        }
        return false;
    }

    private boolean customsPermission() {
        if (fieldsAreNotEmpty()) {
            if (isThisFieldCorrect(firstname.getText(),VALID_NAME_FORMAT)) {
                if (isThisFieldCorrect(lastname.getText(),VALID_NAME_FORMAT)) {
                    if (isThisFieldCorrect(socialid.getText(),VALID_SOCIAL_ID_FORMAT)) {
                        if (isThisFieldCorrect(age.getText(),VALID_AGE_FORMAT)) {
                            if (Integer.parseInt(age.getText()) < 150) {
                                if (isThisFieldCorrect(phonenumber.getText(),VALID_PHONE_NUM_FORMAT)) {
                                    if (isThisFieldCorrect(city.getText(),VALID_NAME_FORMAT)) {
                                        if (isThisFieldCorrect(address.getText(),VALID_ADDRESS_FORMAT)) {
                                            if (isThisFieldCorrect(postalcode.getText(),VALID_POSTALCODE_FORMAT)) {
                                                return true;

                                            }else { systext.setText("Please Check the Postal Code"); }

                                        }else { systext.setText("Please Check the Address"); }

                                    }else { systext.setText("Please Check the City"); }

                                }else { systext.setText("Please Check the Phone Number"); }
                            }else { systext.setText("Please Check the Value of age"); }
                        }else { systext.setText("Please Check the Age"); }

                    }else { systext.setText("Please Check the Social ID"); }

                }else { systext.setText("Please Check the Last Name"); }

            }else { systext.setText("Please Check the First Name"); }
        }else { systext.setText("Please Fill the Form Completely"); }
        return false;
    }

    private static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }




}


