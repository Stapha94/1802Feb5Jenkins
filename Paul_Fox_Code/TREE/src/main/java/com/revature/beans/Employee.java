package com.revature.beans;

import java.util.Objects;

public class Employee {

    private String firstName;
    private String lastName;
    private String SSN;
    private int supervisor;
    private int form;

    public Employee(){}

    public Employee(String firstName, String lastName, String SSN, int supervisor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
        this.supervisor = supervisor;
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

    public int getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(int supervisor) {
        this.supervisor = supervisor;
    }

    public int getForm() {
        return form;
    }

    public void setForm(int form) {
        this.form = form;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getSupervisor() == employee.getSupervisor() &&
                getForm() == employee.getForm() &&
                Objects.equals(getFirstName(), employee.getFirstName()) &&
                Objects.equals(getLastName(), employee.getLastName()) &&
                Objects.equals(getSSN(), employee.getSSN());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getFirstName(), getLastName(), getSSN(), getSupervisor(), getForm());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", SSN='" + SSN + '\'' +
                ", supervisor=" + supervisor +
                ", form=" + form +
                '}';
    }
}
