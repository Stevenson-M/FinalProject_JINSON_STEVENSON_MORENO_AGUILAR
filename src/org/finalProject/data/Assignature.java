package org.finalProject.data;

import java.util.ArrayList;

public class Assignature {
    private String assignatureName;
    private String assignatureRoom;
    private ArrayList<Student> studentsList;
    private Teacher teacher;


    public Assignature(String assignatureName, String assignatureRoom, ArrayList<Student> studentsList, Teacher teacher) {
        this.assignatureName = assignatureName;
        this.assignatureRoom = assignatureRoom;
        this.studentsList = studentsList;
        this.teacher = teacher;
    }

    public String getAssignatureName() {
        return assignatureName;
    }

    public void setAssignatureName(String assignatureName) {
        this.assignatureName = assignatureName;
    }

    public String getAssignatureRoom() {
        return assignatureRoom;
    }

    public void setAssignatureRoom(String assignatureRoom) {
        this.assignatureRoom = assignatureRoom;
    }

    public ArrayList<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(ArrayList<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}


