import java.util.Scanner;

public class UserRoleManager {
    private final PayrollManager payrollManager;
    private final Scanner scanner;

    public UserRoleManager(PayrollManager payrollManager) {
        this.payrollManager = payrollManager;
        this.scanner = new Scanner(System.in);
    }

    public void handleAdmin() {
        System.out.println("Welcome Admin! You can manage employees.");
        while (true) {
            System.out.println("\nAdmin Options:");
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Logout");

            int option = scanner.nextInt();
            scanner.nextLine();  // consume the newline character

            if (option == 1) {
                System.out.print("Enter Employee ID: ");
                int empId = scanner.nextInt();
                scanner.nextLine(); // consume newline
                System.out.print("Enter Employee Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Department: ");
                String department = scanner.nextLine();
                System.out.print("Enter Base Salary: ");
                double salary = scanner.nextDouble();
                scanner.nextLine(); // consume newline
                System.out.print("Enter Employee Type (basic, medical, home, transport): ");
                String empType = scanner.nextLine();

                payrollManager.addEmployee(empId, name, department, salary, empType);
            } else if (option == 2) {
                System.out.print("Enter Employee ID to Delete: ");
                int empId = scanner.nextInt();
                scanner.nextLine(); // consume newline
                payrollManager.deleteEmployee(empId);
            } else if (option == 3) {
                break;  // Logout
            } else {
                System.out.println("Invalid option, try again.");
            }
        }
    }

    public void handleEmployee() {
        System.out.print("Enter your Employee ID: ");
        int empId = scanner.nextInt();
        scanner.nextLine();  // consume newline

        if (payrollManager.isEmployeeExists(empId)) {
            payrollManager.generatePayslip(empId);
        } else {
            System.out.println("Invalid Employee ID.");
        }
    }
}
 