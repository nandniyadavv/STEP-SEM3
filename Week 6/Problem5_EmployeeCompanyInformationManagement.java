class Employee {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class Problem5_EmployeeCompanyInformationManagement {
    public static void main(String[] args) {
        new Employee("Asha", 50000);
        new Employee("Rahul", 60000);
        new Employee("Priya", 55000);

        Employee.printCompanyInfo();
    }
}
