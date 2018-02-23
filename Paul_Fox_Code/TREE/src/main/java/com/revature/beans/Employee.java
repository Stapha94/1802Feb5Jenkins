package com.revature.beans;

import java.util.Objects;

public class Employee {

    private String firstName;
    private String lastName;
    private String SSN;
    private String email;
    private String password;
    private int employeeId;
    private int departmentId;
    private int supervisorId;

    public Employee(){}

    public Employee(String firstName, String lastName, String SSN, String email, String password, int employeeId, int departmentId, int supervisorId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
        this.email = email;
        this.password = password;
        this.employeeId = employeeId;
        this.departmentId = departmentId;
        this.supervisorId = supervisorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(int supervisorId) {
        this.supervisorId = supervisorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getEmployeeId() == employee.getEmployeeId() &&
                getDepartmentId() == employee.getDepartmentId() &&
                getSupervisorId() == employee.getSupervisorId() &&
                Objects.equals(getFirstName(), employee.getFirstName()) &&
                Objects.equals(getLastName(), employee.getLastName()) &&
                Objects.equals(getSSN(), employee.getSSN()) &&
                Objects.equals(getEmail(), employee.getEmail()) &&
                Objects.equals(getPassword(), employee.getPassword());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getFirstName(), getLastName(), getSSN(), getEmail(), getPassword(), getEmployeeId(), getDepartmentId(), getSupervisorId());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", SSN='" + SSN + '\'' +
                ", email='" + email + '\'' +
                ", employeeId=" + employeeId +
                ", departmentId=" + departmentId +
                ", supervisorId=" + supervisorId +
                '}';
    }
}
