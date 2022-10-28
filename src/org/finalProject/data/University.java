package org.finalProject.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class University {
    private String name;
    private ArrayList<Teacher> teachers;
    private ArrayList<Student> students;
    private ArrayList<Course> courses;

    public University(String name) {
        this.name = name;
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public String getName() {
        return name;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public int getTeachersAmount() {
        return teachers.size();
    }

    public Teacher getTeacherByIndex(int i) {
        return teachers.get(i);
    }

    public String getTeachersNames() {
        String teachersNames = "";
        for (Teacher teacher : teachers) {
            teachersNames += teacher.getName() + ", ";
        }
        return teachersNames;
    }

    public int getCoursesAmount() {
        return courses.size();
    }


    public String getCoursesNames() {
        String coursesNames = "";
        for (Course course : courses) {
            coursesNames += course.getCourseName() + ", ";
        }
        return coursesNames;
    }

    public Course getCourseByName(String courseName){
        Course newCurse = new Course();
        for (Course course : this.courses) {
            if (course.getCourseName().equals(courseName)) {
                newCurse = course;
            }
        }
        return newCurse;
    }

    public int getStudentsAmount() {
        return students.size();
    }

    public String getStudentsNames() {
        String studentsNames = "";
        for (Student student : students) {
            studentsNames += student.getName() + ", ";
        }
        return studentsNames;
    }

    public String getCoursesOfAStudentById(int id) {
        String coursesOfAStudentById = "";
        for (Student student : this.students) {
            if (student.getId() == id) {
                coursesOfAStudentById = getStudentCourses(student.getName());
            }
        }
        return coursesOfAStudentById;
    }

    public String getStudentNameById(int id) {
        String studentNameById = "";
        for (Student student : this.students) {
            if (student.getId() == id) {
                studentNameById = student.getName();
            }
        }
        return studentNameById;
    }

    /**Verificar que id de estudiante exista*/
    public boolean verifyStudentId(int id) {
        boolean verifyStudentId = false;
        for (Student student : this.students) {
            if (student.getId() == id) {
                verifyStudentId = true;
            }
        }
        return verifyStudentId;
    }

    public String getStudentCourses(String studentName) {
        String studentCourses = "";
        for (Course course : this.courses) {
            if (course.getStudentsNames().contains(studentName)) {
                studentCourses += course.getCourseName() + ", ";
            }
        }
        return studentCourses;
    }






    public Teacher getTeacherByName(String teacherName) {
        Teacher newTeacher = new Teacher(" ", 0) {
            @Override
            public double calculateTotalSalary() {
                return 0;
            }
        };
        for (Teacher teacher : this.teachers) {
            if (teacher.getName().equals(teacherName)) {
                newTeacher = teacher;
            }
        }
        return newTeacher;
    }




    public Course getCourseByIndex(int i) {
        return courses.get(i);
    }

    public Object getStudentByName(String studentName2) {
        Student newStudent = new Student(" ", 0);
        for (Student student : this.students) {
            if (student.getName().equals(studentName2)) {
                newStudent = student;
            }
        }
        return newStudent;
    }

    public boolean verifyTeacher(String teacherName) {
        boolean verify = false;
        for (Teacher teacher : this.teachers) {
            if (teacher.getName().equals(teacherName)) {
                verify = true;
            }
        }
        return verify;
    }

    public boolean verifyCourse(String courseName) {
        boolean verify = false;
        for (Course course : this.courses) {
            if (course.getCourseName().equals(courseName)) {
                verify = true;
            }
        }
        return verify;
    }

    public void addCourse(String courseName, String teacherName) {
        Course newCourse = new Course(courseName);
        newCourse.addTeacher(teacherName);
        this.courses.add(newCourse);
    }


    public String getStudentNameByIndex(int studentNumber) {
        return students.get(studentNumber).getName();
    }

    public boolean verifyStudent(String studentName2) {
        boolean verify = false;
        for (Student student : this.students) {
            if (student.getName().equals(studentName2)) {
                verify = true;
            }
        }
        return verify;
    }

   /**Student list size**/
   public int studenListSize(){
       return this.students.size();
   }

    public Teacher getTeacher(String teacherName) {
        Teacher newTeacher = new Teacher(" ", 0) {
            @Override
            public double calculateTotalSalary() {
                return 0;
            }
        };
        for (Teacher teacher : this.teachers) {
            if (teacher.getName().equals(teacherName)) {
                newTeacher = teacher;
            }
        }
        return newTeacher;
    }

    public void addStudentToCourse(String studentName2, String courseName2) {
        Course newCourse = new Course();
        for (Course course : this.courses) {
            if (course.getCourseName().equals(courseName2)) {
                newCourse = course;
            }
        }
        newCourse.addStudent(studentName2);
    }

    public Student getStudent(String studentName2) {
        Student newStudent = new Student(" ", 0);
        for (Student student : this.students) {
            if (student.getName().equals(studentName2)) {
                newStudent = student;
            }
        }
        return newStudent;
    }
}


