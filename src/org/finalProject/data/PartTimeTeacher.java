package org.finalProject.data;

public class PartTimeTeacher extends Teacher {
    private float activeHours;


    /**
     * Constructor de la clase PartTimeTeacher
     * @param name nombre del profesor
     * @param basicSalary salario basico del profesor
     * @param activeHours horas activas del profesor
     */
    public PartTimeTeacher(String name, double basicSalary, float activeHours) {
        super(name, basicSalary);
        this.activeHours = activeHours;
    }

    /**
     * Metodo que calcula el salario total del profesor segun las horas trabajas
     * @return salario total
     */
    public double calculateTotalSalary(){
        return super.basicSalary * this.activeHours;
    }




}
