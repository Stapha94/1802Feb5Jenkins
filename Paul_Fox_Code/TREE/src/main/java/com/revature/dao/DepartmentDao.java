package com.revature.dao;

import com.revature.beans.Department;

import java.util.List;

public interface DepartmentDao {

    Department getById(int departmentId);

    List<Department> getByName(Department department);

    void newDepartment(Department department);

    void updateDepartment(Department department);

    void deleteDepartment(Department department);

}
