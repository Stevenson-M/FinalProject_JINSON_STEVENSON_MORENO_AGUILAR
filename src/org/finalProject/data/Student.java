package org.finalProject.data;

public class Student {
    private String name;
    private int id;
    private int age;
    private static int counter = 0;

    /**
     * Constructor de la clase Student
     * @param name
     * @param age
     */
    public Student(String name, int age) {
        this.name = name;
        this.id = 1 + counter;
        counter++;
        this.age = age;
    }

    /**
     * Metodo que valida que el nombre ingresado sea solo String
     * @param  studentName nombre del estudiante
     * @return true si el nombre es valido
     */
    public static boolean isNameValid(String studentName) {
        boolean isNameValid = false;
        if (studentName.matches("[a-zA-Z]+")) {
            isNameValid = true;
        }
        return isNameValid;
    }


    /**
     * Metodo que obtiene el nombre del estudiante
     * @return nombre del estudiante
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo que obtiene el id del estudiante
     * @return id del estudiante
     */
    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Student name: " + name + ", id: " + id + ", age: " + age;
    }

}