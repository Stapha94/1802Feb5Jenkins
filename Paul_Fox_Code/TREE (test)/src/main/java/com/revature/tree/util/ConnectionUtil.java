package com.revature.tree.util;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

    private static ConnectionUtil connectionUtil = new ConnectionUtil();

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private ConnectionUtil(){

        super();

    }

    public static ConnectionUtil getConnectionUtil(){

        return connectionUtil;

    }

    public Connection getConnection(){

        try{

            Properties myProperties = new Properties();
            //myProperties.load(new FileReader("src/main/resources/jdbc.txt"));
            InputStream in = this.getClass().getClassLoader().getResourceAsStream("jdbc.txt");
            if(in != null)
                myProperties.load(in);
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
