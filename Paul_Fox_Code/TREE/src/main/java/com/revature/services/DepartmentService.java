package com.revature.services;

import com.revature.beans.Department;
import com.revature.beans.Employee;
import com.revature.dao.DepartmentDao;
import com.revature.dao.DepartmentDaoJdbcPg;

import java.util.List;

public class DepartmentService {

    private static DepartmentDaoJdbcPg myDepartmentDao = new DepartmentDaoJdbcPg();

    public Department findById(int departmentId){

        return myDepartmentDao.getById(departmentId);

    }

    public List<Department> getDeptByName(String departmentName){

        return myDepartmentDao.getByName(departmentName);

    }

    public void newDepartment(Department department){

        myDepartmentDao.newDepartment(department);

    }

    public void updateDepartment(Department department){

        myDepartmentDao.updateDepartment(department);

    }

    public void deleteDepartment(Department department){

        myDepartmentDao.deleteDepartment(department);

    }

    public Employee getDeptHead(Department department){

        return myDepartmentDao.getDeptHead(department);

    }

}
