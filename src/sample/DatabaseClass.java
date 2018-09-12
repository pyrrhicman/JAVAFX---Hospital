package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import loginpackage.dbUtil.DatabaseConnection;
import newPatientPagePackage.Newpatient;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DatabaseClass implements Initializable {
    Connection connection;
    ObservableList<Patient> data;
    private String patientsql = "SELECT * FROM PatientList";

    public DatabaseClass() {    // Constructor Part

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            this.connection = DatabaseConnection.getConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (this.connection == null) {
            System.exit(1);
        }
    }

    public boolean isDataBaseConnected() {
        return this.connection != null;
    }


    public boolean patientSearch(
            String lastname,
            String socialID) throws Exception {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM PatientList where lastname = ? and socialid = ? ";

        try {
            preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, lastname);
            preparedStatement.setString(2, socialID);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            preparedStatement.close();
            resultSet.close();
        }

    }

    public boolean addNewPatient(
            String firstname,
            String lastname,
            String socialID,
            String sex,
            String dateofbirth,
            String dateofregistration,
            String phonenumber,
            String city,
            String address,
            String postalcode) {

        String sqlnewPatientInsert = "INSERT INTO PatientList(firstname,lastname,socialID,sex,dateofbirth,dateofregistration,phonenumber,city,address,postalcode) VALUES(?,?,?,?,?,?,?,?,?,?)";

        try {
            Connection connection = DatabaseConnection.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sqlnewPatientInsert);
            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, socialID);
            preparedStatement.setString(4, sex);
            preparedStatement.setString(5, dateofbirth);
            preparedStatement.setString(6, dateofregistration);
            preparedStatement.setString(7, phonenumber);
            preparedStatement.setString(8, city);
            preparedStatement.setString(9, address);
            preparedStatement.setString(10, postalcode);
            preparedStatement.execute();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public void loadPatientList() {
        try {
            Connection connection = DatabaseConnection.getConnection();
            this.data = FXCollections.observableArrayList();
            ResultSet resultSet = connection.createStatement().executeQuery(patientsql);

            while (resultSet.next()) {
                String rs10String = resultSet.getString(10);
                String rs9String = resultSet.getString(9);
                String rs8String = resultSet.getString(8);
                String rs7String = resultSet.getString(7);
                String rs6String = resultSet.getString(6);
                String rs5String = resultSet.getString(5);
                String rs4String = resultSet.getString(4);
                String rs3String = resultSet.getString(3);
                String rs2String = resultSet.getString(2);
                String rs1String = resultSet.getString(1);
                Controller.getNewPatientAndSaveIt(new Patient(rs1String,rs2String,rs3String,rs4String,rs5String,rs6String,rs7String,rs8String,rs9String,rs10String));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }











    }


}


