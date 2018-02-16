package com.revature.dao;

import com.revature.beans.Teacher;
import com.revature.util.ConnectionUtil;

import java.sql.*;
import java.util.List;

public class TeacherDaoJdbcPg implements TeacherDao{


    private static ConnectionUtil connectionUtil = ConnectionUtil.getConnectionUtil();

    @Override
    public Teacher getByID(int id) {

        try(Connection conn = connectionUtil.getConnection()
        ) {
            //Statement - DON'T EVER EVER USE STATEMENT! EVER!
            //Prepared Statement - Use this one.
            //Callable

            String standardQuery = ("SELECT first_name, last_name, favorite_quote FROM teachers WHERE teacher_id = ?");
            PreparedStatement ps = conn.prepareStatement(standardQuery);
            ps.setInt(1, id);
            ResultSet results = ps.executeQuery();

            if(results.next()){

                String firstName = results.getString("first_name");
                String lastName = results.getString("last_name");
                String favoriteQuote = results.getString("favorite_quote");
                return new Teacher(id, firstName, lastName, favoriteQuote);

            }
            else
                return null;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;
    }

    @Override
    public List<Teacher> getbyName(String firstName, String lastName) {

        return null;

    }

    @Override
    public void newTeacher(Teacher teacher) {



    }

    @Override
    public void update(Teacher teacher) {



    }

    @Override
    public void delete(Teacher teacher) {



    }

}
