package servicetests;

import com.revature.tree.beans.Employee;
import com.revature.tree.services.EmployeeService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeServiceTest {

    private static EmployeeService employeeService;
    private static Employee myEmployee;

    @BeforeAll
    static void setup(){

        myEmployee = new Employee();
        employeeService = new EmployeeService();

    }

    @BeforeEach
    void runBeforeTest(){

        myEmployee = new Employee();
        employeeService = new EmployeeService();

    }

    @Test
    void testGetEmployeeById(){

        myEmployee = employeeService.getById(1);
        String expectedName = "Paul";
        String actualName = myEmployee.getFirstName();
        assertEquals(expectedName, actualName);

    }

    @Test
    void testGetEmployeeByName() {

        List<Employee> myList = new ArrayList<>();
        myList = employeeService.getByName("Paul", "Fox");
        assertTrue(myList.size() > 0);
        assertEquals(1, myList.get(0).getEmployeeId());

    }

    @Test
    void testNewEmployee() {

        myEmployee = new Employee();
        myEmployee.setFirstName("Dave");
        myEmployee.setLastName("Copperfield");
        myEmployee.setSSN("111-22-3333");
        myEmployee.setEmail("dave@copper.com");
        myEmployee.setPassword(employeeService.hashPassword("IamAGoodPassword"));
        myEmployee.setSupervisorId(1);
        myEmployee.setDepartmentId(1);
        employeeService.newEmployee(myEmployee);
        Employee testEmployee = employeeService.getById(myEmployee.getEmployeeId());
        assertTrue(testEmployee.equals(myEmployee));


    }

    @Test
    void testUpdateEmployee(){

        myEmployee = employeeService.getById(3);
        myEmployee.setEmail("davy@copper.com");
        employeeService.updateEmployee(myEmployee);
        assertTrue(employeeService.getById(3).getEmail().equals("davy@copper.com"));

    }

    @Test
    void testGetSupervisor(){

        myEmployee = employeeService.getById(3);
        Employee supervisor = employeeService.getSupervisor(myEmployee);
        assertEquals(supervisor.getEmployeeId(), 1);

    }

    @Test
    void testCompareHash(){

        myEmployee = employeeService.getById(3);
        myEmployee.setPassword("IamAGoodPassword");
        assertTrue(employeeService.compareHash(myEmployee));

    }

    @Test
    void testDeleteEmployee(){

        myEmployee = employeeService.getById(3);
        employeeService.newEmployee(myEmployee);
        employeeService.deleteEmployee(myEmployee);
        assertNull(employeeService.getById(myEmployee.getEmployeeId()));

    }



}
