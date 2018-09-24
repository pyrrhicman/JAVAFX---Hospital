package newPatientPagePackage;

    //<editor-fold desc="IMPORTS">
import com.jfoenix.controls.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.css.StyleClass;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.DatabaseClass;
import sample.Patient;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
//</editor-fold>

public class Newpatient implements Initializable {

    //<editor-fold desc="FXML Elements">
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
    //</editor-fold>

    private static String validName = "abcdefghijklmnopqrstuvwxyzäöå";
    private static String validsocialid = "0123456789-";
    private static String agevalidinput = "0123456789";
    private static String validPhoneNumber = "0123456789-+";
    private static String validaddress = "abcdefghijklmnopqrstuvwxyzäöå0123456789";
    private static String validpostalcode = "0123456789";

    //<editor-fold desc="STYLES">
    final String formatString = "" +
            " -fx-font-family: Segoe UI semibold ;" +
            " -fx-style: Regular; " +
            " -fx-base: #AE3522; " +
            "-jfx-unfocus-color: linear-gradient(to left, #4B5D68, #62929a 50%, #edebeb 75%);" +
            " -fx-text-fill: white; " +
            " -fx-font-size: 16";

    final String errorstring =  "" +
            " -fx-font-family: Segoe UI semibold ;" +
            " -fx-style: Regular; " +
            " -fx-base: #AE3522; " +
            "-jfx-unfocus-color: linear-gradient(to left, #4B5D68, #62929a 50%, red 75%);" +
            " -fx-text-fill: white; " +
            " -fx-font-size: 16";


    final String formatdatepicker = "" +
            " -fx-font-family: Segoe UI semibold ;" +
            " -fx-style: Regular; " +
            //" -fx-base: #AE3522; " +
            // " -fx-text-fill: white; " +
            " -fx-font-size: 16";


    final String formatbutton = "" +
            "-fx-font-family: Segoe UI semibold; " +
            "-fx-style: Regular; " +
            "-fx-base: #AE3522; " +
            "-fx-text-fill: white; " +
            "-fx-font-size: 16";

    final String formatcomboBox="" +
            "-fx-font-family: Segoe UI semibold; " +
            "-fx-style: Regular; " +
            "-fx-base: #62929a; " +
            "-fx-text-fill: #62929a; " +
            "-fx-font-size: 16";
    //</editor-fold>

    public Newpatient() {
        //Controller controller = new Controller();
        //controller.newPatientForm();
    }

    public void initialize(URL location, ResourceBundle resources) {
        birthday.setDisable(true);
        birthday.setEditable(false);
        gender.getItems().addAll("Male","Female");
        gender.setValue("Male");
        age.setEditable(true);
        registerationday.setEditable(false);
        LocalDate birthDate = LocalDate.of(1900,1,2);
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
            System.out.print("Happened");
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


        EventHandler<ActionEvent> firstnameinstantcheck = event -> {



/*
                if (firstname.getScene().getStylesheets().contains("/css/errorstylesheet.css")) {
                    System.out.println("it contains errorstylesheet");
                        firstname.getScene().getStylesheets().removeAll("/css/errorstylesheet.css");
                        firstname.getScene().getStylesheets().add("/css/stylesheet.css");
                        System.out.println("css added :");
                        customstylesetter();

                }else System.out.println("it does not contains errorstylesheet");


            } else{
                System.out.println("firstname is not formatted");

                if (firstname.getScene().getStylesheets().contains("/css/stylesheet.css")) {
                    System.out.println("it contains stylesheet");

                    firstname.getScene().getStylesheets().removeAll("/css/stylesheet.css");
                    firstname.getScene().getStylesheets().add("/css/errorstylesheet.css");
                    System.out.println("css added");
                    customstylesetter();
                }else System.out.println("it does not contains stylesheet");

                */

        };

        firstname.setOnAction(firstnameinstantcheck);


        firstname.focusedProperty().addListener((arg0, oldPropertyValue, newPropertyValue) -> {

            if (newPropertyValue)
            {
                System.out.println("Textfield on focus");

            }
            else
            {
                System.out.println("Textfield out focus");

                if (nameIsFormatted(firstname.getText())) {
                    System.out.println("firstname is formatted");
                    //firstname.setStyle(formatString);

                } else {
                    System.out.println("firstname is not formatted");
                    firstname.setStyle(errorstring);
                }


            }
        });





        EventHandler<ActionEvent> lastnameinstantcheck = event -> {


        };
        lastname.setOnAction(lastnameinstantcheck);


        EventHandler<ActionEvent> socialidinstantcheck = event -> {


        };
        socialid.setOnAction(socialidinstantcheck);


        EventHandler<ActionEvent> ageinstantcheck = event -> {


        };
        age.setOnAction(ageinstantcheck);


        EventHandler<ActionEvent> phonenumberinstantcheck = event -> {


        };
        phonenumber.setOnAction(phonenumberinstantcheck);


        EventHandler<ActionEvent> cityinstantcheck = event -> {


        };
        city.setOnAction(cityinstantcheck);




    }

    public void customstylesetter() {


        //<editor-fold desc="setSTYLE">
        firstname.setStyle(formatString);
        lastname.setStyle(formatString);
        socialid.setStyle(formatString);
        gender.setStyle(formatcomboBox);
        age.setStyle(formatString);
        registerationday.setStyle(formatdatepicker);
        birthday.setStyle(formatdatepicker);
        //birthday.setDefaultColor(Color.valueOf("#62929a"));
        phonenumber.setStyle(formatString);
        city.setStyle(formatString);
        address.setStyle(formatString);
        postalcode.setStyle(formatString);
        systext.setText(formatString);
        enter.setStyle(formatbutton);
        cancel.setStyle(formatbutton);
        //</editor-fold>

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
                            birthday.getValue(),
                            registerationday.getValue(),
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


    public boolean fieldsAreNotEmpty() {
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



    private boolean nameIsFormatted(String string) {

        char[] inputName = string.toCharArray();

        for (char c : inputName) {
            if (validName.indexOf(c) == -1) {
                return false;
            }
        }

        return true;
    }


    private boolean socialidisFormatted(String string) {
        char[] inputsocialid = string.toCharArray();

        for (char c : inputsocialid) {
            if (validsocialid.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }


    private boolean ageisFormatted() {
        String string = age.getText();
        char[] inputsocialid = string.toCharArray();

        for (char c : inputsocialid) {
            if (agevalidinput.indexOf(c) == -1) {
                return false;
            }
        }
        int age = Integer.parseInt(this.age.getText());

        if (age > 0 & age < 150) return true;
        else return false;
    }


    private boolean phoneNumberIsFormatted() {
        String string = phonenumber.getText();
        char[] inputPhoneNumber = string.toCharArray();

        for (char c : inputPhoneNumber) {
            if (validPhoneNumber.indexOf(c) == -1) {
                return false;
            }
        }

        return true;
    }


    private boolean addressIsFormatted() {
        String string = address.getText();
        char[] inputaddress = string.toCharArray();

        for (char c : inputaddress) {
            if (validaddress.indexOf(c) == -1) {
                return false;
            }
        }

        return true;
    }


    private boolean postalcodeIsFormatted() {
        String string = postalcode.getText();
        char[] inputpostalcode = string.toCharArray();

        for (char c : inputpostalcode) {
            if (validpostalcode.indexOf(c) == -1) {
                return false;
            }
        }

        return true;
    }


    private boolean customsPermission() {
        if (fieldsAreNotEmpty()) {
            if (nameIsFormatted(firstname.getText())) {
                if (nameIsFormatted(lastname.getText())) {
                    if (socialidisFormatted(socialid.getText())) {
                        if (ageisFormatted()) {
                            if (phoneNumberIsFormatted()) {
                                if (nameIsFormatted(city.getText())) {
                                    if (addressIsFormatted()) {
                                        if (postalcodeIsFormatted()) {
                                            return true;

                                        }else { systext.setText("Please Check the Postal Code"); }

                                    }else { systext.setText("Please Check the Address"); }

                                }else { systext.setText("Please Check the City"); }

                            }else { systext.setText("Please Check the Phone Number"); }

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
