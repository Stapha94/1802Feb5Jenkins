package com.revature.tree.dao;

import com.revature.tree.beans.Form;
import com.revature.tree.util.ConnectionUtil;

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
                boolean approvedBySupervisor = rs.getBoolean("approved_by_supervisor");
                boolean approvedByDeptHead = rs.getBoolean("approved_by_dept_head");
                boolean approvedByBenco = rs.getBoolean("approved_by_benco");
                float projectedReimbursement = rs.getFloat("projected_reimbursement");
                Form myForm = new Form(formId, date, time, location, description, cost, eventType, gradingFormat, missedTime, attachments, approvalMsg, approvedBySupervisor, approvedByDeptHead, approvedByBenco, projectedReimbursement, employeeId);

                return myForm;
            }
            return null;

        } catch (SQLException e){

            System.out.println("Failed to find Form by ID");
            e.printStackTrace();
            return null;

        }

    }

    public Form getByEmployeeId(int employeeId){

        try(Connection conn = connectionUtil.getConnection()){

            PreparedStatement ps;
            String query = "SELECT * FROM forms "
                    + "JOIN employees ON forms.employee = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, employeeId);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                int formId = rs.getInt("form_id");
                String date = rs.getString("date");
                String time = rs.getString("time");
                String location = rs.getString("location");
                String description = rs.getString("description");
                float cost = rs.getFloat("cost");
                String eventType = rs.getString("event_type");
                String gradingFormat = rs.getString("grading_format");
                String missedTime = rs.getString("missed_time");
                String attachments = rs.getString("attachments");
                String approvalMsg = rs.getString("approval_msg");
                boolean approvedBySupervisor = rs.getBoolean("approved_by_supervisor");
                boolean approvedByDeptHead = rs.getBoolean("approved_by_dept_head");
                boolean approvedByBenco = rs.getBoolean("approved_by_benco");
                float projectedReimbursement = rs.getFloat("projected_reimbursement");
                Form myForm = new Form(formId, date, time, location, description, cost, eventType, gradingFormat, missedTime, attachments, approvalMsg, approvedBySupervisor, approvedByDeptHead, approvedByBenco, projectedReimbursement, employeeId);

                return myForm;

            }
            return null;

        } catch (SQLException e){

            System.out.println("Could not find Form by Employee ID");
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
            String query = "INSERT INTO forms (date, time, location, description, cost, event_type, grading_format, missed_time, attachments, approval_msg, approved_by_supervisoe, approved_by_dept_head, approved_by_benco, projected_reimbursement, employee) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ?) RETURNING form_id;";
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
            ps.setBoolean(11, form.isApprovedBySupervisor());
            ps.setBoolean(12, form.isApprovedByDeptHead());
            ps.setBoolean(13, form.isApprovedByBenco());
            ps.setFloat(14, form.getProjectedReimbursement());
            ps.setInt(15, form.getEmployeeId());
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
            String query = "UPDATE forms SET date = ?, time = ?, location = ?, description = ?, cost = ?, event_type = ?, grading_format = ?, missed_time = ?, attachments = ? approval_msg = ?, approved_by_supervisor = ?, approved_by_dept_head = ?, approved_by_benco = ?, projected_reimbursement = ? WHERE employee = ?;";
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
            ps.setBoolean(11, form.isApprovedBySupervisor());
            ps.setBoolean(12, form.isApprovedByDeptHead());
            ps.setBoolean(13, form.isApprovedByBenco());
            ps.setFloat(14, form.getProjectedReimbursement());
            ps.setInt(15, form.getEmployeeId());

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
