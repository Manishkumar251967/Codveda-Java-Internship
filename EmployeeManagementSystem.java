import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagementSystem {

    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add employee
    public static void addEmployee() {

        System.out.print("Enter Employee ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = Double.parseDouble(sc.nextLine());

        Employee emp = new Employee(id, name, department, salary);

        employees.add(emp);

        System.out.println("Employee added successfully!");
    }

    // View all employees
    public static void viewEmployees() {

        if (employees.isEmpty()) {
            System.out.println("No employee records found.");
            return;
        }

        for (Employee emp : employees) {
            emp.displayEmployee();
        }
    }

    // Search employee
    public static void searchEmployee() {

        System.out.print("Enter Employee ID to search: ");
        int id = Integer.parseInt(sc.nextLine());

        for (Employee emp : employees) {

            if (emp.getId() == id) {
                System.out.println("Employee found!");
                emp.displayEmployee();
                return;
            }
        }

        System.out.println("Employee not found.");
    }

    // Update employee
    public static void updateEmployee() {

        System.out.print("Enter Employee ID to update: ");
        int id = Integer.parseInt(sc.nextLine());

        for (Employee emp : employees) {

            if (emp.getId() == id) {

                System.out.print("Enter new name: ");
                emp.setName(sc.nextLine());

                System.out.print("Enter new department: ");
                emp.setDepartment(sc.nextLine());

                System.out.print("Enter new salary: ");
                emp.setSalary(Double.parseDouble(sc.nextLine()));

                System.out.println("Employee updated successfully!");
                return;
            }
        }

        System.out.println("Employee not found.");
    }

    // Delete employee
    public static void deleteEmployee() {

        System.out.print("Enter Employee ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());

        for (Employee emp : employees) {

            if (emp.getId() == id) {
                employees.remove(emp);
                System.out.println("Employee deleted successfully!");
                return;
            }
        }

        System.out.println("Employee not found.");
    }

    // Main method
    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    addEmployee();
                    break;

                case 2:
                    viewEmployees();
                    break;

                case 3:
                    searchEmployee();
                    break;

                case 4:
                    updateEmployee();
                    break;

                case 5:
                    deleteEmployee();
                    break;

                case 6:
                    System.out.println("Thank you for using EMS!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}
