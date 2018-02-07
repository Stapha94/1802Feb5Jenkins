package QSeven;

public class Employee {

    String name;
    String dept;
    int age;

    public Employee(String name, String dept, int age){

        this.name = name;
        this.dept = dept;
        this.age = age;

    }

    public static void main(String[] args) {

        Employee employeeOne = new Employee("Bob", "Marketing", 27);
        Employee employeeTwo = new Employee("Seth", "IT", 24);

    }

}
