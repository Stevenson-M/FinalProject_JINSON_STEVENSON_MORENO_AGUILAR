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

    public String getName() {
        return name;
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

    public int getTeachersAmount() {
        return teachers.size();
    }

    public Teacher getTeacherByIndex(int i) {
        return teachers.get(i);
    }

    public int getCoursesAmount() {
        return courses.size();
    }


public String getCoursesNames() {
        String coursesNames = "";
        for (Course course : courses) {
            coursesNames += course.getCourseName() + ", ";
        }
        return coursesNames;
    }


    public Course getCourseByName(String courseName){
        Course newCurse = new Course();
        for (Course course : this.courses) {
            if (course.getCourseName().equals(courseName)) {
                newCurse = course;
            }
        }
        return newCurse;
    }


}
