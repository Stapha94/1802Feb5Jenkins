package com.revature.dao;

import com.revature.beans.Employee;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoJdbcPg implements EmployeeDao{

    ConnectionUtil connectionUtil = ConnectionUtil.getConnectionUtil();

    /**
     * Lists the employee found by the employeeId
     * @param employeeId The employeeID to search for an employee by.
     * @return Returns the employee found by searching the ID.
     */
    @Override
    public Employee getById(int employeeId) {

        try(Connection conn = connectionUtil.getConnection()){

            PreparedStatement ps;
            String query = "SELECT * FROM employees WHERE employee_id = ?;";
            ps = conn.prepareStatement(query);
            ps.setInt(1, employeeId);
            ResultSet rs = ps.executeQuery();

            ps.close();

            if(rs.next()){

                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String SSN = rs.getString("ssn");
                String hash = rs.getString("hash");
                String email = rs.getString("email");
                int departmentId = rs.getInt("department");
                int supervisorId = rs.getInt("supervisor");
                return new Employee(firstName, lastName, SSN, email, hash, employeeId, departmentId, supervisorId);

            }
            else
                return null;

        }catch(SQLException e){

            System.out.println("Failed to get Employee by ID");
            e.printStackTrace();
            return null;

        }

    }

    /**
     * Lists all employees with the given first and last name.
     * @param firstName The first name of the employee/s that you are wanting to find.
     * @param lastName The last name of the employee/s that you are wanting to find.
     * @return Returns a list of employees that matched the given first and last names.
     */
    @Override
    public List<Employee> getByName(String firstName, String lastName) {

        List<Employee> employeeList = new ArrayList<>();

        try(Connection conn = connectionUtil.getConnection()){

            PreparedStatement ps;
            String query = "SELECT * FROM employees WHERE first_name = ? AND last_name = ?;";
            ps = conn.prepareStatement(query);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ResultSet rs = ps.executeQuery();

            ps.close();

            while(rs.next()){

                String fName = rs.getString("first_name");
                String lName = rs.getString("last_name");
                String SSN = rs.getString("ssn");
                String hash = rs.getString("hash");
                String email = rs.getString("email");
                int departmentId = rs.getInt("department");
                int supervisorId = rs.getInt("supervisor");
                int employeeId = rs.getInt("employee_id");
                employeeList.add(new Employee(fName, lName, SSN, email, hash, employeeId, departmentId, supervisorId));

            }
            return employeeList;

        } catch (SQLException e){

            System.out.println("Failed to get Employees by name");
            e.printStackTrace();
            return null;

        }

    }

    @Override
    public Employee getByEmail(String email){

        try(Connection conn = connectionUtil.getConnection()){

            PreparedStatement ps;
            String query = "SELECT * FROM employees WHERE email = ?;";
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            ps.close();

            if(rs.next()){

                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String SSN = rs.getString("ssn");
                String hash = rs.getString("hash");
                int departmentId = rs.getInt("department");
                int supervisorId = rs.getInt("supervisor");
                int employeeId = rs.getInt("employee_id");
                return new Employee(firstName, lastName, SSN, email, hash, employeeId, departmentId, supervisorId);

            }
            return null;

        } catch (SQLException e){

            System.out.println("Failed to get Employee by Email");
            e.printStackTrace();
            return null;

        }

    }

    /**
     * Makes a new employee in the database.
     * @param employee The employee to create.
     */
    @Override
    public void newEmployee(Employee employee) {

        try(Connection conn = connectionUtil.getConnection()){

            PreparedStatement ps;
            String query = "INSERT INTO employees (first_name, last_name, ssn, email, hash, department, supervisor) VALUES (?, ?, ?, ?, ?, ? ,?) RETURNING employee_id;";
            ps = conn.prepareStatement(query);
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getSSN());
            ps.setString(4, employee.getEmail());
            ps.setString(5, employee.getPassword());
            ps.setInt(6, employee.getDepartmentId());
            ps.setInt(7, employee.getSupervisorId());
            ResultSet rs = ps.executeQuery();

            ps.close();

            if(rs.next()){

                employee.setEmployeeId(rs.getInt("employee_id"));

            }

        } catch (SQLException e){

            System.out.println("Failed to create new Employee");
            e.printStackTrace();

        }
    }

    /**
     * Update the given employee in the database.  This method sets everything.  A one update method updates everything scenario
     * @param employee The employee to be updated.
     */
    @Override
    public void updateEmployee(Employee employee) {

        try(Connection conn = connectionUtil.getConnection()){

            PreparedStatement ps;
            String query = "UPDATE employees SET first_name = ?, last_name = ?, ssn = ?, email = ?, hash = ?, department = ?, supervisor = ? WHERE employee_id = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getSSN());
            ps.setString(4, employee.getEmail());
            ps.setString(5, employee.getPassword());
            ps.setInt(6, employee.getDepartmentId());
            ps.setInt(7, employee.getSupervisorId());
            ps.setInt(8, employee.getEmployeeId());

            ps.close();


        } catch (SQLException e){

            System.out.println("Failed to update Employee");
            e.printStackTrace();

        }

    }

    /**
     * Delete an employee and anything associated with that employee from the table.
     * @param employee The employee to be removed from the database.
     */
    @Override
    public void deleteEmployee(Employee employee) {

        Connection conn = connectionUtil.getConnection();

        try{

            conn.setAutoCommit(false);
            PreparedStatement ps;
            String query = "DELETE FROM results WHERE EXISTS (SELECT form_id FROM forms WHERE form_id = form AND employee = ?);";
            ps = conn.prepareStatement(query);
            ps.setInt(1, employee.getEmployeeId());
            ps.execute();

            query = "DELETE FROM forms WHERE employee = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, employee.getEmployeeId());
            ps.execute();

            query = "DELETE FROM reimbursements WHERE employee = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, employee.getEmployeeId());
            ps.execute();

            query = "DELETE FROM departments WHERE department_head = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, employee.getEmployeeId());
            ps.execute();

            query = "DELETE FROM employees WHERE employee_id = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, employee.getEmployeeId());
            ps.execute();

            ps.close();

            conn.commit();

        } catch (SQLException e){

            System.out.println("Failed to delete Employee");
            e.printStackTrace();

            try{

                conn.rollback();

            } catch(SQLException j){

                System.out.println("Failed to rollback");
                e.printStackTrace();

            }


        }

    }
}
