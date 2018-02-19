package com.revature.controllers;

import com.revature.beans.Teacher;
import com.revature.services.TeacherService;

import java.util.List;

public class Launcher {

    static TeacherService teacherService = new TeacherService();
    /**
     * Get access to database.
     * Load a teacher object from the database.
     * Save a teacher object to the database.
     * @param args
     */
    public static void main(String[] args) {

        Teacher teacher = teacherService.getTeacher(1);

        List<Teacher> teachers =
                teacherService.getByName("Jake", "Wilson");

        for(Teacher t: teachers) {
            System.out.println(t);
        }

//        teacher.setFavoriteQuote("Straight to my hips.");
//        teacherService.updateTeacher(teacher);
//        System.out.println(teacher);
//
//        Teacher testTeacher = teacherService.getTeacher(7);
//
//        //Should be present
//        System.out.println(testTeacher);
//        teacherService.delete(testTeacher);
//        testTeacher = teacherService.getTeacher(7);
//
//        //Should be null
//        System.out.println(testTeacher);


//
//        Teacher newTeacher = new Teacher();
//        newTeacher.setFirstName("test name");
//        newTeacher.setLastName("test last name");
//        newTeacher.setFavoriteQuote("test quote");
//        teacherService.saveTeacher(newTeacher);
//        System.out.println(newTeacher);
    }
}
