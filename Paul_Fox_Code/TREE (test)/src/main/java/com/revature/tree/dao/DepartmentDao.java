package com.revature.tree.dao;

import com.revature.tree.beans.Department;
import com.revature.tree.beans.Employee;

import java.util.List;

public interface DepartmentDao {

    Department getById(int departmentId);

    List<Department> getByName(String departmentName);

    Employee getDeptHead(Department department);

    void newDepartment(Department department);

    void updateDepartment(Department department);

    void deleteDepartment(Department department);

}
