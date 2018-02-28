package com.revature.tree.beans;

import java.util.Objects;

public class Department {

    private String name;
    private int departmentHead;
    private int departmentId;

    public Department(){}

    public Department(String name, int departmentHead, int departmentId) {
        this.name = name;
        this.departmentHead = departmentHead;
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepartmentHead() {
        return departmentHead;
    }

    public void setDepartmentHead(int departmentHead) {
        this.departmentHead = departmentHead;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return getDepartmentHead() == that.getDepartmentHead() &&
                getDepartmentId() == that.getDepartmentId() &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getDepartmentHead(), getDepartmentId());
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", departmentHead=" + departmentHead +
                ", departmentId=" + departmentId +
                '}';
    }

}
