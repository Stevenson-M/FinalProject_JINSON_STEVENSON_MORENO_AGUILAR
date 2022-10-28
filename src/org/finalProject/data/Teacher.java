package org.finalProject.data;

import com.sun.deploy.net.MessageHeader;

public abstract class Teacher {
    protected String name;
    protected double basicSalary;

    public Teacher(String name, double basicSalary) {
        this.name = name;
        this.basicSalary = basicSalary;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateTotalSalary();

    @Override
    public String toString() {
        return "Teacher name: " + name + ", total salary: " + calculateTotalSalary()+ ", basic salary: " + basicSalary+ ", Type of teacher: " + getClass().getSimpleName();
    }



}
