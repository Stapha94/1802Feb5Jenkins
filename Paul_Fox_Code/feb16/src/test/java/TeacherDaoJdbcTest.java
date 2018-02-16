import com.revature.beans.Teacher;
import com.revature.dao.TeacherDao;
import com.revature.dao.TeacherDaoJdbcPg;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TeacherDaoJdbcTest {

    private static TeacherDao dao = new TeacherDaoJdbcPg();

    @Test
    void saveTeacherTest(){

        String testFName = "first name";
        String testLName = "last name";
        String testFQuote = "test quote";
        Teacher testTeacher = new Teacher();
        testTeacher.setFirstName("first name");
        testTeacher.setLastName("last name");
        testTeacher.setFavoriteQuote("Test Quote");

        dao.newTeacher(testTeacher);

        assertTrue(testTeacher.getId() != 0);

    }

}
