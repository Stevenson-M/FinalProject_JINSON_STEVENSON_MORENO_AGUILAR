package org.finalProject.data;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    private String courseRoom;
    private ArrayList<Student> studentsList;
    private Teacher teacher;


    /**
     * Constructor de la clase Course
     * @param courseName nombre del curso
     * @param courseRoom aula del curso
     * @param teacher profesor del curso
     */
    public Course(String courseName, String courseRoom, ArrayList<Student> studentsList, Teacher teacher) {
        this.courseName = courseName;
        this.courseRoom = courseRoom;
        this.studentsList = studentsList;
        this.teacher = teacher;
    }

    /**
     * Constructor de la clase Course
     */
    public Course() {
    }

    /**
     * Metodo que valida que el nombre del curso tenga solo Strings
     * @param  courseName nombre del curso
     * @return true si el nombre del curso es valido
     */
    public static boolean isNameValid(String courseName) {
        boolean isNameValid = false;
        if (courseName.matches("[a-zA-Z]+")) {
            isNameValid = true;
        }
        return isNameValid;
    }

    /**
     * Metodo que obtiene el nombre de los estudiantes del curso
     * @return  nombres de los estudiantes
     */
    public String getStudentsNames() {
        String studentsNames = "";
        for (Student student : studentsList) {
            studentsNames += student.getName() + ", ";
        }
        return studentsNames;
    }

    /**
     * Metodo que obtiene el nombre del curso
     * @return  nombre del curso
     */
    public String getCourseName() {
        return courseName;
    }


    /**
     * Metodo que agregan un estudiante a la lista de estudiantes del curso
     * @param newStudent estudiante a agregar
     */
   /** public void addStudent(Student newStudent) {
        studentsList.add(newStudent);
    }**/
    public void addStudent(Student newStudent) {
        studentsList.add(newStudent);
    }

    @Override
    public String toString() {
        return "Course name: " + courseName + ", course room: " + courseRoom + ", students: " + getStudentsNames() + " teacher: " + teacher.getName();
    }

}


