package beantests;

import com.revature.tree.beans.Result;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

public class ResultTest {

    @Test
    void resultTest(){

        new BeanTester().testBean(Result.class);

    }

}
