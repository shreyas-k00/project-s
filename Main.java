import java.util.Scanner;
import model.Student;
import service.StudentService;

public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Assign Course");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    service.addStudent(new Student(id, name));
                }
                case 2 -> service.listStudents();
                case 3 -> {
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();
                    service.assignCourse(id, course);
                }
                case 4 -> {
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    service.deleteStudent(id);
                }
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option.");
            }
        } while (choice != 5);
    }
}
