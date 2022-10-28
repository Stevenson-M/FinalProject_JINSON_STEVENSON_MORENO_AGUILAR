package org.finalProject.runner;

import org.finalProject.data.Course;
import org.finalProject.data.Student;
import org.finalProject.data.Teacher;
import org.finalProject.data.University;
import org.finalProject.persistence.DataInitializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        University myUniversity = DataInitializer.loadUniversity();
        Scanner scan = new Scanner(System.in);
        int option = 0;

        do {
            try {
                System.out.println("Welcome to " + myUniversity.getName() + " University");
                System.out.println("1. Print all the professors of the university");
                System.out.println("2. Print list of the courses of the university");
                System.out.println("3. Create a new student");
                System.out.println("4. Create a new course");
                System.out.println("5. List all the courses of a particular student");
                System.out.println("6. Exit");

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
                    case 4:
                        System.out.println("Enter the name of the course: ");
                        String courseName2 = scan.nextLine();
                        scan = new Scanner(System.in);
                        if(myUniversity.verifyCourse(courseName2) == true){
                            System.out.println("The course already exists");
                        }else {
                            List<Student> newCourseStudents = new ArrayList<>();
                            printTeacherNames(myUniversity);
                            System.out.println("Now enter the name of the teacher that will teach the course: ");
                            String teacherName = scan.nextLine();
                            scan = new Scanner(System.in);
                            if (myUniversity.verifyTeacher(teacherName) == false) {
                                System.out.println("The teacher doesn't exist");
                            } else {
                                Teacher teacher = myUniversity.getTeacher(teacherName);
                                System.out.println("Enter the room of the course: ");
                                String courseRoom = scan.nextLine();
                                scan = new Scanner(System.in);
                                printStudentsNames(myUniversity);
                                System.out.println("Now enter the number of the students that will attend the course: ");
                                int numberOfStudents = scan.nextInt();
                                scan = new Scanner(System.in);
                                if (numberOfStudents > myUniversity.studenListSize()) {
                                    System.out.println("The number of students is too big");
                                } else {

                                    for (int i = 0; i < numberOfStudents; i++) {
                                        System.out.println("Enter the name of the student: ");
                                        String studentName2 = scan.nextLine();
                                        scan = new Scanner(System.in);
                                        if (myUniversity.verifyStudent(studentName2) == false) {
                                            System.out.println("The student doesn't exist");
                                        } else {
                                            newCourseStudents.add(myUniversity.getStudent(studentName2));
                                        }

                                    }
                                }
                                createCourse(myUniversity, courseName2,courseRoom, teacher, newCourseStudents);
                                System.out.println("The course has been created");

                            }
                        }

                        break;
                    case 5:
                        System.out.println("Enter the id of the student: ");
                        int studentId = scan.nextInt();
                        scan = new Scanner(System.in);
                        if(myUniversity.verifyStudentId(studentId) == true) {
                            printCoursesOfAStudent(myUniversity, studentId);
                        } else {
                            System.out.println("The student id is not valid");
                        }
                        break;
                    case 6:
                        System.out.println("Goodbye!");
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

    private static void createCourse(University myUniversity, String courseName, String courseRoom, Teacher teacher, List<Student> newCourseStudents) {
        Course newCourse = new Course(courseName, courseRoom, (ArrayList<Student>) newCourseStudents, teacher);
        myUniversity.addCourse(newCourse);
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


    public static void printTeacherNames(University university) {
        if (university.getTeachersAmount() == 0) {
            System.out.println("There are currently no professors registered at the university");
        } else {
            System.out.println("The existing professors at the university right now are: \n"
                    + university.getTeachersNames());
        }
    }

    public static void printStudentsNames(University university) {
        if (university.getStudentsAmount() == 0) {
            System.out.println("There are currently no students registered at the university");
        } else {
            System.out.println("The existing students at the university right now are: \n"
                    + university.getStudentsNames());
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
        Course newCourse = university.getCourseByName(courseName);



        if (newCourse.getCourseName() == null) {
            System.out.println("There is no course with that name");
        } else {
            System.out.println(newCourse);
        }
    }

    private static void createStudentAndAddToAnExistingCourse(University university, String studentName, String courseName) {
        Course newCourse = university.getCourseByName(courseName);

        if (newCourse.getCourseName() == null) {
            System.out.println("There is no course with that name, the courses currently available are the following: " + university.getCoursesNames());
        } else {
            newCourse.addStudent(studentName);
            System.out.println("The Student " + studentName + " has been successfully added to the course " + courseName);
        }
    }

    public static void printCoursesOfAStudent(University university, int studentId) {
        if (university.getStudentsAmount() == 0) {
            System.out.println("There are currently no students registered at the university");
        } else {
            System.out.println("The student " + university.getStudentNameById(studentId) + " with id " + studentId + " is currently enrolled in the following courses: \n"
                    + university.getCoursesOfAStudentById(studentId));

        }
    }




    }























