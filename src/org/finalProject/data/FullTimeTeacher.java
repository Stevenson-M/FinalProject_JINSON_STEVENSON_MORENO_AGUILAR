package org.finalProject.data;

public class FullTimeTeacher extends Teacher {
    private int experienceYears;


    /**
     * Constructor de la clase FullTimeTeacher
     * @param name nombre del profesor
     * @param basicSalary salario basico del profesor
     * @param experienceYears años de experiencia del profesor
     */
    public FullTimeTeacher(String name, double basicSalary, int experienceYears) {
        super(name, basicSalary);
        this.experienceYears = experienceYears;
    }

    /**
     * Metodo que calcula el salario total del profesor segun los años de experiencia
     * @return salario total
     */
    public double calculateTotalSalary() {
        return super.basicSalary * (this.experienceYears * 1.1);
    }







}







