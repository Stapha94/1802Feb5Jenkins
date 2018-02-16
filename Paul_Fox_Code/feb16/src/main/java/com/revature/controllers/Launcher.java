package com.revature.controllers;

import com.revature.beans.Teacher;
import com.revature.services.TeacherService;

public class Launcher {


    static TeacherService teacherService = new TeacherService();
    /**
     * Get access to database,
     * Load a teacher from the database,
     * save a teacher object to the database.
     * @param args
     */
    public static void main(String[] args) {

        Teacher teacher = teacherService.getTeacher(1);
        System.out.println(teacher);

    }

}
