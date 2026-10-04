import java.util.*;

public class Problem5_HomeApplianceEnergyReport {
    static abstract class Appliance {
        double hours;
        Appliance(double hours) { this.hours = hours; }

        abstract double powerWatts();
        abstract String type();

        double units() {
            return powerWatts() * hours / 1000.0;
        }

        double cost() {
            return units() * 8.0;
        }
    }

    interface SaverMode {
        double saverUnits();
    }

    static class Fridge extends Appliance {
        Fridge(double hours) { super(hours); }
        double powerWatts() { return 150; }
        String type() { return "FRIDGE"; }
    }

    static class AC extends Appliance implements SaverMode {
        AC(double hours) { super(hours); }
        double powerWatts() { return 1500; }
        String type() { return "AC"; }
        public double saverUnits() { return units() * 0.75; }
    }

    static class TV extends Appliance {
        TV(double hours) { super(hours); }
        double powerWatts() { return 100; }
        String type() { return "TV"; }
    }

    static class Washer extends Appliance implements SaverMode {
        Washer(double hours) { super(hours); }
        double powerWatts() { return 500; }
        String type() { return "WASHER"; }
        public double saverUnits() { return units() * 0.75; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();
            boolean saver = sc.hasNext("SAVER") && sc.next().equals("SAVER");

            Appliance appliance;
            if (type.equals("FRIDGE")) appliance = new Fridge(hours);
            else if (type.equals("AC")) appliance = new AC(hours);
            else if (type.equals("TV")) appliance = new TV(hours);
            else appliance = new Washer(hours);

            if (saver && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = saver
                    ? ((SaverMode) appliance).saverUnits()
                    : appliance.units();
            double cost = units * 8.0;
            totalCost += cost;

            System.out.printf("%s: Units=%.2f Cost=%.2f%n", type, units, cost);
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
    }
}