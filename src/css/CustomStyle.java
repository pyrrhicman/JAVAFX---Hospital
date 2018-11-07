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

    private  static String fxStyle = "Regular";
    private  static String fxFontFamily = "Segoe UI semibold";
    private  static String fxFontSize = "14";
    private  static String fxTextFill = "black";
    private  static String fxErrorTextFill = "red";
    private  static String fxborderwidth = "2.0";

    private  static String fxBase = "#ECF0F1";

    private  static String fxUnfocusColor = "#4B5D68";
    private  static String fxFocusColor = "#FCFF31";
    private  static String fxErrorUnfocusColor = "red";

    private  static String fxPromptTextColor = "#515A5A";
    private  static String fxErrorPromptTextColor = "#B03A2E";


    private  static String fxAnchorBackgroundColor = "#4B5D68";

    private  static String fxButtonSideColor = "#4B5D68";
    private  static String fxButtonColor = "#4B5D68";
    //private  static String jfxUnfocusColor2 = "white";
    //private  static String fxPromptTextColor = "#A3A3A3";
    //private  static String jfxErrorUnfocusColor2 = "white";


    //private String anchorPane_Style_err = "-fx-background-color: " + fxAnchorBackgroundColor + ";";
    String anchorPane_Style = "-fx-background-color: " + fxAnchorBackgroundColor + ";";
    // String anchorPane_Style_err = "-fx-background-color: " + fxAnchorBackgroundColor + ";";
    static String formatbutton = "" +
            "-fx-font-family: Segoe UI semibold; " +
            "-fx-style: Regular; " +
            "-fx-base: #AE3522; " +
            "-fx-text-fill: black; " +
            "-fx-font-size: 16";


        //<editor-fold desc="TEXT FIELD STYLE">

    static String textField_Style = ""+
            "-fx-base:" + fxBase + ";"+
            "-fx-font-family: "+ fxFontFamily +";" +
            "-fx-style:"+ fxStyle + ";" +
            "-fx-border-width: "+fxborderwidth+";" +
            "-fx-font-size:"+ fxFontSize +";" +

            "-fx-text-fill: "+ fxTextFill +";" +
            "-fx-unfocus-color:"+ fxUnfocusColor + ";" +
            "-fx-focus-color: " + fxFocusColor +";"+
            "-fx-prompt-text-fill: "+ fxPromptTextColor + ";"+
            "-fx-border-color: transparent transparent green transparent"+";";
    static String textField_Style_err = ""+
            "-fx-base:" + fxBase + ";"+
            "-fx-font-family: "+ fxFontFamily +";" +
            "-fx-style:"+ fxStyle + ";" +
            "-fx-border-width: "+fxborderwidth+";" +
            "-fx-font-size:"+ fxFontSize +";" +

            "-fx-text-fill: "+ fxErrorTextFill +";" +
            "-fx-unfocus-color: "  + fxErrorUnfocusColor +";" +
            "-fx-prompt-text-fill: "+ fxErrorPromptTextColor + ";"+
            "-fx-border-color:transparent transparent red transparent  ;"+

                "-fx-focus-color: " + fxFocusColor +";";
        //</editor-fold>


    static String comboBox_Style = ""+
            "-fx-font-family: "+ fxFontFamily +";" +
            "-fx-style:"+ fxStyle + ";" +
            "-fx-font-size:"+ fxFontSize +";"+
            "-fx-base:" + fxBase + ";"+
            "-fx-unfocus-color:"+ fxUnfocusColor + ";" +
            "-fx-focus-color: " + fxFocusColor +";"+
            "-fx-text-fill: "+ fxTextFill +";" +
          //"-fx-prompt-text-fill: "+ fxPromptTextColor + ";"+
            "-fx-border-color: transparent transparent transparent transparent"+";";


    static String datePicker_Style_Font = "" +
            "-fx-font-family: " + fxFontFamily + ";" +
            "-fx-style:" + fxStyle + ";" +
            "-fx-font-size:" + fxFontSize + ";";
    static String datePicker_Style = ""+
                "-fx-base:" + fxBase + ";"+
                "-fx-unfocus-color: "  + fxUnfocusColor + ";" +
                "-fx-focus-color: " + fxFocusColor +";"+
                "-fx-text-fill: "+ fxTextFill +";" +
                "-fx-font-family: "+ fxFontFamily +";" +
                "-fx-style:"+ fxStyle + ";" +
                "-fx-font-size:"+ fxFontSize +";" +
                "-fx-border-color: transparent transparent transparent transparent"+";";
                //"-fx-prompt-text-fill: "+ fxPromptTextColor + ";";

    static String datePicker_Style_err = ""+
                "-fx-base:" + fxBase + ";"+
                "-fx-unfocus-color: "  + fxErrorUnfocusColor +";" +
                "-fx-focus-color: " + fxFocusColor +";"+
                "-fx-text-fill: "+ fxTextFill +";" +
                "-fx-font-family: "+ fxFontFamily +";" +
                "-fx-style:"+ fxStyle + ";" +
                "-fx-font-size:"+ fxFontSize +";";


    public static String getFormatbutton() {
        return formatbutton;
    }


    public static String getTextField_Style() {
        return textField_Style;
    }

    public static String getTextField_Style_err() {
        return textField_Style_err;
    }


    public static String getComboBox_Style() {
        return comboBox_Style;
    }

    public static String getDatePicker_Style_Font() {
        return datePicker_Style_Font;
    }

    public static String getDatePicker_Style() {
        return datePicker_Style;
    }

    public static String getDatePicker_Style_err() {
        return datePicker_Style_err;
    }
}
