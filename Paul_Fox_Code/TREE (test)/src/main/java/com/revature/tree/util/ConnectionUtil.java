package com.revature.tree.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

    private static ConnectionUtil connectionUtil = new ConnectionUtil();

    private ConnectionUtil(){

        super();

    }

    public static ConnectionUtil getConnectionUtil(){

        return connectionUtil;

    }

    public Connection getConnection(){

        try{

            Properties myProperties = new Properties();
            myProperties.load(new FileReader("src/main/resources/jdbc.txt"));
            return DriverManager.getConnection(myProperties.getProperty("url"), myProperties.getProperty("user"), myProperties.getProperty("password"));

        } catch (SQLException e){

            e.printStackTrace();
            return null;

        } catch (IOException e){

            e.printStackTrace();
            return null;

        }

    }

}
