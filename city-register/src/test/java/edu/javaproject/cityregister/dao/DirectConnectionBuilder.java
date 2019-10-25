package edu.javaproject.cityregister.dao;

import edu.javaproject.cityregister.config.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/***
 * That class build database connection using Class.forName() + DriverManager
 */
public class DirectConnectionBuilder implements ConnectionBuilder {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(
                Config.getProperty(Config.DB_URL),
                Config.getProperty(Config.DB_LOGIN),
                Config.getProperty(Config.DB_PASSWORD));
        return con;
    }
}
