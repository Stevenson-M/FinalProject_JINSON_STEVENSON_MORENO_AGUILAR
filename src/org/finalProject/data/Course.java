package org.finalProject.data;

import java.util.ArrayList;

public class Course {
    private String courseName;
    private String courseRoom;
    private ArrayList<Student> studentsList;
    private Teacher teacher;


    public Course(String courseName, String courseRoom, ArrayList<Student> studentsList, Teacher teacher) {
        this.courseName = courseName;
        this.courseRoom = courseRoom;
        this.studentsList = studentsList;
        this.teacher = teacher;
    }



}


