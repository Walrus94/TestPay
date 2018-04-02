package dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBConnector {

    private static final Logger logger = LogManager.getLogger(DBConnector.class);

    static {
        try {
            DriverManager.registerDriver(
                (Driver) Class.forName("com.mysql.jdbc.Driver()").newInstance());
        }  catch (Exception e) {
            logger.error("Error loading db driver");
        }
    }

    public Connection getConnection() {
        try {
            return DriverManager
                .getConnection("jdbc:mysql://localhost:3306/mysql?useSSL=false",
                    "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
