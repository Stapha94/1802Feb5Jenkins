package com.revature.dao;

import com.revature.beans.Department;
import com.revature.beans.Employee;

import java.util.List;

public interface DepartmentDao {

    Department getById(int departmentId);

    List<Department> getByName(String departmentName);

    Employee getDeptHead(Department department);

    void newDepartment(Department department);

    void updateDepartment(Department department);

    void deleteDepartment(Department department);

}
