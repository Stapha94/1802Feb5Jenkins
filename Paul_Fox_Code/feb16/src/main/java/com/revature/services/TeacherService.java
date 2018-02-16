package com.revature.services;

import com.revature.dao.TeacherDao;
import com.revature.dao.TeacherDaoJdbcPg;
import com.revature.beans.Teacher;

public class TeacherService {

    private static TeacherDao teacherDao = new TeacherDaoJdbcPg();

    public Teacher getTeacher(int id){

        return teacherDao.getByID(id);

    }

}
