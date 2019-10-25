package edu.javaproject.cityregister.dao;

import edu.javaproject.cityregister.config.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/***
 * That class build database connection (PostgreSQL).
 */
public interface ConnectionBuilder {
    public Connection getConnection() throws SQLException, ClassNotFoundException;
}
