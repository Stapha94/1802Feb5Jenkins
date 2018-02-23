package com.revature.dao;

import com.revature.beans.Result;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultDaoJdbcPg implements ResultDao {

    private static ConnectionUtil connectionUtil = ConnectionUtil.getConnectionUtil();

    /**
     * Searches the Database for the given Result ID
     * @param resultId The Result ID to search the Database for.
     * @return The Result object that was found in the Database, or null if nothing is found or an error occurs.
     */
    @Override
    public Result getById(int resultId) {

        try(Connection conn = connectionUtil.getConnection()){

            PreparedStatement ps;
            String query = "SELECT * FROM results WHERE result_id = ?;";
            ps = conn.prepareStatement(query);
            ps.setInt(1, resultId);
            ResultSet rs = ps.executeQuery();

            ps.close();

            if(rs.next()){

                int formId = rs.getInt("form");
                float grade = rs.getFloat("grade");
                return new Result(resultId, formId, grade);

            }
            return null;


        } catch (SQLException e){

            System.out.println("Failed to find Result by ID");
            e.printStackTrace();
            return null;

        }

    }

    /**
     * Creates a new Result in the database from the given Result
     * @param result The Result to be created.
     */
    @Override
    public void newResult(Result result) {

        try(Connection conn = connectionUtil.getConnection()){

            PreparedStatement ps;
            String query = "INSERT INTO results (form, grade) VALUES (?, ?) RETURNING result_id";
            ps = conn.prepareStatement(query);
            ps.setInt(1, result.getFormId());
            ps.setFloat(2, result.getGrade());
            ResultSet rs = ps.executeQuery();

            ps.close();

            if(rs.next())
                result.setResultId(rs.getInt("result_id"));


        } catch (SQLException e){

            System.out.println("Failed to create new Result");
            e.printStackTrace();

        }

    }

    /**
     * Updates the given Result in the Database.
     * @param result The Result to be updated.
     */
    @Override
    public void updateResult(Result result) {

        try(Connection conn = connectionUtil.getConnection()){

            PreparedStatement ps;
            String query = "UPDATE results SET form = ?, grade = ? WHERE result_id = ?;";
            ps = conn.prepareStatement(query);
            ps.setInt(1, result.getFormId());
            ps.setFloat(2, result.getGrade());
            ps.setInt(3, result.getResultId());
            ps.execute();

            ps.close();


        } catch (SQLException e){

            System.out.println("Failed to update Result");
            e.printStackTrace();

        }

    }

    /**
     * Deletes the given Result from the Database
     * @param result The Result to be deleted.
     */
    @Override
    public void deleteResult(Result result) {

        Connection conn = connectionUtil.getConnection();

        try{

            conn.setAutoCommit(false);

            PreparedStatement ps;
            String query = "DELETE FROM results WHERE result_id = ?;";
            ps = conn.prepareStatement(query);
            ps.setInt(1, result.getResultId());
            ps.execute();

            conn.commit();
            ps.close();


        } catch (SQLException e){

            System.out.println("Failed to delete Result");
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
