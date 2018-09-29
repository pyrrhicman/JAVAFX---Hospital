package css;




public class CustomStyle {



    private final static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÅabcdefghijklmnopqrstuvwxyz";
    private final static String NUMBERS = "0123456789";
    private final static String SPACES = " ";
    public final static String VALID_NAME_FORMAT =         ALPHABET + SPACES;
    public final static String VALID_SOCIAL_ID_FORMAT =    NUMBERS + "-";
    public final static String VALID_AGE_FORMAT =          NUMBERS;
    public final static String VALID_PHONE_NUM_FORMAT =    NUMBERS + "-+";
    public final static String VALID_ADDRESS_FORMAT =      ALPHABET + NUMBERS + SPACES;
    public final static String VALID_POSTALCODE_FORMAT =   NUMBERS;

    public  static String fxStyle = "Regular";
    public  static String fxFontFamily = "Segoe UI semibold";
    public  static String fxFontSize = "16";
    public  static String fxTextFill = "white";
    public  static String fxBase = "#AE3522";
    public  static String jfxUnfocusColor1 = "#4B5D68";
    public  static String jfxUnfocusColor2 = "white";
    public  static String fxFocusColor = "#FCFF31";
    public  static String jfxErrorUnfocusColor1 = "#4B5D68";
    public  static String jfxErrorUnfocusColor2 = "white";
    public  static String fxButtonColor = "#4B5D68";
    public  static String fxButtonSideColor = "#4B5D68";
    public  static String fxPromptTextColor = "#4B5D68";
    public  static String fxAnchorBackgroundColor = "#4B5D68";
    public  static String textField_Style_Font;
    public  static String textField_Style;
    public  static String textField_Style_err;
    public  static String comboBox_Style_Font;
    public  static String comboBox_Style;
    public  static String comboBox_Style_err;
    public  static String datePicker_Style_Font;
    public  static String datePicker_Style;
    public  static String datePicker_Style_err;
    public  static String button_Style_Font;
    public  static String button_Style;
    public  static String button_Style_err;
    public  static String anchorPane_Style;
    //private String anchorPane_Style_err = "-fx-background-color: " + fxAnchorBackgroundColor + ";";

    public static void updateCustomStyle() {

        //<editor-fold desc="TEXT FIELD STYLE">
        String textField_Style_Font = ""+
                "-fx-font-family: "+ fxFontFamily +";" +
                "-fx-style:"+ fxStyle + ";" +
                "-fx-font-size:"+ fxFontSize +";";

        String textField_Style = ""+
                "-fx-base:" + fxBase + ";"+
                "-jfx-unfocus-color: linear-gradient(to left, "  + jfxUnfocusColor1 + " 10%" +   ","   + jfxUnfocusColor2 +   " 75%);" +
                "-jfx-focus-color: " + fxFocusColor +";"+
                "-fx-text-fill: "+ fxTextFill +";" +
                "-fx-border-color: transparent transparent transparent transparent"+";" +
                "-fx-prompt-text-fill: "+ fxPromptTextColor + ";";

        String textField_Style_err = ""+
                "-fx-base:" + fxBase + ";"+
                "-jfx-unfocus-color: linear-gradient(to left, "  + jfxErrorUnfocusColor1 + " 10%" +   ","   + jfxErrorUnfocusColor2 +   " 75%);" +
                "-jfx-focus-color: " + fxFocusColor +";"+
                "-fx-text-fill: "+ fxTextFill +";" +
                "-fx-font-family: "+ fxFontFamily +";" +
                "-fx-style:"+ fxStyle + ";" +
                "-fx-font-size:"+ fxFontSize +";";
        //</editor-fold>

        //<editor-fold desc="COMBOBOX STYLE">
        String comboBox_Style_Font = ""+
                "-fx-font-family: "+ fxFontFamily +";" +
                "-fx-style:"+ fxStyle + ";" +
                "-fx-font-size:"+ fxFontSize +";";


        String comboBox_Style = ""+
                "-fx-base:" + fxBase + ";"+
                "-jfx-unfocus-color: linear-gradient(to left, "  + jfxUnfocusColor1 + " 10%" +   ","   + jfxUnfocusColor2 +   " 75%);" +
                "-jfx-focus-color: " + fxFocusColor +";"+
                "-fx-text-fill: "+ fxTextFill +";" +
                "-fx-border-color: transparent transparent transparent transparent"+";" +
                "-fx-prompt-text-fill: "+ fxPromptTextColor + ";";

        String comboBox_Style_err = ""+
                "-fx-base:" + fxBase + ";"+
                "-jfx-unfocus-color: linear-gradient(to left, "  + jfxErrorUnfocusColor1 + " 10%" +   ","   + jfxErrorUnfocusColor2 +   " 75%);" +
                "-jfx-focus-color: " + fxFocusColor +";"+
                "-fx-text-fill: "+ fxTextFill +";" +
                "-fx-font-family: "+ fxFontFamily +";" +
                "-fx-style:"+ fxStyle + ";" +
                "-fx-font-size:"+ fxFontSize +";";
        //</editor-fold>

        //<editor-fold desc="DATEPICKER STYLE">
        String datePicker_Style_Font = ""+
                "-fx-font-family: "+ fxFontFamily +";" +
                "-fx-style:"+ fxStyle + ";" +
                "-fx-font-size:"+ fxFontSize +";";
        String datePicker_Style = ""+
                "-fx-base:" + fxBase + ";"+
                "-jfx-unfocus-color: linear-gradient(to left, "  + jfxUnfocusColor1 + " 10%" +   ","   + jfxUnfocusColor2 +   " 75%);" +
                "-jfx-focus-color: " + fxFocusColor +";"+
                "-fx-text-fill: "+ fxTextFill +";" +
                "-fx-font-family: "+ fxFontFamily +";" +
                "-fx-style:"+ fxStyle + ";" +
                "-fx-font-size:"+ fxFontSize +";" +
                "-fx-border-color: transparent transparent transparent transparent"+";" +
                "-fx-prompt-text-fill: "+ fxPromptTextColor + ";";

        String datePicker_Style_err = ""+
                "-fx-base:" + fxBase + ";"+
                "-jfx-unfocus-color: linear-gradient(to left, "  + jfxErrorUnfocusColor1 + " 10%" +   ","   + jfxErrorUnfocusColor2 +   " 75%);" +
                "-jfx-focus-color: " + fxFocusColor +";"+
                "-fx-text-fill: "+ fxTextFill +";" +
                "-fx-font-family: "+ fxFontFamily +";" +
                "-fx-style:"+ fxStyle + ";" +
                "-fx-font-size:"+ fxFontSize +";";
        //</editor-fold>

        //<editor-fold desc="BUTTON STYLE">
        String button_Style_Font = ""+
                "-fx-font-family: "+ fxFontFamily +";" +
                "-fx-style:"+ fxStyle + ";" +
                "-fx-font-size:"+ fxFontSize +";";

        String button_Style = ""+
                "-fx-base:" + fxBase + ";"+
                "-jfx-unfocus-color: linear-gradient(to left, "  + jfxUnfocusColor1 + " 10%" +   ","   + jfxUnfocusColor2 +   " 75%);" +
                "-jfx-focus-color: " + fxFocusColor +";"+
                "-fx-text-fill: "+ fxTextFill +";" +
                "-fx-border-color: transparent transparent transparent "+ fxButtonSideColor +";" +
                "-fx-prompt-text-fill: "+ fxPromptTextColor + ";";

        String button_Style_err = ""+
                "-fx-base:" + fxBase + ";"+
                "-jfx-unfocus-color: linear-gradient(to left, "  + jfxErrorUnfocusColor1 + " 10%" +   ","   + jfxErrorUnfocusColor2 +   " 75%);" +
                "-jfx-focus-color: " + fxFocusColor +";"+
                "-fx-text-fill: "+ fxTextFill +";" +
                "-fx-font-family: "+ fxFontFamily +";" +
                "-fx-style:"+ fxStyle + ";" +
                "-fx-font-size:"+ fxFontSize +";";
        //</editor-fold>

        //<editor-fold desc="ANCHOR PANE">
        String anchorPane_Style = "-fx-background-color: " + fxAnchorBackgroundColor + ";";
        // String anchorPane_Style_err = "-fx-background-color: " + fxAnchorBackgroundColor + ";";
        //</editor-fold>

        CustomStyle.textField_Style_Font = textField_Style_Font;
        CustomStyle.textField_Style = textField_Style;
        CustomStyle.textField_Style_err = textField_Style_err;

        CustomStyle.comboBox_Style_Font = comboBox_Style_Font;
        CustomStyle.comboBox_Style = comboBox_Style;
        CustomStyle.comboBox_Style_err = comboBox_Style_err;

        CustomStyle.datePicker_Style_Font=datePicker_Style_Font;
        CustomStyle.datePicker_Style =datePicker_Style;
        CustomStyle.datePicker_Style_err=datePicker_Style_err;

        CustomStyle.button_Style_Font=button_Style_Font;
        CustomStyle.button_Style=button_Style;
        CustomStyle.button_Style_err=button_Style_err;

        CustomStyle.anchorPane_Style=anchorPane_Style;
    }
}
