package util;

import model.Student;
import java.io.*;
import java.util.List;

public class FileHandler {
    public static void saveStudents(List<Student> students, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> loadStudents(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Student>) in.readObject();
        } catch (Exception e) {
            return new java.util.ArrayList<>();
        }
    }
}
