package beantests;

import com.revature.tree.beans.Employee;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;


 public class EmployeeTest {

    private static Employee testEmployee;

    @Test
     public void testEmployee() {
        new BeanTester().testBean(Employee.class);
    }

}
