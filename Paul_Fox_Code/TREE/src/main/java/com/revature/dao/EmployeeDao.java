package com.revature.dao;

import com.revature.beans.Employee;

import java.util.List;

public interface EmployeeDao {

    Employee getById(int employeeId);

    List<Employee> getByName(String firstName, String lastName);

    void newEmployee(Employee employee);

    void update(Employee employee);

    void delete(Employee employee);

}
