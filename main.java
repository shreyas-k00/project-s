package com.example.studentapp;

import com.example.studentapp.dao.StudentDAO;
import com.example.studentapp.entity.Student;
import com.example.studentapp.util.JPAUtil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== Student Management ====");
            System.out.println("1. Add Student");
            System.out.println("2. View Student by ID");
            System.out.println("3. View All Students");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Age: ");
                    int age = scanner.nextInt();
                    dao.createStudent(new Student(name, age));
                }
                case 2 -> {
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    Student s = dao.getStudent(id);
                    System.out.println(s != null ? s : "Not found.");
                }
                case 3 -> dao.getAllStudents().forEach(System.out::println);
                case 4 -> {
                    System.out.print("Enter ID to update: ");
                    int id = scanner.nextInt(); scanner.nextLine();
                    Student s = dao.getStudent(id);
                    if (s != null) {
                        System.out.print("New name: ");
                        s.setName(scanner.nextLine());
                        System.out.print("New age: ");
                        s.setAge(scanner.nextInt());
                        dao.updateStudent(s);
                    } else {
                        System.out.println("Student not found.");
                    }
                }
                case 5 -> {
                    System.out.print("Enter ID to delete: ");
                    dao.deleteStudent(scanner.nextInt());
                }
            }

        } while (choice != 0);

        JPAUtil.shutdown();
        scanner.close();
    }
}
