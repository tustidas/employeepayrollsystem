import java.util.HashMap;
import java.util.Map;

public class Attendance {
    private final Map<Integer, String> attendanceRecords;

    public Attendance() {
        this.attendanceRecords = new HashMap<>();
    }

    public void markAttendance(int empId, String status) {
        attendanceRecords.put(empId, status);
    }

    public String getAttendance(int empId) {
        return attendanceRecords.getOrDefault(empId, "No Record");
    }
}
