package com.ex;

import com.ex.connector.H2Connector;
import com.ex.connector.properties.Configuration;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtils {

    private static H2Connector connector = H2Connector.CONNECTOR;

    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection newConnection() throws SQLException {
        Properties props = connector.getProperties();
        return DriverManager.getConnection(props.getProperty("url"));
    }
}
