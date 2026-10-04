import java.util.*;

public class Problem4_CityCabFareMeter {
    static abstract class Cab {
        double km;

        Cab(double km) { this.km = km; }
        abstract double ratePerKm();
        abstract String type();

        double baseFare() {
            return Math.max(km * ratePerKm(), 100.0);
        }
    }

    interface NightService {
        double nightFare();
    }

    static class Mini extends Cab {
        Mini(double km) { super(km); }
        double ratePerKm() { return 10; }
        String type() { return "MINI"; }
    }

    static class Sedan extends Cab implements NightService {
        Sedan(double km) { super(km); }
        double ratePerKm() { return 14; }
        String type() { return "SEDAN"; }
        public double nightFare() { return baseFare() * 1.20; }
    }

    static class SUV extends Cab implements NightService {
        SUV(double km) { super(km); }
        double ratePerKm() { return 18; }
        String type() { return "SUV"; }
        public double nightFare() { return baseFare() * 1.20; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;
            if (type.equals("MINI")) cab = new Mini(km);
            else if (type.equals("SEDAN")) cab = new Sedan(km);
            else cab = new SUV(km);

            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double fare = time.equals("NIGHT")
                    ? ((NightService) cab).nightFare()
                    : cab.baseFare();

            total += fare;
            System.out.printf("%s: %.2f%n", type, fare);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}