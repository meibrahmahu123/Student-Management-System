import java.util.ArrayList;
import java.util.Scanner;

// Student class
class Student {
    @SuppressWarnings("FieldMayBeFinal")
    private int id;
    @SuppressWarnings("FieldMayBeFinal")
    private String name;
    @SuppressWarnings("FieldMayBeFinal")
    private int age;
    @SuppressWarnings("FieldMayBeFinal")
    private String course;

    public Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student [ID=" + id + ", Name=" + name + ", Age=" + age + ", Course=" + course + "]";
    }
}

// Main Class
public class StudentManagementSystem {
    @SuppressWarnings("FieldMayBeFinal")
    private ArrayList<Student> studentList;
    @SuppressWarnings("FieldMayBeFinal")
    private Scanner scanner;

    public StudentManagementSystem() {
        studentList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void menu() {
        int choice;
        do {
            System.out.println("\n==== Student Management System ====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Remove Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            
            // check if input is an integer
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter a number: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> searchStudent();
                case 4 -> removeStudent();
                case 5 -> System.out.println("Exiting program. Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume leftover newline

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume leftover newline

        System.out.print("Enter Student Course: ");
        String course = scanner.nextLine();

        Student student = new Student(id, name, age, course);
        studentList.add(student);
        System.out.println("Student added successfully.");
    }

    private void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("\nList of Students:");
            for (Student s : studentList) {
                System.out.println(s);
            }
        }
    }

    private void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume leftover newline

        boolean found = false;
        for (Student s : studentList) {
            if (s.getId() == id) {
                System.out.println("Student found: " + s);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    private void removeStudent() {
        System.out.print("Enter Student ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume leftover newline

        Student toRemove = null;
        for (Student s : studentList) {
            if (s.getId() == id) {
                toRemove = s;
                break;
            }
        }

        if (toRemove != null) {
            studentList.remove(toRemove);
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.menu();
    }
}