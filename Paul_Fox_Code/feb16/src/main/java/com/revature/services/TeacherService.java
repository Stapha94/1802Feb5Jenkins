package com.revature.services;

import com.revature.dao.TeacherDao;
import com.revature.dao.TeacherDaoJdbcPg;
import com.revature.beans.Teacher;

import java.util.List;

public class TeacherService {

    private static TeacherDao teacherDao = new TeacherDaoJdbcPg();

    public Teacher getTeacher(int id){

        return teacherDao.getByID(id);

    }

    public Teacher saveTeacher(Teacher teacher){

        teacherDao.newTeacher(teacher);
        return teacher;

    }

    public void updateTeacher(Teacher teacher){

        teacherDao.update(teacher);

    }

    public void deleteTeacher(Teacher teacher){

        teacherDao.delete(teacher);

    }

    public List<Teacher> getByName(String firstName, String lastName){

        return teacherDao.getByName(firstName, lastName);

    }

}
