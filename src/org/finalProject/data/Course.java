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

    public Course() {
    }

    public String getStudentsNames() {
        String studentsNames = "";
        for (Student student : studentsList) {
            studentsNames += student.getName() + ", ";
        }
        return studentsNames;
    }

    public String getCourseName() {
        return courseName;
    }

    public void addStudent(Student newStudent) {
        studentsList.add(newStudent);
    }

    @Override
    public String toString() {
        return "Course name: " + courseName + ", course room: " + courseRoom + ", students: " + getStudentsNames() + " teacher: " + teacher.getName();
    }

}


