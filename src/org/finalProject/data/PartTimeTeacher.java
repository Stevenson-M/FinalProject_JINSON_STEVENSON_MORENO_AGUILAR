package org.finalProject.data;

public class PartTimeTeacher extends Teacher {
    private float activeHours;


    public PartTimeTeacher(String name, double basicSalary, float activeHours) {
        super(name, basicSalary);
        this.activeHours = activeHours;
    }

    public double calculateTotalSalary(){
        return super.basicSalary * this.activeHours;
    }




}
