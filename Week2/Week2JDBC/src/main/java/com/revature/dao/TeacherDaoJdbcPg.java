package com.revature.dao;

import com.revature.beans.Teacher;
import com.revature.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoJdbcPg implements TeacherDao {

    private static ConnectionUtil connectionUtil = ConnectionUtil.getConnectionUtil();

    @Override
    public Teacher getById(int id) {

        try (Connection conn = connectionUtil.getConnection()) {
            // Prepare query
            String standardQuery = "SELECT first_name, last_name, favorite_quote FROM teachers WHERE teacher_id = ?";
            PreparedStatement ps = conn.prepareStatement(standardQuery);
            ps.setInt(1, id);

            // Get result set
            ResultSet results = ps.executeQuery();

            // Process Result set
            if (results.next()) {
                String firstName = results.getString("first_name");
                String lastName = results.getString("last_name");
                String favoriteQuote = results.getString("favorite_quote");
                return new Teacher(id, firstName, lastName, favoriteQuote);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Teacher> getByName(String firstName, String lastName) {
        try(Connection conn = connectionUtil.getConnection()) {
            //Prepare query
            String query = "SELECT teacher_id, first_name, last_name, favorite_quote " +
                    " FROM teachers" +
                    " WHERE first_name = ? AND last_name = ?";
            PreparedStatement ps = conn.prepareStatement(query);

            //Assign parameters
            ps.setString(1, firstName);
            ps.setString(2, lastName);

            //Execute update
            ResultSet results = ps.executeQuery();

            List<Teacher> teachers = new ArrayList<>();

            while(results.next()) {
                String fName = results.getString("first_name");
                String lName = results.getString("last_name");
                String fQuote = results.getString("favorite_quote");
                int id = results.getInt("teacher_id");

                teachers.add(new Teacher(id, fName, lName, fQuote));
            }

            return teachers;

        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void newTeacher(Teacher teacher) {

        try(Connection conn = connectionUtil.getConnection()) {
            //Prepare query
            String query = "INSERT INTO teachers (first_name, last_name, favorite_quote) " +
                    " VALUES (?, ?, ?) RETURNING teacher_id";
            PreparedStatement ps = conn.prepareStatement(query);

            //Assign parameters
            ps.setString(1, teacher.getFirstName());
            ps.setString(2, teacher.getLastName());
            ps.setString(3, teacher.getFavoriteQuote());

            // Get result set storing the primary key for the newly inserted object
            ResultSet results = ps.executeQuery();
            if(results.next()) {
                //Assign PK to ID field
                teacher.setId(results.getInt("teacher_id"));
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Teacher teacher) {

        try(Connection conn = connectionUtil.getConnection()) {
            //Prepare query
            String query = "UPDATE teachers " +
                    "SET first_name = ?, last_name = ?, favorite_quote = ? " +
                    "WHERE teacher_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);

            //Assign parameters
            ps.setString(1, teacher.getFirstName());
            ps.setString(2, teacher.getLastName());
            ps.setString(3, teacher.getFavoriteQuote());
            ps.setInt(4, teacher.getId());

            //Execute update
            ps.execute();
        } catch(SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Teacher teacher) {
        try(Connection conn = connectionUtil.getConnection()) {
            //Prepare query
            String query = "DELETE FROM teachers WHERE teacher_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);

            //Assign parameters
            ps.setInt(1, teacher.getId());

            //Execute update
            ps.execute();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

}
