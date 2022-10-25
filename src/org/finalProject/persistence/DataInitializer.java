package org.finalProject.persistence;

import org.finalProject.data.*;

import java.util.ArrayList;
import java.util.List;

public class DataInitializer {

    public static University loadUniversity(){
        University myUniversity = new University("M.I.T");
        loadStudentsIntoUniversity(myUniversity);
        loadTeachersIntoUniversity(myUniversity);
        loadCourseIntoUniversity(myUniversity);
        return myUniversity;
    }
    private static void loadTeachersIntoUniversity(University myUniversity) {

        FullTimeTeacher teacher1 = new FullTimeTeacher("John Martin", 1000, 3);
        FullTimeTeacher teacher2 = new FullTimeTeacher("Mary Brown", 2000, 6);

        PartTimeTeacher teacher3 = new PartTimeTeacher("Peter Black", 500, 9.3f);
        PartTimeTeacher teacher4 = new PartTimeTeacher("Jane Fishman", 500, 10.5f);

        myUniversity.addTeacher(teacher1);
        myUniversity.addTeacher(teacher2);
        myUniversity.addTeacher(teacher3);
        myUniversity.addTeacher(teacher4);
    }

    private static void loadStudentsIntoUniversity(University myUniversity) {

        Student student1 = new Student("Juan Perez", 27);
        Student student2 = new Student("Maria Lopez", 21);
        Student student3 = new Student("Pedro Gomez", 22);
        Student student4 = new Student("Luisa Suarez", 23);
        Student student5 = new Student("Juan Miranda", 24);
        Student student6 = new Student("Marta Molina", 25);

        myUniversity.addStudent(student1);
        myUniversity.addStudent(student2);
        myUniversity.addStudent(student3);
        myUniversity.addStudent(student4);
        myUniversity.addStudent(student5);
        myUniversity.addStudent(student6);

    }

    private static void loadCourseIntoUniversity(University myUniversity) {

        List<Student> mathStudents = new ArrayList<>();
        mathStudents.add(myUniversity.getStudents().get(0));
        mathStudents.add(myUniversity.getStudents().get(1));
        Course math = new Course("Math", "Classroom 1", (ArrayList<Student>) mathStudents, myUniversity.getTeachers().get(0));

        List<Student> sportStudents = new ArrayList<>();
        sportStudents.add(myUniversity.getStudents().get(2));
        sportStudents.add(myUniversity.getStudents().get(3));
        Course sport = new Course("Sport", "Classroom 2", (ArrayList<Student>) sportStudents, myUniversity.getTeachers().get(1));

        List<Student> englishStudents = new ArrayList<>();
        englishStudents.add(myUniversity.getStudents().get(4));
        englishStudents.add(myUniversity.getStudents().get(5));
        Course english = new Course("English", "Classroom 3", (ArrayList<Student>) englishStudents, myUniversity.getTeachers().get(2));

        List<Student> artStudents = new ArrayList<>();
        artStudents.add(myUniversity.getStudents().get(0));
        artStudents.add(myUniversity.getStudents().get(3));
        artStudents.add(myUniversity.getStudents().get(5));
        Course art = new Course("Art", "Classroom 4", (ArrayList<Student>) artStudents, myUniversity.getTeachers().get(3));

        myUniversity.addCourse(math);
        myUniversity.addCourse(sport);
        myUniversity.addCourse(english);
        myUniversity.addCourse(art);

    }
}
