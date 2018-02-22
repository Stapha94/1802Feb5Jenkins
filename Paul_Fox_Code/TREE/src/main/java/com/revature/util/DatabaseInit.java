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
                    + "ssn VARCHAR(11), "
                    + "supervisor INTEGER REFERENCES employees(employee_id));";
            ps = conn.prepareStatement(query);
            ps.execute();

            query = "CREATE TABLE IF NOT EXISTS departments( "
                    + "department_id SERIAL PRIMARY KEY, "
                    + "department_name VARCHAR(40), "
                    + "department_head INTEGER REFERENCES employees(employee_id));";
            ps = conn.prepareStatement(query);
            ps.execute();

            query = "CREATE TABLE IF NOT EXISTS reimbursements( "
                    + "reimbursement_id SERIAL PRIMARY KEY, "
                    + "reimbursement_total FLOAT, "
                    + "reimbursement_used FLOAT, "
                    + "reimbursement_remainder FLOAT, "
                    + "employee INTEGER REFERENCES employees(employee_id));";
            ps = conn.prepareStatement(query);
            ps.execute();

            query = "CREATE TABLE IF NOT EXISTS forms( "
                    + "form_id SERIAL PRIMARY KEY, "
                    + "date VARCHAR(30), "
                    + "time VARCHAR(50), "
                    + "location VARCHAR(100), "
                    + "description TEXT, "
                    + "cost FLOAT, "
                    + "event_type VARCHAR(100), "
                    + "grading_format VARCHAR(50), "
                    + "missed_time VARCHAR(50), "
                    + "attachments VARCHAR(255), "
                    + "approval_msg VARCHAR(255), "
                    + "projected_reimbursement FLOAT, "
                    + "employee INTEGER REFERENCES employees(employee_id));";
            ps = conn.prepareStatement(query);
            ps.execute();

            query = "CREATE TABLE IF NOT EXISTS results( "
                    + "result_id SERIAL PRIMARY KEY, "
                    + "form INTEGER REFERENCES forms(form_id), "
                    + "grade FLOAT);";
            ps = conn.prepareStatement(query);
            ps.execute();

            query = "ALTER TABLE employees "
                    + "ADD department INTEGER REFERENCES departments(department_id);";
            ps = conn.prepareStatement(query);
            ps.execute();

            ps.close();

        } catch (SQLException e){

            System.out.println("Database Failed to Create");
            e.printStackTrace();

        }

    }

}
