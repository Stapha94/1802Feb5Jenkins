package com.revature.dao;

import com.revature.beans.Reimbursement;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReimbursementDaoJdbcPg implements ReimbursementDao {

    private static ConnectionUtil connectionUtil = ConnectionUtil.getConnectionUtil();

    @Override
    public Reimbursement getById(int reimbursementId) {

        try(Connection conn = connectionUtil.getConnection()){

            PreparedStatement ps;
            String query = "SELECT * FROM reimbursements WHERE reimbursement_id = ?;";
            ps = conn.prepareStatement(query);
            ps.setInt(1, reimbursementId);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                int employeeId = rs.getInt("employee");
                return new Reimbursement(reimbursementId, employeeId);

            }
            return null;

        } catch (SQLException e){

            System.out.println("Failed to find Reimbursement by ID");
            e.printStackTrace();
            return null;

        }

    }

    @Override
    public void newReimbursement(Reimbursement reimbursement) {

        try(Connection conn = connectionUtil.getConnection()){

            PreparedStatement ps;
            String query = "INSERT INTO reimbursements (employee_id) VALUES (?) RETURNING reimbursement_id;";
            ps = conn.prepareStatement(query);
            ps.setInt(1, reimbursement.getEmployeeId());
            ResultSet rs = ps.executeQuery();

            ps.close();

            if(rs.next())
                reimbursement.setReimbursementId(rs.getInt("reimbursement_id"));

        } catch (SQLException e){

            System.out.println("Failed to create new Reimbursement");
            e.printStackTrace();

        }

    }

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
