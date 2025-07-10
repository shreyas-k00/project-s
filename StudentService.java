public package service;

import model.Student;
import util.FileHandler;
import java.util.*;

public class StudentService {
    private List<Student> students = new ArrayList<>();
    private final String FILE_NAME = "students.dat";

    public StudentService() {
        students = FileHandler.loadStudents(FILE_NAME);
    }

    public void addStudent(Student s) {
        students.add(s);
        FileHandler.saveStudents(students, FILE_NAME);
    }

    public void listStudents() {
        students.forEach(System.out::println);
    }

    public Student findStudent(int id) {
        return students.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    public void deleteStudent(int id) {
        students.removeIf(s -> s.getId() == id);
        FileHandler.saveStudents(students, FILE_NAME);
    }

    public void assignCourse(int id, String course) {
        Student s = findStudent(id);
        if (s != null) {
            s.addCourse(course);
            FileHandler.saveStudents(students, FILE_NAME);
        }
    }
}
 {
    
}
