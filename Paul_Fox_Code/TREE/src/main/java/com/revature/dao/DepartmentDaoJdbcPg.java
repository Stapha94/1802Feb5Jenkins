package com.revature.dao;

import com.revature.beans.Department;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJdbcPg implements DepartmentDao {

    private static ConnectionUtil connectionUtil = ConnectionUtil.getConnectionUtil();

    /**
     * Searches the database for a department by the provided department id.
     * @param departmentId The department ID to search for a department for.
     * @return Returns the department that was found by searching the database, or null if none were found or an error occurred.
     */
    @Override
    public Department getById(int departmentId) {

        try(Connection conn = connectionUtil.getConnection()){

            PreparedStatement ps;
            String query = "SELECT * FROM departments WHERE department_id = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, departmentId);
            ResultSet rs = ps.executeQuery();

            ps.close();

            if(rs.next()){

                String departmentName = rs.getString("department_name");
                int departmentHead = rs.getInt("deapartment_head");

                return new Department(departmentName, departmentHead, departmentId);

            }
            else
                return null;

        } catch (SQLException e){

            System.out.println("Failed to find Department by ID");
            e.printStackTrace();
            return null;

        }

    }

    /**
     * Returns a list of departments found by searching the database for the department name.
     * @param department The name of the department to search for.
     * @return Returns a list of departments that were found by searching for a name or null if nothing was found or an error was returned.
     */
    @Override
    public List<Department> getByName(Department department) {

        List<Department> departmentList = new ArrayList<>();

        try(Connection conn = connectionUtil.getConnection()){

            PreparedStatement ps;
            String query = "SELECT * FROM departments WHERE department_name = ?;";
            ps = conn.prepareStatement(query);
            ps.setString(1, department.getName());
            ResultSet rs = ps.executeQuery();

            ps.close();

            while(rs.next()){

                String departmentName = rs.getString("department_name");
                int departmentHead = rs.getInt("deapartment_head");
                int departmentId = rs.getInt("department_id");

                departmentList.add(new Department(departmentName, departmentHead, departmentId));

            }

            return departmentList;

        } catch (SQLException e){

            System.out.println("Failed to find Department by Name");
            e.printStackTrace();
            return null;

        }

    }

    /**
     * Creates a new department using the provided department object.
     * @param department The department to be created.
     */
    @Override
    public void newDepartment(Department department) {

        try(Connection conn = connectionUtil.getConnection()){

            PreparedStatement ps;
            String query = "INSERT INTO departments (department_head, department_name) VALUES (?, ?);";
            ps = conn.prepareStatement(query);
            ps.setInt(1, department.getDepartmentHead());
            ps.setInt(2, department.getDepartmentId());
            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                department.setDepartmentId(rs.getInt("department_id"));

            }

            ps.close();

        } catch (SQLException e){

            System.out.println("Failed to create new Department");
            e.printStackTrace();

        }

    }

    /**
     * Updates the provided department in the department table.  Updates all values.
     * @param department The department to be updated.
     */
    @Override
    public void updateDepartment(Department department) {

        try(Connection conn = connectionUtil.getConnection()){

            PreparedStatement ps;
            String query = "UPDATE departments SET department_name = ?, department_head = ? WHERE department_id = ?;";
            ps = conn.prepareStatement(query);
            ps.setString(1, department.getName());
            ps.setInt(2, department.getDepartmentHead());
            ps.setInt(3, department.getDepartmentId());

            ps.execute();

            ps.close();

        } catch (SQLException e){

            System.out.println("Failed to update Department");
            e.printStackTrace();

        }

    }

    /**
     * Deletes the provided department from the department table.
     * @param department The department to be deleted.
     */
    @Override
    public void deleteDepartment(Department department) {

        Connection conn = connectionUtil.getConnection();

        try{

            conn.setAutoCommit(false);
            PreparedStatement ps;
            String query = "DELETE FROM departments WHERE departmnet_id = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, department.getDepartmentId());
            ps.execute();

            ps.close();

            conn.commit();

        } catch (SQLException e){

            System.out.println("Failed to delete Department");
            e.printStackTrace();

            try{

                conn.rollback();

            } catch (SQLException j){

                System.out.println("Failed to rollback the database");
                e.printStackTrace();

            }

        }

    }
}
