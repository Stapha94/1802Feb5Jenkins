package com.revature.tree.services;

import com.revature.tree.dao.EmployeeDaoJdbcPg;
import com.revature.tree.beans.Employee;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

public class EmployeeService {

    private static EmployeeDaoJdbcPg myEmployeeDao = new EmployeeDaoJdbcPg();
    private static FormService myFormService = new FormService();

    public Employee getById(int employeeId){

        return myEmployeeDao.getById(employeeId);

    }

    public List<Employee> getByName(String firstName, String lastName){

        return myEmployeeDao.getByName(firstName, lastName);

    }

    public void newEmployee(Employee employee){

        myEmployeeDao.newEmployee(employee);

    }

    public void updateEmployee(Employee employee){

        myEmployeeDao.updateEmployee(employee);

    }

    public void deleteEmployee(Employee employee){

        myEmployeeDao.deleteEmployee(employee);

    }

    public boolean compareHash(Employee employee){

        Employee myComparedEmployee = employee;
        Employee databaseEmployee = myEmployeeDao.getByEmail(employee.getEmail());
        return BCrypt.checkpw(myComparedEmployee.getPassword(), databaseEmployee.getPassword());

    }

    public String hashPassword(String password){


        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        return hashed;

    }

    public Employee getSupervisor(Employee employee){

        return myEmployeeDao.getSupervisor(employee);

    }

}
