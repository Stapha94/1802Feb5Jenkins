package com.revature.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseInit {

    private static ConnectionUtil connectionUtil = ConnectionUtil.getConnectionUtil();

    public static void init(){

        try(Connection conn = connectionUtil.getConnection()){

            PreparedStatement ps;
            String query = "CREATE TABLE IF NOT EXISTS employees( "
                    + "employee_id SERIAL PRIMARY KEY, "
                    + "first_name VARCHAR(40), "
                    + "last_name VARCHAR(40), "
                    + "ssn VARCHAR(11), " +
                    + "supervisor_id INTEGER REFERENCES employees(employee_id), "
                    + "form_id INTEGER REFERENCES forms(form_id);";
            ps = conn.prepareStatement(query);


        } catch (SQLException e){

            System.out.println("Database Failed to Create");
            e.printStackTrace();

        }

    }

}
