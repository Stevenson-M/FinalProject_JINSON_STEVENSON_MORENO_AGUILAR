package org.finalProject.data;

import java.util.ArrayList;

public class University {
    private String name;
    private ArrayList<Teacher> teachers;
    private ArrayList<Student> students;
    private ArrayList<Course> courses;


    /**
     * Constructor de la clase University
     * @param name nombre de la universidad
     */
    public University(String name) {
        this.name = name;
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    /**
     * Metodo que obtiene los profesores de la universidad
     * @return  profesores de la universidad
     */
    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    /**
     * Metodo que obtiene los estudiantes de la universidad
     * @return estudiantes de la universidad
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * Metodo que el nombre de la universidad
     * @return nombre de la universidad
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo que agrega un profesor a la lista de profesores de la universidad
     * @param teacher profesor a agregar
     */
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    /**
     * Metodo que agrega un estudiante a la lista de estudiantes de la universidad
     * @param student estudiante a agregar
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Metodo que agrega un curso a la lista de cursos de la universidad
     * @param course curso a agregar
     */
    public void addCourse(Course course) {
        courses.add(course);
    }

    /**
     * Metodo que obtiene la cantidad de profesores de la universidad
     * @return cantidad de profesores de la universidad
     */
    public int getTeachersAmount() {
        return teachers.size();
    }

    /**
     * Metodo que busca un profesor en la lista de profesores de la universidad
     * @param i indice del profesor a buscar
     * @return profesor buscado
     */
    public Teacher getTeacherByIndex(int i) {
        return teachers.get(i);
    }

    /**
     * Metodo que obtiene los nombres de los profesores de la universidad
     * @return nombres de los profesores de la universidad
     */
    public String getTeachersNames() {
        String teachersNames = "";
        for (Teacher teacher : teachers) {
            teachersNames += teacher.getName() + ", ";
        }
        return teachersNames;
    }

    /**
     * Metodo que verifica que el profesor exista en la lista de profesores de la universidad
     * @param teacherName nombre del profesor
     * @return true si el profesor existe, false si no existe
     */
    public boolean verifyTeacher(String teacherName) {
        boolean verify = false;
        for (Teacher teacher : this.teachers) {
            if (teacher.getName().equals(teacherName)) {
                verify = true;
            }
        }
        return verify;
    }

    /**
     * Metodo que obtiene el profesor de la universidad
     * @param teacherName nombre del profesor
     * @return profesor de la universidad
     */
    public Teacher getTeacher(String teacherName) {
        Teacher newTeacher = new Teacher(" ", 200) {
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

    /**
     * Metodo que obtiene la cantidad de cursos de la universidad
     * @return cantidad de cursos de la universidad
     */
    public int getCoursesAmount() {
        return courses.size();
    }

    /**
     * Metodo que obtiene los nombres de los cursos de la universidad
     * @return nombres de los cursos de la universidad
     */
    public String getCoursesNames() {
        String coursesNames = "";
        for (Course course : courses) {
            coursesNames += course.getCourseName() + ", ";
        }
        return coursesNames;
    }

    /**
     * Metodo que obtiene el curso de la universidad cuando se busca por su nombre
     * @param courseName nombre del curso
     * @return curso de la universidad
     */
    public Course getCourseByName(String courseName) {
        Course newCurse = new Course();
        for (Course course : this.courses) {
            if (course.getCourseName().equals(courseName)) {
                newCurse = course;
            }
        }
        return newCurse;
    }

    /**
     * Metodo que verifica que el curso exista en la lista de cursos de la universidad
     * @param courseName nombre del curso
     * @return true si el curso existe, false si no existe
     */
    public boolean verifyCourse(String courseName) {
        boolean verify = false;
        for (Course course : this.courses) {
            if (course.getCourseName().equals(courseName)) {
                verify = true;
            }
        }
        return verify;
    }

    /**
     * Metodo que obtiene los cursos en los que esta inscrito un estudiante
     * @param studentName nombre del estudiante
     * @return cursos en los que esta inscrito el estudiante
     */
    public String getStudentCourses(String studentName) {
        String studentCourses = "";
        for (Course course : this.courses) {
            if (course.getStudentsNames().contains(studentName)) {
                studentCourses += course.getCourseName() + ", ";
            }
        }
        return studentCourses;
    }


    /**
     * Metodo que busca los cursos en los que esta inscrito un estudiante por su id
     * @param id id del estudiante
     * @return cursos en los que esta inscrito el estudiante
     */
    public String getCoursesOfAStudentById(int id) {
        String coursesOfAStudentById = "";
        for (Student student : this.students) {
            if (student.getId() == id) {
                coursesOfAStudentById = getStudentCourses(student.getName());
            }
        }
        return coursesOfAStudentById;
    }

    /**
     * Metodo que obtiene la cantidad de estudiantes de la universidad
     * @return cantidad de estudiantes de la universidad
     */
    public int getStudentsAmount() {
        return students.size();
    }

    /**
     * Metodo que obtiene los nombres de los estudiantes de la universidad
     * @return nombres de los estudiantes de la universidad
     */
    public String getStudentsNames() {
        String studentsNames = "";
        for (Student student : students) {
            studentsNames += student.getName() + ", ";
        }
        return studentsNames;
    }

    /**
     * Metodo que obtiene el estudiante de la universidad por su id
     * @param id id del estudiante
     * @return estudiante de la universidad
     */
    public String getStudentNameById(int id) {
        String studentNameById = "";
        for (Student student : this.students) {
            if (student.getId() == id) {
                studentNameById = student.getName();
            }
        }
        return studentNameById;
    }

    /**
     * Metodo que obtiene el estudiante de la universidad por su nombre
     * @param studentName nombre del estudiante
     * @return estudiante de la universidad
     */
    public Student getStudent(String studentName) {
        Student newStudent = new Student(" ", 0);
        for (Student student : this.students) {
            if (student.getName().equals(studentName)) {
                newStudent = student;
            }
        }
        return newStudent;
    }

    /**
     * Metodo que retorna la cantidad de estudiantes en la lista de estudiantes
     * @return cantidad de estudiantes en la lista de estudiantes
     */
    public int studentListSize(){
        return this.students.size();
    }

    /**
     * Metodo que verifica que el nombre del estudiante exista en la lista de estudiantes de la universidad
     * @param studentName nombre del estudiante
     * @return true si el nombre del estudiante es String, false si no lo es
     */
    public boolean verifyStudent(String studentName) {
        boolean verify = false;
        for (Student student : this.students) {
            if (student.getName().equals(studentName)) {
                verify = true;
            }
        }
        return verify;
    }

    /**
     * Metodo que verifica el id del estudiante
     * @param id id del estudiante
     * @return true si el id del estudiante es int, false si no lo es
     */
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


