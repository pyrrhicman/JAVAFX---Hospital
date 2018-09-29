package newPatientPagePackage;

    //<editor-fold desc="IMPORTS">
import com.jfoenix.controls.*;
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
    private AnchorPane anchorPane;
    @FXML
    private JFXButton enter;
    @FXML
    private JFXButton cancel;
    @FXML
    private JFXButton settheme;
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
    @FXML
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
    private JFXColorPicker cp9;
    //</editor-fold>
    private final static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÅabcdefghijklmnopqrstuvwxyz";
    private final static String NUMBERS = "0123456789";
    private final static String SPACES = " ";

    private final static String VALID_NAME_FORMAT =         ALPHABET + SPACES;
    private final static String VALID_SOCIAL_ID_FORMAT =    NUMBERS + "-";
    private final static String VALID_AGE_FORMAT =          NUMBERS;
    private final static String VALID_PHONE_NUM_FORMAT =    NUMBERS + "-+";
    private final static String VALID_ADDRESS_FORMAT =      ALPHABET + NUMBERS + SPACES;
    private final static String VALID_POSTALCODE_FORMAT =   NUMBERS;

    private  static String FX_STYLE = "Regular";
    private  static String FX_FONT_FAMILY = "Segoe UI semibold";
    private  static String FX_FONT_SIZE = "16";
    private  static String FX_TEXT_FILL = "white";
    private  static String FX_BASE = "#AE3522";
    private  static String JFX_UNFOCUS_COLOR_1 = "#4B5D68";
    private  static String JFX_UNFOCUS_COLOR_2 = "white";
    private  static String FX_FOCUS_COLOR = "#FCFF31";

    private  static String JFX_ERROR_UNFOCUS_COLOR_1 = "#4B5D68";
    private  static String JFX_ERROR_UNFOCUS_COLOR_2 = "white";

    private  static String FX_BUTTON_COLOR = "#4B5D68";
    private  static String FX_BUTTON_SIDE_COLOR = "#4B5D68";

    private  static String FX_PROMPT_TEXT_COLOR = "#4B5D68";

    private  static String FX_ANCHOR_BACKGROUND_COLOR = "#4B5D68";

    //<editor-fold desc="TEXTFIELD STYLE">
    private String textField_Style_Font;
    private String textField_Style;
    private String textField_Style_err;

    private String comboBox_Style_Font;
    private String comboBox_Style;
    private String comboBox_Style_err;

    private String datePicker_Style_Font;
    private String datePicker_Style;
    private String datePicker_Style_err;

    private String button_Style_Font;
    private String button_Style;
    private String button_Style_err;

    //<editor-fold desc="ANCHOR PANE STYLE">
    private String anchorPane_Style = "-fx-background-color: " + FX_ANCHOR_BACKGROUND_COLOR + ";";
    //private String anchorPane_Style_err = "-fx-background-color: " + FX_ANCHOR_BACKGROUND_COLOR + ";";
    //</editor-fold>


    class TextfieldlistenerEditor {


        TextfieldlistenerEditor(JFXTextField jfxTextField, String string) {

            jfxTextField.focusedProperty().addListener((arg0, oldPropertyValue, newPropertyValue) -> {
                if (newPropertyValue)
                {
                    System.out.println(jfxTextField.getId()+ "  on focus");
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

        EventHandler<MouseEvent> mouseEvent = event -> {

            System.out.println(event.toString());//36-42
            String string = event.toString().substring(36, 42);
            switch (string) {
                case "id=cp1":
                    systext.setText("FX_FOCUS_COLOR");
                    break;
                case "id=cp2":
                    systext.setText("JFX_UNFOCUS_COLOR_1");
                    break;
                case "id=cp3":
                    systext.setText("JFX_UNFOCUS_COLOR_2");
                    break;
                case "id=cp4":
                    systext.setText("FX_BASE");
                    break;
                case "id=cp5":
                    systext.setText("FX_TEXT_FILL");
                    break;
                case "id=cp6":
                    systext.setText("FX_BUTTON_COLOR");
                    break;
                case "id=cp7":
                    systext.setText("FX_BUTTON_SIDE_COLOR");
                    break;
                case "id=cp8":
                    systext.setText("FX_PROMPT_TEXT_COLOR");
                    break;
                case "id=cp9":
                    systext.setText("FX_ANCHOR_BACKGROUND_COLOR");
                    break;
            }
        };
        cp1.setOnMouseEntered(mouseEvent);
        cp2.setOnMouseEntered(mouseEvent);
        cp3.setOnMouseEntered(mouseEvent);
        cp4.setOnMouseEntered(mouseEvent);
        cp5.setOnMouseEntered(mouseEvent);
        cp6.setOnMouseEntered(mouseEvent);
        cp7.setOnMouseEntered(mouseEvent);
        cp8.setOnMouseEntered(mouseEvent);
        cp9.setOnMouseEntered(mouseEvent);
        TextfieldlistenerEditor firstname_Listener  = new TextfieldlistenerEditor(firstname,VALID_NAME_FORMAT);
        TextfieldlistenerEditor lastname_Listener  = new TextfieldlistenerEditor(lastname,VALID_NAME_FORMAT);
        TextfieldlistenerEditor socialid_Listener  = new TextfieldlistenerEditor(socialid,VALID_SOCIAL_ID_FORMAT);
        TextfieldlistenerEditor age_Listener  = new TextfieldlistenerEditor(age,VALID_AGE_FORMAT);
        TextfieldlistenerEditor phonenumber_Listener  = new TextfieldlistenerEditor(phonenumber,VALID_PHONE_NUM_FORMAT);
        TextfieldlistenerEditor city_Listener  = new TextfieldlistenerEditor(city,VALID_NAME_FORMAT);
        TextfieldlistenerEditor address_Listener  = new TextfieldlistenerEditor(address,VALID_ADDRESS_FORMAT);
        TextfieldlistenerEditor postalcode_Listener  = new TextfieldlistenerEditor(postalcode,VALID_POSTALCODE_FORMAT);
        cp1.setValue(Color.valueOf(FX_FOCUS_COLOR));
        cp2.setValue(Color.valueOf(JFX_UNFOCUS_COLOR_1));
        cp3.setValue(Color.valueOf(JFX_UNFOCUS_COLOR_2));
        cp4.setValue(Color.valueOf(FX_BASE));
        cp5.setValue(Color.valueOf(FX_TEXT_FILL));
        cp6.setValue(Color.valueOf(FX_BUTTON_COLOR));
        cp7.setValue(Color.valueOf(FX_BUTTON_SIDE_COLOR));
        cp8.setValue(Color.valueOf(FX_PROMPT_TEXT_COLOR));
        cp9.setValue(Color.valueOf(FX_ANCHOR_BACKGROUND_COLOR));

    }

    public void customstylesetter() {

        //<editor-fold desc="setSTYLE">
        styleupdate();

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
        enter.setStyle(button_Style_Font + button_Style +"-fx-background-color: "+ FX_BUTTON_COLOR+";");
        cancel.setStyle(button_Style_Font + button_Style +"-fx-background-color: "+ FX_BUTTON_COLOR+";");
        settheme.setStyle(button_Style_Font + button_Style +"-fx-background-color: "+ FX_BUTTON_COLOR+";");

        //TEXT
        systext.setText(textField_Style);



        //</editor-fold>
        //enter.setStyle("-fx-background-color: "+ FX_BUTTON_COLOR+";" + "-fx-border-color:transparent transparent transparent "+FX_BUTTON_SIDE_COLOR +";");
        //cancel.setStyle("-fx-background-color: "+ FX_BUTTON_COLOR+";");
        //settheme.setStyle("-fx-background-color: "+ FX_BUTTON_COLOR+";");

    }

    public void cancelButtonPressed() {
        Stage stage = (Stage) this.cancel.getScene().getWindow();
        stage.close();
    }
    public void setthemebutton() {
        FX_FOCUS_COLOR = "#" + Integer.toHexString(cp1.getValue().hashCode());
        FX_FOCUS_COLOR = FX_FOCUS_COLOR.substring(0, 7);

        JFX_UNFOCUS_COLOR_1 = "#" + Integer.toHexString(cp2.getValue().hashCode());
        JFX_UNFOCUS_COLOR_1 = JFX_UNFOCUS_COLOR_1.substring(0, 7);

        JFX_UNFOCUS_COLOR_2 = "#" + Integer.toHexString(cp3.getValue().hashCode());
        JFX_UNFOCUS_COLOR_2 = JFX_UNFOCUS_COLOR_2.substring(0, 7);

        FX_BASE = "#" + Integer.toHexString(cp4.getValue().hashCode());
        FX_BASE = FX_BASE.substring(0, 7);

        FX_TEXT_FILL = "#" + Integer.toHexString(cp5.getValue().hashCode());
        FX_TEXT_FILL = FX_TEXT_FILL.substring(0, 7);

        FX_BUTTON_COLOR = "#" + Integer.toHexString(cp6.getValue().hashCode());
        FX_BUTTON_COLOR = FX_BUTTON_COLOR.substring(0, 7);

        FX_BUTTON_SIDE_COLOR = "#" + Integer.toHexString(cp7.getValue().hashCode());
        FX_BUTTON_SIDE_COLOR = FX_BUTTON_SIDE_COLOR.substring(0, 7);

        FX_PROMPT_TEXT_COLOR = "#" + Integer.toHexString(cp8.getValue().hashCode());
        FX_PROMPT_TEXT_COLOR = FX_PROMPT_TEXT_COLOR.substring(0, 7);

        FX_ANCHOR_BACKGROUND_COLOR = "#" + Integer.toHexString(cp9.getValue().hashCode());
        FX_ANCHOR_BACKGROUND_COLOR = FX_ANCHOR_BACKGROUND_COLOR.substring(0, 7);


        customstylesetter();
        System.out.println("theme is set " + "FX_FOCUS_COLOR: " + FX_FOCUS_COLOR + " JFX_UNFOCUS_COLOR_1: " + JFX_UNFOCUS_COLOR_1+ " JFX_UNFOCUS_COLOR_2: " + JFX_UNFOCUS_COLOR_2 + " FX_BASE: " + FX_BASE );
        System.out.println(textField_Style);


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

    private void styleupdate() {
        //<editor-fold desc="TEXTFIELD STYLE">
         String textField_Style_Font = ""+
                "-fx-font-family: "+FX_FONT_FAMILY+";" +
                "-fx-style:"+ FX_STYLE + ";" +
                "-fx-font-size:"+FX_FONT_SIZE+";";

         String textField_Style = ""+
                "-fx-base:" +  FX_BASE  + ";"+
                "-jfx-unfocus-color: linear-gradient(to left, "  +JFX_UNFOCUS_COLOR_1+ " 10%" +   ","   +JFX_UNFOCUS_COLOR_2+   " 75%);" +
                "-jfx-focus-color: " + FX_FOCUS_COLOR +";"+
                "-fx-text-fill: "+FX_TEXT_FILL+";" +
                "-fx-border-color: transparent transparent transparent transparent"+";" +
                "-fx-prompt-text-fill: "+ FX_PROMPT_TEXT_COLOR + ";";

         String textField_Style_err = ""+
                "-fx-base:" +  FX_BASE  + ";"+
                "-jfx-unfocus-color: linear-gradient(to left, "  +JFX_ERROR_UNFOCUS_COLOR_1+ " 10%" +   ","   +JFX_ERROR_UNFOCUS_COLOR_2+   " 75%);" +
                "-jfx-focus-color: " + FX_FOCUS_COLOR +";"+
                "-fx-text-fill: "+FX_TEXT_FILL+";" +
                "-fx-font-family: "+FX_FONT_FAMILY+";" +
                "-fx-style:"+ FX_STYLE + ";" +
                "-fx-font-size:"+FX_FONT_SIZE+";";
        //</editor-fold>

        //<editor-fold desc="COMBOBOX STYLE">
         String comboBox_Style_Font = ""+
                "-fx-font-family: "+FX_FONT_FAMILY+";" +
                "-fx-style:"+ FX_STYLE + ";" +
                "-fx-font-size:"+FX_FONT_SIZE+";";


         String comboBox_Style = ""+
                "-fx-base:" +  FX_BASE  + ";"+
                "-jfx-unfocus-color: linear-gradient(to left, "  +JFX_UNFOCUS_COLOR_1+ " 10%" +   ","   +JFX_UNFOCUS_COLOR_2+   " 75%);" +
                "-jfx-focus-color: " + FX_FOCUS_COLOR +";"+
                "-fx-text-fill: "+FX_TEXT_FILL+";" +
                "-fx-border-color: transparent transparent transparent transparent"+";" +
                "-fx-prompt-text-fill: "+ FX_PROMPT_TEXT_COLOR + ";";

         String comboBox_Style_err = ""+
                "-fx-base:" +  FX_BASE  + ";"+
                "-jfx-unfocus-color: linear-gradient(to left, "  +JFX_ERROR_UNFOCUS_COLOR_1+ " 10%" +   ","   +JFX_ERROR_UNFOCUS_COLOR_2+   " 75%);" +
                "-jfx-focus-color: " + FX_FOCUS_COLOR +";"+
                "-fx-text-fill: "+FX_TEXT_FILL+";" +
                "-fx-font-family: "+FX_FONT_FAMILY+";" +
                "-fx-style:"+ FX_STYLE + ";" +
                "-fx-font-size:"+FX_FONT_SIZE+";";
        //</editor-fold>

        //<editor-fold desc="DATEPICKER STYLE">
         String datePicker_Style_Font = ""+
                "-fx-font-family: "+FX_FONT_FAMILY+";" +
                "-fx-style:"+ FX_STYLE + ";" +
                "-fx-font-size:"+FX_FONT_SIZE+";";
         String datePicker_Style = ""+
                "-fx-base:" +  FX_BASE  + ";"+
                "-jfx-unfocus-color: linear-gradient(to left, "  +JFX_UNFOCUS_COLOR_1+ " 10%" +   ","   +JFX_UNFOCUS_COLOR_2+   " 75%);" +
                "-jfx-focus-color: " + FX_FOCUS_COLOR +";"+
                "-fx-text-fill: "+FX_TEXT_FILL+";" +
                "-fx-font-family: "+FX_FONT_FAMILY+";" +
                "-fx-style:"+ FX_STYLE + ";" +
                "-fx-font-size:"+FX_FONT_SIZE+";" +
                "-fx-border-color: transparent transparent transparent transparent"+";" +
                "-fx-prompt-text-fill: "+ FX_PROMPT_TEXT_COLOR + ";";

         String datePicker_Style_err = ""+
                "-fx-base:" +  FX_BASE  + ";"+
                "-jfx-unfocus-color: linear-gradient(to left, "  +JFX_ERROR_UNFOCUS_COLOR_1+ " 10%" +   ","   +JFX_ERROR_UNFOCUS_COLOR_2+   " 75%);" +
                "-jfx-focus-color: " + FX_FOCUS_COLOR +";"+
                "-fx-text-fill: "+FX_TEXT_FILL+";" +
                "-fx-font-family: "+FX_FONT_FAMILY+";" +
                "-fx-style:"+ FX_STYLE + ";" +
                "-fx-font-size:"+FX_FONT_SIZE+";";
        //</editor-fold>

        //<editor-fold desc="BUTTON STYLE">
         String button_Style_Font = ""+
                "-fx-font-family: "+FX_FONT_FAMILY+";" +
                "-fx-style:"+ FX_STYLE + ";" +
                "-fx-font-size:"+FX_FONT_SIZE+";";

         String button_Style = ""+
                "-fx-base:" +  FX_BASE  + ";"+
                "-jfx-unfocus-color: linear-gradient(to left, "  +JFX_UNFOCUS_COLOR_1+ " 10%" +   ","   +JFX_UNFOCUS_COLOR_2+   " 75%);" +
                "-jfx-focus-color: " + FX_FOCUS_COLOR +";"+
                "-fx-text-fill: "+FX_TEXT_FILL+";" +
                "-fx-border-color: transparent transparent transparent "+FX_BUTTON_SIDE_COLOR +";" +
                "-fx-prompt-text-fill: "+ FX_PROMPT_TEXT_COLOR + ";";

         String button_Style_err = ""+
                "-fx-base:" +  FX_BASE  + ";"+
                "-jfx-unfocus-color: linear-gradient(to left, "  +JFX_ERROR_UNFOCUS_COLOR_1+ " 10%" +   ","   +JFX_ERROR_UNFOCUS_COLOR_2+   " 75%);" +
                "-jfx-focus-color: " + FX_FOCUS_COLOR +";"+
                "-fx-text-fill: "+FX_TEXT_FILL+";" +
                "-fx-font-family: "+FX_FONT_FAMILY+";" +
                "-fx-style:"+ FX_STYLE + ";" +
                "-fx-font-size:"+FX_FONT_SIZE+";";
        //</editor-fold>

        //<editor-fold desc="ANCHOR PANE STYLE">
         String anchorPane_Style = "-fx-background-color: " + FX_ANCHOR_BACKGROUND_COLOR + ";";
        //private String anchorPane_Style_err = "-fx-background-color: " + FX_ANCHOR_BACKGROUND_COLOR + ";";
        //</editor-fold>


        this.textField_Style_Font= textField_Style_Font;
        this.textField_Style_err=textField_Style_err;
        this.textField_Style = textField_Style;

        this.comboBox_Style = comboBox_Style;
        this.comboBox_Style_err = comboBox_Style_err;
        this.comboBox_Style_Font = comboBox_Style_Font;

        this.datePicker_Style = datePicker_Style;
        this.datePicker_Style_err = datePicker_Style_err;
        this.datePicker_Style_Font = datePicker_Style_Font;

        this.button_Style = button_Style;
        this.button_Style_err = button_Style_err;
        this.button_Style_Font = button_Style_Font;

        this.anchorPane_Style = anchorPane_Style;



    }



}


