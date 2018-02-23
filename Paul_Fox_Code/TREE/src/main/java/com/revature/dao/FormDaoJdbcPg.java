package com.revature.dao;

import com.revature.beans.Form;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FormDaoJdbcPg implements FormDao {

    private static ConnectionUtil connectionUtil = ConnectionUtil.getConnectionUtil();

    /**
     * Find a form by the given Form ID.
     * @param formId The Form ID to search the database for.
     * @return Returns the Form found in the database by the ID, or null if none were found or an error occurred.
     */
    @Override
    public Form getById(int formId) {

        try(Connection conn = connectionUtil.getConnection()){

            PreparedStatement ps;
            String query = "SELECT * FROM forms WHERE form_id = ?;";
            ps = conn.prepareStatement(query);
            ps.setInt(1, formId);
            ResultSet rs = ps.executeQuery();

            ps.close();

            if(rs.next()){

                String date = rs.getString("date");
                String time = rs.getString("time");
                String location = rs.getString("location");
                String description = rs.getString("description");
                float cost = rs.getFloat("cost");
                String eventType = rs.getString("event_type");
                String gradingFormat = rs.getString("grading_format");
                int employeeId = rs.getInt("employee");
                String missedTime = rs.getString("missed_time");
                String attachments = rs.getString("attachments");
                String approvalMsg = rs.getString("approval_msg");
                float projectedReimbursement = rs.getFloat("projected_reimbursement");
                Form myForm = new Form(formId, date, time, location, description, cost, eventType, gradingFormat, employeeId);

                if(missedTime != null)
                    myForm.setMissedTime(missedTime);
                else if(attachments != null)
                    myForm.setAttachments(attachments);
                else if(approvalMsg != null)
                    myForm.setApprovalMsg(approvalMsg);
                else if(projectedReimbursement != 0.00f)
                    myForm.setProjectedReimbursement(projectedReimbursement);

                return myForm;
            }
            return null;

        } catch (SQLException e){

            System.out.println("Failed to find Form by ID");
            e.printStackTrace();
            return null;

        }

    }

    /**
     * Creates a new Form in the database and sets the object form's ID variable.
     * @param form The Form to create in the Database.
     */
    @Override
    public void newForm(Form form) {

        try(Connection conn = connectionUtil.getConnection()){

            PreparedStatement ps;
            String query = "INSERT INTO forms (date, time, location, description, cost, event_type, grading_format, missed_time, attachments, approval_msg, projected_reimbursement, employee) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            ps = conn.prepareStatement(query);
            ps.setString(1, form.getDate());
            ps.setString(2, form.getTime());
            ps.setString(3, form.getLocation());
            ps.setString(4, form.getDescription());
            ps.setFloat(5, form.getCost());
            ps.setString(6, form.getEventType());
            ps.setString(7, form.getGradingFormat());
            ps.setString(8, form.getMissedTime());
            ps.setString(9, form.getAttachments());
            ps.setString(10, form.getApprovalMsg());
            ps.setFloat(11, form.getProjectedReimbursement());
            ps.setInt(12, form.getEmployeeId());
            ResultSet rs = ps.executeQuery();

            ps.close();

            if(rs.next())
                form.setFormId(rs.getInt("form_id"));

        } catch (SQLException e){

            System.out.println("Failed to create new Form");
            e.printStackTrace();

        }

    }

    /**
     * Updates the given Form in the Database.
     * @param form The form to update.
     */
    @Override
    public void updateForm(Form form) {

        try(Connection conn = connectionUtil.getConnection()){

            PreparedStatement ps;
            String query = "UPDATE forms SET date = ?, time = ?, location = ?, description = ?, cost = ?, event_type = ?, grading_format = ?, missed_time = ?, attachments = ? approval_msg = ?, projected_reimbursement = ? WHERE employee = ?;";
            ps = conn.prepareStatement(query);
            ps.setString(1, form.getDate());
            ps.setString(2, form.getTime());
            ps.setString(3, form.getLocation());
            ps.setString(4, form.getDescription());
            ps.setFloat(5, form.getCost());
            ps.setString(6, form.getEventType());
            ps.setString(7, form.getGradingFormat());
            ps.setString(8, form.getMissedTime());
            ps.setString(9, form.getAttachments());
            ps.setString(10, form.getApprovalMsg());
            ps.setFloat(11, form.getProjectedReimbursement());
            ps.setInt(12, form.getEmployeeId());

            ps.execute();

            ps.close();

        } catch (SQLException e){

            System.out.println("Failed to update Form");
            e.printStackTrace();

        }

    }

    /**
     * Deletes a given Form from the Database.
     * @param form The Form to delete from the Database.
     */
    @Override
    public void deleteForm(Form form) {

        Connection conn = connectionUtil.getConnection();

        try{

            conn.setAutoCommit(false);
            PreparedStatement ps;
            String query = "DELETE FROM forms WHERE form_id = ?;";
            ps = conn.prepareStatement(query);
            ps.setInt(1, form.getFormId());
            ps.execute();

            ps.close();

            conn.commit();


        } catch (SQLException e){

            System.out.println("Failed to delete Form");
            e.printStackTrace();

            try{

                conn.rollback();

            } catch (SQLException j){

                System.out.println("Failed to rollback Database");
                j.printStackTrace();

            }

        }

    }

}
