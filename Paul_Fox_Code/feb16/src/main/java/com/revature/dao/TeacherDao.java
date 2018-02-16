package com.revature.dao;

import com.revature.beans.Teacher;
import java.util.*;

public interface TeacherDao {

    public Teacher getByID(int id);

    public List<Teacher> getByName(String firstName, String lastName);

    public void newTeacher(Teacher teacher);

    public void update(Teacher teacher);

    public void delete(Teacher teacher);

}
