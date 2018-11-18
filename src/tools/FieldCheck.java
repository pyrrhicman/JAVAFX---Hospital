package tools;

import css.CustomStyle;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static css.CustomStyle.VALID_AGE_FORMAT;

public class FieldCheck {
    private static Boolean ageYearBool = false;
    private static Boolean ageMonthBool = false;
    private static Boolean ageDayBool = false;
    /*public FieldCheck(TextField textField , String string) {
        textField.focusedProperty().addListener((arg0, oldPropertyValue, newPropertyValue) -> {
            if (!newPropertyValue) {
                System.out.println(textField.getId() + "  out focus");

                if (isThisFieldCorrect(textField.getText(), string)) {
                    System.out.println(textField.getId() + "  is formatted in Cons");
                    textField.setStyle(CustomStyle.getTextField_Style());

                } else {
                    System.out.println(textField.getId() + "  is not formatted");
                    textField.setStyle(CustomStyle.getTextField_Style_err());
                }
            }
        });

    }*/


    public static  void fieldCheck(TextField textField , String string) {
        textField.focusedProperty().addListener((arg0, oldPropertyValue, newPropertyValue) -> {
            if (!newPropertyValue) {
                System.out.println(textField.getId() + "  out focus");

                if (isThisFieldCorrect(textField.getText(), string)) {
                    System.out.println(textField.getId() + "  is formatted in method");
                    textField.setStyle(CustomStyle.getTextField_Style());

                } else {
                    System.out.println(textField.getId() + "  is not formatted");
                    textField.setStyle(CustomStyle.getTextField_Style_err());
                }
            }
        });


    }

    public static  void birthdayTextFieldWatchDog(TextField textField, int min, int max) {

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

    private static boolean isThisFieldCorrect(String string, String format) {

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



}
