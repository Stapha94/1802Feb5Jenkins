package QSeven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Employee {

    public String name;
    public String dept;
    public int age;
    public static ArrayList<Employee> employeeList = new ArrayList<>();

    public Employee(String name, String dept, int age){

        this.name = name;
        this.dept = dept;
        this.age = age;

    }

    public String toString(){

        return this.name + " " + this.dept + " " + this.age;

    }

    public static void main(String[] args) {

        Employee employeeOne = new Employee("Bob", "Marketing", 27);
        Employee employeeTwo = new Employee("Seth", "IT", 24);
        employeeList.add(employeeOne);
        employeeList.add(employeeTwo);

        System.out.println("Unsorted");
        for(int i = 0; i < employeeList.size(); i++){

            System.out.println(employeeList.get(i));

        }

        System.out.println("\nSorted by Name");
        for(int i = 0; i < employeeList.size(); i++){

            Collections.sort(employeeList, new SortByName());
            System.out.println(employeeList.get(i));

        }

        System.out.println("\nSorted by Dept");
        for(int i = 0; i < employeeList.size(); i++){

            Collections.sort(employeeList, new SortByDept());
            System.out.println(employeeList.get(i));

        }

        System.out.println("\nSorted by Age");
        for(int i = 0; i < employeeList.size(); i++){

            Collections.sort(employeeList, new SortByAge());
            System.out.println(employeeList.get(i));

        }
    }

}

class SortByName implements Comparator<Employee>{

    public int compare(Employee a, Employee b){

        return a.name.compareTo(b.name);

    }

}

class SortByDept implements Comparator<Employee>{

    public int compare(Employee a, Employee b){

        return a.dept.compareTo(b.dept);

    }

}

class SortByAge implements Comparator<Employee>{

    public int compare(Employee a, Employee b){

        return a.age - b.age;

    }

}