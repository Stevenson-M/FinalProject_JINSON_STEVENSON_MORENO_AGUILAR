package org.finalProject.data;

public class Student {
    private String name;
    private int id;
    private int age;

    private int counter = 0;



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

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student name: " + name + ", id: " + id + ", age: " + age;
    }
}