import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            try {
                System.out.println("\n1. Add a student");
                System.out.println("2. Edit a student");
                System.out.println("3. Delete a student");
                System.out.println("4. Search for a student");
                System.out.println("5. Sort students by marks");
                System.out.println("6. Display all students");
                System.out.println("7. Exit");
                System.out.print("Choose an option: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Student Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Student Marks: ");
                        double marks = sc.nextDouble();
                        sc.nextLine();
                        manager.add(name, marks);
                        break;
                    case 2:
                        System.out.print("Enter Student ID to edit: ");
                        String studentId = sc.nextLine();
                        manager.edit(studentId, sc);
                        break;
                    case 3:
                        System.out.print("Enter Student ID to delete: ");
                        String id = sc.nextLine();
                        manager.delete(id);
                        break;
                    case 4:
                        System.out.print("Enter Student ID or Name to search: ");
                        String query = sc.nextLine();
                        manager.search(query);
                        break;
                    case 5:
                        manager.SelectionSortStudent();
                        break;
                    case 6:
                        manager.display();
                        break;
                    case 7:
                        System.out.println("Exiting the program.");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.nextLine();
            }
        } while (choice != 7);
    }
}