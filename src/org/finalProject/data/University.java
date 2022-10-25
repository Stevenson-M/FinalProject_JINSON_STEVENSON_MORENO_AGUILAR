package org.finalProject.data;

import java.util.ArrayList;

public class University {
    private String name;
    private ArrayList<Teacher> teachers;
    private ArrayList<Student> students;
    private ArrayList<Course> courses;

    public University(String name) {
        this.name = name;
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

}
