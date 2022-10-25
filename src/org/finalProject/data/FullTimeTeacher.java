package org.finalProject.data;

public class FullTimeTeacher extends Teacher {
    private int experienceYears;

    public FullTimeTeacher(String name, double totalSalary, int experienceYears) {
        this.name = name;
        this.totalSalary = setTotalSalary();
        this.experienceYears = experienceYears;
    }

    @Override
    public double setTotalSalary() {
        return basicSalary * (experienceYears * 1.1);
    }






}
