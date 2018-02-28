package beantests;

import com.revature.tree.beans.Department;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

public class DepartmentTest {


    @Test
    void departmentTest() {

        new BeanTester().testBean(Department.class);

    }

}
