package org.finalProject.data;

public class PartTimeTeacher extends Teacher {
    private int activeHours;

    public PartTimeTeacher(String name, double totalSalary, int activeHours) {
        this.name = name;
        this.totalSalary = setTotalSalary();
        this.activeHours = activeHours;
    }

    @Override
    public double setTotalSalary() {
        return basicSalary * activeHours;
    }




}
