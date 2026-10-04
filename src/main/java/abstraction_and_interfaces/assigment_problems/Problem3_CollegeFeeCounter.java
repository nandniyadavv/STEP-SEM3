import java.util.*;

public class Problem3_CollegeFeeCounter {
    static abstract class Student {
        static final double TRANSPORT_FEE = 12000;
        String name;

        Student(String name) { this.name = name; }
        abstract double tuitionFee();
        abstract boolean usesBus();

        double totalFee() {
            return tuitionFee() + (usesBus() ? TRANSPORT_FEE : 0);
        }
    }

    static class DayScholar extends Student {
        DayScholar(String name) { super(name); }
        double tuitionFee() { return 40000; }
        boolean usesBus() { return true; }
    }

    static class Hosteller extends Student {
        Hosteller(String name) { super(name); }
        double tuitionFee() { return 40000 + 60000; }
        boolean usesBus() { return false; }
    }

    static class Scholar extends Student {
        Scholar(String name) { super(name); }
        double tuitionFee() { return 20000; }
        boolean usesBus() { return true; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Student student;

            if (type.equals("DAY_SCHOLAR")) student = new DayScholar(name);
            else if (type.equals("HOSTELLER")) student = new Hosteller(name);
            else student = new Scholar(name);

            double fee = student.totalFee();
            total += fee;
            System.out.printf("%s: %.2f%n", student.name, fee);
        }

        System.out.printf("Total Collected: %.2f%n", total);
    }
}