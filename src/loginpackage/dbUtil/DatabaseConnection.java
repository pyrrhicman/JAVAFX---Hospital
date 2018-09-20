package loginpackage.dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String SERVER_NAME = " ";
    private static final String MYSQL_GOOGLE_DATABASE_NAME = "patientlist";
    private static final String MYSQL_GOOGLE_PRIMARY_IP_ADDRESS = "35.228.119.107";
    private static final String MYSQL_GOOGLE_INSTANCE_CONN_NAME = "second-jet-216010:europe-north1:mhdaska";
    private static final String MYSQL_GOOGLE_USERNAME = "root";
    private static final String MYSQL_GOOGLE_PASSWORD = "Hashem741";
    private static final String MYSQL_GOOGLE_MINE = "jdbc:mysql://" + MYSQL_GOOGLE_PRIMARY_IP_ADDRESS + "/" + MYSQL_GOOGLE_DATABASE_NAME + "?useSSL=false";

    private static final String MYSQL_LOCAL_DATABASE_NAME = "patientlist";
    private static final String MYSQLUSERNAME = "root";
    private static final String MYSQLPASSWORD = "Hashem741";
    private static final String MYSQLCONN = "jdbc:mysql://localhost:3306/" + MYSQL_LOCAL_DATABASE_NAME + "?autoReconnect=true&useSSL=false";

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Class.forName("org.sqlite.JDBC");

            //return DriverManager.getConnection(SQCONN); //Local Sqlite Database
            //return DriverManager.getConnection(MYSQLCONN, MYSQLUSERNAME, MYSQLPASSWORD); //Local MYSQL Server
            return DriverManager.getConnection(MYSQL_GOOGLE_MINE, MYSQL_GOOGLE_USERNAME, MYSQL_GOOGLE_PASSWORD); ////GCP MYSQL SERVER

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static Connection mysql_LOCAL_SERVER_Connection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(MYSQLCONN, MYSQLUSERNAME, MYSQLPASSWORD); //Local MYSQL Server
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public static Connection get_GCP_MYSQL_Connection() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(MYSQL_GOOGLE_MINE, MYSQL_GOOGLE_USERNAME, MYSQL_GOOGLE_PASSWORD); ////GCP MYSQL SERVER
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace(); }return null; }

    public static Connection sqlite_LOCAL_DATABASE_Connection(String database_name) throws SQLException {
         final String SQCONN = "jdbc:sqlite:" + database_name + ".sqlite";
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(SQCONN); //Local Sqlite Database
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
