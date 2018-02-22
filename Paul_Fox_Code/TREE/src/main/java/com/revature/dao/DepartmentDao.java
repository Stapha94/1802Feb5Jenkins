package com.revature.dao;

import com.revature.beans.Department;

public interface DepartmentDao {

    Department getById(Department department);

    Department getByName(Department department);

    void newDepartment(Department department);

    void updateDepartment(Department department);

    void deleteDepartment(Department department);

}
