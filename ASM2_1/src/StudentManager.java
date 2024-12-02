import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentManager {
    private LinkedList<Student> students;
    private int nextId = 1;

    public StudentManager() {
        students = new LinkedList<>();
    }

    private boolean isValidName(String name) {
        return Pattern.matches("[a-zA-Z\\s]+", name);
    }

    public void add(String name, double marks) {
        if (!isValidName(name)) {
            System.out.println("Invalid name. Please use only letters and no numbers.");
            return;
        }
        if (marks < 0 || marks > 10) {
            System.out.println("Invalid marks. Please enter marks between 0 and 10.");
            return;
        }

        String id = String.valueOf(nextId++);
        Student st = new Student(id, name, marks);
        students.add(st);
        System.out.println("Student added: " + st);
    }

    public void edit(String studentId, Scanner sc) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                System.out.println("Current information of the student:");
                System.out.println(student);

                try {
                    System.out.print("Enter new name (or press Enter to keep current): ");
                    String newName = sc.nextLine();
                    if (!newName.isEmpty()) {
                        if (!isValidName(newName)) {
                            System.out.println("Invalid name. Please use only letters and no numbers.");
                            return;
                        }
                        student.setName(newName);
                    }

                    System.out.print("Enter new marks (or -1 to keep current): ");
                    double newMarks = sc.nextDouble();
                    sc.nextLine();
                    if (newMarks >= 0) {
                        student.setMarks(newMarks);
                    }

                    System.out.println("Student updated: " + student);
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again.");
                    sc.nextLine();
                }
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void delete(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                System.out.println("Student deleted: " + student);
                students.remove(student);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void search(String query) {
        boolean found = false;
        for (Student student : students) {
            if (student.getId().equals(query) || student.getName().equalsIgnoreCase(query)) {
                System.out.println("Student found: " + student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No student found with ID or Name: " + query);
        }
    }

    public void SelectionSortStudent() {
        for (int i = 0; i < students.size() - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < students.size(); j++) {
                if (students.get(j).getMarks() > students.get(maxIndex).getMarks()) {
                    maxIndex = j;
                }
            }
            Student temp = students.get(i);
            students.set(i, students.get(maxIndex));
            students.set(maxIndex, temp);
        }

        System.out.println("Students sorted by marks:");
        display();
    }

    public void display() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            System.out.println("ID\tName\tMarks\tRank");
            for (Student student : students) {
                System.out.println(student.getId() + "\t" + student.getName() + "\t" + student.getMarks() + "\t" + student.getRank());
            }
        }
    }
}