import java.util.HashMap;
import java.util.Map;

public class Problem4_EmployeeIdLookup {
    static class Record {
        String employeeId;
        String department;

        Record(String employeeId, String department) {
            this.employeeId = employeeId;
            this.department = department;
        }
    }

    static Map<String, String> buildLookup(Record[] records) {
        Map<String, String> lookup = new HashMap<>();
        for (Record record : records) {
            lookup.put(record.employeeId, record.department);
        }
        return lookup;
    }

    static String getDepartment(Map<String, String> lookup, String employeeId) {
        return lookup.getOrDefault(employeeId, "Unknown");
    }

    public static void main(String[] args) {
        Record[] records = {new Record("E390", "Marketing")};
        System.out.println(getDepartment(buildLookup(records), "E390"));
    }
}