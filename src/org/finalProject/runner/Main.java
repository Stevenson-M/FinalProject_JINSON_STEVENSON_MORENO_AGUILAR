package org.finalProject.runner;

import org.finalProject.data.Course;
import org.finalProject.data.University;
import org.finalProject.persistence.DataInitializer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        University myUniversity = DataInitializer.loadUniversity();
        Scanner scan = new Scanner(System.in);
        int option = 0;

        do {
            try {
                System.out.println("Welcome to " + myUniversity.getName() + " University");
                System.out.println("1. Print all the professors with its data");
                System.out.println("2. Print list of university courses");
                System.out.println("3. Create a new student and add into an existing course");

                option = scan.nextInt();
                scan = new Scanner(System.in);

                switch (option) {
                    case 1:
                        printTeacherList(myUniversity);
                        break;
                    case 2:
                        printCoursesName(myUniversity);

                        int option2;

                        do {

                            System.out.println("Enter 1 if you want to see the complete data of a specific course: ");
                            System.out.println("Enter 2 if you want to go back to the main menu: ");

                            option2 = scan.nextInt();
                            scan = new Scanner(System.in);
                            switch (option2) {
                                case 1:
                                    System.out.println("Enter the name of the course you want to see: ");
                                    String courseName = scan.nextLine();
                                    scan = new Scanner(System.in);
                                    printCourseData(myUniversity, courseName);
                                    break;
                                case 2:
                                    break;
                                default:
                                    System.out.println("Invalid option");
                                    break;
                            }
                        } while (option2 != 2);
                        break;
                    case 3:
                          System.out.println("Enter the name of the student: ");
                            String studentName = scan.nextLine();
                            scan = new Scanner(System.in);
                            System.out.println("Enter the name of the course: ");
                            String courseName = scan.nextLine();
                            scan = new Scanner(System.in);
                            createStudentAndAddToAnExistingCourse(myUniversity, studentName, courseName);
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid option");
                scan = new Scanner(System.in);
            }
        } while (option != 6);
    }

    public static void printTeacherList(University university) {
        if (university.getTeachersAmount() == 0) {
            System.out.println("There are currently no professors registered at the university");
        } else {
            for (int i = 0; i < university.getTeachersAmount(); i++) {
                System.out.println(university.getTeacherByIndex(i));
            }
        }
    }

    public static void printCoursesName(University university) {
        if (university.getCoursesAmount() == 0) {
            System.out.println("There are currently no courses registered at the university");
        } else {
            System.out.println("The existing courses at the university right now are: \n"
                    + university.getCoursesNames());
        }
    }


    private static void printCourseData(University university, String courseName) {
        Course newCourse =  university.getCourseByName(courseName);

        if (newCourse.getCourseName() == null) {
            System.out.println("There is no course with that name");
        } else {
            System.out.println(newCourse);
        }
    }

    private static void createStudentAndAddToAnExistingCourse(University university, String studentName, String courseName) {
        Course newCourse =  university.getCourseByName(courseName);

        if (newCourse.getCourseName() == null) {
            System.out.println("There is no course with that name, the courses currently available are the following: "  + university.getCoursesNames());
        } else {
            newCourse.addStudent(studentName);
            System.out.println("The Student " + studentName + " has been successfully added to the course " + courseName);
        }
    }
}







