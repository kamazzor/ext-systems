package edu.javaproject.cityregister.dao;

import edu.javaproject.cityregister.config.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/***
 * Database connection builder. Database config is specified in dao.properties
 */
public class ConnectionBuilder {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(
                Config.getProperty(Config.DB_URL),
                Config.getProperty(Config.DB_LOGIN),
                Config.getProperty(Config.DB_PASSWORD));
        return con;
    }
}
