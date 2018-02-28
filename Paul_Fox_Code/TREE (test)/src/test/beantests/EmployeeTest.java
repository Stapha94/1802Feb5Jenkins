package beantests;

import com.revature.tree.beans.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

 public class EmployeeTest {

    private static Employee testEmployee;

    @BeforeEach
     void testSetup(){

        testEmployee = new Employee();

    }

    @Test
    void testGetSetFirstName(){

        String expected = "Paul";
        String actual;
        testEmployee.setFirstName(expected);
        actual = testEmployee.getFirstName();
        assertEquals(expected, actual);

    }

    @Test
    void testGetSetLastName(){

        String expected = "Fox";
        String actual;
        testEmployee.setLastName(expected);
        actual = testEmployee.getLastName();
        assertEquals(expected, actual);

    }

    @Test
    void testGetSetSSN(){

        String expected = "123-45-6789";
        String actual;
        testEmployee.setSSN(expected);
        actual = testEmployee.getSSN();
        assertEquals(expected, actual);

    }

    @Test
    void testGetSetEmail(){

        String expected = "test@test.test";
        String actual;
        testEmployee.setEmail(expected);
        actual = testEmployee.getEmail();
        assertEquals(expected, actual);

    }

    @Test
    void testGetSetPassword(){

        String expected = "password";
        String actual;
        testEmployee.setPassword(expected);
        actual = testEmployee.getPassword();
        assertEquals(expected, actual);

    }

    @Test
    void testGetSetEmployeeId(){

        int expected = 1;
        int actual;
        testEmployee.setEmployeeId(expected);
        actual = testEmployee.getEmployeeId();
        assertEquals(expected, actual);

    }

    @Test
    void testGetSetDepartmentId(){

        int expected = 1;
        int actual;
        testEmployee.setDepartmentId(expected);
        actual = testEmployee.getDepartmentId();
        assertEquals(expected, actual);

    }

    @Test
    void testGetSetSupervisorId(){

        int expected = 1;
        int actual;
        testEmployee.setSupervisorId(expected);
        actual = testEmployee.getSupervisorId();
        assertEquals(expected, actual);

    }

}
