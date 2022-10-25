package org.finalProject.data;

public class FullTimeTeacher extends Teacher {
    private int experienceYears;


    public FullTimeTeacher(String name, double basicSalary, int experienceYears) {
        super(name, basicSalary);
        this.experienceYears = experienceYears;
    }

    public double calculateTotalSalary() {
        return super.basicSalary * (this.experienceYears * 1.1);
    }

}







