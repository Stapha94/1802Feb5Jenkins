package beantests;

import com.revature.tree.beans.Reimbursement;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

public class ReimbursementTest {

    @Test
    void ReimbursementTest(){

        new BeanTester().testBean(Reimbursement.class);

    }

}
