package org.finalProject.data;
import com.sun.deploy.net.MessageHeader;

public abstract class Teacher {
    protected String name;
    protected double basicSalary;

    /**
     * Constructor de la clase Teacher
     * @param name nombre del profesor
     * @param basicSalary salario basico del profesor
     */
    public Teacher(String name, double basicSalary) {
        this.name = name;
        this.basicSalary = basicSalary;
    }

    /**
     * Metodo que obtiene el nombre del profesor
     * @return nombre del profesor
     */
    public String getName() {
        return name;
    }


    /**
     * Metodo que obtiene el salario basico del profesor
     * @return salario basico del profesor
     */
    public abstract double calculateTotalSalary();


    @Override
    public String toString() {
        return "|-- Teacher name: " + name + ", total salary: " + calculateTotalSalary()+ ", basic salary: " + basicSalary+ ", Type of teacher: " + getClass().getSimpleName()+" --|";
    }



}
