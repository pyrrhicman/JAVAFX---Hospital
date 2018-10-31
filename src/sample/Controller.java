package sample;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.w3c.dom.Element;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.ElementType;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    //<editor-fold desc="#### >>>>>> FXML ELEMENTS <<<<<<< #####">
    @FXML
    public TableView<Patient> mytable;
    @FXML
    private TableColumn<Patient, String> lastname;//Full name
    @FXML
    private TableColumn<Patient, String> firstname;//Social Id
    @FXML
    private TableColumn<Patient, String> socialid;//sex
    @FXML
    private TableColumn<Patient, String> gender;//
    @FXML
    private TableColumn<Patient, String> age;//
    @FXML
    private TableColumn<Patient, LocalDate> birthday;
    @FXML
    private TableColumn<Patient, LocalDate> dateofregistration;
    @FXML
    private TableColumn<Patient, String> phonenumber;
    @FXML
    private TableColumn<Patient, String> city;
    @FXML
    private TableColumn<Patient, String> address;
    @FXML
    private TableColumn<Patient, String> postalcode;
    @FXML
    private JFXButton b1;
    @FXML
    private JFXButton b2;
    @FXML
    private JFXButton b3;
    @FXML
    private JFXButton b4;
    @FXML
    private Text text;
    //</editor-fold>
    private double xOffset = 0;
    private double yOffset = 0;

    TableData tableData = new TableData();
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //<editor-fold desc="#### >>>>>> set Cell Value Factory = Connecting Fields to Table Columns <<<<<<< #####">
        lastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        socialid.setCellValueFactory(new PropertyValueFactory<>("socialid"));
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        birthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        dateofregistration.setCellValueFactory(new PropertyValueFactory<>("dateofregistration"));
        phonenumber.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
        city.setCellValueFactory(new PropertyValueFactory<>("city"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));//TABLE ELEMENTS//
        postalcode.setCellValueFactory(new PropertyValueFactory<>("postalcode"));//TABLE ELEMENTS//
        //</editor-fold>
        mytable.setItems(tableData.allPatientCahceList());

        final String formatbutton = "" +
                "-fx-font-family: Segoe UI semibold; " +
                "-fx-style: Regular; " +
                "-fx-base: #AE3522; " +
                "-fx-text-fill: white; " +
                "-fx-font-size: 16";

        b1.setStyle(formatbutton);
        b2.setStyle(formatbutton);
        b3.setStyle(formatbutton);
        b4.setStyle(formatbutton);
        getDatafromDatabase();
    }
    public void newPatientButtonPressed() {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            InputStream inputStream = getClass().getResource("/newPatientPagePackage/newpatient.fxml").openStream();
            Pane pane = loader.load(inputStream);

            Scene scene = new Scene(pane);
            stage.setScene(scene);
            scene.getStylesheets().add("/css/stylesheet.css");
            stage.setTitle("New Patient");
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setResizable(true);

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
            getDatafromDatabase();


        } catch (IOException ex) { ex.printStackTrace(); }
    }

    public void deleteExistedPatient() {

        /*if (!(t3.getText().isEmpty())) {
            for (int j = tableData.allPatientCahceList().size() - 1; j >= 0; j--) {
                if (tableData.allPatientCahceList().get(j).getSocialid().equals(t3.getText())) {
                    tableData.allPatientCahceList().remove(j);
                    mytable.getItems();
                }
            }
        }*/

    }

    public void getDatafromDatabase() {
            DatabaseClass dbc = new DatabaseClass();
            if (!dbc.isDataBaseConnected()) {
                try {

                    List<String> listDB = dbc.getDatabasesList();
                    List<String> listTABLES = dbc.getTablesList("mypatientlist");
                    System.out.println("DATABASES: ");
                    for (int i = 0; i < listDB.size(); i++) {
                        System.out.println(listDB.get(i));
                    }
                    System.out.println("TABLES: ");
                    for (int i = 0; i < listTABLES.size(); i++) {
                        System.out.println(listTABLES.get(i));
                    }
                } catch (NoSuchElementException ex) {
                    System.out.println(ex.getMessage());
                }
                mytable.getItems().removeAll(tableData.allPatientCahceList());
                mytable.setItems(dbc.loadAllPatientList());



            }

    }

    public void exitButtonPressed() {
        Stage stage =(Stage)this.b3.getScene().getWindow();
        stage.close();
        System.exit(0);

    }
}














