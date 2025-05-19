import java.util.Scanner;

public class EmployeePayrollSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PayrollManager payrollManager = new PayrollManager();
        UserRoleManager userRoleManager = new UserRoleManager(payrollManager);

        while (true) {
            System.out.print("Enter your role (ADMIN/EMPLOYEE): ");
            String roleInput = scanner.nextLine().toUpperCase();
            UserRole role;
            try {
                role = UserRole.valueOf(roleInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid role entered.");
                continue;
            }

            if (role == UserRole.ADMIN) {
                userRoleManager.handleAdmin();
            } else if (role == UserRole.EMPLOYEE) {
                userRoleManager.handleEmployee();
            } else {
                System.out.println("Invalid role entered.");
            }

            System.out.print("Do you want to logout? (yes/no): ");
            String logoutChoice = scanner.nextLine().toLowerCase();
            if (logoutChoice.equals("yes")) {
                System.out.println("Logged out successfully!");
                break;
            }
        }
        scanner.close();
    }
}
