package com.revature.tree.dao;

import com.revature.tree.beans.Reimbursement;
import com.revature.tree.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReimbursementDaoJdbcPg implements ReimbursementDao {

    private static ConnectionUtil connectionUtil = ConnectionUtil.getConnectionUtil();

    /**
     * Searches the Database for a Reimbursement by the given Reimbursement ID.
     * @param reimbursementId The Reimbursement ID to search the Database for
     * @return Returns the Reimbursement Object that is found in the database, or null if nothing is found or an error occurs.
     */
    @Override
    public Reimbursement getById(int reimbursementId) {

        try(Connection conn = connectionUtil.getConnection()){

            PreparedStatement ps;
            String query = "SELECT * FROM reimbursements WHERE reimbursement_id = ?;";
            ps = conn.prepareStatement(query);
            ps.setInt(1, reimbursementId);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                float rTotal = rs.getFloat("reimbursement_total");
                float rUsed = rs.getFloat("reimbursement_used");
                float rRemainder = rs.getFloat("reimbursement_remainder");
                int employeeId = rs.getInt("employee");
                return new Reimbursement(reimbursementId, rTotal, rUsed, rRemainder, employeeId);

            }
            return null;

        } catch (SQLException e){

            System.out.println("Failed to find Reimbursement by ID");
            e.printStackTrace();
            return null;

        }

    }

    /**
     * Searches the Database for a Reimbursement that is tied to a specific Employee ID.
     * @param employeeId The Employee ID to searche the database for a Reimbursement for.
     * @return Returns the Reimbursement Object found, or null if nothing was found or an error occurred.
     */
    @Override
    public Reimbursement getByEmployee(int employeeId){

        try(Connection conn = connectionUtil.getConnection()){

            PreparedStatement ps;
            String query = "SELECT reimbursement_id, reimbursement_total, reimbursement_used, reimbursement_remainder FROM reimbursements "
                    + "JOIN employees ON reimbursements.employee = ?;";
            ps = conn.prepareStatement(query);
            ps.setInt(1, employeeId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){

                int rId = rs.getInt("reimbursement_id");
                float rTotal = rs.getFloat("reimbursement_total");
                float rUsed = rs.getFloat("reimbursement_used");
                float rRemainder = rs.getFloat("reimbursement_remainder");
                return new Reimbursement(rId, rTotal, rUsed, rRemainder, employeeId);

            }
            return null;


        } catch (SQLException e){

            System.out.println("Failed to find Reimbursement by Employee ID");
            e.printStackTrace();
            return null;

        }

    }

    /**
     * Creates a new Reimbursement in the Database from the given Reimbursement Object.
     * @param reimbursement The Reimbursement to be created.
     */
    @Override
    public void newReimbursement(Reimbursement reimbursement) {

        try(Connection conn = connectionUtil.getConnection()){

            PreparedStatement ps;
            String query = "INSERT INTO reimbursements (reimbursement_total, reimbursement_used, reimbursement_remainder, employee_id) VALUES (?, ?, ?, ?) RETURNING reimbursement_id;";
            ps = conn.prepareStatement(query);
            ps.setFloat(1, reimbursement.getReimbursementTotal());
            ps.setFloat(2, reimbursement.getReimbursementUsed());
            ps.setFloat(3, reimbursement.getReimbursementRemainder());
            ps.setInt(4, reimbursement.getEmployeeId());
            ResultSet rs = ps.executeQuery();

            ps.close();

            if(rs.next())
                reimbursement.setReimbursementId(rs.getInt("reimbursement_id"));

        } catch (SQLException e){

            System.out.println("Failed to create new Reimbursement");
            e.printStackTrace();

        }

    }

    /**
     * Updates the given Reimbursement in the Database.
     * @param reimbursement The Reimbursement to be updated.
     */
    @Override
    public void updateReimbursement(Reimbursement reimbursement) {

        try(Connection conn = connectionUtil.getConnection()){

            PreparedStatement ps;
            String query = "UPDATE reimbursements SET reimbursement_total = ?, reimbursement_used = ?, reimbursement_remainder = ? WHERE reimbursement_id = ?;";
            ps = conn.prepareStatement(query);
            ps.setFloat(1, reimbursement.getReimbursementTotal());
            ps.setFloat(2, reimbursement.getReimbursementRemainder());
            ps.setFloat(3, reimbursement.getReimbursementRemainder());
            ps.setInt(4, reimbursement.getReimbursementId());
            ps.execute();

            ps.close();

        } catch (SQLException e){

            System.out.println("Failed to update Reimbursement");
            e.printStackTrace();

        }

    }

    /**
     * Deletes the given Reimbursement from the Database.
     * @param reimbursement The Reimbursement to be deleted
     */
    @Override
    public void deleteReimbursement(Reimbursement reimbursement) {

        Connection conn = connectionUtil.getConnection();

        try{

            conn.setAutoCommit(false);

            PreparedStatement ps;
            String query = "DELETE FROM reimbursements WHERE reimbursement_id = ?;";
            ps = conn.prepareStatement(query);
            ps.setInt(1, reimbursement.getReimbursementId());
            ps.execute();

            ps.close();

            conn.commit();


        } catch(SQLException e){

            System.out.println("Failed to delete Reimbursement");
            e.printStackTrace();

            try{

                conn.rollback();

            } catch(SQLException j){

                System.out.println("Failed to rollback Database");
                j.printStackTrace();

            }

        }

    }
}
