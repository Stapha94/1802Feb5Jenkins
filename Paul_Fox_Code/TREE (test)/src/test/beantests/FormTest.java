package beantests;

import com.revature.tree.beans.Form;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

public class FormTest {

    @Test
    void formTest(){
        new BeanTester().testBean(Form.class);
    }

}
