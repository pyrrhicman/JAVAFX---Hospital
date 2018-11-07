package sample;

    //<editor-fold desc="#### >>>>>> IMPORTS <<<<<<< #####">
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import loginpackage.dbUtil.DatabaseConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
//</editor-fold>


public class DatabaseClass implements Initializable {
    private Connection connection;
    private ObservableList<Patient> data;


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


    public boolean patientSearch(String lastname, String socialID) throws Exception {
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


    public List<String> getDatabasesList() {
        List<String> databaseList = new ArrayList<String>();

        try {
            connection = DatabaseConnection.getConnection();
            this.data = FXCollections.observableArrayList();

            assert connection != null;
            ResultSet resultSet = connection.createStatement().executeQuery("show databases;");
            while (resultSet.next()) {
                String string = resultSet.getString(1);
                databaseList.add(string);
            }
            connection.close();
        } catch (SQLException | NullPointerException ex) {
            ex.printStackTrace();
        }
        return databaseList;
    }


    public List<String> getTablesList(String nameOfDatabase) {
        List<String> tableList = new ArrayList<>();
        List<String> databaseList = getDatabasesList();
        if (!(databaseList.contains(nameOfDatabase))) {
            throw new NoSuchElementException("Selected Database Not found");
        } else {

        try {
            connection = DatabaseConnection.getConnection();
            this.data = FXCollections.observableArrayList();

            assert connection != null;
            connection.createStatement().executeQuery("use " + nameOfDatabase + ";");

            ResultSet resultSet = connection.createStatement().executeQuery("show tables ;");
            while (resultSet.next()) {
                String string = resultSet.getString(1);
                tableList.add(string);
            }
            connection.close();
        } catch (SQLException | NullPointerException ex) {
            ex.printStackTrace();
        }
            return tableList;
        }

    }


    public boolean tableExistenceCheck(String nameOftable) {

        return true;
    }







    public void addNewPatient(Patient patient) {


        System.out.println("Importing new Data...");
        String sqlnewPatientInsert = "INSERT INTO "+ DatabaseConnection.getMysqlTableName() +  "(" +
                "firstname," +
                "lastname," +
                "socialID," +
                "sex," +
                "age," +
                "birthday," +
                "dateofregistration," +
                "phonenumber," +
                "city," +
                "address," +
                "postalcode) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        System.out.println("utilDate:" + utilDate);
        System.out.println("sqlDate:" + sqlDate);
        try {
            Connection connection = DatabaseConnection.getConnection();
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sqlnewPatientInsert);
            preparedStatement.setString(1, patient.getFirstname());
            preparedStatement.setString(2, patient.getLastname());
            preparedStatement.setString(3, patient.getSocialid());
            preparedStatement.setString(4, patient.getGender());
            preparedStatement.setString(5, patient.getAge());
            //preparedStatement.setDate(6, java.sql.Date.valueOf(patient.getBirthday()));
            //preparedStatement.setDate(7, java.sql.Date.valueOf(patient.getDateofregistration()));
            preparedStatement.setString(6, patient.getBirthday().toString());
            preparedStatement.setString(7, patient.getDateofregistration().toString());
            preparedStatement.setString(8, patient.getPhonenumber());
            preparedStatement.setString(9, patient.getCity());
            preparedStatement.setString(10, patient.getAddress());
            preparedStatement.setString(11, patient.getPostalcode());
            preparedStatement.execute();
            connection.close();
            connection.close();

        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }

        System.out.println("End of Importing new Data.");
    }








    public ObservableList<Patient> loadAllPatientList() {
        System.out.println("retrieving data from server...");
        String TABLE_SELECT = "SELECT * FROM " + DatabaseConnection.getMysqlTableName(); //Table Name

        try {
            Connection connection = DatabaseConnection.getConnection();
            this.data = FXCollections.observableArrayList();

            assert connection != null;
            ResultSet resultSet = connection.createStatement().executeQuery(TABLE_SELECT);

            while (resultSet.next()) {
                this.data.add(
                        new Patient(
                                resultSet.getString(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getString(5),
                                //resultSet.getDate(6).toLocalDate(),
                                //resultSet.getDate(7).toLocalDate(),
                                resultSet.getString(6),
                                resultSet.getString(7),
                                resultSet.getString(8),
                                resultSet.getString(9),
                                resultSet.getString(10),
                                resultSet.getString(11)));
            }
            System.out.println("End of retrieving data from server.");
            return this.data;
        } catch (SQLException | NullPointerException ex) {
            ex.printStackTrace();
        }
        System.out.println("End of retrieving data from server with error.");
        return this.data;
    }

}


