package org.finalProject.data;

public class Student {
    private String name;
    private int id;
    private int age;

    private static int counter = 0;



    public Student(String name, int age) {
        this.name = name;
        this.id = 1 + counter;
        counter++;
        this.age = age;
    }

    public Student(String name) {
        this.name = name;
        this.id = 1 + counter;
        counter++;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student name: " + name + ", id: " + id + ", age: " + age;
    }



}