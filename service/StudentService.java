package service;

import java.util.Scanner;
import java.util.ArrayList;
import model.Student;

public class StudentService {

    Scanner s = new Scanner(System.in);
    ArrayList<Student> students = new ArrayList<>();

    // 🔵 ADD STUDENT
    public void add() {

        System.out.print("Input id: ");
        int id = s.nextInt();
        s.nextLine(); // fix buffer

        System.out.print("Input name: ");
        String name = s.nextLine();

        System.out.print("Input age: ");
        int age = s.nextInt();
        s.nextLine();

        System.out.print("Input department: ");
        String department = s.nextLine();

        System.out.print("Input GPA: ");
        double gpa = s.nextDouble();

        Student student = new Student(id, name, age, department, gpa);
        students.add(student);

        System.out.println("Student added successfully!");
    }

    // 🔵 VIEW STUDENTS
    public void view() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }

    // 🔵 SEARCH STUDENT
    public Student search() {

        System.out.print("Enter ID to search: ");
        int inputId = s.nextInt();

        for (Student student : students) {
            if (student.getId() == inputId) {
                System.out.println("Student found:");
                System.out.println(student);
                return student;
            }
        }

        System.out.println("Student not found.");
        return null;
    }

    // 🔵 DELETE STUDENT
    public void delete() {

        System.out.print("Enter ID to delete: ");
        int inputId = s.nextInt();

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == inputId) {
                students.remove(i);
                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // 🔵 FILTER GPA (LAMBDA)
    public void filterGPA() {

        System.out.println("Students with GPA > 3.5:");

        students.stream()
                .filter(student -> student.getGpa() > 3.5)
                .forEach(System.out::println);
    }
}