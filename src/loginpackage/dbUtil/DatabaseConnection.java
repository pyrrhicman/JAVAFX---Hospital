package loginpackage.dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String USERNAME = "dbuser";
    private static final String PASSWORD = "dbpassword";
    private static final String SQCONN   = "jdbc:sqlite:PatientList.sqlite";

    private static final String MYSQLUSERNAME = "root";
    private static final String MYSQLPASSWORD = "Hashem741";
    private static final String MYSQLCONN =  "jdbc:mysql://localhost:3306/mysql?autoReconnect=true&useSSL=false";

            public static Connection getConnection() throws SQLException {
                try {
                    //Class.forName("org.sqlite.JDBC");
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    //return DriverManager.getConnection(SQCONN);
                    return DriverManager.getConnection(MYSQLCONN, MYSQLUSERNAME, MYSQLPASSWORD);
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                return null;
            }


}
