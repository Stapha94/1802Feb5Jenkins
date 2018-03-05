package com.revature.tree.dao;

import com.revature.tree.beans.Employee;

import java.util.List;

public interface EmployeeDao {

    Employee getById(int employeeId);

    List<Employee> getByName(String firstName, String lastName);

    Employee getByEmail(String email);

    Employee getSupervisor(Employee employee);

    void newEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(Employee employee);

}
