package org.finalProject.data;

import java.util.ArrayList;

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

    public boolean verifyTeacher(String teacherName) {
        boolean verify = false;
        for (Teacher teacher : this.teachers) {
            if (teacher.getName().equals(teacherName)) {
                verify = true;
            }
        }
        return verify;
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

    public Course getCourseByName(String courseName) {
        Course newCurse = new Course();
        for (Course course : this.courses) {
            if (course.getCourseName().equals(courseName)) {
                newCurse = course;
            }
        }
        return newCurse;
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

    public String getStudentCourses(String studentName) {
        String studentCourses = "";
        for (Course course : this.courses) {
            if (course.getStudentsNames().contains(studentName)) {
                studentCourses += course.getCourseName() + ", ";
            }
        }
        return studentCourses;
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

    public String getStudentNameById(int id) {
        String studentNameById = "";
        for (Student student : this.students) {
            if (student.getId() == id) {
                studentNameById = student.getName();
            }
        }
        return studentNameById;
    }

    public Student getStudent(String studentName) {
        Student newStudent = new Student(" ", 0);
        for (Student student : this.students) {
            if (student.getName().equals(studentName)) {
                newStudent = student;
            }
        }
        return newStudent;
    }

    public int studentListSize(){
        return this.students.size();
    }

    public boolean verifyStudent(String studentName) {
        boolean verify = false;
        for (Student student : this.students) {
            if (student.getName().equals(studentName)) {
                verify = true;
            }
        }
        return verify;
    }

    public boolean verifyStudentId(int id) {
        boolean verifyStudentId = false;
        for (Student student : this.students) {
            if (student.getId() == id) {
                verifyStudentId = true;
            }
        }
        return verifyStudentId;
    }

}


