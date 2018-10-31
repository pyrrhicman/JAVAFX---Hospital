package loginpackage.dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String MYSQL_GOOGLE_SERVER_NAME = " ";
    private static final String MYSQL_GOOGLE_DATABASE_NAME = "patientlist";
    private static final String MYSQL_GOOGLE_PRIMARY_IP_ADDRESS = "35.228.119.107";
    private static final String MYSQL_GOOGLE_INSTANCE_CONN_NAME = "second-jet-216010:europe-north1:mhdaska";
    private static final String MYSQL_GOOGLE_USERNAME = "root";
    private static final String MYSQL_GOOGLE_PASSWORD = "Hashem741";
    private static final String MYSQL_GOOGLE_MINE = "jdbc:mysql://" + MYSQL_GOOGLE_PRIMARY_IP_ADDRESS + "/" + MYSQL_GOOGLE_DATABASE_NAME + "?useSSL=false";

    private static final String MYSQL_LOCAL_DATABASE_NAME = "mypatientlist";
    private static final String MYSQL_LOCAL_USERNAME = "root";
    private static final String MYSQL_LOCAL_PASSWORD = "Hashem741";
    private static final String MYSQL_LOCAL_CONNECTION = "jdbc:mysql://localhost:3306/" + MYSQL_LOCAL_DATABASE_NAME + "?autoReconnect=true&useSSL=false";

    private static final String SQLITE_DATABASE_NAME = "Patientlist";
    private static final String SQLITE_DATABASE_CONNECTION = "jdbc:sqlite:" + SQLITE_DATABASE_NAME + ".sqlite";

    public static Connection getConnection() throws SQLException {

        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("org.sqlite.JDBC");

            //return DriverManager.getConnection(SQLITE_DATABASE_CONNECTION); //Local Sqlite Database
            //return DriverManager.getConnection(MYSQL_LOCAL_CONNECTION, MYSQL_LOCAL_USERNAME, MYSQL_LOCAL_PASSWORD); //Local MYSQL Server
            return DriverManager.getConnection(MYSQL_GOOGLE_MINE, MYSQL_GOOGLE_USERNAME, MYSQL_GOOGLE_PASSWORD); ////GCP MYSQL SERVER

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
