package com.revature.services;

import com.revature.dao.EmployeeDaoJdbcPg;
import com.revature.beans.Employee;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

public class EmployeeService {

    private static EmployeeDaoJdbcPg myEmployeeDao = new EmployeeDaoJdbcPg();

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
        if(myComparedEmployee.getPassword().equals(databaseEmployee.getPassword())){

            return true;

        }
        else
            return false;

    }

    public String hashPassword(String password){


        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        return hashed;

    }

}
