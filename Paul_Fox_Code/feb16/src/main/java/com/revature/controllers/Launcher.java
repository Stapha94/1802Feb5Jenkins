package com.revature.controllers;

import com.revature.beans.Teacher;
import com.revature.services.TeacherService;

import java.util.List;

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

        List<Teacher> teachers =
                teacherService.getByName("Jake", "Wilson");

        for (Teacher t: teachers){

            System.out.println(t);

        }
//        System.out.println(teacher);
//
//        teacher.setFavoriteQuote("Straight to my hips.");
//        teacherService.updateTeacher(teacher);
//        System.out.println(teacher);
//        Teacher newTeacher = new Teacher();
//        newTeacher.setFirstName("test");
//        newTeacher.setLastName("test");
//        newTeacher.setFavoriteQuote("test");
//        teacherService.saveTeacher(newTeacher);
//        System.out.println(newTeacher);
//
//        Teacher testTeacher = teacherService.getTeacher(7);
//        System.out.println(testTeacher);
//        teacherService.deleteTeacher(testTeacher);

    }

}
