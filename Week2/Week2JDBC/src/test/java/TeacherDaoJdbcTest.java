import com.revature.beans.Teacher;
import com.revature.controllers.Launcher;
import com.revature.dao.TeacherDao;
import com.revature.dao.TeacherDaoJdbcPg;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class TeacherDaoJdbcTest {
    private static TeacherDao dao = new TeacherDaoJdbcPg();

    @Test
    public void saveTeacherTest() throws Exception {
        final String firstName = "first name";
        final String lastName = "last name";
        final String favoriteQuote = "favorite quote";

        Teacher testTeacher = new Teacher();
        testTeacher.setFirstName(firstName);
        testTeacher.setLastName(lastName);
        testTeacher.setFavoriteQuote(favoriteQuote);

        dao.newTeacher(testTeacher);
        assertTrue(testTeacher.getId() != 0);

    }
}
