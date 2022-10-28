package org.finalProject.view;

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
                System.out.println("|********************** Welcome To " + myUniversity.getName() + "**********************|");
                System.out.println("|--------1. Print professors list------------------------------------------|");
                System.out.println("|--------2. Print Courses list---------------------------------------------|");
                System.out.println("|--------3. Register a new student-----------------------------------------|");
                System.out.println("|--------4. Register a new course------------------------------------------|");
                System.out.println("|--------5. Print all the courses of a particular student------------------|");
                System.out.println("|--------6. Exit-----------------------------------------------------------|");
                System.out.println("");

                option = scan.nextInt();
                scan = new Scanner(System.in);

                switch (option) {
                    case 1:
                        printTeacherList(myUniversity);
                        break;
                    case 2:
                        printCourses(myUniversity);
                        break;
                    case 3:
                        createStudent(myUniversity);
                        break;
                    case 4:
                        createNewCourse(myUniversity);
                        break;
                    case 5:
                        findStudentCourses(myUniversity);
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

    /**
     * Metodo que imprime las lista completa de profesores con todos sus datos
     * @param university la universidad
     */
    private static void printTeacherList(University university) {
        if (university.getTeachersAmount() == 0) {
            System.out.println("There are currently no professors registered at the university");
        } else {
            for (int i = 0; i < university.getTeachersAmount(); i++) {
                System.out.println(university.getTeacherByIndex(i));
            }
        }
    }

    /**
     * Metodo que imprime los datos de un curso en particular
     * @param university la universidad
     * @param courseName Nombre del curso
     */
    private static void printCourseData(University university, String courseName) {
        Course newCourse = university.getCourseByName(courseName);

        if (newCourse.getCourseName() == null) {
            System.out.println("There is no course with that name");
        } else {
            System.out.println(newCourse);
        }
    }

    /**
     * Metodo que imprime la lista completa de cursos
     * @param university la universidad
     */
    private static void printCoursesName(University university) {
        if (university.getCoursesAmount() == 0) {
            System.out.println("There are currently no courses registered at the university");
        } else {
            System.out.println("The existing courses at the university right now are: \n"
                    + university.getCoursesNames());
        }
    }

    /**
     * Metodo que imprime la lista completa de cursos con todos sus datos
     * @param university la universidad
     */
    private static void printCourses( University university) {
        printCoursesName(university);
        Scanner scan = new Scanner(System.in);
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
                    printCourseData(university, courseName);
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (option2 != 2);

    }

    /**
     * Metodo que mira si registra un nuevo estudiante a un curso
     * @param university la universidad
     * @param studentName nombre del estudiante
     * @param studentAge edad del estudiante
     * @param courseName nombre del curso
     */
    private static void createStudentAndAddToAnExistingCourse(University university, String studentName,int studentAge, String courseName) {
        Course newCourse = university.getCourseByName(courseName);

        if (newCourse.getCourseName() == null) {
            System.out.println("There is no course with that name, the courses currently available are the following: " + university.getCoursesNames());
        } else {
            Student newStudent = new Student(studentName, studentAge);
            university.addStudent(newStudent);
            newCourse.addStudent(newStudent);
            System.out.println("The Student " + studentName + " has been successfully added to the course " + courseName);

        }
    }

    /**
     * Metodo que registra un nuevo estudiante
     * @param university la universidad
     */
    private static void createStudent(University university){
            Scanner scan = new Scanner(System.in);

            int option = 0;

            do{
                System.out.println("Enter the name of the student: ");
                String studentName = scan.nextLine();
                scan = new Scanner(System.in);
                if(studentName.length() == 0){
                    System.out.println("Invalid name");
                }
                else if (Student.isNameValid(studentName) == false){
                    System.out.println("Invalid name");

                }else {
                    System.out.println("Enter the age of the student: ");
                    int studentAge = scan.nextInt();
                    scan = new Scanner(System.in);
                        if (studentAge <= 0) {
                            System.out.println("Invalid age");
                        } else {
                            printCoursesName(university);
                            System.out.println("Enter the name of the course you want to add the student to: ");
                            String courseName = scan.nextLine();
                            scan = new Scanner(System.in);
                            createStudentAndAddToAnExistingCourse(university, studentName, studentAge, courseName);
                            System.out.println("Enter 1 if you want to add another student to a course");
                            System.out.println("Enter 2 if you want to go back to the main menu");
                            option = scan.nextInt();
                            scan = new Scanner(System.in);
                            if(option != 1 && option != 2) {
                                System.out.println("Invalid option");
                                break;
                            }
                        }
                }
            }while(option != 2);
    }

    /**
     * Metodo que imprime los nombre de los profesored de la universidad
     * @param university la universidad
     */
    private static void printTeacherNames(University university) {
        if (university.getTeachersAmount() == 0) {
            System.out.println("There are currently no professors registered at the university");
        } else {
            System.out.println("The existing professors at the university right now are: \n"
                    + university.getTeachersNames());
        }
    }

    /**
     * Metodo que imprime los nombres de los estudiantes de la universidad
     * @param university la universidad
     */
    private static void printStudentsNames(University university) {
        if (university.getStudentsAmount() == 0) {
            System.out.println("There are currently no students registered at the university");
        } else {
            String s = "Enter the name of the student you want to add: ";
            System.out.println("The existing students at the university right now are: \n"
                    + university.getStudentsNames());
        }
    }

    /**
     * Metodo que crea un nuevo curso
     * @param university la universidad
     * @param courseName nombre del curso
     * @param courseRoom numero de la sala
     * @param teacher nombre del profesor
     * @param newCourseStudents estudiantes del curso
     */
    private static void createCourse(University university, String courseName, String courseRoom, Teacher teacher, List<Student> newCourseStudents) {
        Course newCourse = new Course(courseName, courseRoom, (ArrayList<Student>) newCourseStudents, teacher);
        university.addCourse(newCourse);
    }

    /**
     * Metodo que crea un nuevo curso
     * @param university la universidad
     */
    private static void createNewCourse(University university){
        Scanner scan = new Scanner(System.in);

        int option = 0;

        do {

            System.out.println("Enter the name of the course: ");
            String courseName2 = scan.nextLine();
            scan = new Scanner(System.in);
            if(courseName2.length()== 0 || Course.isNameValid(courseName2) == false) {
                System.out.println("Invalid name");
            }
            else if (university.verifyCourse(courseName2) == true) {
                System.out.println("The course already exists");
            } else {
                List<Student> newCourseStudents = new ArrayList<>();
                printTeacherNames(university);
                System.out.println("Now enter the name of the teacher that will teach the course: ");
                String teacherName = scan.nextLine();
                scan = new Scanner(System.in);
                if (university.verifyTeacher(teacherName) == false) {
                    System.out.println("The teacher doesn't exist");
                } else {
                    Teacher teacher = university.getTeacher(teacherName);
                    System.out.println("Enter the room of the course: ");
                    String courseRoom = scan.nextLine();
                    scan = new Scanner(System.in);
                    if (courseRoom.length() == 0 ) {
                        System.out.println("Invalid name for de room");
                    } else {
                        System.out.println("Enter the number of the students that will attend the course: ");
                        int numberOfStudents = scan.nextInt();
                        scan = new Scanner(System.in);
                        if (numberOfStudents <= 0) {
                            System.out.println("Invalid number of students");

                        } else if (numberOfStudents > university.studentListSize()) {
                            System.out.println("The number of students is too big");

                        } else {
                            for (int i = 0; i < numberOfStudents; i++) {
                                printStudentsNames(university);
                                System.out.println("Enter the name of the student: ");
                                String studentName2 = scan.nextLine();
                                scan = new Scanner(System.in);
                                if (studentName2.length() == 0) {
                                    System.out.println("Invalid Name");
                                }
                                else if (university.verifyStudent(studentName2) == false) {
                                    System.out.println("The student doesn't exist");
                                } else {
                                    newCourseStudents.add(university.getStudent(studentName2));
                                }
                            }
                            createCourse(university, courseName2, courseRoom, teacher, newCourseStudents);
                            System.out.println("The course has been created");
                            System.out.println("Enter 1 if you want to create another course");
                            System.out.println("Enter 2 if you want to go back to the main menu");
                            option = scan.nextInt();
                            scan = new Scanner(System.in);
                            if(option != 1 && option != 2) {
                                System.out.println("Invalid option");
                                break;
                            }

                        }
                    }
                }
            }

        }while(option != 2);

    }

    /**
     * Metodo que imprime los nombres de los cursos en los que esta inscrito un estudiante
     * @param university la universidad
     * @param studentId el id del estudiante
     */
    private static void printCoursesOfAStudent(University university, int studentId) {
        if (university.getStudentsAmount() == 0) {
            System.out.println("There are currently no students registered at the university");
        } else {
            System.out.println("The student " + university.getStudentNameById(studentId) + " with id " + studentId + " is currently enrolled in the following courses: \n"
                    + university.getCoursesOfAStudentById(studentId));

        }
    }

    /**
     * Metodo que imprime los nombres de los cursos en los que esta inscrito un estudiante
     * @param university la universidad
     */
    private static void findStudentCourses(University university) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the id of the student: "); /**Nota: Los id van del numero 1 en adelante*/
        int studentId = scan.nextInt();
        scan = new Scanner(System.in);
        if (university.verifyStudentId(studentId) == true) {
            printCoursesOfAStudent(university, studentId);
        } else {
            System.out.println("The student id is not valid");
        }

    }
}























