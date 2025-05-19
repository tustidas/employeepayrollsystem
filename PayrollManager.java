import java.util.HashMap;
import java.util.Map;

public class PayrollManager {
    private final Map<Integer, Employee> employees;

    public PayrollManager() {
        employees = new HashMap<>();
    }

    public void addEmployee(int empId, String name, String department, double baseSalary, String empType) {
        Employee employee = new Employee(empId, name, department, baseSalary, empType);
        employees.put(empId, employee);
        System.out.println("Employee added successfully!");
    }

    public void deleteEmployee(int empId) {
        if (employees.containsKey(empId)) {
            employees.remove(empId);
            System.out.println("Employee removed successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    public boolean isEmployeeExists(int empId) {
        return employees.containsKey(empId);
    }

    public void generatePayslip(int empId) {
        Employee emp = employees.get(empId);
        Attendance attendance = new Attendance();
        int daysWorked = attendance.getAttendance(empId).equals("Present") ? 25 : 20;
        double netSalary = calculateNetSalary(emp, daysWorked);
        System.out.println("Payslip for " + emp.name + ":");
        System.out.println("Employee ID: " + emp.empId);
        System.out.println("Net Salary: " + netSalary);
    }

    private double calculateNetSalary(Employee emp, int daysWorked) {
        double grossSalary = (emp.baseSalary / 30) * daysWorked;
        double tax = grossSalary * 0.2; 
        double deductions = grossSalary * 0.1;
        return grossSalary - tax - deductions;
    }
}
 