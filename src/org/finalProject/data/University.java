package org.finalProject.data;

import java.util.ArrayList;

public class University {
    private ArrayList<Teacher> teachers;
    private ArrayList<Student> students;
    private ArrayList<Assignature> assignatures;

    public University(ArrayList<Teacher> teachers, ArrayList<Student> students, ArrayList<Assignature> assignatures) {
        this.teachers = teachers;
        this.students = students;
        this.assignatures = assignatures;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Assignature> getAssignatures() {
        return assignatures;
    }
}
