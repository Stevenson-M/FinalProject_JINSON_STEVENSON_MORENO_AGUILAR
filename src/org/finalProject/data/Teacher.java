package org.finalProject.data;

public abstract class Teacher {
    protected String name;

    protected double basicSalary;
    protected double totalSalary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public abstract double setTotalSalary();

    public double getTotalSalary() {
        return totalSalary;
    }

    @Override
    public String toString() {
        return "Teacher name: " + name + ", total salary: " + totalSalary;
    }
}
