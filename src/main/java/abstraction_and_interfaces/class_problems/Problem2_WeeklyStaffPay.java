import java.util.*;

public class Problem2_WeeklyStaffPay {
    static abstract class Staff {
        String name;
        Staff(String name) { this.name = name; }
        abstract double pay();
    }

    static class FullTime extends Staff {
        double salary;
        FullTime(String name, double salary) { super(name); this.salary = salary; }
        double pay() { return salary; }
    }

    static class Hourly extends Staff {
        double hours, rate;
        Hourly(String name, double hours, double rate) {
            super(name); this.hours = hours; this.rate = rate;
        }
        double pay() {
            if (hours <= 40) return hours * rate;
            return 40 * rate + (hours - 40) * rate * 1.5;
        }
    }

    static class Intern extends Staff {
        double stipend;
        Intern(String name, double stipend) { super(name); this.stipend = stipend; }
        double pay() { return stipend; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Staff staff;

            if (type.equals("FULLTIME")) staff = new FullTime(name, sc.nextDouble());
            else if (type.equals("HOURLY")) staff = new Hourly(name, sc.nextDouble(), sc.nextDouble());
            else staff = new Intern(name, sc.nextDouble());

            double pay = staff.pay();
            total += pay;
            System.out.printf("%s: %.2f%n", staff.name, pay);
        }

        System.out.printf("Total Payroll: %.2f%n", total);
    }
}